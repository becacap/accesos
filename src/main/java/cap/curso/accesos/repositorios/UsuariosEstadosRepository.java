package cap.curso.accesos.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cap.curso.accesos.entidades.Calendario;
import cap.curso.accesos.entidades.Empleado;
import cap.curso.accesos.entidades.UsuarioEstado;

@Repository
public interface UsuariosEstadosRepository extends CrudRepository<UsuarioEstado, Integer>
{
	@Query("from UsuarioEstado ue where ue.empleado=:empleado and ue.calendario=:calendario")
	public UsuarioEstado getUsuarioEstadoByEmpleado(Empleado empleado, Calendario calendario);

	//@Query(value = "SELECT * FROM Usuarios_Estados WHERE empleados_id=:empleado AND calendarios_id IN (SELECT calendarios_id FROM calendarios WHERE year(fecha)=:year)", nativeQuery = true)
	@Query(value="SELECT * FROM Usuarios_Estados ue, calendarios c  WHERE ue.empleados_id=:empleado AND ue.calendarios_id=c.id and year(c.fecha)=:year", nativeQuery=true)
	List<UsuarioEstado> getCalendarioEmpleado(@Param("empleado") Integer empleado, @Param("year") Integer year);

}
