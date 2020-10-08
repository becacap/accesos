package cap.curso.accesos.DTOs;

import cap.curso.accesos.entidades.Estado;

public class DatosDiaDto
{

	private int diaSemana;
	private int semanaMes;
	private int dia;
	private Estado estado;
	private int jornada;
	private int idCalendario;
	private String colorActual;

	public DatosDiaDto(int idCalendario, int diaSemana, int semanaMes, int dia, Estado estado, int jornada, String color)
	{
		this.setIdCalendario(idCalendario);
		this.diaSemana = diaSemana;
		this.semanaMes = semanaMes;
		this.dia = dia;
		this.estado = estado;
		this.jornada = jornada;
		this.setColorActual(color);
	}

	public Estado getEstado()
	{
		return estado;
	}

	public void setEstado(Estado estado)
	{
		this.estado = estado;
	}

	public int getJornada()
	{
		return jornada;
	}

	public void setJornada(int jornada)
	{
		this.jornada = jornada;
	}

	public int getDiaSemana()
	{
		return diaSemana;
	}

	public void setDiaSemana(int diaSemana)
	{
		this.diaSemana = diaSemana;
	}

	public int getSemanaMes()
	{
		return semanaMes;
	}

	public void setSemanaMes(int semanaMes)
	{
		this.semanaMes = semanaMes;
	}

	public int getDia()
	{
		return dia;
	}

	public void setDia(int dia)
	{
		this.dia = dia;
	}

	public int getIdCalendario()
	{
		return idCalendario;
	}

	public void setIdCalendario(int idCalendario)
	{
		this.idCalendario = idCalendario;
	}

	public String getColorActual()
	{
		return colorActual;
	}

	public void setColorActual(String colorActual)
	{
		this.colorActual = colorActual;
	}

}
