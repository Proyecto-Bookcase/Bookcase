package classes;

public class Subject implements NodeInfo {
	
	private String name;
	private String id;
	
	public Subject(String name) {
		this.name = name;
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
