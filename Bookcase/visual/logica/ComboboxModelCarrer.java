package logica;

import java.util.LinkedList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

import classes.Carreer;

public class ComboboxModelCarrer extends DefaultComboBoxModel<String>{
	private LinkedList<Carreer> carreraComboList;
	private int seletion;
	
	public ComboboxModelCarrer(String[] items,LinkedList<Carreer> carreraComboList) {
        super(items);
        this.carreraComboList = carreraComboList;
        setSeletion(0);
    }

    @Override
    public String getElementAt(int index) {
        String item = (String) super.getElementAt(index);
        return item;
    }
    
    public Carreer getelemCarreer(int index)
    {
    	return carreraComboList.get(index);
    }

	public int getSeletion() {
		return seletion;
	}

	public void setSeletion(int seletion) {
		this.seletion = seletion;
	}
    


}
