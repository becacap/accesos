package cap.curso.accesos.controladores;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cap.curso.accesos.calendario.exception.CalendarioAlreadyExistsException;
import cap.curso.accesos.calendario.exception.CalendarioNotFoundException;
import cap.curso.accesos.calendario.servicios.CalendarioService;
import cap.curso.accesos.calendario.servicios.CalendarioServiceInterface;
import cap.curso.accesos.entidades.Calendario;
import cap.curso.accesos.entidades.Estado;
import cap.curso.accesos.estado.exception.EstadoNotFoundException;

@RestController
@RequestMapping("/calendario")
public class CalendarioRestController
{
	@Autowired
	private CalendarioServiceInterface calendarioService;

	public CalendarioServiceInterface getCalendarioService()
	{
		return calendarioService;
	}

	public void setCalendarioService(CalendarioService calendarioService)
	{
		this.calendarioService = calendarioService;
	}

	@GetMapping("/all")
	public Iterable<Calendario> findAll()
	{
		return getCalendarioService().findAll();
	}

	@GetMapping("/{anyo}")
	public Iterable<Calendario> findByAnyo(@PathVariable("anyo") Integer anyo)
	{
		try
		{
			return getCalendarioService().findByAnyo(anyo);
		} catch (CalendarioNotFoundException e)
		{
			return new ArrayList<Calendario>();
		}
	}

	@PostMapping("/{anyo}")
	public Iterable<Calendario> generaCalendario(@PathVariable("anyo") Integer anyo)
	{
		try
		{
			return getCalendarioService().generaCalendarioAnyo(anyo);
		} catch (CalendarioAlreadyExistsException | EstadoNotFoundException e)
		{
			return new ArrayList<Calendario>();
		}
	}

	@PostMapping("/actualizar/{dia_id}")
	public Calendario actualizarDiaEnCalendario(@PathVariable("dia_id") int dia_id, @RequestBody Estado estado)
	{
		try
		{
			return getCalendarioService().updateCalendarioEstado(dia_id, estado);
		} catch (CalendarioNotFoundException e)
		{
			System.out.println("No existe ese dia");
			return null;
		}
	}

}
