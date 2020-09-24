package cap.curso.accesos.estado.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cap.curso.accesos.entidades.Estado;
import cap.curso.accesos.estado.repositorios.EstadosRepository;

@Service
public class EstadosService implements EstadosServiceInterface
{

	@Autowired
	private EstadosRepository estadosRepository;

	public EstadosRepository getEstadosRepository()
	{
		return estadosRepository;
	}

	public void setEstadosRepository(EstadosRepository estadosRepository)
	{
		this.estadosRepository = estadosRepository;
	}

	public Estado findByDescripcion(String descripcion)
	{
		return getEstadosRepository().findByDescripcion(descripcion);
	}

	@Override
	public List<Estado> getEstados()
	{
		// TODO Auto-generated method stub
		return (List<Estado>) getEstadosRepository().findAll();
	}

}
