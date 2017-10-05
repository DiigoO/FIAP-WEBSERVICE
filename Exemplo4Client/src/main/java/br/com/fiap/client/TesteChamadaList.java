package br.com.fiap.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class TesteChamadaList {

	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();

		WebTarget target = client.target("http://localhost:8080/Exemplo4").path("alunos");

		Builder invocationBuilder = target.request(MediaType.APPLICATION_XML);

		Response resposta = invocationBuilder.get();

		Alunos alunos = resposta.readEntity(Alunos.class);

		for (Aluno a : alunos.getAlunoList()) {
			System.out.println("Nome: " + a.getNome());
			System.out.println("Turma: " + a.getTurma());
			System.out.println("Média: " + a.getMedia());
			System.out.println("----------");
		}
	}

}