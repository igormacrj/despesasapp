package br.edu.infnet.despesasapp.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import br.edu.infnet.despesasapp.model.Categoria;
import br.edu.infnet.despesasapp.model.Movimentacao;

@Controller
public class MovimentacaoController {

	@Autowired
	private MovimentacaoService serviceMovimentacao;

	@Autowired
	private CategoriaService serviceCategoria;	
	
	
	@RequestMapping(value = "/movimentacoes/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<Movimentacao> movimentacoes = serviceMovimentacao.getMovimentacoes();
		model.addAttribute("listaMovimentacoes", movimentacoes);
		
		List<Movimentacao> movimentacoesReceita = serviceMovimentacao.getMovimentacoesReceita();
		model.addAttribute("listaMovimentacoesReceita", movimentacoesReceita);
		
		List<Movimentacao> movimentacoesDespesa = serviceMovimentacao.getMovimentacoesDespesa();
		model.addAttribute("listaMovimentacoesDespesa", movimentacoesDespesa);
		
		Float valorTotalDespesas = serviceMovimentacao.getValorTotalDespesas();
		model.addAttribute("valorTotalDespesas", valorTotalDespesas);
		
		Float valorTotalReceitas = serviceMovimentacao.getValorTotalReceitas();
		model.addAttribute("valorTotalReceitas", valorTotalReceitas);
				
		return "movimentacoes/list";
	}
	
	@RequestMapping(value = "/movimentacoes/form" , method = RequestMethod.GET)
	public String viewForm(Model model) {
		List<Categoria> categorias = serviceCategoria.getCategorias();
		model.addAttribute("listaCategorias", categorias);
		return "movimentacoes/form";
	}
	
	@RequestMapping(value = "/movimentacoes/add", method = RequestMethod.POST)
	public String save(Model model, Movimentacao movimentacao) {
		movimentacao.setCategoria(serviceCategoria.getCategoria(movimentacao.getIdCategoria().toString()));
		movimentacao.setDataHora(new Timestamp(System.currentTimeMillis()));
		serviceMovimentacao.persite(movimentacao);
		return "redirect:/movimentacoes/list";
	}
	
	@RequestMapping(value = "/movimentacoes/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") String id, Model model) {
		Movimentacao movimentacao = serviceMovimentacao.getMovimentacao(id);
		model.addAttribute("movimentacao", movimentacao);
		List<Categoria> categorias = serviceCategoria.getCategorias();
		model.addAttribute("listaCategorias", categorias);
		return "movimentacoes/edit";
	}
	
	@RequestMapping(value = "/movimentacoes/update", method = RequestMethod.POST)
	public String update(Model model, Movimentacao movimentacao) {
		movimentacao.setCategoria(serviceCategoria.getCategoria(movimentacao.getIdCategoria().toString()));
		//NÃO EDITAR, MANTER DATAHORA ORIGINAL...  movimentacao.setDataHora(new Timestamp(System.currentTimeMillis()));
		serviceMovimentacao.update(movimentacao);
		return "redirect:/movimentacoes/list";
	}
	
	@RequestMapping(value = "/movimentacoes/delete/{id}", method = RequestMethod.GET)
	public String delete(Movimentacao movimentacao) {
		serviceMovimentacao.delete(movimentacao.getId());
		return "redirect:/movimentacoes/list";
	}
	
	public MovimentacaoService getServiceMovimentacao() {
		return serviceMovimentacao;
	}

	public void setServiceMovimentacao(MovimentacaoService serviceMovimentacao) {
		this.serviceMovimentacao = serviceMovimentacao;
	}

	public CategoriaService getServiceCategoria() {
		return serviceCategoria;
	}

	public void setServiceCategoria(CategoriaService serviceCategoria) {
		this.serviceCategoria = serviceCategoria;
	}
	
	
	
}
