package classes;

import java.util.Date;

public class Document extends Material {
	private String tipe_doc;
	public Document(String tittle, String author, Date date_creation, String tipe_doc) {
		super(tittle, author, date_creation);
		this.tipe_doc = tipe_doc;
	}

	public String getTipe_doc() {
		return tipe_doc;
	}

	public void setTipe_doc(String tipe_doc) {
		this.tipe_doc = tipe_doc;
	}

	
}
