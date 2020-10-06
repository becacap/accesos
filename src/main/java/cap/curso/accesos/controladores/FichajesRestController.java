package cap.curso.accesos.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cap.curso.accesos.entidades.Acceso;
import cap.curso.accesos.entidades.Estado;
import cap.curso.accesos.servicios.FichajesServiceInterface;

@RestController
@RequestMapping("/api/fichajes")
public class FichajesRestController
{
	@Autowired
	private FichajesServiceInterface fichajesServiceInterface;

	public FichajesServiceInterface getFichajesServiceInterface()
	{
		return fichajesServiceInterface;
	}

	public void setFichajesServiceInterface(FichajesServiceInterface fichajesServiceInterface)
	{
		this.fichajesServiceInterface = fichajesServiceInterface;
	}

	@GetMapping("/fichajes")
	public List<Acceso> getAccesos()
	{
		return (List<Acceso>) getFichajesServiceInterface().findAll();
	}
	
	
}
