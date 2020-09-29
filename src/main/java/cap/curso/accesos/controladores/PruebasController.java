package cap.curso.accesos.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cap.curso.accesos.entidades.Estado;
import cap.curso.accesos.estado.servicios.EstadosServiceInterface;

@RestController
public class PruebasController
{
	@Autowired
	private EstadosServiceInterface estadosServiceInterface;
	@GetMapping("/estados")
	public List<Estado> getEstados(){
		
		return getEstadosServiceInterface().getEstados();
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
