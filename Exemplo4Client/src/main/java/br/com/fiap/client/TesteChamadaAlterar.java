package br.com.fiap.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


public class TesteChamadaAlterar {
	
	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		
		WebTarget target = client.target("http://localhost:8080/Exemplo4").path("alunos").path("0");
		
		Builder invocationBuilder = target.request(MediaType.APPLICATION_XML);
		
		Aluno a = new Aluno("Eat", "Teoc", 1.0);
		
		Response resposta = invocationBuilder.put(Entity.entity(a, MediaType.APPLICATION_XML));
		
		Retorno r = resposta.readEntity(Retorno.class);
		
		System.out.println(r.getMensagem());
		
//		Response resposta = invocationBuilder.get();
//		
//		Aluno a = resposta.readEntity(Aluno.class);
//		
//		System.out.println("Nome: " + a.getNome());
//		System.out.println("Turma: " + a.getTurma());
//		System.out.println("Média: " + a.getMedia());
	}
	
}