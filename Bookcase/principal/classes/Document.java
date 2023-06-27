package classes;

import java.util.Date;

public class Document extends Material {
	private String typeDoc;
	public Document(String tittle, String author, Date date_creation, String tipe_doc) {
		super(tittle, author, date_creation);
		this.typeDoc = tipe_doc;
	}

	public String getTypeDoc() {
		return typeDoc;
	}

	public void setTypeDoc(String tipe_doc) {
		this.typeDoc = tipe_doc;
	}

	
}
