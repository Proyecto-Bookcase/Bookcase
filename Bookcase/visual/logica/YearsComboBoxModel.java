package logica;

import java.util.LinkedList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

import classes.Bookcase;
import classes.Carreer;

public class YearsComboBoxModel extends DefaultComboBoxModel<String> {

	private static final long serialVersionUID = -4071827807302183490L;

	public YearsComboBoxModel() {
		super(getList());
	}
	
	private static String[] getList() {
		List<String> list = new LinkedList<>();
		list.add("Todas las carreras");
		for(Carreer carreer : Bookcase.getInstance().getAllCarrer()) {
			list.add(carreer.getName());
		}
		return list.toArray(new String[0]);
	}
}
