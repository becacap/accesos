package cap.curso.accesos.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cap.curso.accesos.entidades.Calendario;
import cap.curso.accesos.entidades.Empleado;
import cap.curso.accesos.entidades.Usuario_Estado;
import cap.curso.accesos.servicios.UsuariosEstadoServiceInterface;

@RestController
@RequestMapping("/api")
public class FichajesRestController
{

	@Autowired
	private UsuariosEstadoServiceInterface usuarioEstadoServiceInterface;
	
	@GetMapping("/prueba")
	public Usuario_Estado home(@RequestBody Empleado empleado, @RequestBody Calendario calendario) {
		return getUsuarioEstadoServiceInterface().getDiasTrabajadosEmpleadoByYearByMes(empleado, calendario);
	}
	
	public UsuariosEstadoServiceInterface getUsuarioEstadoServiceInterface()
	{
		return usuarioEstadoServiceInterface;
	}

	public void setUsuarioEstadoServiceInterface(UsuariosEstadoServiceInterface usuarioEstadoServiceInterface)
	{
		this.usuarioEstadoServiceInterface = usuarioEstadoServiceInterface;
	}
}
