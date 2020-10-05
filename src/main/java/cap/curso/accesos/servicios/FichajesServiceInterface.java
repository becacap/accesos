package cap.curso.accesos.servicios;

import org.springframework.stereotype.Service;

import cap.curso.accesos.entidades.Acceso;

@Service
public interface FichajesServiceInterface
{
	public Acceso save(Acceso acceso);
	
	public Iterable<Acceso> findAll();
	
}
