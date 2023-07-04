package logica;

import javax.swing.DefaultComboBoxModel;

import classes.Carreer;

public class ComboboxModelCarrer extends DefaultComboBoxModel<String>{
	
	public ComboboxModelCarrer(String[] items) {
        super(items);
    }

    @Override
    public String getElementAt(int index) {
        String item = (String) super.getElementAt(index);
        return item;
    }


}
