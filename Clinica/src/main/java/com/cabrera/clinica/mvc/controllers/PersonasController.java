package com.cabrera.clinica.mvc.controllers;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cabrera.clinica.domain.Persona;
import com.cabrera.clinica.domain.services.PersonaService;
import com.cabrera.clinica.mvc.form.PersonaForm;

@Controller
@RequestMapping(value = "/personas")
public class PersonasController {

	@Autowired
	private PersonaService service;

	@RequestMapping(method = RequestMethod.GET)
	public void listar(Model model) {
		Collection<Persona> personas = service.findAll();
		model.addAttribute("personas", personas);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public String ver(@PathVariable String id, Model model) {
		Persona persona = service.findById(Long.parseLong(id));
		model.addAttribute("persona", persona);
		return "personas/ver";
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public void borrar(@PathVariable String id, Model model) {
		service.remove(service.findById(Long.parseLong(id)));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String saveOrUpdate(
			@ModelAttribute("personasForm") @Valid PersonaForm personaForm,
			BindingResult result, Model model) {

		System.out.println("Tuvo errores?: " + result.hasErrors());

		if (result.hasErrors()) {
			return "/personas/form"; //Devolver código de error
		}

		Long id = personaForm.getId();

		Persona persona = null;

		if (id == null) {
			persona = new Persona();
			BeanUtils.copyProperties(personaForm, persona);
			id = service.saveOrUpdate(persona).getId();
		} else {
			persona = service.findById(id);
			BeanUtils.copyProperties(personaForm, persona);
			service.saveOrUpdate(persona);
		}

		return "redirect:/personas/" + id;
	}
	
	//Forms	
	@RequestMapping(method = RequestMethod.GET, value = "/alta")
	public String altaPersonaForm(Model model) throws Exception {

		PersonaForm form = new PersonaForm();
		model.addAttribute("personaForm", form);

		return "/personas/form";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/editar")
	public String editarPersona(@RequestParam("id") long id, Model model) {
		Persona persona = service.findById(id);
		PersonaForm personaForm = new PersonaForm();
		BeanUtils.copyProperties(persona, personaForm);
		model.addAttribute("personasForm", personaForm);
		return "/personas/form";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/borrar")
	public String borrarPersona(@RequestParam("id") String id, Model model) {

		service.remove(service.findById(Long.parseLong(id)));

		return "redirect:/personas";
	}

}
