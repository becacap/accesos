package cap.curso.accesos;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cap.curso.jpa.configuracion.Configuracion;
import cap.curso.jpa.entidades.Usuario_Estado;
import cap.curso.jpa.services.UsuariosEstadoServiceInterface;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Configuracion.class)
public class TestFichajesR
{

	@Autowired
	private UsuariosEstadoServiceInterface usuariosEstadoService;
	
	@Test
	public void testWrongMes ()
	{
		int idEmpleado 	= 1; 	// Id que existe
		int year 		= 2018; // Year correcto
		int mes 		= 15; 	// Mes incorrecto
		
//		Usuario_Estado ue = getUsuariosEstadoService().getDiasTrabajadosEmpleadoByYearByMes (getDiasTrabajadosEmpleadoByYearByMes (idEmpleado, year, mes);
	}
	
//	@Test
	public void testWrongUsuario ()
	{
		int idEmpleado 	= 5590; // Id que no existe
		int year 		= 2019; // Year correcto
		int mes 		= 6; 	// Mes correcto

//		¿ assertThrown ? ( getUsuariosEstadoService().getDiasTrabajadosEmpleadoByYearByMes (idEmpleado, year, mes) );
	}

	public UsuariosEstadoServiceInterface getUsuariosEstadoService() {
		return usuariosEstadoService;
	}

	public void setUsuariosEstadoService(UsuariosEstadoServiceInterface usuariosEstadoService) {
		this.usuariosEstadoService = usuariosEstadoService;
	}

}
