package classes;

import java.io.Serializable;
import java.util.Calendar;


public abstract class Material implements Serializable{
	
	private static final long serialVersionUID = 2510482433577051274L;
	protected String tittle;
	protected String author;
	protected Calendar dateCreation;
	protected String id;

	protected Material(String id, String tittle, String author, Calendar dateCreation) {
		setId(id);
		setTittle(tittle);
		setAuthor(author);
		setDateCreation(dateCreation);
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

	public String getId() {
		return id;
	}

	private void setId(String id) {
		this.id = id;
	}

	protected void setAuthor(String author) {
		this.author = author;
	}

	protected Calendar getDateCreation() {
		return dateCreation;
	}

	protected void setDateCreation(Calendar dateCreation) {
		this.dateCreation = dateCreation;
	}

}
