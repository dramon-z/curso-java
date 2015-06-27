package mx.gob.tabasco.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/")
public class IndexController {

	@RequestMapping(method = RequestMethod.GET)
	public String indexAction(Model model) {
		return "index";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String formAction(Model model,
			@RequestParam String nombre,
			@RequestParam Integer edad,
			@RequestParam String ciudad) {
		model.addAttribute("nombre", nombre);
		model.addAttribute("edad", edad);
		model.addAttribute("ciudad", ciudad);
		
		return "resultado";
	}
	
}
