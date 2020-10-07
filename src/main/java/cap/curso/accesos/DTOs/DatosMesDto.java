package cap.curso.accesos.DTOs;

import java.util.List;

public class DatosMesDto
{

	private int mes;
	private String nombreMes;
	private List<DatosDiaDto> datosDias;

	public DatosMesDto(int mes, String nombreMes)
	{
		this.mes = mes;
		this.nombreMes = nombreMes;
	}

	public int getMes()
	{
		return mes;
	}

	public void setMes(int mes)
	{
		this.mes = mes;
	}

	public String getNombreMes()
	{
		return nombreMes;
	}

	public void setNombreMes(String nombreMes)
	{
		this.nombreMes = nombreMes;
	}

	public List<DatosDiaDto> getDatosDias()
	{
		return datosDias;
	}

	public void setDatosDias(List<DatosDiaDto> datosDias)
	{
		this.datosDias = datosDias;
	}

}
