package cap.curso.accesos.servicios;

import org.springframework.stereotype.Service;

import cap.curso.accesos.DTOs.RegistroDto;
import cap.curso.accesos.entidades.Calendario;
import cap.curso.accesos.entidades.Empleado;
import cap.curso.accesos.entidades.UsuarioEstado;

@Service
public interface UsuariosEstadoServiceInterface {
	
	public Iterable<UsuarioEstado> findAll();
	
	public UsuarioEstado findById(Integer id);
	
	public UsuarioEstado save(RegistroDto registro);
	
	public UsuarioEstado save(UsuarioEstado ue);
	
	public void delete(UsuarioEstado ue);

	public UsuarioEstado getDiasTrabajadosEmpleadoByYearByMes (Empleado empleado, Calendario calendario);
}
