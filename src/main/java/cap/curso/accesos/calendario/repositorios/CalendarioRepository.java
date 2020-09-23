package cap.curso.accesos.calendario.repositorios;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cap.curso.accesos.entidades.Calendario;

@Repository
public interface CalendarioRepository extends CrudRepository<Calendario, Integer>
{

	@Query("from Calendario c where SubString(cast(c.fecha as text),1,4) = :anyo")
	public Iterable<Calendario> findByAnyo(@Param("anyo") String anyo);

	// @Query(value =
	// "select * from calendarios c where extract(YEAR from c.fecha) = :anyo",
	// nativeQuery = true)
}
