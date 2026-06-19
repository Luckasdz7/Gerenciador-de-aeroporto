package model;

public class usuarios {

	private int id_usuarios;
	private String login;
	private String senha;
	private perfil perfil;
	
	
	public usuarios(int id_usuarios, String login, String senha, model.perfil perfil) {
		super();
		this.id_usuarios = id_usuarios;
		this.login = login;
		this.senha = senha;
		this.perfil = perfil;
	}


	public int getId_usuarios() {
		return id_usuarios;
	}


	public void setId_usuarios(int id_usuarios) {
		this.id_usuarios = id_usuarios;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public perfil getPerfil() {
		return perfil;
	}


	public void setPerfil(perfil perfil) {
		this.perfil = perfil;
	}
	
	
}
