package cap.curso.accesos.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import cap.curso.accesos.entidades.Usuario_Estado;

@Service
public interface CalendarioEmpleadoServiceInterface
{
	public Usuario_Estado save(Usuario_Estado usuario_Estado);

	public Usuario_Estado findById(Integer id);
	
	public List<Usuario_Estado>  findAll();
	
	public void delete(Usuario_Estado usuario);
	
	public void deleteById(int id);
	
}
