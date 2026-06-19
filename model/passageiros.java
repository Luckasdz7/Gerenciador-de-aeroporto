package model;

public class passageiros {

	private int id_passageiros;
	private String nome;
	private Integer cpf;
	private String email;
	private Integer telefone;
	
	public passageiros(String nome, Integer cpf, String email, Integer telefone) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
	}

	public int getId_passageiros() {
		return id_passageiros;
	}

	public void setId_passageiros(int id_passageiros) {
		this.id_passageiros = id_passageiros;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCpf() {
		return cpf;
	}

	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getTelefone() {
		return telefone;
	}

	public void setTelefone(Integer telefone) {
		this.telefone = telefone;
	}
	
	
	
}
