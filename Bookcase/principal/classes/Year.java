package classes;

import interfaces.NodeInfo;

public class Year implements NodeInfo {
	
	private static final long serialVersionUID = -5860593484384881204L;
	private int numberYear;
	private String id;

	protected Year(String id, int numberYear) {
		setId(id);
		setNumberYear(numberYear);
	}
	
	public int getNumberYear() {
		return numberYear;
	}

	public String getId() {
		return id;
	}

	private void setId(String id) {
		this.id = id;
	}

	private void setNumberYear(int numberYear) {
		this.numberYear = numberYear;
	}
}
