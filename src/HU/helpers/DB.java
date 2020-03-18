package HU.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB extends Thread{
	private static String server="jdbc:postgresql://localhost:5432/Youtube";
	private static String User="postgres";
	private static String pass= "holamundo";
	private static Connection conn = DB.getConnection();
  /*  private static java.sql.Statement stmt;
	private static PreparedStatement pstmt;
	private static ResultSet rs;*/
	
	public static Connection getConnection(){
		if(conn !=null) {//if there is a connection already return it, otherwise establish one 
			return conn;
		}
		else{
			try {
				Class.forName("org.postgresql.Driver");
				conn= DriverManager.getConnection(server, User, pass);
				System.out.println("Conexion establecida!");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
		}
	}
	
	/*public void dbStatement(String query) {
		try {
			stmt = conn.createStatement();
			rs= stmt.executeQuery(query);
			while(rs.next()) {
				System.out.println(rs.getString("Username"));
			}
		}catch ( SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
			}catch ( SQLException e) {
				e.printStackTrace();
			}
		}
	}*/
	
	/*public void dbPrepareStatement(String query, Object[] users) {
		try {
			//pstmt= conn.prepareStatement(query);
			
			for(int i; user.) {
				
			}
			
			pstmt.setString(1, (String) users[0]);
			pstmt.setString(2, (String) users[1]);
			pstmt.setString(3, (String) users[2]);
			pstmt.executeUpdate();
		}catch ( SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
			}catch ( SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	/*public static boolean dbPrepareStatement(String SQL) {
		try {
			pstmt= conn.prepareStatement(SQL);
			pstmt.executeUpdate();
			//this.pstmt.executeUpdate();
			return false;
			
		}catch ( SQLException e) {
			e.printStackTrace();
			return true;
			
		}finally {
			try {
				pstmt.close();
			}catch ( SQLException e) {
				e.printStackTrace();
			}
		}
	}*/
}