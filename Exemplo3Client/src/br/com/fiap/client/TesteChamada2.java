package br.com.fiap.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;

public class TesteChamada2 {
	public static void main(String[] args) {
		List<Aluno> alunos = new ArrayList<>();

		AlunoWeb port = new AlunoWebService().getAlunoWebPort();
		
		try {
			ListarResponse resposta = port.listar(new Listar(), "Rodrigo", "123");
			alunos = resposta.getReturn();
			
			for(Aluno a : alunos) {
				System.out.println("Nome: " + a.getNome());
				System.out.println("Turma: " + a.getTurma());
				System.out.println("Média: " + a.getMedia());
				System.out.println("-----");
			}
		}
		catch(Exception_Exception e) {
			e.printStackTrace();
		}
	}
}
