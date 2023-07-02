package classes;

import java.util.Calendar;

public class Book extends Material {
	private String editorial;
	//I think this property can be int, and not string
	private String edition;
	//I think this property can be int, and not string
	private String publicationYear;
	
	public Book(String id,String tittle, String author, Calendar date_creation, String editorial, String edition,
			String publication_year) {
		super(id,tittle, author, date_creation);
		this.editorial = editorial;
		this.edition = edition;
		this.publicationYear = publication_year;
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
	public String getPublicationYear() {
		return publicationYear;
	}
	public void setPublicationYear(String publication_year) {
		this.publicationYear = publication_year;
	}
	
}
