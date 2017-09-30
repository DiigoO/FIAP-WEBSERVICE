package com.fiap.exemplos.ws2;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

import com.fiap.exemplos.ws2.Aluno;

@WebService
public class AlunoWeb {
	
	@Resource
	WebServiceContext wsctx;
	
	private List<Aluno> alunos;

	public AlunoWeb() {
		alunos = new ArrayList<Aluno>();
	}
	
	@WebMethod(exclude=true)
	public boolean autenticado(String usuario, String senha){
		
		if(usuario.equals("Rodrigo") && senha.equals("123")){
			return true;
		}else{
			return false;
		}
	}
	
	@WebMethod
	public String novo(@WebParam(name = "Aluno", header = false) Aluno a,
						@WebParam(name = "Username", header = true) String usuario,
						@WebParam(name = "Senha", header = true) String senha) throws Exception {
		if(this.autenticado(usuario, senha)){
			this.alunos.add(a);
			return "\\\\o";
		}else{
			throw new Exception("Usuário ou senha inválido");
		}
	}
	
	@WebMethod
	public List<Aluno> listar(@WebParam(name = "Username", header = true) String usuario,
			@WebParam(name = "Senha", header = true) String senha) throws Exception{
		if(this.autenticado(usuario, senha)) {
			return this.alunos;
		}
		else {
			throw new Exception("Usuário ou senha inválida");
		}
	}
}
