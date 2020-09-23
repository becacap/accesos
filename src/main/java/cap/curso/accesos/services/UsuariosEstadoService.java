package cap.curso.accesos.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cap.curso.accesos.entidades.Calendario;
import cap.curso.accesos.entidades.Empleado;
import cap.curso.accesos.entidades.Usuario_Estado;
import cap.curso.accesos.repositorios.UsuariosEstadoRepositoryInterface;

@Service
public class UsuariosEstadoService implements UsuariosEstadoServiceInterface {

	@Autowired
	private UsuariosEstadoRepositoryInterface repositorio;
	
	public Usuario_Estado getDiasTrabajadosEmpleadoByYearByMes (Empleado empleado, Calendario cal) {
		Usuario_Estado ue = getRepositorio().getUsuarioEstadoByEmpleado (empleado, cal);
		
		return null;
	}

	public UsuariosEstadoRepositoryInterface getRepositorio() {
		return repositorio;
	}

	public void setRepositorio(UsuariosEstadoRepositoryInterface repositorio) {
		this.repositorio = repositorio;
	}

}
