package com.cabrera.clinica.mvc.controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cabrera.clinica.domain.Persona;
import com.cabrera.clinica.domain.services.PersonaService;
import com.cabrera.clinica.mvc.form.PersonaForm;

@Controller
@RequestMapping("/personas")
public class PersonasController {
	
	@Autowired
	private PersonaService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public Collection<Persona> listar(Model model)  {
		
		Collection<Persona> personas = service.listar();
		
		model.addAttribute("personas", personas);
		
		return personas;
	}
	
//	@RequestMapping(method = RequestMethod.GET)
//	public String editar(@RequestParam("id") long id, Model model)  {
//		Persona persona = service.obtenerPorId(id);
//		PersonaForm personaForm = new PersonaForm();
//		BeanUtils.copyProperties(persona, personaForm);
//		model.addAttribute("personasForm", personaForm);	
//		return "/personas/form";
//	}
	
//	@RequestMapping(method = RequestMethod.GET)
//	public String borrar(@RequestParam("id") long id, Model model)  {
//		service.borrar(service.obtenerPorId(id));
//		return "redirect:/personas/listar.html";
//	}

//	@RequestMapping(method = RequestMethod.GET)
//	public String nuevo(Model model) throws Exception{
//		
//		PersonaForm productoForm = new PersonaForm();
//		model.addAttribute("productoForm", productoForm);
//		return "/productos/form";
//	}

	@RequestMapping(method = RequestMethod.POST)
	public String guardar(@ModelAttribute("personasForm") @Valid PersonaForm personaForm, BindingResult result, Model model) {
		
		System.out.println(result.hasErrors());
		
		if (result.hasErrors()) {
			return "/personas/form";
		}
		
		Long id = personaForm.getId();
		
		Persona persona = null;
		
		if(id == null) {
			persona = new Persona();
			BeanUtils.copyProperties(personaForm, persona);	
			id = service.guardar(persona).getId();	
		} else {
			persona = service.obtenerPorId(id);
			BeanUtils.copyProperties(personaForm, persona);	
			service.guardar(persona);
		}
		
		return "redirect:/personas/ver.html?id=" + id;
	}
	
}
