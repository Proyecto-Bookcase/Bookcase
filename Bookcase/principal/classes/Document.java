package classes;

import java.util.Calendar;

public class Document extends Material {
	
	private String typeDoc;
	
	public Document(String id, String tittle, String author, Calendar date_creation, String tipe_doc) {
		super(id,tittle, author, date_creation);
		this.typeDoc = tipe_doc;
	}

	public String getTypeDoc() {
		return typeDoc;
	}

	public void setTypeDoc(String tipe_doc) {
		this.typeDoc = tipe_doc;
	}

	
}
