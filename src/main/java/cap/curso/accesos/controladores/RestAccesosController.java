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
import cap.curso.accesos.estado.servicios.EstadosServiceInterface;



@RestController
@RequestMapping("/api")
public class RestAccesosController
{
	@Autowired
	private EstadosServiceInterface estadosServiceInterface;
	
	@GetMapping("/ejemplo")
	public Estado home(@RequestParam("descripcion") String descripcion) {
		return getEstadosServiceInterface().findByDescripcion(descripcion);
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
