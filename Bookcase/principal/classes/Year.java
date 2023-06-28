package classes;

public class Year implements NodeInfo {
	
	private int numberYear;
	private String id;

	protected Year(String id, int numberYear) {
		this.numberYear = numberYear;
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
}
