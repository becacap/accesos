package cap.curso.accesos;

import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

@Verifica
public class Prueba extends Frame
{
	
	public Prueba() throws HeadlessException
	{
		super();
		// TODO Auto-generated constructor stub
	}
	public Prueba(GraphicsConfiguration gc)
	{
		super(gc);
		// TODO Auto-generated constructor stub
	}
	public Prueba(String title, GraphicsConfiguration gc)
	{
		super(title, gc);
		// TODO Auto-generated constructor stub
	}
	public Prueba(String title) throws HeadlessException
	{
		super(title);
		// TODO Auto-generated constructor stub
	}

	private int a,b;

	
	@Verifica
	public int suma()
	{
	
		return getA()+getB();
	}
	public int getA()
	{
		return a;
	}

	public void setA(int a)
	{
		this.a = a;
	}

	public int getB()
	{
		return b;
	}

	public void setB(int b)
	{
		this.b = b;
	}

}
