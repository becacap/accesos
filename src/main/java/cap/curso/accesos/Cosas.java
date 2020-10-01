package cap.curso.accesos;

public class Cosas
{
	public static void main(String[] args)
	{
		System.out.println(suma(2,3));
		
		System.out.println(suma(2,3,5,4,6,7,8,2,4));
		
		System.out.println(suma(2,3,3,3,3,3,3,3,3,3,3,3,3,3));
		
		System.out.println(suma(2,3,9,9,9,9,9,9,9,9,9,9,9));
		
	}
	
	public static int suma(int... datos) {
		
		int salida=0;
		for (int i : datos)
		{
			salida +=i;
		}
		return salida;
	}
}
