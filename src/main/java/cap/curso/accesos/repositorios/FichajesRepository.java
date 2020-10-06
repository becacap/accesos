package cap.curso.accesos.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cap.curso.accesos.entidades.Acceso;
import cap.curso.accesos.entidades.Empleado;

@Repository
public interface FichajesRepository extends CrudRepository<Acceso, Integer>
{
	@Query("from Acceso a where a.empleado=:empleado and a.year=:anyo and a.month=:mes order by fecha, hora")
	public Iterable<Acceso> getFichajesByMes(Empleado empleado, int anyo,int mes);
}
