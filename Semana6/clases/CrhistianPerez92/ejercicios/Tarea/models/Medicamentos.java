package models;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import java.sql.*;

import java.util.Properties;

import java.util.Scanner;
import lib.BD;

public class Medicamentos{
	private String nombre = null;
	private String presentacion = null;
	private String[] medicamento = null;
	private int idMedicamento = 0;
	private BD db = null;

	public Medicamentos(){

	}

	public void AgregarMedicamento()throws SQLException{
		System.out.println("Ingrese el nombre del Medicamento:");
		nombre = new Scanner(System.in).nextLine();
		System.out.println("Ingrese Tipo de presentacion del Medicamento:");
		presentacion = new Scanner(System.in).nextLine();
		ImprimirConfirmacion("Registrar");
		
	}
	
	public void ListarMedicamento(String bus)throws SQLException {
		String query = "select * from medicamentos where  nombre like '%"+bus+"%'";
		try {
			db = new BD();
			ResultSet resultSet = db.SqlConsultas(query);
			while (resultSet.next()) {
				nombre = resultSet.getString("nombre");
				presentacion = resultSet.getString("presentacion");

				System.out.println("--------------");
				System.out.println("No. Medicamento: " + resultSet.getInt("id"));
				System.out.print("Nombre del Medicamento: " + nombre);
				System.out.print(" Presentacion: " + presentacion);
				System.out.println("--------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.CloseConection();
		}
	}

	public void ImprimirConfirmacion(String text)throws SQLException{
		System.out.println("------------------------\n");
		System.out.println("Acuse del registro del Medicamento \n");
		System.out.println("Nombre: "+ nombre.toUpperCase()+"\nPresentacion:"+presentacion.toUpperCase());
		System.out.println("------------------------");
		System.out.println("¿La informacion es la correcta (si/no)?");
		String esCorrecta = new Scanner(System.in).nextLine();
		if("si".equals(esCorrecta)){
			medicamento = new String[2];
			medicamento[0] = nombre;
			medicamento[1] = presentacion;
			String updateQuery = "insert into medicamentos(nombre, presentacion) values(?, ?)";
			db = new BD();
			db.SqlInsertRegistros(updateQuery,medicamento);
		}else{
			System.out.println("Ingresaste " + esCorrecta + ", presiona enter para continuar");
		}
	}	

	public void ActualizarMedicamento()throws SQLException{
		System.out.println("Ingrese el nombre del Medicamento que desea actualizar:");
		nombre = new Scanner(System.in).nextLine();
		ListarMedicamento(nombre);
		System.out.println("Ingrese el No. del Medicamento que desea Actulizar");
		idMedicamento = new Scanner(System.in).nextInt();
		String campo = "";
		String update_valor = "";
		System.out.println("--------------------------------");
		System.out.println("Opciones de campos:");
		System.out.println("1.- Nombre\n2.- Presentacion");
		System.out.println("--------------------------------");
		System.out.println("Ingrese la opcion del campo que desea actulizar del Medicamento:");
		int opcion_edit = new Scanner(System.in).nextInt();
		switch(opcion_edit){
			case 1:{
				campo = "nombre";
				break;
			}
			case 2:{
				campo = "presentacion";
				break;
			}
			default:{
				System.out.println("La opcion del campo ingresado no existe");
				break;
			}
		}
		if(campo != ""){
			System.out.println("Ingrese "+campo.toUpperCase()+" del Medicamento:");
			update_valor = new Scanner(System.in).nextLine();
			System.out.println("Esta seguro que desea Actulizar el registro(si/no):");
			String esCorrecta = new Scanner(System.in).nextLine();
			if("SI".equals(esCorrecta.toUpperCase())){
				medicamento = new String[2];
				String updateQuery = "Update medicamentos set "+campo+" = ? where id = ?";
				medicamento[0] = update_valor.toUpperCase();
				medicamento[1] = String.valueOf(idMedicamento);
				db = new BD();
				db.SqlUpdateRegistros(updateQuery, medicamento);
			}else{
				System.out.println("Ingresaste " + esCorrecta + ", presiona enter para continuar");
			}
		}
	}

	public void EliminarMedicamento()throws SQLException{
		System.out.println("Ingrese el nombre del Medicamento a eliminar:");
		nombre = new Scanner(System.in).nextLine();
		ListarMedicamento(nombre);
		System.out.println("Ingrese el No. del Medicamento que desea eliminar");
		idMedicamento = new Scanner(System.in).nextInt();
		System.out.println("Esta seguro que desea eliminar el registro(si/no):");
		String esCorrecta = new Scanner(System.in).nextLine();
		if("si".equals(esCorrecta)){
			String updateQuery = "delete from medicamentos where id = ?";
			String value = String.valueOf(idMedicamento);
			db = new BD();
			db.SqlDeleteRegistro(updateQuery, value);
		}else{
			System.out.println("Ingresaste " + esCorrecta + ", presiona enter para continuar");
		}
	}

	public void ConsultarMedicamento()throws SQLException{
		System.out.println("Ingrese el nombre completo del Medicamento a buscar:");
		nombre = new Scanner(System.in).nextLine();
		String query = "select * from medicamentos where  nombre like '%"+nombre+"%'";
		//System.out.println(query);
		try {
			db = new BD();
			ResultSet resultSet = db.SqlConsultas(query);
			while (resultSet.next()) {
				nombre = resultSet.getString("nombre");
				presentacion = resultSet.getString("presentacion");
				System.out.println("--------------");
				System.out.println("Nombre del Medicamento: " + nombre);
				System.out.println("Presentacion: " + presentacion);
				System.out.println("--------------");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.CloseConection();
		}
	}
}