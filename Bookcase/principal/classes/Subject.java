package classes;

import interfaces.NodeInfo;

public class Subject implements NodeInfo {
	
	
	private static final long serialVersionUID = -4449467141033612499L;
	private String name;
	private String id;
	
	public Subject(String id, String name) {
		this.name = name;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getId() {
		
		return id;
	}

	

}
