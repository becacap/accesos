package cap.curso.accesos.calendario.servicios;

import org.springframework.stereotype.Service;

import cap.curso.accesos.calendario.exception.CalendarioAlreadyExistsException;
import cap.curso.accesos.calendario.exception.CalendarioNotFoundException;
import cap.curso.accesos.entidades.Calendario;
import cap.curso.accesos.entidades.Estado;
import cap.curso.accesos.estado.exception.EstadoNotFoundException;

@Service
public interface CalendarioServiceInterface
{

	public Iterable<Calendario> findAll();
	
	public Calendario findById(Integer idCalendario);

	public Calendario save(Calendario calendario) throws CalendarioAlreadyExistsException;

	public Iterable<Calendario> generaCalendarioAnyo(Integer anyo)
			throws CalendarioAlreadyExistsException, EstadoNotFoundException;

	public Calendario updateCalendarioEstado(Integer idCalendario, Estado estado) throws CalendarioNotFoundException;

	public Iterable<Calendario> findByAnyo(Integer anyo) throws CalendarioNotFoundException;

}
