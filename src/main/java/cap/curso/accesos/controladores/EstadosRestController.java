package cap.curso.accesos.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cap.curso.accesos.entidades.Estado;
import cap.curso.accesos.servicios.EstadosServiceInterface;

@RestController
@RequestMapping("/api/estados")
@CrossOrigin(origins = "http://localhost:4200")
public class EstadosRestController
{
	@Autowired
	private EstadosServiceInterface estadosServiceInterface;

	public EstadosServiceInterface getEstadosServiceInterface()
	{
		return estadosServiceInterface;
	}

	public void setEstadosServiceInterface(EstadosServiceInterface estadosServiceInterface)
	{
		this.estadosServiceInterface = estadosServiceInterface;
	}

	@GetMapping("/")
	public List<Estado> getEstados()
	{
		return getEstadosServiceInterface().findAll();
	}

	@PostMapping("/guardar-estado")
	public Estado grabaEstado(@RequestBody Estado estado)
	{
		return getEstadosServiceInterface().save(estado);
	}

	@GetMapping("/estados-calendario")
	public Iterable<Estado> getEstadosCalendario()
	{
		return getEstadosServiceInterface().getEstadosCalendario();
	}

}
