package auxiliary_classes;

import java.util.List;

import classes.Carreer;
import classes.Subject;
import classes.Year;

public class AuxiliarySubjectMostMaterialUse {

	private int cantdida;
	private List<SubAuxiliary> sub;
	
	
	public int getCantdida() {
		return cantdida;
	}
	public void setCantdida(int cantdida) {
		this.cantdida = cantdida;
	}
	
	public AuxiliarySubjectMostMaterialUse( List<SubAuxiliary> sub, int cantidad)
	{
		setCantdida(cantidad);
		setSub(sub);
		
		
	}
	public List<SubAuxiliary> getSub() {
		return sub;
	}
	public void setSub(List<SubAuxiliary> sub) {
		this.sub = sub;
	}
	
}
