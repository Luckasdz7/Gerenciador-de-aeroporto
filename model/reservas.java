package model;

import java.util.Date;

public class reservas {

	private voos voo;
	private passageiros passageiro;
	private String assento;
	private Date data_reservar;
	private int id_resevas;
	
	public reservas() {
		
	}
	
	
	public reservas(passageiros passageiro, voos voo, String assento, Date data_reservar) {
		super();
		this.voo = voo;
		this.assento = assento;
		this.data_reservar = data_reservar;
		this.passageiro = passageiro;
	}

	

	public passageiros getPassageiro() {
		return passageiro;
	}



	public void setPassageiro(passageiros passageiro) {
		this.passageiro = passageiro;
	}



	public voos getVoo() {
		return voo;
	}


	public void setVoo(voos voo) {
		this.voo = voo;
	}


	public String getAssento() {
		return assento;
	}


	public void setAssento(String assento) {
		this.assento = assento;
	}


	public Date getData_reservar() {
		return data_reservar;
	}


	public void setData_reservar(Date data_reservar) {
		this.data_reservar = data_reservar;
	}


	public int getId_resevas() {
		return id_resevas;
	}


	public void setId_resevas(int id_resevas) {
		this.id_resevas = id_resevas;
	}
	
	
	
	
}
