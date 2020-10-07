package cap.curso.accesos.servicios;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cap.curso.accesos.DTOs.DatosDiaDto;
import cap.curso.accesos.DTOs.DatosMesDto;
import cap.curso.accesos.entidades.Calendario;
import cap.curso.accesos.entidades.Estado;
import cap.curso.accesos.exception.CalendarioAlreadyExistsException;
import cap.curso.accesos.exception.CalendarioNotFoundException;
import cap.curso.accesos.exception.EstadoNotFoundException;
import cap.curso.accesos.repositorios.CalendarioRepository;
import cap.curso.accesos.repositorios.EstadosRepository;

@Service
public class CalendarioService implements CalendarioServiceInterface
{

	@Autowired
	private CalendarioRepository calendarioRepository;

	@Autowired
	private EstadosRepository estadosRepository;

	public CalendarioRepository getCalendarioRepository()
	{
		return calendarioRepository;
	}

	public void setCalendarioRepository(CalendarioRepository calendarioRepository)
	{
		this.calendarioRepository = calendarioRepository;
	}

	public EstadosRepository getEstadosRepository()
	{
		return estadosRepository;
	}

	public void setEstadosRepository(EstadosRepository estadosRepository)
	{
		this.estadosRepository = estadosRepository;
	}

	public Iterable<Calendario> findAll()
	{
		return getCalendarioRepository().findAll();
	}

	public Calendario findById(Integer idCalendario)
	{
		return getCalendarioRepository().findById(idCalendario).orElse(null);
	}

	public Calendario save(Calendario calendario) throws CalendarioAlreadyExistsException
	{
		Calendario calendarioSearched = getCalendarioRepository().findById(calendario.getId()).orElse(null);

		if (calendarioSearched == null)
		{
			return getCalendarioRepository().save(calendario);
		} else
		{
			throw new CalendarioAlreadyExistsException("El calendario ya existe en la bd existe");
		}
	}

	@Override
	public Iterable<Calendario> generaCalendarioAnyo(Integer anyo)
			throws CalendarioAlreadyExistsException, EstadoNotFoundException
	{
		Iterable<Calendario> diasAnyo = getCalendarioRepository().findByAnyo(anyo);

		// System.out.println("-----> HE BUSCADO POR AÑO");

		Iterator<Calendario> it = diasAnyo.iterator();
		if (it.hasNext()) // si la lista de dias no esta vacia, no se genera calendario
		{
			throw new CalendarioAlreadyExistsException("El calendario ya existe en la bd");
		}

		// System.out.println("-----> HE ENCONTRADO POR AÑO");

		Estado laborable = getEstadosRepository().findByDescripcion("Laborable");
		Estado festivo = getEstadosRepository().findByDescripcion("Festivo");

		// System.out.println("-----> HE BUSCADO LOS ESTADOS");

		if (laborable == null)
		{
			throw new EstadoNotFoundException("El estado Laborable no existe");
		} else if (festivo == null)
		{
			throw new EstadoNotFoundException("El estado Festivo no existe");
		}

		// System.out.println("-----> HE ENCONTRADO LOS ESTADOS");

		List<Calendario> listaDiasAnyo = new ArrayList<Calendario>();
		GregorianCalendar calendario = new GregorianCalendar(anyo, 0, 1); // instanciamos el año
		int daysInYear = calendario.getActualMaximum(Calendar.DAY_OF_YEAR);

		for (int i = 1; i <= daysInYear; ++i)
		{
			Calendario fila = new Calendario();
			Date fecha = new Date(calendario.getTime().getTime());
			fila.setFecha(fecha);

			int dayOfWeek = calendario.get(Calendar.DAY_OF_WEEK);
			if (dayOfWeek > 1 && dayOfWeek <= 6) // si es esntre semana
			{
				// System.out.println(calendario.getTime().toString() + " - DIARIO");
				fila.setEstado(laborable);

			} else // fin de semana
			{
				// System.out.println(calendario.getTime().toString() + " - FINDE");
				fila.setEstado(festivo);
			}

			Calendario insertado = getCalendarioRepository().save(fila);

			// System.out.println("-----> HE INSERTADO EL DIA");

			listaDiasAnyo.add(insertado);

			calendario.add(Calendar.DAY_OF_YEAR, 1); // avanzamos al dia siguiente
		}

		return listaDiasAnyo;
	}

	public Calendario updateCalendarioEstado(Integer idCalendario, Estado estado) throws CalendarioNotFoundException
	{
		Calendario calendarioSearched = getCalendarioRepository().findById(idCalendario).orElse(null);

		if (calendarioSearched != null)
		{
			calendarioSearched.setEstado(estado);
			return getCalendarioRepository().save(calendarioSearched);
		} else
		{
			throw new CalendarioNotFoundException("El calendario no existe");
		}
	}

