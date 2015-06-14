package mx.gob.tabasco.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.gob.tabasco.db.ManejadorDb;

@WebServlet(name = "detalleAseguradoServlet", urlPatterns = {"/detalle-asegurado"})
public class DetalleAseguradoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		ManejadorDb manejadorDb = new ManejadorDb();
		
		req.setAttribute("asegurado", manejadorDb.findAseguradoById(id));
		
		req.getRequestDispatcher("/WEB-INF/views/detalle_asegurado.jsp").forward(req, resp);
	}
	
}
