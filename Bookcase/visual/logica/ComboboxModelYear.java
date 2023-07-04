package logica;

import javax.swing.DefaultComboBoxModel;

public class ComboboxModelYear extends DefaultComboBoxModel<String>{
	
	public ComboboxModelYear(String[] items) {
        super(items);
    }

    @Override
    public String getElementAt(int index) {
        String item = (String) super.getElementAt(index);
        return item;
    }


}

