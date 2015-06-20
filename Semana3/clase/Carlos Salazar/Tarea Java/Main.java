public class Main{

	public static void main(String[]args){

		System.out.print("Write your name: ");
		String nombre = System.console().readLine();

		System.out.print("Write your lastname: ");
		String apellido = System.console().readLine();

		System.out.print("Write your born year: ");
		int edad = 2015 - Integer.parseInt(System.console().readLine());

		System.out.println("\n"+"Name: " + nombre + " LastName: " +apellido+ " Age: " +edad);
	}
}