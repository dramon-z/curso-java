package models;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Date;
import java.sql.*;
import java.util.Properties;

import java.util.Scanner;
import lib.BD;

public class Consulta{
	private BD db = null;
	private String observacion = null;
	private int idAsegurado = 0;
	private int idMedico = 0;
	private int idConsulta = 0;	
	private Date fecha = null;
	private String[] consulta = null;
	private Asegurado asegurado = null;
	private Medicamentos medicamento = null;
	private Medico medico = null;
	private boolean existe = true;
	private String sqlQuery = null;

	public Consulta(){

	}

	public void AgregarConsulta()throws SQLException{
		if(idMedico == 0){
			System.out.println("Ingrese el nombre del Medico:");
			String medico_nombre = new Scanner(System.in).nextLine();
			medico = new Medico();
			medico.ListarMedico(medico_nombre);
			System.out.println("Ingrese N0. del Medico para la consulta:");
			idMedico = new Scanner(System.in).nextInt();
			existe = medico.getExiste(idMedico);
			if(existe == false){
				System.out.println("No existe el medico seleccionado.");
				idMedico = 0;
				AgregarConsulta();
			}
		}
		if(idAsegurado == 0){
			System.out.println("Ingrese el nombre del Asegurado:");
			String asegurado_nombre = new Scanner(System.in).nextLine();
			asegurado = new Asegurado();
			asegurado.ListarAsegurado(asegurado_nombre);
			System.out.println("Ingrese N0. del Asegurado para la consulta:");
			idAsegurado = new Scanner(System.in).nextInt();
			existe = medico.getExiste(idAsegurado);
			if(existe == false){
				System.out.println("No existe el asegurado seleccionado.");
				idAsegurado = 0;
				AgregarConsulta();
			}
		}
		System.out.println("Ingrese observacion:");
		observacion = new Scanner(System.in).nextLine();
		db = new BD();
		sqlQuery = "insert into consultas(medicos_id, asegurados_id, observaciones, fecha) value(?,?,?,now());";
		consulta = new String[3];
		consulta[0] = String.valueOf(idMedico);
		consulta[1] = String.valueOf(idAsegurado);
		consulta[2] = observacion;
		db.SqlInsertRegistros(sqlQuery, consulta);
		
	}
	
}