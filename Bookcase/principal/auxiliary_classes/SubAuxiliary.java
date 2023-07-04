package auxiliary_classes;

import java.util.List;

import classes.Carreer;
import classes.Subject;
import classes.Year;

public class SubAuxiliary {
	
	private Subject subject;
	private Carreer carrer;
	private Year year;
	public Carreer getCarrer() {
		return carrer;
	}
	public void setCarrer(Carreer carrer) {
		this.carrer = carrer;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public Year getYear() {
		return year;
	}
	public void setYear(Year year) {
		this.year = year;
	}
	public  SubAuxiliary(Subject subject, Carreer carreer, Year year) {
		setSubject(subject);
		setCarrer(carreer);
		setYear(year);
	}
	
	
	
	
}
