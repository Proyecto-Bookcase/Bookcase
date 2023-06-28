package classes;

public class Subject implements NodeInfo {
	
	private String name;
	
	public Subject(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}

}
