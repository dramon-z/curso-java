package mx.gob.tabasco.spring.controllers;

import java.util.List;

import mx.gob.tabasco.entities.Asegurado;
import mx.gob.tabasco.services.AseguradoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/asegurados/")
public class AseguradoController {

	@Autowired
	private AseguradoService aseguradoService;
	
	@RequestMapping
	public String indexAction(Model model) {
		List<Asegurado> asegurados = aseguradoService.findAll();
		model.addAttribute("asegurados", asegurados);
		
		return "asegurados/index";
	}
	
	@RequestMapping(value = "/nuevo", method = RequestMethod.GET)
	public String nuevoAseguradoAction() {
		return "asegurados/nuevo";
	}
	
	@RequestMapping(value = "/detalle", method = RequestMethod.GET)
	public String detalleAseguradoAction(@RequestParam Integer id, Model model) {
		Asegurado asegurado = aseguradoService.getById(id);
		model.addAttribute("asegurado", asegurado);
		
		return "asegurados/detalle";
	}
	
	@RequestMapping(value = "/resultado", method = RequestMethod.POST)
	public String resultadoAseguradoAction(Model model,
			Asegurado asegurado) {
		
		String mensaje = "La información del asegurado se ha guardado.";
		try {
			aseguradoService.save(asegurado);
		} catch (Exception e) {
			mensaje = "Hubo un error al guardar los datos: " + e.getMessage();
		}
		
		model.addAttribute("mensaje", mensaje);
		
		return "asegurados/resultado";
	}
	
}
