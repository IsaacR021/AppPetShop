package entidades;

public class Responsavel {
	private String nome;
	private String telefone;
	private String cpf;
	private String endereco;

	public Responsavel(String nome, String telefone, String cpf, String endereco) {
		this.nome = nome;
		this.telefone = telefone;
		this.cpf = cpf;
		this.endereco = endereco;
	}


	public void apresentaresponsavel() {
		System.out.println("nome: " + this.nome);
		System.out.println("telefone: " + this.telefone);
		System.out.println("cpf: " + this.cpf);
		System.out.println("endereco: " + this.endereco);
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String gettelefone() {
		return telefone;
	}

	public void settelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getcpf() {
		return cpf;
	}

	public void setcpf(String cpf) {
		this.cpf = cpf;
	}

	public String getendereco() {
		return endereco;
	}

	public void setendereco(String endereco) {
		this.endereco = endereco;
	}

}
