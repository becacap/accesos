package cap.curso.accesos;

public class Reflection
{

	public static void main(String[] args) throws Exception
	{
		Reflection reflection= new Reflection();
		reflection.metodo("suma");
		

	}
	
	public void metodo(String nombreMetodo) throws Exception {
		
		Prueba prueba=Prueba.class.newInstance();
		prueba.getClass().getMethod("setA", int.class).invoke(prueba, 17);
		
		prueba.getClass().getMethod("setB", int.class).invoke(prueba, 25);
		
		System.out.println("el resulado es:"+prueba.getClass().getMethod("suma").invoke(prueba));
		
		
		
		
		
	}
}
