package cap.curso.accesos.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import cap.curso.accesos.entidades.Estado;
import cap.curso.accesos.servicios.EstadosServiceInterface;

@RestController
public class PruebasRestController
{
	@Autowired
	private EstadosServiceInterface estadosServiceInterface;
	@CrossOrigin(origins = "http://localhost:4200")
	
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
