package cap.curso.accesos.servicios;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cap.curso.accesos.entidades.Empleado;
import cap.curso.accesos.entidades.Jornada;
import cap.curso.accesos.repositorios.EmpleadoRepositoryInterface;

@Service
public class EmpleadoService implements EmpleadoServiceInterface
{
	@Autowired
	private EmpleadoRepositoryInterface empleadoRepo;
	
	public Empleado save(Empleado empleado)
	{
		return getEmpleadoRepo().save(empleado);
	}

	public Iterable<Empleado> findAll()
	{
		// TODO Auto-generated method stub
		return getEmpleadoRepo().findAll();
	}

	public Optional<Empleado> findById(Integer id) {
		return getEmpleadoRepo().findById(id);
	}
	
	public Empleado modificarJornada(Empleado empleado, Jornada jornada) {
		empleado.setJornada(jornada);
		empleadoRepo.save(empleado);
		return empleado;
	}
	
//	############ GETTER && SETTER  ###########################
	public EmpleadoRepositoryInterface getEmpleadoRepo()
	{
		return empleadoRepo;
	}

	public void setEmpleadoRepo(EmpleadoRepositoryInterface empleadoRepo)
	{
		this.empleadoRepo = empleadoRepo;
	}

}
