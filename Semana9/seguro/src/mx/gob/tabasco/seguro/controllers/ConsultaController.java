package mx.gob.tabasco.seguro.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/consultas")
public class ConsultaController {

	@RequestMapping(method = RequestMethod.GET)
	public String indexAction() {
		return "consultas/index";
	}
	
	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public String newFormAction() {
		return "consultas/new_form";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String detailsAction(@PathVariable Integer id) {
		return  "consultas/details";
	}
	
}
