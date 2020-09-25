package cap.curso.accesos.controladores;


import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	private JPAJornadaServiceInterface jornadaServiceInterface;
	
	@GetMapping("/ejemplo")
	public Estado home(@RequestParam("descripcion") String descripcion) {
		return getEstadosServiceInterface().findByDescripcion(descripcion);
	}
	
	@GetMapping("jornada")
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
	
	

	public JPAJornadaServiceInterface getJornadaServiceInterface()
	{
		return jornadaServiceInterface;
	}

	public void setJornadaServiceInterface(JPAJornadaServiceInterface jornadaServiceInterface)
	{
		this.jornadaServiceInterface = jornadaServiceInterface;
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
