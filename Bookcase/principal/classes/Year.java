package classes;

public class Year implements NodeInfo {
	
	private int numYear;

	public Year(int number_year) {
		this.numYear = number_year;
	}
	
	public int getNumYear() {
		return numYear;
	}

	public void setNumYear(int number_year) {
		this.numYear = number_year;
	}

}
