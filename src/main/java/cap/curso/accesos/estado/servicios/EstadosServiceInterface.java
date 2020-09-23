package cap.curso.accesos.estado.servicios;

import org.springframework.stereotype.Service;

import cap.curso.accesos.entidades.Estado;

@Service
public interface EstadosServiceInterface
{

	public Estado findByDescripcion(String descripcion);
	
}
