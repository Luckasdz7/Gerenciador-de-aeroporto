package model;

import java.util.ArrayList;
import java.util.List;

public class voos {
	
	private int voos; 

	private int id_voo;
	private String Embarque;
	private String Desembarque;
	private String numero_voo;
	private String companhia;
	private String status;
	private aeronaves aeronaves;
	List<reservas> listresevar;
	
	
	public voos() {
		
	}
	public voos(String embarque, String desembarque, String numero_voo, String companhia, String status,  aeronaves aeronaves ) {
		super();
		Embarque = embarque;
		Desembarque = desembarque;
		this.numero_voo = numero_voo;
		this.companhia = companhia;
		this.status = status;
		this.aeronaves =  aeronaves;
		
		 listresevar = new ArrayList<>();
	}
	
	
	public aeronaves getAeronaves() {
		return aeronaves;
	}
	
	
	
	

	public int getId_voo() {
		return id_voo;
	}
	public void setId_voo(int id_voo) {
		this.id_voo = id_voo;
	}
	public void setAeronaves(aeronaves aeronaves) {
		this.aeronaves = aeronaves;
	}
	
	public List<reservas> getListresevar() {
		return listresevar;
	}
	
	public void setListresevar(List<reservas> listresevar) {
		this.listresevar = listresevar;
	}
	
	public String getEmbarque() {
		return Embarque;
	}
	public void setEmbarque(String embarque) {
		Embarque = embarque;
	}
	public String getDesembarque() {
		return Desembarque;
	}
	public void setDesembarque(String desembarque) {
		Desembarque = desembarque;
	}
	public String getNumero_voo() {
		return numero_voo;
	}
	public void setNumero_voo(String numero_voo) {
		this.numero_voo = numero_voo;
	}
	public String getCompanhia() {
		return companhia;
	}
	public void setCompanhia(String companhia) {
		this.companhia = companhia;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
	    return "┌─ VOO ──────────────────────────────\n"
	         + "│  Número   : " + numero_voo  + "\n"
	         + "│  Embarque : " + Embarque    + "\n"
	         + "│  Pouso    : " + Desembarque + "\n"
	         + "│  Companhia: " + companhia   + "\n"
	         + "│  Status   : " + status      + "\n"
	         + "└────────────────────────────────────";
	}
	
}
