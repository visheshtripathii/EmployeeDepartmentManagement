package com.employee.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
	
	// Static Path
	public final String UPLOAD_DIR="/Users/visheshtripathi/Documents/workspace-spring-tool-suite-4-4.19.1.RELEASE/EmployeeDepartmentManagement/src/main/resources/static/image" ;
	
	//Dynamic Path
//	public final String UPLOAD_DIR= new ClassPathResource("static/image/").getFile().getAbsolutePath();
	
	public FileUploadHelper() throws IOException{
		
	}
	
	public boolean uploadFile(MultipartFile multipartFile) {
		
		boolean f=false;
		
		try {
			
			InputStream is = multipartFile.getInputStream();
			
			// READ
			byte data[]=new byte[is.available()];
			is.read();
			
			// WRITE
			FileOutputStream fos =new FileOutputStream(UPLOAD_DIR+"/"+multipartFile.getOriginalFilename());
			fos.write(data);
			
			fos.flush();
			fos.close();
			
			//
//			Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			
			f=true;
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
		
		
		
	}
}
