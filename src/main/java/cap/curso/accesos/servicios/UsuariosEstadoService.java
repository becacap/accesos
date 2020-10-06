package cap.curso.accesos.servicios;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cap.curso.accesos.DTOs.RegistroDto;
import cap.curso.accesos.entidades.Acceso;
import cap.curso.accesos.entidades.Calendario;
import cap.curso.accesos.entidades.Empleado;
import cap.curso.accesos.entidades.Estado;
import cap.curso.accesos.entidades.Jornada;
import cap.curso.accesos.entidades.UsuarioEstado;
import cap.curso.accesos.repositorios.CalendarioRepository;
import cap.curso.accesos.repositorios.EmpleadoRepositoryInterface;
import cap.curso.accesos.repositorios.EstadosRepository;
import cap.curso.accesos.repositorios.FichajesRepository;
import cap.curso.accesos.repositorios.JornadaRepository;
import cap.curso.accesos.repositorios.UsuariosEstadosRepository;

@Service
public class UsuariosEstadoService implements UsuariosEstadoServiceInterface
{

	@Autowired
	private UsuariosEstadosRepository usuariosEstadosRepository;

	@Autowired
	private EmpleadoRepositoryInterface empleadosRepository;

	@Autowired
	private JornadaRepository jornadaRepository;

	@Autowired
	private EstadosRepository estadoRepository;

	@Autowired
	private CalendarioRepository calendarioRepository;

	public UsuariosEstadosRepository getUsuariosEstadosRepository()
	{
		return usuariosEstadosRepository;
	}

	public void setUsuariosEstadosRepository(UsuariosEstadosRepository usuariosEstadosRepository)
	{
		this.usuariosEstadosRepository = usuariosEstadosRepository;
	}

	public EmpleadoRepositoryInterface getEmpleadosRepository()
	{
		return empleadosRepository;
	}

	public void setEmpleadosRepository(EmpleadoRepositoryInterface empleadosRepository)
	{
		this.empleadosRepository = empleadosRepository;
	}

	public JornadaRepository getJornadaRepository()
	{
		return jornadaRepository;
	}

	public void setJornadaRepository(JornadaRepository jornadaRepository)
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

	public Iterable<UsuarioEstado> findAll()
	{
		return getUsuariosEstadosRepository().findAll();
	}

	public UsuarioEstado findById(Integer id)
	{
		return getUsuariosEstadosRepository().findById(id).orElse(null);
	}

	public UsuarioEstado save(RegistroDto registro)
	{
		Empleado emp = getEmpleadosRepository().findById(registro.getIdEmpleado()).orElse(null);
		Jornada jor = getJornadaRepository().findById(registro.getIdJornada()).orElse(null);
		Estado est = getEstadoRepository().findById(registro.getIdEstado()).orElse(null);
		Calendario cal = getCalendarioRepository().findById(registro.getIdCalendario()).orElse(null);

		UsuarioEstado ue = getUsuariosEstadosRepository().getUsuarioEstadoByEmpleado(emp, cal);
		if (ue == null)
		{ // no existe en la bd
			UsuarioEstado nuevoRegistro = new UsuarioEstado();
			nuevoRegistro.setEmpleado(emp);
			nuevoRegistro.setJornada(jor);
			nuevoRegistro.setEstado(est);
			nuevoRegistro.setCalendario(cal);
			return getUsuariosEstadosRepository().save(nuevoRegistro);
		} else
		{
			ue.setEstado(est);
			ue.setJornada(jor);
			return getUsuariosEstadosRepository().save(ue);
		}

	}

	public UsuarioEstado save(UsuarioEstado ue)
	{
		return getUsuariosEstadosRepository().save(ue);
	}

	public void delete(UsuarioEstado ue)
	{
		getUsuariosEstadosRepository().delete(ue);
	}

	public UsuarioEstado getDiasTrabajadosEmpleadoByYearByMes(Empleado empleado, Calendario calendario)
	{
		return getUsuariosEstadosRepository().getUsuarioEstadoByEmpleado(empleado, calendario);
	}
	
	/*
	@Autowired
	private FichajesRepository fichajesRepo;

	@Override
	public void generarAccesos(int year)
	{
		Iterable<UsuarioEstado> usuariosEstados = getUsuariosEstadosRepository().findAll();
		
		while(usuariosEstados.iterator().next().getCalendario().getFecha().compareTo(new Date()) <= 0 && usuariosEstados.iterator().hasNext() && usuariosEstados.iterator().next().getCalendario().getFecha().getYear() == year) {
			UsuarioEstado ue = usuariosEstados.iterator().next();
			for (int i = 0; i<5; i++)
			{
				Acceso acc = new Acceso();
				acc.setEmpleado(ue.getEmpleado());
				acc.setDay(ue.getCalendario().getFecha().getDay());
				acc.setFecha(ue.getCalendario().getFecha());
				acc.setMonth(ue.getCalendario().getFecha().getMonth());
				acc.setYear(ue.getCalendario().getFecha().getYear());
				acc.setHora(ue.getCalendario().getFecha().getHours());
				acc.setMinuto(ue.getCalendario().getFecha().getMinutes());
				acc.setTipo(tipo);
				fichajesRepo.save(acc);
			}			
		}
	}*/
	

}
