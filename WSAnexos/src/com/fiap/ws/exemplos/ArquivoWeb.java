package com.fiap.ws.exemplos;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class ArquivoWeb {
	@WebMethod
	public void upload(String fileName, byte[] imageBytes) throws IOException {
		String filePath = "C:/Temp/Upload/" + fileName;
		
		FileOutputStream fos;
		fos = new FileOutputStream(filePath);
		BufferedOutputStream outputStream = new BufferedOutputStream(fos);
		outputStream.write(imageBytes);
		outputStream.close();

	}
	
	@WebMethod
	public byte[] download(String fileName) throws IOException {
		String filePath = "C:/Temp/Download/" + fileName;
		
		File file = new File(filePath);		
		FileInputStream fis = new FileInputStream(file);
		BufferedInputStream inputStream = new BufferedInputStream(fis);
		byte[] fileBytes = new byte[(int) file.length()];
		inputStream.read(fileBytes);
		inputStream.close();
		
		return fileBytes;

	}
}
