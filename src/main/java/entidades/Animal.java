package entidades;

public class Animal {
	private int id;
	private String nome;
	private String especie;
	private String raca;
	private long responsavel_cpf;

	public Animal(int id, String nome, String especie, String raca,long responsavel_cpf) {
		this.id=id;
		this.nome = nome;
		this.especie = especie;
		this.raca = raca;
		this.responsavel_cpf= responsavel_cpf;
	}



	public long getResponsavel_cpf(){
		return responsavel_cpf;
	}
	public void setResponsavel_cpf(int responsavel_cpf){
		this.responsavel_cpf=responsavel_cpf;
	}


	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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



}
