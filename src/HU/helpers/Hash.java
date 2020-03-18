package HU.helpers;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

	public static String getHash(String text) {
		MessageDigest md;
		String hash = null;
		try {
			md = MessageDigest.getInstance("MD5");
			md.reset();
			byte[] bytes = md.digest(text.getBytes("UTF-8"));
			
			BigInteger BI = new BigInteger(1, bytes);
			hash = BI.toString(8);
			
			while(hash.length() < 16){
				hash = "0" + hash;
			}
			return hash;
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hash;
	}
}