package com.formacion.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.formacion.model.Formacion;
import com.formacion.service.FormacionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(tags="formacion")
@CrossOrigin("*")
@RestController
@RequestMapping("formacion")
public class FormacionController {
	
	@Autowired
	FormacionService service;
	
	
	@ApiOperation(value="Devuelve la lista de todas las formaciones")
	@GetMapping(value="/lista",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Formacion> ListaCursos() {
		
		return service.cursos();
	}
	
	@ApiOperation(value="Alta de un curso sino existe a partir de los datos de la formación")
	@PostMapping(value="/alta",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public void AltaCurso(@ApiParam(value="JSON con los datos de la formación") @RequestBody Formacion formacion) {
		
	 service.altaCurso(formacion);
	}
	
	
	
}
