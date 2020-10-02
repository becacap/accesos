package cap.curso.accesos.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cap.curso.accesos.calendario.servicios.CalendarioServiceInterface;
import cap.curso.accesos.entidades.Calendario;
import cap.curso.accesos.entidades.Empleado;
import cap.curso.accesos.entidades.Jornada;
import cap.curso.accesos.entidades.Usuario_Estado;
import cap.curso.accesos.estado.servicios.EstadosServiceInterface;
import cap.curso.accesos.servicios.CalendarioEmpleadoServiceInterface;
import cap.curso.accesos.servicios.JPAEmpleadoServiceInterface;
import cap.curso.accesos.servicios.JPAJornadaServiceInterface;

@RestController
@RequestMapping("/api")
public class RestCalendarioEmpleadoControler
{
	@Autowired
	private CalendarioEmpleadoServiceInterface calendarioEmpleadoServiceInterface;

	@Autowired
	private CalendarioServiceInterface calendarioServiceInterface;
	@Autowired
	private JPAEmpleadoServiceInterface jpaEmpleadoServiceInterface;
	@Autowired
	private JPAJornadaServiceInterface jpaJornadaServiceInterface;
	@Autowired
	private EstadosServiceInterface estadosServiceInterface;

	@PostMapping("/calendario-empleado")
	public Usuario_Estado getCalendarioEmpleado(@RequestBody Usuario_Estado usuario_Estado)
	{
		return getCalendarioEmpleadoServiceInterface().save(usuario_Estado);
	}

	@GetMapping("/calendario-empleados/{id}")
	public Usuario_Estado getCalendarioEmpleadoById(@PathVariable Integer id)
	{
		return calendarioEmpleadoServiceInterface.findById(id);
	}

	//FindAll
	@GetMapping("/tabla")
	public List<Usuario_Estado> getUsuariosEstados()
	{
		List<Usuario_Estado> usuarios_estados = new ArrayList<Usuario_Estado>();
		usuarios_estados = getCalendarioEmpleadoServiceInterface().findAll();
		// System.out.println(usuarios_estados);
		return usuarios_estados;
	}

	@GetMapping("")
	public Usuario_Estado getCalendarioEmpleadoByIds(
			@PathVariable("empleado_id") Integer empleado_id,
			@PathVariable("calendario_id") Integer calendario_id, 
			@PathVariable("jornada_id") Integer jornada_id,
			@PathVariable("estado_id") Integer estado_id)
	{

		Empleado empleado = jpaEmpleadoServiceInterface.findById(empleado_id).get();
		Jornada jornada = jpaJornadaServiceInterface.findById(jornada_id).get();
		//Calendario calendario = calendarioServiceInterface.
		
		
		return null;
		
	}

	/*
	 * @GetMapping("/calendario-empleado/{id}") public Usuario_Estado
	 * getCalendarioEmpleadoByEmpleadoId(@PathVariable("id") Integer id) {
	 * 
	 * Empleado empleado = jpaEmpleadoServiceInterface.findById(id).get();
	 * 
	 * System.out.println(empleado.getNombre());
	 * 
	 * 
	 * return null; }
	 */

	// @PostMapping("/calendario-empleado")
	// public Usuario_Estado postUsuario_Estado(@RequestBody Usuario_Estado usuario_Estado)
	// {

	// 	return calendarioEmpleadoServiceInterface.save(usuario_Estado);
	// }

	/////////////////////////////////////////////////////////////////////////////////////////////////////////

	public CalendarioEmpleadoServiceInterface getCalendarioEmpleadoServiceInterface()
	{
		return calendarioEmpleadoServiceInterface;
	}

	public void setCalendarioEmpleadoServiceInterface(
			CalendarioEmpleadoServiceInterface calendarioEmpleadoServiceInterface)
	{
		this.calendarioEmpleadoServiceInterface = calendarioEmpleadoServiceInterface;
	}

	public CalendarioServiceInterface getCalendarioServiceInterface()
	{
		return calendarioServiceInterface;
	}

	public void setCalendarioServiceInterface(CalendarioServiceInterface calendarioServiceInterface)
	{
		this.calendarioServiceInterface = calendarioServiceInterface;
	}

	public JPAEmpleadoServiceInterface getJpaEmpleadoServiceInterface()
	{
		return jpaEmpleadoServiceInterface;
	}

	public void setJpaEmpleadoServiceInterface(JPAEmpleadoServiceInterface jpaEmpleadoServiceInterface)
	{
		this.jpaEmpleadoServiceInterface = jpaEmpleadoServiceInterface;
	}

	public JPAJornadaServiceInterface getJpaJornadaServiceInterface()
	{
		return jpaJornadaServiceInterface;
	}

	public void setJpaJornadaServiceInterface(JPAJornadaServiceInterface jpaJornadaServiceInterface)
	{
		this.jpaJornadaServiceInterface = jpaJornadaServiceInterface;
	}

	public EstadosServiceInterface getEstadosServiceInterface()
	{
		return estadosServiceInterface;
	}

	public void setEstadosServiceInterface(EstadosServiceInterface estadosServiceInterface)
	{
		this.estadosServiceInterface = estadosServiceInterface;
	}

}
