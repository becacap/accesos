package cap.curso.accesos.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cap.curso.accesos.entidades.Acceso;
import cap.curso.accesos.repositorios.FichajesRepository;

@Service
public class FichajesService implements FichajesServiceInterface
{
	
	@Autowired
	private FichajesRepository fichajesRepo;

	@Override
	public Acceso save(Acceso acceso)
	{
		return getFichajesRepo().save(acceso);
	}

	@Override
	public Iterable<Acceso> findAll()
	{
		return getFichajesRepo().findAll();
	}

	public FichajesRepository getFichajesRepo()
	{
		return fichajesRepo;
	}

	public void setFichajesRepo(FichajesRepository fichajesRepo)
	{
		this.fichajesRepo = fichajesRepo;
	}
	
	
	

}