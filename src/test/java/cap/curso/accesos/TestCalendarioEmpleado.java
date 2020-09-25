package cap.curso.accesos;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cap.curso.accesos.servicios.CalendarioEmpleadoServiceInterface;

@RunWith(SpringJUnit4ClassRunner.class)
public class TestCalendarioEmpleado
{
	@Autowired
	private CalendarioEmpleadoServiceInterface calendarioEmpleado;

	@Test
	public void testSave()
	{
		// enero1 = getCalendario()byYear();
		// getEmpleadobyId();

		/*
		 * Usuario_Estado usuario_Estado = new Usuario_Estado();
		 * usuario_Estado.setEmpleado(empleado);
		 * 
		 * for (Calendario calendario : getCalendarioByYear()) {
		 * usuario_Estado.setCalendario(calendario);
		 * 
		 * calendarioEmpleado.save(usuario_Estado); }
		 */

		/*
		 * GregorianCalendar gregorianCalendar = new GregorianCalendar(2020, 9, 21);
		 * Date fecha = new Date(gregorianCalendar.getTime().getTime()); Calendario
		 * calendario = new Calendario(); calendario.setId(1);
		 * calendario.setFecha(fecha); Estado e1 = new Estado(); Estado e2 = new
		 * Estado(); Estado e3 = new Estado(); e1.setId(1);
		 * e1.setDescripcion("Festivo"); e2.setId(2); e2.setDescripcion("Laboral");
		 * e3.setId(3); e3.setDescripcion("Festivo"); List<Estado> estados = new
		 * ArrayList<Estado>(); estados.add(e1); estados.add(e2); estados.add(e3);
		 * getCalendarioEmpleado().save(calendario, estados);
		 */
	}

	public CalendarioEmpleadoServiceInterface getCalendarioEmpleado()
	{
		return calendarioEmpleado;
	}

	public void setCalendarioEmpleado(CalendarioEmpleadoServiceInterface calendarioEmpleado)
	{
		this.calendarioEmpleado = calendarioEmpleado;
	}

	@Test
	public void testUpdateEstado()
	{

		/*
		 * Calendario calendario = getCalendarioById(); Empleado empleado =
		 * getEmpleadoById(); Jornada jornada = getJornadaById();
		 * 
		 * if (calendario.getEstado().getId() == 1) calendario.getEstado().setId(2);
		 * else { calendario.getEstado().setId(1); }
		 * 
		 * getCalendarioEmpleado().update(calendario.getId(), empleado.getId(),
		 * jornada.getId(), calendario.getEstado().getId());
		 */
	}

	@Test
	public void testUpdateJornada()
	{

		/*
		 * Calendario calendario = getCalendarioById(); Empleado empleado =
		 * getEmpleadoById(); Jornada jornada = getJornadaById();
		 * 
		 * // Updatear a mano a otra jornada Id
		 * 
		 * 
		 * getCalendarioEmpleado().update(calendario.getId(), empleado.getId(),
		 * jornada.getId(), calendario.getEstado().getId());
		 * 
		 */
	}

	/*
	 * @Test public void testUpdate() {
	 * 
	 * GregorianCalendar gregorianCalendar = new GregorianCalendar(2020, 9, 21);
	 * Date fecha = new Date(gregorianCalendar.getTime().getTime());
	 * 
	 * Calendario calendario = new Calendario(); calendario.setId(1);
	 * calendario.setFecha(fecha);
	 * 
	 * Empleado empleado = new Empleado(); empleado.setId(1);
	 * 
	 * Jornada jornada = new Jornada(); jornada.setId(1);
	 * 
	 * Estado estado = new Estado(); estado.setId(1);
	 * 
	 * getCalendarioEmpleado().update(calendario.getId(), empleado.getId(),
	 * jornada.getId(), estado.getId());
	 * 
	 * }
	 */

}
