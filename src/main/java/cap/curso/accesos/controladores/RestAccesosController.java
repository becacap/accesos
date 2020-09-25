package cap.curso.accesos.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cap.curso.accesos.entidades.Empleado;
import cap.curso.accesos.estado.servicios.EstadosServiceInterface;

@RestController
@RequestMapping("/api")
public class RestAccesosController
{
	@Autowired
	private EstadosServiceInterface estadosServiceInterface;

	@PostMapping("/ejemplo")
	public Empleado home(@RequestBody Empleado empleado)
	{

		System.out.println(empleado.getNombre());
		System.out.println(empleado.getApellidos());
		System.out.println(empleado.getDni());
		System.out.println(empleado.getIdentificador());

		empleado.setNombre("nuevo nombre");
		
		empleado.getJornada().setMartes("hoy es martes");

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
