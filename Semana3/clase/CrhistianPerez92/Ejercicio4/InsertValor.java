public class InsertValor{

	public static void main(String[] args){
		System.out.println("-----------------------");
		System.out.println("Inserta Tu Nombre:");
		String nombre = String.valueOf(System.console().readLine());
		System.out.println("Nombre: " + nombre);
		System.out.println("Tablas:");
		System.out.println("Inserta el valor para la tabla de multiplicar:");
		int numero = Integer.parseint(System.console().readLine());
		System.out.println("Hasta que numero desea la tabla:");
		int hasta = Integer.parseint(System.console().readLine());

		for(int x=0; x<=hasta;x++){
			int valor = x * numero;
			System.out.println(x+ " * " + numero + " = "+valor+";");
		} 

		System.out.println("-----------------------");
	}

}