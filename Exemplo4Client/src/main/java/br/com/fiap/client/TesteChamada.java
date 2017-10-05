package br.com.fiap.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.filter.HttpBasicAuthFilter;


public class TesteChamada {
	
	public static void main(String[] args) {
		Client client = ClientBuilder.newClient();
		
		client.register(new HttpBasicAuthFilter("fabio","123"));
		
		WebTarget target = client.target("http://localhost:8080/Exemplo4").path("alunos");
		
		Builder invocationBuilder = target.request(MediaType.APPLICATION_XML);
		
		Aluno a = new Aluno("Manoel", "Do Pagode", 10.0);
		
		Response resposta = invocationBuilder.post(Entity.entity(a, MediaType.APPLICATION_XML));
		
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