package HU.Controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import HU.helpers.Auth;
import HU.helpers.Hash;

public class LoginControllers {
	static public void login(HttpServletResponse response, String name, String pass, HttpSession s, PrintWriter out) throws IOException {

		String passwordhasheado = Hash.getHash(pass);
		String mail = Auth.Login(name, passwordhasheado);
		if(mail!=null) {
			
			s.setAttribute("usuario", name);
			s.setAttribute("correo", mail);
			
			response.sendRedirect("youtube.html");

		}else {
			out.println("Password incorrecto");
		}
	}
}