package br.com.fiap.client;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TesteDownload {

	public static void main(String[] args) {
		ArquivoWeb port = new ArquivoWebService().getArquivoWebPort();
		
		try {
			byte[] fileBytes = port.download("pntm.jpg");
			
			FileOutputStream fos = new FileOutputStream("C:/Temp/download.jpg");
			BufferedOutputStream outputStream = new BufferedOutputStream(fos);
			outputStream.write(fileBytes);
			outputStream.close();
		} catch (IOException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
