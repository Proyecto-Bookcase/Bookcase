package classes;

public class Subject implements NodeInfo {
	
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
