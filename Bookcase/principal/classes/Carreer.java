package classes;

public class Carreer implements NodeInfo {
	
	private String name;
	private String id;
	private int duration;
	boolean[] years;
	
	protected Carreer(String id, String name, int duration) {
		setId(id);
		setName(name);
		setDuration(duration);
		years = new boolean[10];
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
	public String getId() {
		return id;
	}
	private void setId(String id) {
		this.id = id;
	}
	
}
