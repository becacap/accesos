package cap.curso.accesos.services;

import org.springframework.stereotype.Service;

import cap.curso.accesos.entidades.Calendario;
import cap.curso.accesos.entidades.Empleado;
import cap.curso.accesos.entidades.Usuario_Estado;

@Service
public interface UsuariosEstadoServiceInterface {
	
	public Usuario_Estado getDiasTrabajadosEmpleadoByYearByMes (Empleado empleado, Calendario cal);
	
}
