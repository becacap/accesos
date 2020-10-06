package cap.curso.accesos.DTOs;

public class EmpleadoCalendarioRequestDto
{
	private Integer empleado_id;
	private Integer year;
	
	public Integer getEmpleado_id()
	{
		return empleado_id;
	}
	public void setEmpleado_id(Integer empleado_id)
	{
		this.empleado_id = empleado_id;
	}
	public Integer getYear()
	{
		return year;
	}
	public void setYear(Integer year)
	{
		this.year = year;
	}
	
}
