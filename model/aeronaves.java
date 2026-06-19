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
