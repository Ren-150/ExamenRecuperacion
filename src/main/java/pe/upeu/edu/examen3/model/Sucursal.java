package pe.upeu.edu.examen3.model;

public class Sucursal {
	private int idsucursal;
	private String nomsucursal;
	
	public Sucursal() {
	
	}
	
	public Sucursal(String nomsucursal) {
		this.nomsucursal = nomsucursal;
	}

	public int getIdsucursal() {
		return idsucursal;
	}

	public void setIdsucursal(int idsucursal) {
		this.idsucursal = idsucursal;
	}

	public String getNomsucursal() {
		return nomsucursal;
	}

	public void setNomsucursal(String nomsucursal) {
		this.nomsucursal = nomsucursal;
	}
	
}
