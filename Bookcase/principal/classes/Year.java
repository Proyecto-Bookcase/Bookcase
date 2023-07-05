package classes;

import interfaces.NodeInfo;

public class Year implements NodeInfo {
	
	private static final long serialVersionUID = -5860593484384881204L;
	private int numberYear;
	private String id;

	public Year(String id, int numberYear) {
		setId(id);
		setNumberYear(numberYear);
	}
	
	public int getNumberYear() {
		return numberYear;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setNumberYear(int numberYear) {
		this.numberYear = numberYear;
	}
}
