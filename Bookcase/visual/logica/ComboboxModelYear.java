package logica;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;

import classes.Bookcase;
import classes.Carreer;
import classes.Year;

public class ComboboxModelYear extends DefaultComboBoxModel<String>{
	private List<Year> comboYearList;
	private int seletion;
	
	public ComboboxModelYear(String[] items) {
        super(items);
        comboYearList = new LinkedList<Year>();
        setSeletion(0);
    }

    @Override
    public String getElementAt(int index) {
        String item = (String) super.getElementAt(index);
        return item;
    }
    public Year getelemYear(int index)
    {
    	return comboYearList.get(index);
    }
    public void update(Carreer carreer,Bookcase bookcase)
    {
    	removeAllElements();
    	comboYearList = bookcase.getAllYearOfCarrer(carreer);
    	Iterator<Year> iter = comboYearList.iterator();
    	while (iter.hasNext()) {
    		addElement(Integer.toString(iter.next().getNumberYear()));
			
		}
    }

	public int getSeletion() {
		return seletion;
	}

	public void setSeletion(int seletion) {
		this.seletion = seletion;
	}


}

