package cap.curso.accesos.DTOs;

import java.util.Date;

public class FichajesDTO
{

	private Date fecha;
	private String nombre;
	private String horaEntrada;
	private String horaSalida;
	
	
	public Date getFecha()
	{
		return fecha;
	}
	public void setFecha(Date fecha)
	{
		this.fecha = fecha;
	}
	public String getNombre()
	{
		return nombre;
	}
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	public String getHoraEntrada()
	{
		return horaEntrada;
	}
	public void setHoraEntrada(String horaEntrada)
	{
		this.horaEntrada = horaEntrada;
	}
	public String getHoraSalida()
	{
		return horaSalida;
	}
	public void setHoraSalida(String horaSalida)
	{
		this.horaSalida = horaSalida;
	}
	
	
}
