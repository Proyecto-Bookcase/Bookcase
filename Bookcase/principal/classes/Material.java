package classes;

import java.util.Date;

public class Material {
	private String tittle;
	private String author;
	private Date dateCreation;
	
	
	public Material(String tittle, String author, Date date_creation) {
		this.tittle = tittle;
		this.author = author;
		this.dateCreation = date_creation;
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
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date date_creation) {
		this.dateCreation = date_creation;
	}
	
	
}
