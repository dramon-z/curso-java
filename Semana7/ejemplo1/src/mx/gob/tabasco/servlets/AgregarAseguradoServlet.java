package mx.gob.tabasco.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.gob.tabasco.db.ManejadorDb;
import mx.gob.tabasco.entities.Asegurado;

@WebServlet(name = "agregarAseguradoServlet", urlPatterns = {"/agregar-asegurado"})
public class AgregarAseguradoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/agregar_asegurado.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String resultado = "La información del asegurado se ha guardado correctamente";
		try {
			String nombre = req.getParameter("nombre");
			String apellido = req.getParameter("apellido");
			Integer edad = Integer.parseInt(req.getParameter("edad"));
			String sexo = req.getParameter("sexo");
			String numeroSeguroSocial = req.getParameter("numero_seguro_social");
			
			Asegurado asegurado = new Asegurado();
			asegurado.setNombre(nombre);
			asegurado.setApellido(apellido);
			asegurado.setEdad(edad);
			asegurado.setSexo(sexo);
			asegurado.setNumeroSeguroSocial(numeroSeguroSocial);
			
			ManejadorDb manejadorDb = new ManejadorDb();
			manejadorDb.saveAsegurado(asegurado);
		} catch (Exception e) {
			resultado = "Ocurrió un error al intentar guardar el asegurado: " + e.getMessage();
		}
		
		req.setAttribute("resultado", resultado);
		req.getRequestDispatcher("/WEB-INF/views/confirmacion_asegurado_agregado.jsp").forward(req, resp);
	}

}
