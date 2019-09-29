package br.edu.infnet.despesasapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.edu.infnet.despesasapp.model.Categoria;

@Controller
public class CategoriaController {

	@Autowired
	private CategoriaService service;
	
	@RequestMapping(value = "/categorias/list", method = RequestMethod.GET)
	public String list(Model model) {
		List<Categoria> categorias = service.getCategorias();
		model.addAttribute("listaCategorias", categorias);
		return "categorias/list";
	}
	
	@RequestMapping(value = "/categorias/form" , method = RequestMethod.GET)
	public String viewForm(Model model) {
		return "categorias/form";
	}
	
	
	@RequestMapping(value = "/categorias/add", method = RequestMethod.POST)
	public String save(Model model, Categoria categoria) {
		service.persite(categoria);
		return "redirect:/categorias/list";
	}
	
	@RequestMapping(value = "/categorias/edit/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable("id") String id, Model model) {
		Categoria categoria = service.getCategoria(id);
		model.addAttribute("categoria", categoria);
		return "categorias/edit";
	}
	
	@RequestMapping(value = "/categorias/update", method = RequestMethod.POST)
	public String update(Model model, Categoria categoria) {
		service.update(categoria);
		return "redirect:/categorias/list";
	}
	
	@RequestMapping(value = "/categorias/delete/{id}", method = RequestMethod.GET)
	public String delete(Categoria categoria) {
		service.delete(categoria.getId());
		return "redirect:/categorias/list";
	}
	
	public CategoriaService getService() {
		return service;
	}

	public void setService(CategoriaService service) {
		this.service = service;
	}
	
}
