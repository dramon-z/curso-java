package mx.gob.tabasco.seguro.controllers.rest;

import java.util.ArrayList;
import java.util.List;

import mx.gob.tabasco.seguro.entities.Asegurado;
import mx.gob.tabasco.seguro.services.AseguradoService;
import mx.gob.tabasco.seguro.vo.AseguradoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/asegurados")
public class AseguradoRestController {

	@Autowired
	private AseguradoService aseguradoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<AseguradoVO> listAction() {
		Iterable<Asegurado> asegurados = aseguradoService.findAll();
		List<AseguradoVO> aseguradosVO = new ArrayList<AseguradoVO>();
		
		for (Asegurado asegurado : asegurados) {
			AseguradoVO aseguradoVO = new AseguradoVO();
			aseguradoVO.setNombre(asegurado.getNombre());
			aseguradoVO.setApellido(asegurado.getApellido());
			aseguradoVO.setEdad(asegurado.getEdad());
			aseguradoVO.setSexo(asegurado.getSexo());
			aseguradoVO.setNumeroSeguroSocial(asegurado.getNumeroSeguroSocial());
			
			aseguradosVO.add(aseguradoVO);
		}
		
		return aseguradosVO;
	}
	
}
