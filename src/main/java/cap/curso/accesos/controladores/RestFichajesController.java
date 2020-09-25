package cap.curso.accesos.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cap.curso.accesos.entidades.Calendario;
import cap.curso.accesos.entidades.Empleado;
import cap.curso.accesos.entidades.Estado;
import cap.curso.accesos.entidades.Usuario_Estado;
import cap.curso.accesos.estado.servicios.EstadosServiceInterface;
import cap.curso.accesos.services.UsuariosEstadoServiceInterface;

@RestController
@RequestMapping("/api")
public class RestFichajesController
{

	@Autowired
	private UsuariosEstadoServiceInterface usuarioEstadoServiceInterface;
	
	@GetMapping("/prueba")
	public Usuario_Estado home(@RequestParam("empleado") Empleado empleado, @RequestParam("calendario") Calendario calendario) {
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
