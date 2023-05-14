package classes;

public class Carreer extends NodeInfo {
	private String name;
	//I think this property is not necessary
	private int duration;
	
	public Carreer() {
		
	}
	public Carreer(String name, int duration) {
		this.name = name;
		this.duration = duration;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
}
