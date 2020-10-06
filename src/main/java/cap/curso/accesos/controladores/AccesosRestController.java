package cap.curso.accesos.controladores;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import cap.curso.accesos.servicios.EstadosServiceInterface;
import cap.curso.accesos.servicios.EmpleadoServiceInterface;
import cap.curso.accesos.servicios.JornadaServiceInterface;


@RestController
@RequestMapping("/api")
public class AccesosRestController
{
	@Autowired
	private EstadosServiceInterface estadosServiceInterface;

	@Autowired
	private JornadaServiceInterface jPAJornadaServiceInterface;

	@Autowired
	private EmpleadoServiceInterface jpaEmpleadoSI;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping(value="/estados")
	public Estado grabaEstado(@RequestBody Estado estado) {
		
		return getEstadosServiceInterface().save(estado);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/estado")
	public Estado getEstadoByDesc(@RequestParam("descripcion") String descripcion)
	{
		return getEstadosServiceInterface().findByDescripcion(descripcion);
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/add-jornada")
	public Jornada introducirJornada(@RequestBody Jornada jornada) {
		if(jornada.getId() == 0) return getJornadaServiceInterface().save(jornada);
		else return null;
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/jornadas")
	public List<Jornada> getAllJornadas()
	{
		List<Jornada> jornadas = new ArrayList<Jornada>();
		jornadas = (ArrayList<Jornada>) getJornadaServiceInterface().findAll();
		return jornadas;
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/jornada/{id}")
	public Optional<Jornada> getJornada(@PathVariable int id)
	{
		return getJornadaServiceInterface().findById(id);
	}
	@CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/modificarJornada")
	public Empleado modificarJornada(@RequestBody Empleado empleado)
	{
		if(empleado.getJornada().getId() == 0) {
		empleado.setJornada(getjPAJornadaServiceInterface().save(empleado.getJornada()));
		}
		getJpaEmpleadoSI().save(empleado);
		return empleado;
	}

	@GetMapping("/modificarEmpleados")
	public Empleado modificarEmpleado(@RequestBody Empleado empleado)
	{
		if(empleado.getJornada().getId()==0) {
			empleado.setJornada(getjPAJornadaServiceInterface().save(empleado.getJornada()));
		}
		getJpaEmpleadoSI().save(empleado);
		
		return empleado;
	}
	@GetMapping("/empleados")
	public List<Empleado> getAllEmpleados()
	{
		return (ArrayList<Empleado>) getJpaEmpleadoSI().findAll();
	}
	
	@GetMapping("/empleado/{id}")
	public Optional<Empleado> getEmpleado(@PathVariable int id)
	{
		return getJpaEmpleadoSI().findById(id);
	}
	public JornadaServiceInterface getJornadaServiceInterface()

	{
		return jPAJornadaServiceInterface;
	}

	public void setJornadaServiceInterface(JornadaServiceInterface jornadaServiceInterface)
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

	public cap.curso.accesos.servicios.EmpleadoServiceInterface getJpaEmpleadoSI()
	{
		return jpaEmpleadoSI;
	}

	public void setJpaEmpleadoSI(cap.curso.accesos.servicios.EmpleadoServiceInterface jpaEmpleadoSI)
	{
		this.jpaEmpleadoSI = jpaEmpleadoSI;
	}

	public JornadaServiceInterface getjPAJornadaServiceInterface()
	{
		return jPAJornadaServiceInterface;
	}

	public void setjPAJornadaServiceInterface(JornadaServiceInterface jPAJornadaServiceInterface)
	{
		this.jPAJornadaServiceInterface = jPAJornadaServiceInterface;
	}
}
