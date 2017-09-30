package br.com.fiap.client;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TesteUpload {

	public static void main(String[] args) {
		ArquivoWeb port = new ArquivoWebService().getArquivoWebPort();
		
		try {
			File file = new File("C:/Temp/Download/12031429309000.jpg");
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream inputStream = new BufferedInputStream(fis);
			byte[] imageBytes = new byte[(int) file.length() ];
			inputStream.read(imageBytes);
			System.out.println(imageBytes);
			port.upload("Caiu denovo.jpg", imageBytes);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOExcep	tion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
