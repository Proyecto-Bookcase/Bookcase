package logica;

import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.DefaultComboBoxModel;

import classes.Bookcase;
import classes.Carreer;
import classes.Material;
import classes.Subject;
import classes.Year;

public class ComboboxModelMaterial extends DefaultComboBoxModel {

	private LinkedList<Material> materialComboList;
	private int seletion;
	
	public ComboboxModelMaterial(String[] items) {
        super(items);
        this.materialComboList = new LinkedList<Material>();
        setSeletion(0);
    }

    @Override
    public String getElementAt(int index) {
        String item = (String) super.getElementAt(index);
        return item;
    }
    
    public Material getelemMaterial(int index)
    {
    	return materialComboList.get(index);
    }

	public int getSeletion() {
		return seletion;
	}

	public void setSeletion(int seletion) {
		this.seletion = seletion;
	}
	
	public void updateDelete(Subject subject,Bookcase bookcase)
    {
    	removeAllElements();
    	materialComboList = (LinkedList<Material>) bookcase.getAllMaterialOfSubject(subject);
    	Iterator<Material> iter = materialComboList.iterator();
    	while (iter.hasNext()) {
    		addElement(iter.next().getTittle()+" "+iter.next().getClass().getSimpleName());
			
		}
    }
	public void updateAdd(Subject subject,Bookcase bookcase)
    {
    	removeAllElements();
    	materialComboList = (LinkedList<Material>) bookcase.getAllMaterialOfNotUseSubject(subject);
    	Iterator<Material> iter = materialComboList.iterator();
    	while (iter.hasNext()) {
    		addElement(iter.next().getTittle()+" "+iter.next().getClass().getSimpleName());
			
		}
    }
}
