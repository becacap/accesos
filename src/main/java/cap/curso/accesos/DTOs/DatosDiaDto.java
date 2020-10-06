package cap.curso.accesos.DTOs;

public class DatosDiaDto
{

	private int diaSemana;
	private int semanaMes;
	private int dia;
	private int estado;
	private int jornada;

	public int getEstado()
	{
		return estado;
	}

	public void setEstado(int estado)
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

}
