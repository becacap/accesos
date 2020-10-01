package cap.curso.accesos.services;

import org.springframework.stereotype.Service;

import cap.curso.accesos.DTOs.RegistroDto;
import cap.curso.accesos.entidades.Calendario;
import cap.curso.accesos.entidades.Empleado;
import cap.curso.accesos.entidades.Usuario_Estado;

@Service
public interface UsuariosEstadoServiceInterface {
	
	public Usuario_Estado getDiasTrabajadosEmpleadoByYearByMes (Empleado empleado, Calendario cal);
	
	public Iterable<Usuario_Estado> findAll();
	
	public Usuario_Estado save(RegistroDto registro);
	
	public Usuario_Estado save(Usuario_Estado ue);
	
	public void delete(Usuario_Estado ue);
	
}
