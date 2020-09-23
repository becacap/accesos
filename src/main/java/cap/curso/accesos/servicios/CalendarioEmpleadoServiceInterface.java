package cap.curso.accesos.servicios;

import org.springframework.stereotype.Service;

import cap.curso.accesos.entidades.Usuario_Estado;

@Service
public interface CalendarioEmpleadoServiceInterface
{
	public Usuario_Estado save(Usuario_Estado usuario_Estado);
	
}
