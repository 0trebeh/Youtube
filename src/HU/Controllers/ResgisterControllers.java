package HU.Controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import HU.helpers.Auth;
import HU.helpers.DB;
import HU.helpers.Hash;

public class ResgisterControllers {
	
	private static Connection conn = DB.getConnection();
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	private static String mail;
	private static String name;
	private static String passwordhasheado;
	
	static public void register(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		PrintWriter out = response.getWriter();
		name=request.getParameter("usuario");
		passwordhasheado = Hash.getHash(request.getParameter("pass"));
		mail = request.getParameter("mail");

		if(Auth.user(name)==true) {
			out.print("Usuario ya Existe");
		}else if(Auth.mail(mail)==true) {
			out.print("Este Correo ya esta asociado a una cuenta");
		}else {
			try	{
				pstmt = conn.prepareStatement("Insert into registro(correo, name, password) values(?,?,?)");
				pstmt.setString(1, mail);
				pstmt.setString(2, name);
				pstmt.setString(3, passwordhasheado);
				rs = pstmt.executeQuery();
			}
			catch(SQLException e){
				e.printStackTrace();
				System.out.println("error en el catch de registercontrollers");
			}
			HttpSession s = request.getSession(true);
			s.setAttribute("usuario", name);
			s.setAttribute("correo", mail);
			response.sendRedirect("youtube.html");
		}
	}
}
