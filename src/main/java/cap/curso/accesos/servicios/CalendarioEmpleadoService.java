package cap.curso.accesos.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cap.curso.accesos.entidades.Usuario_Estado;
import cap.curso.accesos.repositorios.CalendarioEmpleadoRepositoryInterface;

@Service
public class CalendarioEmpleadoService implements CalendarioEmpleadoServiceInterface
{
	@Autowired
	private CalendarioEmpleadoRepositoryInterface calendarioEmpleadoRepository;
	
	public Usuario_Estado save(Usuario_Estado usuario_Estado)
	{
		return getCalendarioEmpleadoRepository().save(usuario_Estado);

	}

	

	public CalendarioEmpleadoRepositoryInterface getCalendarioEmpleadoRepository()
	{
		return calendarioEmpleadoRepository;
	}

	public void setCalendarioEmpleadoRepository(CalendarioEmpleadoRepositoryInterface calendarioEmpleadoRepository)
	{
		this.calendarioEmpleadoRepository = calendarioEmpleadoRepository;
	}

	
	

}
