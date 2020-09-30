package cap.curso.accesos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cap.curso.accesos.entidades.Empleado;
import cap.curso.accesos.entidades.Jornada;
import cap.curso.accesos.servicios.EmpleadoServiceInterface;
import cap.curso.accesos.servicios.JornadaServiceInterface;

@SpringBootTest

public class TestEmpleado
{

	@Autowired
	private EmpleadoServiceInterface jpaEmpleadoSI;

	@Autowired
	private JornadaServiceInterface jpaJornadaSI;
	
//	@Test
	public void crearEmpleado(){
		Empleado e = new Empleado();
		e.setNombre("Juanito");
		e.setApellidos("G");
		e.setDni("34249867D");
		e.setIdentificador("11111111");
		e.setFecha_alta(new Date(998888));
		getJpaEmpleadoSI().save(e);
	}
	
//	@Test
	public void testTodosEmpleados()
	{
		List<Empleado> e = (List<Empleado>) getJpaEmpleadoSI().findAll();
		for (Empleado emp : e)
		{
			System.out.println(emp.getNombre());
		}
	}
	
//	@Test
	public void testEmpleadoByID() {
		Optional<Empleado> e = Optional.ofNullable(new Empleado());
		e = getJpaEmpleadoSI().findById(1);
		System.out.println(e.get().getNombre() + "@@@@@@@@@@@@@@@@@@@@@@@@@@");
	}
	
	@Test
	public void testModificarJornada() {
		Jornada jornadaNueva = new Jornada();
		jornadaNueva.setLunes("9.00-20.00");
		jornadaNueva.setMartes("9.00-20.00");
		jornadaNueva.setMiercoles("9.00-20.00");
		jornadaNueva.setJueves("9.00-20.00");
		jornadaNueva.setViernes("9.00-20.00");
		jornadaNueva.setDescripcion("Jornada completa");
		jpaJornadaSI.save(jornadaNueva);
		
		Optional<Empleado> empleado = jpaEmpleadoSI.findById(1);
		int jornada1_id = empleado.get().getJornada().getId();
		Empleado empleado1 = jpaEmpleadoSI.modificarJornada(empleado.get(), jornadaNueva);
		
		assertEquals(empleado.get().getId(), empleado1.getId());
		assertNotEquals(jornada1_id, empleado1.getJornada().getId());

	}

	public EmpleadoServiceInterface getJpaEmpleadoSI()
	{
		return jpaEmpleadoSI;
	}
	public void setJpaEmpleadoSI(EmpleadoServiceInterface jpaEmpleadoSI)
	{
		this.jpaEmpleadoSI = jpaEmpleadoSI;
	}

}
