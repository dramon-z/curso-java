import java.util.Date;

public class Tarea{
	
	public static void main(String[] args){
		System.out.println("-----------------------");
		System.out.println("Inserta tu nombre:");
		String nombre = System.console().readLine();
		System.out.println("Inserta tus apellidos:");
		String apellidos = System.console().readLine();
		System.out.println("Inseta tu fecha de nacimiento(yy/mm/dd)");
		String fecha_nacimiento = System.console().readLine();
		Date fecha = new Date(fecha_nacimiento);
		Date fecha_actual = new Date();
		long fecha_actual_ms = fecha_actual.getTime();
		long fecha_ms = fecha.getTime();
		long diferencia = fecha_actual_ms - fecha_ms;
        double dias = Math.floor(diferencia / (1000 * 60 * 60 * 24));
		double edad_dec = dias/365;
		int edad = (int)edad_dec;
		System.out.println("Hola "+nombre+" - "+apellidos+", tu edad es: "+edad);
		System.out.println("-----------------------");
	}
}