package model;

public class voos {
	
	private int voos; 

	private String Embarque;
	private String Desembarque;
	private String numero_voo;
	private String companhia;
	private String status;
	
	
	public voos() {
		
	}
	public voos(String embarque, String desembarque, String numero_voo, String companhia, String status) {
		super();
		Embarque = embarque;
		Desembarque = desembarque;
		this.numero_voo = numero_voo;
		this.companhia = companhia;
		this.status = status;
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
		return "  || Embarque= " + Embarque + ", Desembarque = " + Desembarque + ", numero_voo = " + numero_voo
				+ ", companhia = " + companhia + ", status = " + status + "||";
	}
	
	
}
