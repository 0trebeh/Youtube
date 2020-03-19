package HU.helpers;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

public class VideoHelp {
	
	//getFileInfo(video, name del video)
	public static String getFileInfo(Part part, String type){
		for(String Content: part.getHeader("Content-disposition").split(";")) {
			if(Content.trim().startsWith("Filename")) {
				switch(type) {
				case "Name":
					return Content.substring(Content.indexOf('/')+1).trim().replace("\"","");
				case "Exection": 
					return Content.substring(Content.indexOf('.')+1).trim().replace("\"","");
				}
			}
		}
		return "500";
	}
	
	public static void upload(HttpServletResponse response, InputStream in) throws IOException{
		int read = 0;
		final byte[] bytes = new byte[1024];
		ServletOutputStream out = response.getOutputStream();
		try {
			while ((read = in.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
