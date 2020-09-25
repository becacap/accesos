package cap.curso.accesos.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cap.curso.accesos.calendario.servicios.CalendarioServiceInterface;
import cap.curso.accesos.entidades.Empleado;
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
	
	
	
	
	@GetMapping("/calendario-empleado")
	public Usuario_Estado home(@RequestParam("usuario_Estado") Usuario_Estado usuario_Estado) {
		
		//Calendario calendario = calendarioEmpleadoServiceInterface.(usuario_Estado.getEmpleado().getId()).get();
		Empleado empleado = jpaEmpleadoServiceInterface.findById(usuario_Estado.getEmpleado().getId()).get();
		

		
		System.out.println("Get - " + usuario_Estado.getId());
		
		return getCalendarioEmpleadoServiceInterface().save(usuario_Estado);
	}
	
	@PostMapping("/calendario-empleado")
	public Usuario_Estado postUsuario_Estado(@RequestBody Usuario_Estado usuario_Estado) {
		
		System.out.println("A ver " + usuario_Estado.getId());
		
		return usuario_Estado;
	}
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	public CalendarioEmpleadoServiceInterface getCalendarioEmpleadoServiceInterface()
	{
		return calendarioEmpleadoServiceInterface;
	}

	public void setCalendarioEmpleadoServiceInterface(CalendarioEmpleadoServiceInterface calendarioEmpleadoServiceInterface)
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
