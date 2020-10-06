package cap.curso.accesos.servicios;

import java.util.List;
import java.util.Optional;

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

	@Override
	public Usuario_Estado findById(Integer id)
	{
		return getCalendarioEmpleadoRepository().findById(id).orElse(null);
	}


	@Override
	public List<Usuario_Estado> findAll()
	{
		// TODO Auto-generated method stub
		return (List<Usuario_Estado>) getCalendarioEmpleadoRepository().findAll();
	}
///////////////////----------------  GETTER && SETTER   -------------------------
	
	public CalendarioEmpleadoRepositoryInterface getCalendarioEmpleadoRepository()
	{
		return calendarioEmpleadoRepository;
	}

	public void setCalendarioEmpleadoRepository(CalendarioEmpleadoRepositoryInterface calendarioEmpleadoRepository)
	{
		this.calendarioEmpleadoRepository = calendarioEmpleadoRepository;
	}


	@Override
	public void delete(Usuario_Estado usuarioEstado)
	{
		// TODO Auto-generated method stub
		 getCalendarioEmpleadoRepository().delete(usuarioEstado);
	}


	@Override
	public void deleteById(int id)
	{
		getCalendarioEmpleadoRepository().deleteById(id);
		
	}

	
	

}
