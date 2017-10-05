package br.com.fiap.rs.exemplos;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/alunos")
public class AlunoWeb {
	
	static private List<Aluno> alunos;
	
	static {
		alunos = new ArrayList<>();
		Aluno a = new Aluno();
		a.setNome("Guilherme Andrade");
		a.setTurma("SCJ");
		a.setMedia(9.5);
		alunos.add(a);
		
		Aluno b = new Aluno();
		b.setNome("Rodrigo Pereira");
		b.setTurma("SCJ");
		b.setMedia(8.5);
		alunos.add(b);
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Aluno> getAlunos() {
		return alunos;
	}
	
	@Path("{indice}")
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Aluno getAluno(@PathParam("indice") int indice) {
		return alunos.get(indice);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Retorno novo(Aluno a) {
		alunos.add(a);
		Retorno r = new Retorno();
		r.setMensagem("Aluno foi adicionado com sucesso");
		return r;
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	@Path("{indice}")
	public Retorno alterar(Aluno a, @PathParam("indice") int indice){
		alunos.set(indice,a);
		return new Retorno("Aluno foi alterado");
		
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_XML)
	@Path("{indice}")
	public Retorno excluir(@PathParam("indice") int indice){
		alunos.remove(indice);
		return new Retorno("Aluno foi EXCLUIDO");
	}
	
}
