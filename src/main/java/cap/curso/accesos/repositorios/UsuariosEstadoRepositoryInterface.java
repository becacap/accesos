package cap.curso.accesos.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cap.curso.accesos.entidades.Calendario;
import cap.curso.accesos.entidades.Empleado;
import cap.curso.accesos.entidades.Usuario_Estado;

@Repository
public interface UsuariosEstadoRepositoryInterface extends CrudRepository<Usuario_Estado, Integer>
{
	
	//from Usuario_Estado ue where ue.emplead=:empleado and ue.calendario=:calendario

	@Query("from Usuario_Estado ue where ue.empleado=:empleado and ue.calendario=:calendario")
	public Usuario_Estado getUsuarioEstadoByEmpleado(Empleado empleado,Calendario calendario);
}
