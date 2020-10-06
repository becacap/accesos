package cap.curso.accesos.servicios;

import org.springframework.stereotype.Service;

import cap.curso.accesos.entidades.Acceso;
import cap.curso.accesos.entidades.Empleado;

@Service
public interface FichajesServiceInterface
{
	public Acceso save(Acceso acceso);
	
	public Iterable<Acceso> findAll();
	
	public Iterable<Acceso> findFichajesMes(Empleado empleado, int anyo, int mes);
	
}
