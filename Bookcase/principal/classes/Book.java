package classes;

import java.util.Calendar;

public class Book extends Material {
	
	private static final long serialVersionUID = -1291910790657215574L;
	private String editorial;
	//I think this property can be int, and not string
	private String edition;
	//I think this property can be int, and not string
	private String publicationYear;
	
	public Book(String id,String tittle, String author, Calendar dateCreation, String editorial, String edition,
			String publicationYear) {
		super(id,tittle, author, dateCreation);
		this.editorial = editorial;
		this.edition = edition;
		this.publicationYear = publicationYear;
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
	public void setPublicationYear(String publicationYear) {
		this.publicationYear = publicationYear;
	}
	
}
