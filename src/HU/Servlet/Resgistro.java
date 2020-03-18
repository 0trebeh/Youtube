package HU.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import HU.Controllers.ResgisterControllers;

@MultipartConfig()
@WebServlet("/Resgistro")
public class Resgistro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("register.html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String user = request.getParameter("usuario");
		String mail = request.getParameter("mail");		
		
		if(user.isEmpty() || mail.isEmpty()) {
			out.print("error hay campos vacios");
		}else {
			try {
				ResgisterControllers.register(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
				out.print("el catch que esta en el Registro");
			}		
		}
	}
}