package cap.curso.accesos.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cap.curso.accesos.entidades.Empleado;
import cap.curso.accesos.entidades.Estado;
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

	@PostMapping("/modificarJornada")
	public Empleado modificarJornada(@RequestBody Empleado empleado)
	{

		empleado.setJornada(getjPAJornadaServiceInterface().save(empleado.getJornada()));
		getJpaEmpleadoSI().save(empleado);
		return empleado;
	}

	@PostMapping("/empleados/modificar")
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
		List<Empleado> empleados = new ArrayList<Empleado>();
		empleados = (ArrayList<Empleado>) getJpaEmpleadoSI().findAll();
		return empleados;
	}
	
	@GetMapping("/empleados/{id}")
	public Optional<Empleado> getEmpleado(@PathVariable int id)
	{
		return getJpaEmpleadoSI().findById(id);
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
