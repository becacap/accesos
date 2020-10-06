package cap.curso.accesos.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cap.curso.accesos.entidades.Acceso;
import cap.curso.accesos.servicios.AccesosServiceInterface;

@RestController
@RequestMapping("/api/accesos")
public class AccesosRestController
{
	@Autowired
	private AccesosServiceInterface fichajesServiceInterface;

	public AccesosServiceInterface getFichajesServiceInterface()
	{
		return fichajesServiceInterface;
	}

	public void setFichajesServiceInterface(AccesosServiceInterface fichajesServiceInterface)
	{
		this.fichajesServiceInterface = fichajesServiceInterface;
	}

	@GetMapping("/")
	public List<Acceso> getAccesos()
	{
		return (List<Acceso>) getFichajesServiceInterface().findAll();
	}

	@GetMapping("/{id}")
	public Acceso findById(@PathVariable("id") Integer idFichaje)
	{
		return getFichajesServiceInterface().findById(idFichaje);
	}

}
