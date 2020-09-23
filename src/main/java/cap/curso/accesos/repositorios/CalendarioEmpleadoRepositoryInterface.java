package cap.curso.accesos.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cap.curso.accesos.entidades.Usuario_Estado;

@Repository
public interface CalendarioEmpleadoRepositoryInterface extends CrudRepository<Usuario_Estado, Integer>
{

	//@Query("update Calendario c set c.estado=:estado where c.id = id_calendario")
	//public void update(Integer id_calendario, Integer id_empleado, Integer id_jornada, Integer id_estado);



}
