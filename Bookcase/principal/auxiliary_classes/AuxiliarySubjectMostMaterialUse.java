package auxiliary_classes;

import java.util.List;

import classes.Subject;

public class AuxiliarySubjectMostMaterialUse {

	private int cantdida;
	private List<Subject> subjectList;
	public int getCantdida() {
		return cantdida;
	}
	public void setCantdida(int cantdida) {
		this.cantdida = cantdida;
	}
	public List<Subject> getSubjectList() {
		return subjectList;
	}
	public void setSubjectList(List<Subject> subjectList) {
		this.subjectList = subjectList;
	}
	public AuxiliarySubjectMostMaterialUse(List<Subject> subjectList, int cantidad)
	{
		setCantdida(cantidad);
		setSubjectList(subjectList);
		
	}
}
