package cap.curso.accesos;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import cap.curso.accesos.entidades.Calendario;
import cap.curso.accesos.entidades.Empleado;
import cap.curso.accesos.services.UsuariosEstadoServiceInterface;

@SpringBootTest
public class TestFichajesM
{

	@Autowired
	private UsuariosEstadoServiceInterface usuariosEstadoService;
	
	@Test
	public void testTodoCorrecto()
	{
		Empleado empleado = new Empleado();
		empleado.setNombre("Pepe");
		empleado.setApellidos("Maroto");
		empleado.setDni("382928383N");
		empleado.setIdentificador("Empleado");
		Calendario calendario = new Calendario();
		calendario.setFecha(new Date(01, 03, 2016));
		assertNotNull(usuariosEstadoService.getDiasTrabajadosEmpleadoByYearByMes(empleado, calendario));
	}
	
	@Test
	public void testMesMal()
	{
		Empleado empleado = new Empleado();
		empleado.setNombre("Pepe");
		empleado.setApellidos("Maroto");
		empleado.setDni("382928383N");
		empleado.setIdentificador("Empleado");
		Calendario calendario = new Calendario();
		calendario.setFecha(new Date(01, 22, 2016));
		assertNull(usuariosEstadoService.getDiasTrabajadosEmpleadoByYearByMes(empleado,calendario));
	}

}
