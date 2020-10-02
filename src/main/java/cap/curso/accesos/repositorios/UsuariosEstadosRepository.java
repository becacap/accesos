package cap.curso.accesos.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cap.curso.accesos.entidades.Calendario;
import cap.curso.accesos.entidades.Empleado;
import cap.curso.accesos.entidades.UsuarioEstado;

@Repository
public interface UsuariosEstadosRepository extends CrudRepository<UsuarioEstado, Integer>
{
	@Query("from UsuarioEstado ue where ue.empleado=:empleado and ue.calendario=:calendario")
	public UsuarioEstado getUsuarioEstadoByEmpleado(Empleado empleado, Calendario calendario);
}
