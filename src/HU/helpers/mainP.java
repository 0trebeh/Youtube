package HU.helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.security.NoSuchAlgorithmException;

import java.sql.SQLException;

import java.util.Properties;

public class mainP {

	public static void main(String[] args) throws SQLException, IOException, NoSuchAlgorithmException {
		// TODO Auto-generated method stub
		
		
		Video.doget();
		
		
		
		
		//System.out.println(Hash.getHash("hola"));
		
	/*	System.out.println(Auth.Login("123", "123"));
		System.out.println(Auth.mail("123"));
		System.out.println(Auth.user("tnt"));
		
		Properties p= new Properties();
		InputStream A = new FileInputStream("src/properties/archivo.properties"); 
		p.load(A);

		System.out.println(p.getProperty("hola")+" "+p.getProperty("azucar"));*/
	}
}