package mx.gob.tabasco.seguro.controllers;

import mx.gob.tabasco.seguro.entities.Asegurado;
import mx.gob.tabasco.seguro.services.AseguradoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/asegurados/")
public class AseguradoController {
	
	@Autowired
	private AseguradoService aseguradoService;

	@RequestMapping(method = RequestMethod.GET)
	public String indexAction(Model model) {
		Iterable<Asegurado> asegurados = aseguradoService.findAll();
		
		model.addAttribute("asegurados", asegurados);
		
		return "asegurados/index";
	}
	
	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public String newFormAction() {
		return "asegurados/new_form";
	}
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String saveAction(Asegurado asegurado, Model model) {
		try {
			aseguradoService.save(asegurado);
			return "redirect:/asegurados/";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("asegurado", asegurado);
			return "asegurados/new_form";
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String detailsAction(@PathVariable Integer id, Model model) {
		Asegurado asegurado = aseguradoService.getById(id);
		model.addAttribute("asegurado", asegurado);
		
		return  "asegurados/details";
	}
	
}
