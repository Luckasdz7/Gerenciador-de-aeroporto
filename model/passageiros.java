package model;

public class passageiros {

	private int id_passageiros;
	private String nome;
	private String cpf;
	private String email;
	private String telefone;
	
	
	public passageiros() {
		
	}
	public passageiros(String nome, String cpf, String email, String telefone) {
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	@Override
	public String toString() {
		return "passageiros [id_passageiros=" + id_passageiros + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email
				+ ", telefone=" + telefone + "]";
	}
	
	
	
	
}
