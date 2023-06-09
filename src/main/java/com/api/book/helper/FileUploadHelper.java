package com.api.book.helper;
import org.springframework.core.io.ClassPathResource;
import java.io.File;
import java.io.IOException;
//import java.io.FileOutputStream;
//import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
	
	//public final String UPLOAD_DIR="/Users/accordinnovationssdnbhd/workspace-spring-tool-suite-4-4.18.1.202304122255-SNAPSHOT/BOOTRESTBOOK/src/main/resources/static/image";
	
	public final String UPLOAD_DIR=new ClassPathResource("static/image/").getFile().getAbsolutePath();
	
	public FileUploadHelper()throws IOException
	{
		
	}
	
	public boolean uploadFile(MultipartFile multiPartFile)
	{
		boolean f=false;
		
		try {
//			InputStream is=multiPartFile.getInputStream();
//			byte data[]=new byte[is.available()]; 
//			is.read(data);
//			
//			FileOutputStream fos=new FileOutputStream(UPLOAD_DIR+File.separator+multiPartFile.getOriginalFilename());
//			fos.write(data);
//			fos.flush();
//			fos.close();
			Files.copy(multiPartFile.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+multiPartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			
			f=true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return f;
	}
}
