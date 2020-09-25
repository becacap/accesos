package cap.curso.accesos.controladores;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cap.curso.accesos.entidades.Empleado;
import cap.curso.accesos.entidades.Estado;
import cap.curso.accesos.entidades.Jornada;
import cap.curso.accesos.estado.servicios.EstadosServiceInterface;
import cap.curso.accesos.servicios.JPAJornadaServiceInterface;

@RestController
@RequestMapping("/api")
public class RestAccesosController
{
	@Autowired
	private EstadosServiceInterface estadosServiceInterface;


	@Autowired
	private JPAJornadaServiceInterface jPAJornadaServiceInterface;

	@Autowired
	private cap.curso.accesos.servicios.JPAEmpleadoServiceInterface jpaEmpleadoSI;

	@GetMapping("/ejemplo")
	public Estado home(@RequestParam("descripcion") String descripcion)
	{
		return getEstadosServiceInterface().findByDescripcion(descripcion);
	}
	
	@PostMapping("/add-jornada")
	public Jornada introducirJornada() {
		Jornada jornada = new Jornada();
		jornada.setDescripcion("Jornada Completa");
		jornada.setLunes("8:00-14:00&15:00-17:30");
		jornada.setMartes("8:00-14:00&15:00-17:30");
		jornada.setMiercoles("8:00-14:00&15:00-17:30");
		jornada.setJueves("8:00-14:00&15:00-17:30");
		jornada.setViernes("8:00-15:00");
		jornada.setEspecial(0);
		
		return getJornadaServiceInterface().save(jornada);
	}
	
	@GetMapping("/find-jornadas")
	public List<Jornada> getAllJornadas()
	{
		List<Jornada> jornadas = new ArrayList<Jornada>();
		jornadas = (List<Jornada>) getJornadaServiceInterface().findAll();
		return jornadas;
	}
	
	@GetMapping("/jornadaId/{id}")
	public Optional<Jornada> getJornada(@RequestParam("id") int id)
	{
		Optional<Jornada> jornada = getJornadaServiceInterface().findById(id);
		return jornada;
	}
	
	

	@PostMapping("/modificarJornada")
	public Empleado modificarJornada(@RequestBody Empleado empleado)
	{
		empleado.setJornada(getjPAJornadaServiceInterface().save(empleado.getJornada()));
		getJpaEmpleadoSI().save(empleado);
		return empleado;
	}

	public JPAJornadaServiceInterface getJornadaServiceInterface()
	{
		return jPAJornadaServiceInterface;
	}

	public void setJornadaServiceInterface(JPAJornadaServiceInterface jornadaServiceInterface)
	{
		this.jPAJornadaServiceInterface = jornadaServiceInterface;
	}

	public EstadosServiceInterface getEstadosServiceInterface()
	{
		return estadosServiceInterface;
	}

	public void setEstadosServiceInterface(EstadosServiceInterface estadosServiceInterface)
	{
		this.estadosServiceInterface = estadosServiceInterface;
	}

	public cap.curso.accesos.servicios.JPAEmpleadoServiceInterface getJpaEmpleadoSI()
	{
		return jpaEmpleadoSI;
	}

	public void setJpaEmpleadoSI(cap.curso.accesos.servicios.JPAEmpleadoServiceInterface jpaEmpleadoSI)
	{
		this.jpaEmpleadoSI = jpaEmpleadoSI;
	}

	public JPAJornadaServiceInterface getjPAJornadaServiceInterface()
	{
		return jPAJornadaServiceInterface;
	}

	public void setjPAJornadaServiceInterface(JPAJornadaServiceInterface jPAJornadaServiceInterface)
	{
		this.jPAJornadaServiceInterface = jPAJornadaServiceInterface;
	}
}
