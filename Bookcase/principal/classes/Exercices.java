package classes;

import java.util.Calendar;

public class Exercices extends Material {

	//I think this property is not necesary
	private int total;
	private String tipe;

	
	public Exercices(String id,String tittle, String author, Calendar date_creation, int total, String tipe) {
		super(id, tittle, author, date_creation);
		this.total = total;
		this.tipe = tipe;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getTipe() {
		return tipe;
	}

	public void setTipe(String tipe) {
		this.tipe = tipe;
	}
	
}
