package model;

public class aeronaves {

	private int id_aeronaves;
	private String modelos;
	private int capacidade;
	
	
	public aeronaves()
	{
		
	}
	public aeronaves(String modelos, int capacidade) {
		
		this.modelos = modelos;
		this.capacidade = capacidade;
	}
	
	
	
	@Override
	public String toString() {
		return "aeronaves [id_aeronaves=" + id_aeronaves + ", modelos=" + modelos + ", capacidade=" + capacidade + "]";
	}
	public int getId_aeronaves() {
		return id_aeronaves;
	}
	public void setId_aeronaves(int id_aeronaves) {
		this.id_aeronaves = id_aeronaves;
	}
	public String getModelos() {
		return modelos;
	}
	public void setModelos(String modelos) {
		this.modelos = modelos;
	}
	public int getCapacidade() {
		return capacidade;
	}
	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}
	
	
	
	
}
