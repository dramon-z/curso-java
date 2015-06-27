package mx.gob.tabasco.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mx.gob.tabasco.db.ManejadorDb;

@WebServlet(name = "indexServlet", urlPatterns = {"/"})
public class IndexServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ManejadorDb manejadorDb = new ManejadorDb();
		
		req.setAttribute("asegurados", manejadorDb.findAllAsegurados());
		
		req.getRequestDispatcher("/WEB-INF/views/listar_asegurados.jsp").forward(req, resp);
	}	
	
}
