package cap.curso.accesos;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cap.curso.jpa.configuracion.Configuracion;
import cap.curso.jpa.entidades.Estado;
import cap.curso.jpa.estado.exception.EstadoNotFoundException;
import cap.curso.jpa.estado.servicios.EstadosServiceInterface;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Configuracion.class)
public class EstadosTest
{

	@Autowired
	private EstadosServiceInterface estadosService;

	public EstadosServiceInterface getEstadosService()
	{
		return estadosService;
	}

	public void setEstadosService(EstadosServiceInterface estadosService)
	{
		this.estadosService = estadosService;
	}

	@Test
	public void estadoFindByDescriptionOkTest()
	{
		Estado estado = getEstadosService().findByDescripcion("Laborable");
	}

	@Test(expected = EstadoNotFoundException.class)
	public void estadoFindByDescriptionNoOkTest()
	{
		Estado estado = getEstadosService().findByDescripcion("jajaNoExiste");
	}

}