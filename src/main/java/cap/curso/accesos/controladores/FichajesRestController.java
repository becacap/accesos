package cap.curso.accesos.controladores;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cap.curso.accesos.DTOs.FichajesDTO;
import cap.curso.accesos.entidades.Acceso;
import cap.curso.accesos.entidades.Empleado;
import cap.curso.accesos.servicios.FichajesServiceInterface;

@RestController
@RequestMapping("/api/fichajes")
public class FichajesRestController
{
	@Autowired
	private FichajesServiceInterface fichajesServiceInterface;

	public FichajesServiceInterface getFichajesServiceInterface()
	{
		return fichajesServiceInterface;
	}

	public void setFichajesServiceInterface(FichajesServiceInterface fichajesServiceInterface)
	{
		this.fichajesServiceInterface = fichajesServiceInterface;
	}

	@GetMapping("/")
	public List<FichajesDTO> getAccesos()
	{
		
		String horaEntrada = null;
		List<FichajesDTO> fichajesResultado = new ArrayList();
		FichajesDTO resultado = new FichajesDTO();
		int hora =0;
		int minuto = 0;
		List<Acceso> accesos =  (List<Acceso>) getFichajesServiceInterface().findAll();
		for(int i=0; i< accesos.size();i++) {
			if(accesos.get(i).getTipo() != 1) {
				hora = accesos.get(i).getHora();
				minuto = accesos.get(i).getMinuto();
			}else {
				
				horaEntrada = String.valueOf(hora).concat(":").concat(String.valueOf(minuto));
				resultado.setFecha(accesos.get(i).getFecha());
				resultado.setHoraEntrada(horaEntrada);
				resultado.setNombre(accesos.get(i).getEmpleado().getNombre());
				resultado.setHoraSalida(String.valueOf(accesos.get(i).getHora()).concat(":").concat(String.valueOf(accesos.get(i).getMinuto())));
				fichajesResultado.add(resultado);
			}
		}
		return fichajesResultado;
	}
	
	@GetMapping("/{anyo}/{mes}")
	public List<FichajesDTO> getAccesosByAnyoMesEmpleado(@RequestBody Empleado empleado, @PathVariable("anyo") int anyo, @PathVariable("mes") int mes)
	{
		String horaEntrada = null;
		List<FichajesDTO> fichajesResultado = new ArrayList();
		FichajesDTO resultado = new FichajesDTO();
		int hora =0;
		int minuto = 0;
		List<Acceso> accesos =  (List<Acceso>) getFichajesServiceInterface().findFichajesMes(empleado, anyo, mes);
		for(int i=0; i< accesos.size();i++) {
			if(accesos.get(i).getTipo() != 1) {
				hora = accesos.get(i).getHora();
				minuto = accesos.get(i).getMinuto();
			}else {
				
				horaEntrada = String.valueOf(hora).concat(":").concat(String.valueOf(minuto));
				resultado.setFecha(accesos.get(i).getFecha());
				resultado.setHoraEntrada(horaEntrada);
				resultado.setNombre(accesos.get(i).getEmpleado().getNombre());
				resultado.setHoraSalida(String.valueOf(accesos.get(i).getHora()).concat(":").concat(String.valueOf(accesos.get(i).getMinuto())));
				fichajesResultado.add(resultado);
			}
		}
		return fichajesResultado;
	}
}
