package cap.curso.accesos.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import cap.curso.accesos.DTOs.RegistroDto;
import cap.curso.accesos.entidades.Calendario;
import cap.curso.accesos.entidades.Empleado;
import cap.curso.accesos.entidades.UsuarioEstado;
import cap.curso.accesos.exception.CalendarioNotFoundException;
import cap.curso.accesos.exception.EmpleadoNotFoundException;

@Service
public interface UsuariosEstadoServiceInterface
{

	public Iterable<UsuarioEstado> findAll();

	public UsuarioEstado findById(Integer id);

	public UsuarioEstado save(RegistroDto registro);

	public UsuarioEstado save(UsuarioEstado ue);

	public void delete(UsuarioEstado ue);

	public UsuarioEstado getDiasTrabajadosEmpleadoByYearByMes(Empleado empleado, Calendario calendario);

	public List<UsuarioEstado> getCalendarioEmpleado(Integer empleado_id, Integer year) throws CalendarioNotFoundException, EmpleadoNotFoundException;

}
