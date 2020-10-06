package cap.curso.accesos.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cap.curso.accesos.DTOs.RegistroDto;
import cap.curso.accesos.entidades.UsuarioEstado;
import cap.curso.accesos.servicios.UsuariosEstadoServiceInterface;

@RestController
@RequestMapping("/api/usuarios-estados")
public class UsuariosEstadosRestController
{

	@Autowired
	private UsuariosEstadoServiceInterface usuariosEstadosService;
	

	public UsuariosEstadoServiceInterface getUsuariosEstadosService()
	{
		return usuariosEstadosService;
	}

	public void setUsuariosEstadosService(UsuariosEstadoServiceInterface usuariosEstadosService)
	{
		this.usuariosEstadosService = usuariosEstadosService;
	}

	@GetMapping("/")
	public Iterable<UsuarioEstado> getCuadrante()
	{
		return getUsuariosEstadosService().findAll();
	}

	@GetMapping("/{id}")
	public UsuarioEstado getCalendarioEmpleadoById(@PathVariable("id") Integer id)
	{
		return getUsuariosEstadosService().findById(id);
	}

	@PostMapping("/guardar-registro")
	public UsuarioEstado guardar(@RequestBody RegistroDto registro)
	{
		return getUsuariosEstadosService().save(registro);
	}

	@PostMapping("/borrar-registro")
	public void delete(@RequestBody UsuarioEstado ue)
	{
		getUsuariosEstadosService().delete(ue);
	}
	
	@GetMapping("/calendario/{empleadoId}/{anyo}")
	public List<UsuarioEstado> getCalendarioEmpleadoByIdAndYear(@PathVariable("empleadoId") Integer idEmpleado, @PathVariable("anyo") Integer anyo)
	{
		return getUsuariosEstadosService().getCalendarioEmpleado(idEmpleado, anyo);
	}

}
