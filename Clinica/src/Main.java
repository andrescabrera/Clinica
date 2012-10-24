

import java.util.Date;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cabrera.clinica.domain.Analisis;
import com.cabrera.clinica.domain.Liquidacion;
import com.cabrera.clinica.domain.Paciente;
import com.cabrera.clinica.domain.Persona;
import com.cabrera.clinica.domain.Secretaria;
import com.cabrera.clinica.domain.Telefono;
import com.cabrera.clinica.domain.Turno;
import com.cabrera.clinica.domain.repositories.Repositorio;
import com.cabrera.clinica.domain.repositories.RepositorioDeLiquidaciones;
import com.cabrera.clinica.domain.repositories.RepositorioDePacientes;
import com.cabrera.clinica.domain.repositories.RepositorioDePersonas;
import com.cabrera.clinica.domain.repositories.RepositorioDeSecretarias;
import com.cabrera.clinica.domain.repositories.RepositorioDeTelefonos;
import com.cabrera.clinica.domain.repositories.RepositorioDeTurnos;

/**
 * Sistema de Administración de Clinica
 * Demostración por Consola
 * 
 * @author acabrera
 * 
 */
public class Main {

	/**
	 * @param args ninguno
	 */
	public static void main(String[] args) {
		AbstractApplicationContext appContext = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
		
		Persona pepino = (Persona)appContext.getBean("persona");
		pepino.setApellido("Cabrera");
		pepino.setDireccion("Alsina 178");
		pepino.setNombre("Andrés");
		pepino.setDocumento("31998243");
		Paciente pacientePepe = (Paciente)appContext.getBean("paciente");
		
		pepino.agregarRol(pacientePepe);
		pacientePepe.setPersona(pepino);
		
		Turno turno = (Turno)appContext.getBean("turno");
		Analisis analisis = (Analisis)appContext.getBean("analisis");
		turno.setFecha(new Date());
		turno.setPaciente(pacientePepe);
		turno.setMontoAPagar(5500d);
		analisis.setFecha(new Date());
		analisis.setMontoAPagar(3440d);
		
		pacientePepe.agregarContraPrestacion(analisis);
		pacientePepe.agregarContraPrestacion(turno);
		System.out.println("Persona: " + pepino);
		pacientePepe.listarContraPrestaciones();
		
		RepositorioDePersonas repoPersonas = (RepositorioDePersonas)appContext.getBean("repositorioDePersonas");
		pepino = repoPersonas.saveOrUpdate(pepino);		
		
		RepositorioDePacientes repoPacientes = (RepositorioDePacientes)appContext.getBean("repositorioDePacientes");
		pacientePepe = repoPacientes.saveOrUpdate(pacientePepe);
		
		System.out.println("Id de Paciente: " + pacientePepe.getId());
		System.out.println("Levantando paciente...");
		Paciente siSeGuardoEsta = repoPacientes.findById(pacientePepe.getId());
		System.out.println("Id del paciente guardado: " + siSeGuardoEsta.getId());
		
		Telefono tel = (Telefono)appContext.getBean("telefono");
		tel.setNumero("123123123");
		Repositorio<Telefono, Long> telRepo = (RepositorioDeTelefonos)appContext.getBean("repositorioDeTelefonos");
		telRepo.saveOrUpdate(tel);
		for(Telefono t : telRepo.findAll()) {
			System.out.println("Tel bd: " + t.getNumero());
		}
		System.out.println("Numero de Tel: " + tel.getNumero());
		
		Secretaria unaSecretaria = (Secretaria)appContext.getBean("secretaria");
		unaSecretaria.setSueldoNetoActual(1500d);
		unaSecretaria.setSueldoBrutoActual(1400d);

		Persona doniaRamona = (Persona)appContext.getBean("persona");
		doniaRamona.setApellido("Gonzalez");
		doniaRamona.setNombre("Ramona");
		doniaRamona.setDocumento("3198212");
		doniaRamona.agregarRol(unaSecretaria);
		unaSecretaria.setPersona(doniaRamona);
		unaSecretaria.setLegajo(53231l);
		RepositorioDeSecretarias repoSecre = (RepositorioDeSecretarias)appContext.getBean("repositorioDeSecretarias");
		unaSecretaria = repoSecre.saveOrUpdate(unaSecretaria);
		
		Liquidacion liquiFinDeMes = (Liquidacion)appContext.getBean("liquidacion");
		liquiFinDeMes.realizarLiquidacion(unaSecretaria);
		
		RepositorioDeLiquidaciones repoLiquidaciones = (RepositorioDeLiquidaciones)appContext.getBean("repositorioDeLiquidaciones");
		liquiFinDeMes = repoLiquidaciones.saveOrUpdate(liquiFinDeMes);
		
		liquiFinDeMes.mostrarLiquidacion();
		
		unaSecretaria.setSueldoBrutoActual(10000d);
		unaSecretaria.setSueldoNetoActual(8000d);
		unaSecretaria = repoSecre.saveOrUpdate(unaSecretaria);
		liquiFinDeMes.mostrarLiquidacion();
		
		RepositorioDeTurnos repoTurnos = (RepositorioDeTurnos)appContext.getBean("repositorioDeTurnos");
		for(Turno t : repoTurnos.findAll()) {
			System.out.println("Fecha del Turno: " + t.getFecha());
			System.out.println("Nombre del paciente:  " + t.getPaciente().getPersona().getNombre());
		}
		
		
	}

}
