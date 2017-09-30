package br.com.fiap.exemplos;

import java.rmi.RemoteException;

public class PrimeiroClient {

	public static void main(String[] args) {
		
		PrimeiroPortTypeProxy ws = new PrimeiroPortTypeProxy();
		
		try {
			System.out.println(ws.ola("Lauana"));
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
