package mx.gob.tabasco.seguro.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/recetas")
public class RecetaController {

	@RequestMapping(method = RequestMethod.GET)
	public String indexAction() {
		return "recetas/index";
	}
	
	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public String newFormAction() {
		return "recetas/new_form";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String detailsAction(@PathVariable Integer id) {
		return  "recetas/details";
	}
	
}