	public Iterable<Calendario> findByAnyo(Integer anyo) throws CalendarioNotFoundException
	{
		Iterable<Calendario> diasAnyo = getCalendarioRepository().findByAnyo(anyo);

		Iterator<Calendario> it = diasAnyo.iterator();
		if (!it.hasNext()) // si la lista de dias no esta vacia, no se genera calendario
		{
			throw new CalendarioNotFoundException("El calendario no existe en la bd");
		}

		return diasAnyo;
	}

	public void deleteAll()
	{
		getCalendarioRepository().deleteAll();
	}

	/*
	 * @SuppressWarnings("deprecation")
	 * 
	 * @Override public List<DatosMesDto> getDatosYear(int year) { List<Calendario>
	 * calendarios = (List<Calendario>) getCalendarioRepository().findByAnyo(year);
	 * List<DatosMesDto> datos = new ArrayList<DatosMesDto>(); for (int i = 0; i <
	 * 12; i++) { GregorianCalendar dia1 = new GregorianCalendar(year, i, 1);
	 * DatosMesDto datosMesDto = new DatosMesDto();
	 * datosMesDto.setNombreMes(dia1.getDisplayName(Calendar.MONTH, Calendar.LONG,
	 * Locale.getDefault())); datosMesDto.setMes(i); datosMesDto.setDatosDias(new
	 * ArrayList<DatosDiaDto>()); for (Calendario calendario : calendarios) { if
	 * (calendario.getFecha().getMonth() == i + 1) { Date fechaBD =
	 * calendario.getFecha(); GregorianCalendar fecha = new GregorianCalendar();
	 * fecha.setTimeInMillis(fechaBD.getTime()); fecha.setMinimalDaysInFirstWeek(4);
	 * fecha.setFirstDayOfWeek(4); DatosDiaDto datosDiaDto = new DatosDiaDto();
	 * datosDiaDto.setEstado(calendario.getEstado().getId());
	 * datosDiaDto.setDia(fecha.get(Calendar.DAY_OF_MONTH)); int diaSemana =
	 * fecha.get(Calendar.DAY_OF_WEEK); int diaSemanaTemp = 7; if (diaSemana < 8)
	 * diaSemanaTemp = diaSemana - 1; datosDiaDto.setDiaSemana(diaSemanaTemp);
	 * datosDiaDto.setSemanaMes(fecha.get(Calendar.WEEK_OF_MONTH) - 1);
	 * datosMesDto.getDatosDias().add(datosDiaDto); }
	 * 
	 * } datos.add(datosMesDto);
	 * 
	 * } return datos;
	 * 
	 * }
	 */

	public Iterable<String> getAnyosDiferentes()
	{
		return getCalendarioRepository().getAnyosDiferentes();
	}

	public Iterable<DatosMesDto> getDatosAnyo(Integer anyo)
	{

		List<DatosMesDto> meses = new ArrayList<>();
		int numeroMes = 1; // Primer mes del año

		while (numeroMes <= 12)
		{
			Iterable<Calendario> calendarioMes = getCalendarioRepository().findByAnyoMes(anyo, numeroMes);

			String nombreMes = new GregorianCalendar(anyo, numeroMes - 1, 1).getDisplayName(Calendar.MONTH,
					Calendar.LONG, Locale.getDefault());
			DatosMesDto mes = new DatosMesDto(numeroMes, nombreMes);
			int numeroSemana = 1;

			List<DatosDiaDto> dias = new ArrayList<>();
			for (Calendario calendarioDia : calendarioMes)
			{
				GregorianCalendar diaActual = new GregorianCalendar();
				diaActual.setTime(calendarioDia.getFecha());

				int diaDelMes = diaActual.get(Calendar.DAY_OF_MONTH); // EL DIA DE LA SEMANA DOMINGO ES EL VALOR 1
				int diaDeLaSemana = diaActual.get(Calendar.DAY_OF_WEEK); // empieza la semana en domingo
				int semanaDelMes = numeroSemana;
				if (diaDeLaSemana == 1)
					numeroSemana++;

				DatosDiaDto dia = new DatosDiaDto(diaDeLaSemana, semanaDelMes, diaDelMes,
						calendarioDia.getEstado().getId(), -1);
				dias.add(dia);

			}
			mes.setDatosDias(dias);
			meses.add(mes);

			numeroMes++;
		}

		return meses;
	}

}
