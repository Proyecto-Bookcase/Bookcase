package classes;

import java.util.Date;

public class Link extends Material{
	private String url;

	public Link(String tittle, String author, Date date_creation, String url) {
		super(tittle, author, date_creation);
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
