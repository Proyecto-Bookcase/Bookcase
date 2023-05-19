package classes;

import java.util.Date;

public class Material {
	private String tittle;
	private String author;
	private Date date_creation;
	
	
	public Material(String tittle, String author, Date date_creation) {
		this.tittle = tittle;
		this.author = author;
		this.date_creation = date_creation;
	}
	public String getTittle() {
		return tittle;
	}
	public void setTittle(String tittle) {
		this.tittle = tittle;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getDate_creation() {
		return date_creation;
	}
	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}
	
	
}
