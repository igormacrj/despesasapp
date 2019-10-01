package br.edu.infnet.despesasapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.infnet.despesasapp.model.Movimentacao;

@Controller
public class MovimentacaoController {

	@Autowired
	private MovimentacaoService service;
	
	@RequestMapping(value = "/movimentacoes/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<Movimentacao> movimentacoes = service.getMovimentacoes();
		model.addAttribute("listaMovimentacoes", movimentacoes);
		return "movimentacoes/list";
	}
	
	@RequestMapping(value = "/movimentacoes/form" , method = RequestMethod.GET)
	public String viewForm(Model model) {
		return "movimentacoes/form";
	}
	
	
	@RequestMapping(value = "/movimentacoes/add", method = RequestMethod.POST)
	public String save(Model model, Movimentacao movimentacao) {
		service.persite(movimentacao);
		return "redirect:/movimentacoes/list";
	}
	
	@RequestMapping(value = "/movimentacoes/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") String id, Model model) {
		Movimentacao movimentacao = service.getMovimentacao(id);
		model.addAttribute("movimentacao", movimentacao);
		return "movimentacoes/edit";
	}
	
	@RequestMapping(value = "/movimentacoes/update", method = RequestMethod.POST)
	public String update(Model model, Movimentacao movimentacao) {
		service.update(movimentacao);
		return "redirect:/movimentacoes/list";
	}
	
	@RequestMapping(value = "/movimentacoes/delete/{id}", method = RequestMethod.GET)
	public String delete(Movimentacao movimentacao) {
		service.delete(movimentacao.getId());
		return "redirect:/movimentacoes/list";
	}
	
	public MovimentacaoService getService() {
		return service;
	}

	public void setService(MovimentacaoService service) {
		this.service = service;
	}
	
}
