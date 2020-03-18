package HU.helpers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Auth {
	private static Connection conn = DB.getConnection();
	private static java.sql.PreparedStatement pstmt;
	private static ResultSet rs;

	public static String Login(String name, String passwordhasheado){
		String value=null;
		try	{
			pstmt = conn.prepareStatement("select * from Registro where name = '"+name+"' and password = '"+passwordhasheado+"';");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				value= rs.getString("correo"); 
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return value;
	}

	static public boolean user(String name) throws SQLException {
		boolean value=false;
		try	{
			pstmt = conn.prepareStatement("select * from Registro where name = '"+name+"';");
			rs = pstmt.executeQuery();
			value= rs.next();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return value;
	}

	static public boolean mail(String mail) throws SQLException {
		boolean value=false;
		try	{
			pstmt = conn.prepareStatement("select * from Registro where correo = '"+mail+"';");
			rs = pstmt.executeQuery();
			value= rs.next();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return value;
	}
}