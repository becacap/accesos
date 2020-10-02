package cap.curso.accesos.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cap.curso.accesos.entidades.Empleado;
import cap.curso.accesos.entidades.Estado;
import cap.curso.accesos.entidades.Jornada;
import cap.curso.accesos.entidades.Usuario_Estado;
import cap.curso.accesos.servicios.CalendarioEmpleadoServiceInterface;
import cap.curso.accesos.servicios.CalendarioServiceInterface;
import cap.curso.accesos.servicios.EstadosServiceInterface;
import cap.curso.accesos.servicios.EmpleadoServiceInterface;
import cap.curso.accesos.servicios.JornadaServiceInterface;

@RestController
@RequestMapping("/api")
public class CalendarioEmpleadoRestControler
{
	@Autowired
	private CalendarioEmpleadoServiceInterface calendarioEmpleadoServiceInterface;

	@Autowired
	private CalendarioServiceInterface calendarioServiceInterface;
	@Autowired
	private EmpleadoServiceInterface jpaEmpleadoServiceInterface;
	@Autowired
	private JornadaServiceInterface jpaJornadaServiceInterface;
	@Autowired
	private EstadosServiceInterface estadosServiceInterface;

	@GetMapping("/usuariosEstados")
	public Iterable<Usuario_Estado> getUsuariosEstados(){
		return getCalendarioEmpleadoServiceInterface().findAll();
	}
	
	@GetMapping("/calendario-empleado")
	public Usuario_Estado getCalendarioEmpleado(@RequestParam("usuario_Estado") Usuario_Estado usuario_Estado)
	{
		return getCalendarioEmpleadoServiceInterface().save(usuario_Estado);
	}

	@GetMapping("/calendario-empleado/{id}")
	public Usuario_Estado getCalendarioEmpleadoById(@PathVariable("id") Integer id)
	{
		return calendarioEmpleadoServiceInterface.findById(id);
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
	
	
	@GetMapping("/usuarioEstado")
	public List<Usuario_Estado> getUsuario_Estado()
	{
		return  getCalendarioEmpleadoServiceInterface().findAll();
	}
	
	
	
	@DeleteMapping("/deleteUsuarioEstado/{id}")
	public void deleteUsuarioEstado(@PathVariable("id") int id) {
		getCalendarioEmpleadoServiceInterface().deleteById(id);
	}

	@PostMapping("/calendario-empleado")
	public Usuario_Estado postUsuario_Estado(@RequestBody Usuario_Estado usuario_Estado)
	{

		return calendarioEmpleadoServiceInterface.save(usuario_Estado);
	}

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

	public EmpleadoServiceInterface getJpaEmpleadoServiceInterface()
	{
		return jpaEmpleadoServiceInterface;
	}

	public void setJpaEmpleadoServiceInterface(EmpleadoServiceInterface jpaEmpleadoServiceInterface)
	{
		this.jpaEmpleadoServiceInterface = jpaEmpleadoServiceInterface;
	}

	public JornadaServiceInterface getJpaJornadaServiceInterface()
	{
		return jpaJornadaServiceInterface;
	}

	public void setJpaJornadaServiceInterface(JornadaServiceInterface jpaJornadaServiceInterface)
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
