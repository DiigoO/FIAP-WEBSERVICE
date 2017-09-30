package br.com.fiap.client;

public class TesteChamada {
	public static void main(String[] args) {
		Aluno a = new Aluno();
		a.setNome("Zezinho");
		a.setTurma("Turma");
		a.setMedia(9);

		AlunoWeb port = new AlunoWebService().getAlunoWebPort();

		Novo parametros = new Novo();
		parametros.setAluno(a);
		try {
			System.out.println(port.novo(parametros, "Rodrigo", "123").getReturn());
		} catch (Exception_Exception e) {
			e.printStackTrace();
		}
	}
}
