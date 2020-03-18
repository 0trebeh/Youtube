package HU.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import HU.Controllers.LoginControllers;

@MultipartConfig()
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s = request.getSession(true);
		PrintWriter out = response.getWriter();
	
		if(request.getSession(false) != null) {
			
			String user = request.getParameter("usuario");
			String pass = request.getParameter("pass");
			
			if(user.isEmpty()) {
				out.print("El campo Usuario esta vacio");
			}else {
				LoginControllers.login(response, user, pass, s, out);
			}
		}else {
			out.println("sesion ya iniciada anteriormente");
		}
		response.getWriter();
	}
}