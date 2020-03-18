package HU.Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import HU.Servlet.LogOut;
import HU.helpers.Auth;
import HU.helpers.DB;
import HU.helpers.Hash;

public class UserCntrollers {
	
	private static Connection conn = DB.getConnection();
	private static PreparedStatement pstmt;
	private static String mail;
	private static String name;
	
	public static void perfil(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		if(request.getSession(false) != null) {
			HttpSession s = request.getSession(false);
			out.println(" name: "+s.getAttribute("usuario")+"\n mail: "+s.getAttribute("correo"));
			response.sendRedirect("perfil.html");
		} else {
			out.println("no hay una sesion creada");
		}
	}
	
	public static void update(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException{
		
		PrintWriter out = response.getWriter();
		if(request.getSession(false) != null) {
			HttpSession s = request.getSession(false);
			
			name = (String) s.getAttribute("usuario");
			mail = (String) s.getAttribute("correo");
			
			String newname = request.getParameter("usuario");
			String newmail = request.getParameter("correo");
			String passwordhasheado = Hash.getHash(request.getParameter("pass"))+"          ";
			
			if(name!=newname) {
				if(Auth.user(name)==true) {
					out.print("Este nombre de usuario ya Existe");
				}else {
					pstmt = conn.prepareStatement("UPDATE  Registro SET name = '"+newname+"' WHERE name = '"+name+"';"); 
					s.setAttribute("usuario", newname);
					name = newname;
				}
			}
			if(mail!=newmail) {
				if(Auth.mail(mail)==true) {
					out.print("Este Correo ya esta asociado a una cuenta");
				}else {
					pstmt = conn.prepareStatement("UPDATE  Registro SET correo = '"+newmail+"' WHERE correo = '"+mail+"';"); 
					s.setAttribute("correo", newmail);
				}
			}
			if(name!=null) {
				pstmt = conn.prepareStatement("UPDATE  Registro SET password = '"+passwordhasheado+"' WHERE name = '"+name+"';");
			}
			
			out.println(" name: "+s.getAttribute("usuario")+"\n mail: "+s.getAttribute("correo"));
		
		}else {
			out.print("session cerrada inesperadamente");
		}
	}
	
	public static void delete(HttpServletRequest request, HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		if(request.getSession(false) != null) {
			HttpSession s = request.getSession(false);
			name=(String) s.getAttribute("usuario");
			
			try{
				pstmt = conn.prepareStatement("delete from Registro where name='"+name+"'");
				pstmt.executeUpdate();
				out.print("Usuario Eliminado con exito");
				LogOut.logOut(request, response);             //cierra sesion
				response.sendRedirect("register.html");
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		else {
			out.print("session no iniciada");
		}
	}
}
