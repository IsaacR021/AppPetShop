package entidades;

public class Agendamento {
	private int id;
	private String endereco;
	private String data;
	private String horario;
	private String servico;
	private String especie;
	private String raca;
	private String nome;
	private long responsavel_cpf;

	public Agendamento(int id,String endereco,String data,String horario,String servico, String nome, String especie, String raca,long responsavel_cpf) {
		this.id=id;
		this.endereco = endereco;
		this.data = data;
		this.horario = horario;
		this.servico = servico;
		this.especie = especie;
		this.raca = raca;
		this.nome = nome;
		this.responsavel_cpf= responsavel_cpf;
	}




	

	public String getEndereco(){
		return endereco;
	}
	public void setEndereco(String endereco){
		this.endereco=endereco;
	}


	public String getData(){
		return data;
	}
	public void setData(String data){
		this.data=data;


	}public String getHorario(){
		return horario;
	}
	public void setHorario(String horario){
		this.horario=horario;
	}


	public String getServico(){
		return servico;
	}
	public void setServico(String servico){
		this.servico=servico;
	}

	public long getResponsavel_cpf(){
		return responsavel_cpf;
	}
	public void setResponsavel_cpf(Long responsavel_cpf){
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
