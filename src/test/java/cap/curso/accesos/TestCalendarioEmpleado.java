package cap.curso.accesos;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cap.curso.accesos.entidades.Calendario;
import cap.curso.accesos.entidades.Empleado;
import cap.curso.accesos.entidades.Estado;
import cap.curso.accesos.entidades.Jornada;
import cap.curso.accesos.entidades.Usuario_Estado;
import cap.curso.accesos.servicios.CalendarioEmpleadoServiceInterface;
import cap.curso.accesos.calendario.servicios.CalendarioServiceInterface;
import cap.curso.accesos.estado.servicios.EstadosServiceInterface;
import cap.curso.accesos.servicios.JPAEmpleadoServiceInterface;
import cap.curso.accesos.servicios.JPAJornadaServiceInterface;

@SpringBootTest
public class TestCalendarioEmpleado
{
	
	@Autowired
	private CalendarioEmpleadoServiceInterface calendarioEmpleado;
	@Autowired
	private CalendarioServiceInterface calendario;
	@Autowired
	private JPAEmpleadoServiceInterface empleado;
	@Autowired
	private JPAJornadaServiceInterface jornada;
	@Autowired
	private EstadosServiceInterface estado;

	
	/*
	 * Estado estado = new Estado(); estado1.setDescripcion("Festivo");
	 * estado1.setId(2); estado1.setTipo(1);
	 */

	/*
	 * Jornada jornada = new Jornada(); jornada.setLunes("9.00-20.00");
	 * jornada.setMartes("9.00-20.00"); jornada.setMiercoles("9.00-20.00");
	 * jornada.setJueves("9.00-20.00"); jornada.setViernes("9.00-20.00");
	 * jornada.setDescripcion("Jornada completa");
	 */

	/*
	 * Empleado empleado = new Empleado(); empleado.setId(3);
	 * empleado.setNombre("Jorge"); empleado.setApellidos("martin sanchez");
	 * empleado.setDni("3829393a"); empleado.setFecha_alta(null);
	 * empleado.setFecha_baja(null); empleado.setIdentificador("pasaporte");
	 * empleado.setJornada(jornada);
	 */
		
	
	
	
	
	
	@Test
	public void testSaveCalendarioEmpleado()
	{

		Usuario_Estado usuario_Estado = new Usuario_Estado();

		GregorianCalendar gregorianCalendar = new GregorianCalendar(2020, 8, 23);
		Date fecha = new Date(gregorianCalendar.getTime().getTime());

		Empleado e = empleado.findById(1).get();
		Jornada j = jornada.findById(1).get();
		Estado es = estado.findByDescripcion("LABORAL");
		
		Calendario calendario = new Calendario();
		calendario.setId(1);
		calendario.setFecha(fecha);
		calendario.setEstado(es);
	
		
		/////////////////////////////////////////////////////////
		
		usuario_Estado.setCalendario(calendario);
		usuario_Estado.setEmpleado(e);
		usuario_Estado.setEstado(es);
		usuario_Estado.setJornada(j);

		getCalendarioEmpleado().save(usuario_Estado);

	}

	
	
	@Test
	public void testUpdateCalendarioEmpleado()
	{

		Usuario_Estado usuario_Estado = new Usuario_Estado();

		GregorianCalendar gregorianCalendar = new GregorianCalendar(2020, 8, 23);
		Date fecha = new Date(gregorianCalendar.getTime().getTime());
		
		Empleado e = empleado.findById(1).get();
		Jornada j = jornada.findById(1).get();
		
		// Update estado
		Estado es = estado.findByDescripcion("FESTIVO");
		
		Calendario calendario = new Calendario();
		calendario.setId(1);
		calendario.setFecha(fecha);
		calendario.setEstado(es);

		/////////////////////////////////////////////////////////
		
		usuario_Estado.setCalendario(calendario);
		usuario_Estado.setEmpleado(e);
		usuario_Estado.setEstado(es);
		usuario_Estado.setJornada(j);

		getCalendarioEmpleado().save(usuario_Estado);
		
	}
	
	
	
	
	///////////////////////////////////////////////////////////////////////////////////////////

	public CalendarioEmpleadoServiceInterface getCalendarioEmpleado()
	{
		return calendarioEmpleado;
	}

	public void setCalendarioEmpleado(CalendarioEmpleadoServiceInterface calendarioEmpleado)
	{
		this.calendarioEmpleado = calendarioEmpleado;
	}

	public CalendarioServiceInterface getCalendario()
	{
		return calendario;
	}

	public void setCalendario(CalendarioServiceInterface calendario)
	{
		this.calendario = calendario;
	}

	public JPAEmpleadoServiceInterface getEmpleado()
	{
		return empleado;
	}

	public void setEmpleado(JPAEmpleadoServiceInterface empleado)
	{
		this.empleado = empleado;
	}

	public JPAJornadaServiceInterface getJornada()
	{
		return jornada;
	}

	public void setJornada(JPAJornadaServiceInterface jornada)
	{
		this.jornada = jornada;
	}

	public EstadosServiceInterface getEstado()
	{
		return estado;
	}

	public void setEstado(EstadosServiceInterface estado)
	{
		this.estado = estado;
	}

}
