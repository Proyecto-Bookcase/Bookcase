package classes;

import java.util.Date;

public abstract class Material {
	
	
	protected String tittle;
	protected String author;
	protected Date dateCreation;
	
	
	protected Material(String tittle, String author, Date date_creation) {
		this.tittle = tittle;
		this.author = author;
		this.dateCreation = date_creation;
	}
	protected String getTittle() {
		return tittle;
	}
	protected void setTittle(String tittle) {
		this.tittle = tittle;
	}
	protected String getAuthor() {
		return author;
	}
	protected void setAuthor(String author) {
		this.author = author;
	}
	protected Date getDateCreation() {
		return dateCreation;
	}
	protected void setDateCreation(Date date_creation) {
		this.dateCreation = date_creation;
	}
	
	
}
