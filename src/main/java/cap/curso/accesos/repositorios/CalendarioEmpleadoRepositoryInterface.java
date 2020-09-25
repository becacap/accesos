package cap.curso.accesos.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cap.curso.accesos.entidades.Usuario_Estado;

@Repository
public interface CalendarioEmpleadoRepositoryInterface extends CrudRepository<Usuario_Estado, Integer>
{

}
