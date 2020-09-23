package cap.curso.accesos.servicios;

import java.util.Optional;

import org.springframework.stereotype.Service;

import cap.curso.accesos.entidades.Empleado;
import cap.curso.accesos.entidades.Jornada;

@Service
public interface JPAEmpleadoServiceInterface
{
	public Empleado save(Empleado empleado);
	
	public Iterable<Empleado> findAll();
	
	public Optional<Empleado> findById(Integer id);
	
	public Empleado modificarJornada(Empleado idEmpleado, Jornada idJornada);
}
