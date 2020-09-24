package cap.curso.accesos.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cap.curso.accesos.entidades.Usuario_Estado;
import cap.curso.accesos.servicios.CalendarioEmpleadoServiceInterface;

@RestController
@RequestMapping("/api")
public class RestCalendarioEmpleadoControler
{
	@Autowired
	private CalendarioEmpleadoServiceInterface calendarioEmpleadoServiceInterface;
	
	@GetMapping("/calendario-empleado")
	public Usuario_Estado home(@RequestParam("usuario_Estado") Usuario_Estado usuario_Estado) {
		return getCalendarioEmpleadoServiceInterface().save(usuario_Estado);
	}
	
	public CalendarioEmpleadoServiceInterface getCalendarioEmpleadoServiceInterface()
	{
		return calendarioEmpleadoServiceInterface;
	}

	public void setCalendarioEmpleadoServiceInterface(CalendarioEmpleadoServiceInterface calendarioEmpleadoServiceInterface)
	{
		this.calendarioEmpleadoServiceInterface = calendarioEmpleadoServiceInterface;
	}
}
