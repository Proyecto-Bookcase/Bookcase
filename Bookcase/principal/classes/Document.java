package classes;

import java.util.Calendar;

public class Document extends Material {
	
	private static final long serialVersionUID = -2951714311121138460L;
	private String typeDoc;
	
	public Document(String id, String tittle, String author, Calendar dateCreation, String typeDoc) {
		super(id,tittle, author, dateCreation);
		this.typeDoc = typeDoc;
	}

	public String getTypeDoc() {
		return typeDoc;
	}

	public void setTypeDoc(String typeDoc) {
		this.typeDoc = typeDoc;
	}

	
}
