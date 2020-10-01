package cap.curso.accesos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cap.curso.accesos.DTOs.RegistroDto;
import cap.curso.accesos.calendario.repositorios.CalendarioRepository;
import cap.curso.accesos.entidades.Calendario;
import cap.curso.accesos.entidades.Empleado;
import cap.curso.accesos.entidades.Estado;
import cap.curso.accesos.entidades.Jornada;
import cap.curso.accesos.entidades.Usuario_Estado;
import cap.curso.accesos.estado.repositorios.EstadosRepository;
import cap.curso.accesos.repositorios.EmpleadoRepositoryInterface;
import cap.curso.accesos.repositorios.JornadaRepositoryInterface;
import cap.curso.accesos.repositorios.UsuariosEstadoRepositoryInterface;

@Service
public class UsuariosEstadoService implements UsuariosEstadoServiceInterface
{

	@Autowired
	private UsuariosEstadoRepositoryInterface repositorio;

	@Autowired
	private EmpleadoRepositoryInterface empleadosRepository;

	@Autowired
	private JornadaRepositoryInterface jornadaRepository;

	@Autowired
	private EstadosRepository estadoRepository;

	@Autowired
	private CalendarioRepository calendarioRepository;

	public UsuariosEstadoRepositoryInterface getRepositorio()
	{
		return repositorio;
	}

	public void setRepositorio(UsuariosEstadoRepositoryInterface repositorio)
	{
		this.repositorio = repositorio;
	}

	public EmpleadoRepositoryInterface getEmpleadosRepository()
	{
		return empleadosRepository;
	}

	public void setEmpleadosRepository(EmpleadoRepositoryInterface empleadosRepository)
	{
		this.empleadosRepository = empleadosRepository;
	}

	public JornadaRepositoryInterface getJornadaRepository()
	{
		return jornadaRepository;
	}

	public void setJornadaRepository(JornadaRepositoryInterface jornadaRepository)
	{
		this.jornadaRepository = jornadaRepository;
	}

	public EstadosRepository getEstadoRepository()
	{
		return estadoRepository;
	}

	public void setEstadoRepository(EstadosRepository estadoRepository)
	{
		this.estadoRepository = estadoRepository;
	}

	public CalendarioRepository getCalendarioRepository()
	{
		return calendarioRepository;
	}

	public void setCalendarioRepository(CalendarioRepository calendarioRepository)
	{
		this.calendarioRepository = calendarioRepository;
	}

	public Usuario_Estado getDiasTrabajadosEmpleadoByYearByMes(Empleado empleado, Calendario cal)
	{
		Usuario_Estado ue = getRepositorio().getUsuarioEstadoByEmpleado(empleado, cal);

		return null;
	}

	public Iterable<Usuario_Estado> findAll()
	{
		return getRepositorio().findAll();
	}

	public Usuario_Estado save(RegistroDto registro)
	{
		Empleado emp = getEmpleadosRepository().findById(registro.getIdEmpleado()).orElse(null);
		Jornada jor = getJornadaRepository().findById(registro.getIdJornada()).orElse(null);
		Estado est = getEstadoRepository().findById(registro.getIdEstado()).orElse(null);
		Calendario cal = getCalendarioRepository().findById(registro.getIdCalendario()).orElse(null);
		
		Usuario_Estado ue = getRepositorio().getUsuarioEstadoByEmpleado(emp, cal);
		if(ue == null) { // no existe en la bd
			Usuario_Estado nuevoRegistro = new Usuario_Estado();
			nuevoRegistro.setEmpleado(emp);
			nuevoRegistro.setJornada(jor);
			nuevoRegistro.setEstado(est);
			nuevoRegistro.setCalendario(cal);
			return getRepositorio().save(nuevoRegistro);
		}
		else {
			ue.setEstado(est);
			ue.setJornada(jor);
			return getRepositorio().save(ue);
		}
		
	}
	
	public Usuario_Estado save(Usuario_Estado ue) {
		return getRepositorio().save(ue);
	}

	public void delete(Usuario_Estado ue) {
		getRepositorio().delete(ue);
	}
	
}
