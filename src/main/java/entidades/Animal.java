package entidades;

public class Animal {
	
	private String nome;
	private String especie;
	private String raca;
	private int idade;

	public Animal(String nome, String especie, String raca, int idade) {
		this.nome = nome;
		this.especie = especie;
		this.raca = raca;
		this.idade = idade;
	}



	public void apresentaAnimal() {
		System.out.println("nome: " + this.nome);
		System.out.println("especie: " + this.especie);
		System.out.println("raca: " + this.raca);
		System.out.println("idade: " + this.idade);
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

}
