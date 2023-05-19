package classes;

import java.util.Date;

public class Book extends Material {
	private String editorial;
	//I think this property can be int, and not string
	private String edition;
	//I think this property can be int, and not string
	private String publication_year;
	
	public Book(String tittle, String author, Date date_creation, String editorial, String edition,
			String publication_year) {
		super(tittle, author, date_creation);
		this.editorial = editorial;
		this.edition = edition;
		this.publication_year = publication_year;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public String getEdition() {
		return edition;
	}
	public void setEdition(String edition) {
		this.edition = edition;
	}
	public String getPublication_year() {
		return publication_year;
	}
	public void setPublication_year(String publication_year) {
		this.publication_year = publication_year;
	}
	
}
