package cap.curso.accesos.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cap.curso.accesos.entidades.Jornada;
import cap.curso.accesos.repositorios.JornadaRepositoryInterface;

@Service
public class JPAJornadaService implements JPAJornadaServiceInterface
{
	@Autowired
	JornadaRepositoryInterface jornadaRepositoryInterface;

	public Jornada save(Jornada jornada)
	{
		return getJornadaRepositoryInterface().save(jornada);
	}

	public Iterable<Jornada> findAll()
	{
		return getJornadaRepositoryInterface().findAll();
	}

	
	

	public JornadaRepositoryInterface getJornadaRepositoryInterface()
	{
		return jornadaRepositoryInterface;
	}

	public void setJornadaRepositoryInterface(JornadaRepositoryInterface jornadaRepositoryInterface)
	{
		this.jornadaRepositoryInterface = jornadaRepositoryInterface;
	}

	public Optional<Jornada> findById(Integer id)
	{
		// TODO Auto-generated method stub
		return getJornadaRepositoryInterface().findById(id);
	}


	
	
	

}
