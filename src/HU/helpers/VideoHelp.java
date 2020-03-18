package HU.helpers;

import java.io.InputStream;

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
	
	public static void upload(InputStream in){
		int read = 0;
		final Byte[] bytes = new Byte[1024];
		try {
			while ((read = in.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
