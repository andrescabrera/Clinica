package com.cabrera.clinica.mvc.controllers;

import java.util.Collection;
import java.util.Date;

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

import com.cabrera.clinica.domain.Administrativo;
import com.cabrera.clinica.domain.Empleado;
import com.cabrera.clinica.domain.Sueldo;
import com.cabrera.clinica.domain.services.AdministrativoService;
import com.cabrera.clinica.domain.services.EmpleadoService;
import com.cabrera.clinica.domain.services.MedicoService;
import com.cabrera.clinica.domain.services.SecretariaService;
import com.cabrera.clinica.mvc.form.EmpleadoForm;
import com.cabrera.clinica.mvc.form.PersonaForm;

@Controller
@RequestMapping(value = "/empleados")
public class EmpleadosController {

	@Autowired
	private EmpleadoService service;
	
	@Autowired
	private SecretariaService secretariaService;

	@Autowired
	private MedicoService medicoService;
	
	@Autowired
	private AdministrativoService administrativoService;
	
	@RequestMapping(method = RequestMethod.GET)
	public void listar(Model model) {
		Collection<Empleado> empleados = service.findAll();
		model.addAttribute("empleados", empleados);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public String ver(@PathVariable String id, Model model) {
		Empleado empleado = service.findById(Long.parseLong(id));
		model.addAttribute("empleado", empleado);
		model.addAttribute("tipoEmpleado", empleado.getClass().getName());
		return "empleados/ver";
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public void borrar(@PathVariable String id, Model model) {
		service.remove(service.findById(Long.parseLong(id)));
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String saveOrUpdate(
			@ModelAttribute("empleadoForm") @Valid EmpleadoForm empleadoForm,
			BindingResult result, Model model) {

		System.out.println("Tuvo errores?: " + result.hasErrors());

		if (result.hasErrors()) {
			return "/empleados/form"; //Devolver código de error
		}

		Long id = empleadoForm.getId();

		Empleado empleado = null;

		if (id == null) {
			try {
				empleado = empleadoForm.comoEmpleado();
				id = service.saveOrUpdate(empleado).getId(); //Deberia guardar el objeto Persona en cascada.
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			empleado = service.findById(id);
			BeanUtils.copyProperties(empleadoForm, empleado);
			service.saveOrUpdate(empleado);
		}

		return "redirect:/empleados/" + id;
	}
	
	//Forms	
	@RequestMapping(method = RequestMethod.GET, value = "/alta")
	public String altaEmpleadoForm(Model model) throws Exception {
		EmpleadoForm formEmpleado = new EmpleadoForm();
		
		model.addAttribute("empleadoForm", formEmpleado);

		return "/empleados/form";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/editar")
	public String editarEmpleado(@RequestParam("id") long id, Model model) {
		Empleado empleado = service.findById(id);
		EmpleadoForm empleadoForm = new EmpleadoForm();
		
//		TODO: vamos a tener que copiar las propiedades a mano...
		//		BeanUtils.copyProperties(empleado, empleadoForm);
		
		model.addAttribute("empleadoForm", empleadoForm);
		return "/empleados/form";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/borrar")
	public String borrarEmpleado(@RequestParam("id") String id, Model model) {

		service.remove(service.findById(Long.parseLong(id)));

		return "redirect:/empleados"; 
	}

}
