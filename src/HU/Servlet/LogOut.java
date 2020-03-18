package HU.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@MultipartConfig()
@WebServlet("/LogOut")
public class LogOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// cerrar session al eliminar un usuario
	public static void logOut(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
    	if(request.getSession(false) != null) {
    		//cerrar sesion
    		request.getSession(false).invalidate();
       	}
    	else {
    		out.print("No hay ninguna sesion que cerrar");
    	}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
    	if(request.getSession(false) != null) {
    		//cerrar sesion
    		request.getSession(false).invalidate();
    		response.sendRedirect("login.html");
    	}
    	else {
    		out.print("No hay ninguna sesion que cerrar");
    	}
	}
}
