package cap.curso.accesos.utilidades;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

import cap.curso.accesos.DTOs.DatosDiaDto;

public class CalendarioUtilidades
{
	public static DatosDiaDto getValoresFecha(int dia,int mes,int anyo) {
		GregorianCalendar fecha= new GregorianCalendar(Locale.getDefault());
		fecha.set(Calendar.DAY_OF_MONTH, dia);
		fecha.set(Calendar.MONTH,mes-1);
		fecha.set(Calendar.YEAR, anyo);
		System.out.println(fecha.getFirstDayOfWeek());
		fecha.setFirstDayOfWeek(2);
		int diaSemana=fecha.get(Calendar.DAY_OF_WEEK);
		System.out.println("dia semana:"+fecha.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault())+" - "+diaSemana);
		int semanaMes=fecha.get(Calendar.WEEK_OF_MONTH);
		System.out.println("semana mes:"+semanaMes);
		return null;
		
	}

}
