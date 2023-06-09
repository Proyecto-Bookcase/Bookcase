package classes;

import interfaces.NodeInfo;

public class University implements NodeInfo{
	
	private static final long serialVersionUID = -2532574182095177780L;
	private String id;
	private String name;

	public University(String id, String name){
		setId(id);
		setName(name);
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
	private void setId(String id) {
		this.id = id;
	}
}
