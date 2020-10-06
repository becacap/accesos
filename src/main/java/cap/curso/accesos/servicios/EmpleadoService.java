package cap.curso.accesos.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cap.curso.accesos.entidades.Empleado;
import cap.curso.accesos.entidades.Jornada;
import cap.curso.accesos.exception.EmpleadoNotFoundException;
import cap.curso.accesos.repositorios.EmpleadoRepository;

@Service
public class EmpleadoService implements EmpleadoServiceInterface
{
	@Autowired
	private EmpleadoRepository empleadoRepo;

	public EmpleadoRepository getEmpleadoRepo()
	{
		return empleadoRepo;
	}

	public void setEmpleadoRepo(EmpleadoRepository empleadoRepo)
	{
		this.empleadoRepo = empleadoRepo;
	}

	public Empleado save(Empleado empleado)
	{
		return getEmpleadoRepo().save(empleado);
	}

	public Iterable<Empleado> findAll()
	{
		return getEmpleadoRepo().findAll();
	}

	public Empleado findById(Integer id)
	{
		return getEmpleadoRepo().findById(id).orElse(null);
	}

	public Empleado modificarJornada(Integer idEmpleado, Jornada jornada) throws EmpleadoNotFoundException
	{
		Empleado empleado = getEmpleadoRepo().findById(idEmpleado).orElse(null);

		if (empleado == null)
		{
			throw new EmpleadoNotFoundException("No existe el empleado");
		}

		empleado.setJornada(jornada);
		return getEmpleadoRepo().save(empleado);
	}

}
