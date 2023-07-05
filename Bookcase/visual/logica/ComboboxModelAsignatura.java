package logica;

import java.util.LinkedList;

import javax.swing.DefaultComboBoxModel;

import classes.Material;
import classes.Subject;

public class ComboboxModelAsignatura extends DefaultComboBoxModel {

	private LinkedList<Subject> subjectComboList;
	private int seletion;
	
	public ComboboxModelAsignatura(String[] items,LinkedList<Subject> carreraComboList) {
        super(items);
        this.subjectComboList = carreraComboList;
        setSeletion(0);
    }

    @Override
    public String getElementAt(int index) {
        String item = (String) super.getElementAt(index);
        return item;
    }
    
    public Subject getelemSubject(int index)
    {
    	return subjectComboList.get(index);
    }

	public int getSeletion() {
		return seletion;
	}

	public void setSeletion(int seletion) {
		this.seletion = seletion;
	}
}
