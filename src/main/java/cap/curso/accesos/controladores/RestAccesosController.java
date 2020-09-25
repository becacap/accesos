package cap.curso.accesos.controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cap.curso.accesos.entidades.Empleado;
import cap.curso.accesos.entidades.Estado;
import cap.curso.accesos.entidades.Jornada;
import cap.curso.accesos.estado.servicios.EstadosServiceInterface;



@RestController
@RequestMapping("/api")
public class RestAccesosController
{
	@Autowired
	private EstadosServiceInterface estadosServiceInterface;
	
	@Autowired
	private cap.curso.accesos.servicios.JPAJornadaServiceInterface jpaJornadaSI;
	
	@Autowired
	private cap.curso.accesos.servicios.JPAEmpleadoServiceInterface jpaEmpleadoSI;
	
	@GetMapping("/ejemplo")
	public Estado home(@RequestParam("descripcion") String descripcion) {
		return getEstadosServiceInterface().findByDescripcion(descripcion);
	}
	
	@PostMapping("/modificarJornada")
	public java.util.Optional<Empleado> modificarJornada(@RequestBody("empleado") java.util.Optional<Empleado> empleado, Jornada jornada) {
		Jornada jornadaNueva = new Jornada();
		jornadaNueva.setLunes("9.00-20.00");
		jornadaNueva.setMartes("9.00-20.00");
		jornadaNueva.setMiercoles("9.00-20.00");
		jornadaNueva.setJueves("9.00-20.00");
		jornadaNueva.setViernes("9.00-20.00");
		jornadaNueva.setDescripcion("Jornada completa");
		jpaJornadaSI.save(jornadaNueva);
		
		empleado.get().setJornada(jornadaNueva);
		return empleado;
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
