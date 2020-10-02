package cap.curso.accesos.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import cap.curso.accesos.entidades.Estado;

@Service
public interface EstadosServiceInterface
{

	public Estado findByDescripcion(String descripcion);
	public List<Estado> getEstados();
	public Estado save(Estado estado);
	public Optional<Estado> findById(int idEstado);
}
