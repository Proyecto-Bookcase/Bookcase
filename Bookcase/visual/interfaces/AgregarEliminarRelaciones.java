package interfaces;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.TitledBorder;

import classes.Bookcase;
import classes.Carreer;
import classes.Subject;
import logica.ComboboxModelAsignatura;
import logica.ComboboxModelCarrer;
import logica.ComboboxModelMaterial;
import logica.ComboboxModelYear;

import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class AgregarEliminarRelaciones extends JPanel{
	private JComboBox comboBox_1;
	private JComboBox comboBox;
	private JComboBox comboBox_2;
	private JComboBox comboBox_1_1;
	public AgregarEliminarRelaciones() {
		setLayout(null);
		Bookcase bookcase = Bookcase.getInstance();
		
		JPanel panel = new JPanel();
		panel.setBounds(120, 5, 605, 348);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Agregar Relaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(65, 10, 483, 125);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int seleccion = comboBox.getSelectedIndex();
				if (seleccion != ((ComboboxModelAsignatura)comboBox.getModel()).getSeletion()) {
					((ComboboxModelAsignatura)comboBox.getModel()).setSeletion(seleccion);
					
					((ComboboxModelMaterial)comboBox_1.getModel()).updateAdd(((ComboboxModelAsignatura)comboBox.getModel()).
							getelemSubject(seleccion)
							, bookcase);
				}
			}
			
		});
		comboBox.setBounds(10, 65, 207, 21);
		LinkedList<Subject> subjectComboList = (LinkedList<Subject>) bookcase.getAllSubjects();
		LinkedList<String> b = new LinkedList<String>();
		for (Subject val : subjectComboList) {
			b.add(val.getName());
		}
		comboBox.setModel(new ComboboxModelAsignatura(b.toArray( new String[b.size()]), subjectComboList));
		
		panel_1.add(comboBox);
		
		JLabel lblNewLabel_1_5 = new JLabel("Material");
		lblNewLabel_1_5.setFont(new Font("Yu Gothic UI Semibold", Font.ITALIC, 16));
		lblNewLabel_1_5.setBounds(238, 21, 132, 34);
		panel_1.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("Asignatura");
		lblNewLabel_1_5_1.setFont(new Font("Yu Gothic UI Semibold", Font.ITALIC, 16));
		lblNewLabel_1_5_1.setBounds(10, 21, 132, 34);
		panel_1.add(lblNewLabel_1_5_1);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(238, 65, 207, 21);
		panel_1.add(comboBox_1);
		
		comboBox_1.setModel(new ComboboxModelMaterial(new String[] {}));
		((ComboboxModelMaterial)comboBox_1.getModel()).updateAdd(((ComboboxModelAsignatura)comboBox.getModel()).
				getelemSubject(comboBox.getSelectedIndex())
				, bookcase);
		
		
		JButton btnNewButton = new JButton("Añadir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int seleccionSubject = comboBox.getSelectedIndex();
				int seleccionMaterial = comboBox_1.getSelectedIndex();
				
				bookcase.addRelation(((ComboboxModelAsignatura)comboBox.getModel()).
						getelemSubject(seleccionSubject).getId(), 
						
						((ComboboxModelMaterial)comboBox_1.getModel()).
						getelemMaterial(seleccionMaterial).getId());
				
				((ComboboxModelMaterial)comboBox_1.getModel()).updateAdd(((ComboboxModelAsignatura)comboBox.getModel()).
						getelemSubject(seleccionSubject)
						, bookcase);
			}
		});
		btnNewButton.setBounds(360, 94, 85, 21);
		panel_1.add(btnNewButton);
		int index =comboBox.getSelectedIndex();
		Subject carreer =((ComboboxModelAsignatura)comboBox.getModel()).getelemSubject(index);
		((ComboboxModelMaterial)comboBox_1.getModel()).updateAdd(null, bookcase);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Eliminar Relaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(65, 165, 483, 125);
		panel.add(panel_1_1);
		
		comboBox_2 = new JComboBox();
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int seleccion = comboBox_2.getSelectedIndex();
				if (seleccion != ((ComboboxModelAsignatura)comboBox_2.getModel()).getSeletion()) {
					((ComboboxModelAsignatura)comboBox_2.getModel()).setSeletion(seleccion);
					
					((ComboboxModelMaterial)comboBox_1_1.getModel()).updateDelete(((ComboboxModelAsignatura)comboBox_2.getModel()).
							getelemSubject(seleccion)
							, bookcase);
				}
			}
		});
		comboBox_2.setBounds(10, 65, 207, 21);
		
//		LinkedList<Subject> subjectComboList1 = (LinkedList<Subject>) bookcase.getAllSubjects();
//		LinkedList<String> b = new LinkedList<String>();
//		for (Subject val : subjectComboList) {
//			b.add(val.getName());
//		}
		comboBox_2.setModel(new ComboboxModelAsignatura(b.toArray( new String[b.size()]), subjectComboList));
		
		panel_1_1.add(comboBox_2);
		
		JLabel lblNewLabel_1_5_2 = new JLabel("Material\r\n");
		lblNewLabel_1_5_2.setFont(new Font("Yu Gothic UI Semibold", Font.ITALIC, 16));
		lblNewLabel_1_5_2.setBounds(238, 21, 132, 34);
		panel_1_1.add(lblNewLabel_1_5_2);
		
		JLabel lblNewLabel_1_5_1_1 = new JLabel("Asignatura");
		lblNewLabel_1_5_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.ITALIC, 16));
		lblNewLabel_1_5_1_1.setBounds(10, 21, 132, 34);
		panel_1_1.add(lblNewLabel_1_5_1_1);
		
		comboBox_1_1 = new JComboBox();
		comboBox_1_1.setBounds(238, 65, 207, 21);
		comboBox_1_1.setModel(new ComboboxModelMaterial(new String[] {}));
		((ComboboxModelMaterial)comboBox_1_1.getModel()).updateDelete(((ComboboxModelAsignatura)comboBox_2.getModel()).
				getelemSubject(comboBox_2.getSelectedIndex())
				, bookcase);
		
		panel_1_1.add(comboBox_1_1);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int seleccionSubject = comboBox_2.getSelectedIndex();
				int seleccionMaterial = comboBox_1_1.getSelectedIndex();
				
				bookcase.deleteRelation(((ComboboxModelAsignatura)comboBox_2.getModel()).
						getelemSubject(seleccionSubject).getId(), 
						
						((ComboboxModelMaterial)comboBox_1_1.getModel()).
						getelemMaterial(seleccionMaterial).getId());
				
				((ComboboxModelMaterial)comboBox_1_1.getModel()).updateDelete(((ComboboxModelAsignatura)comboBox_2.getModel()).
						getelemSubject(seleccionSubject)
						, bookcase);
			}
		});
		btnEliminar.setBounds(360, 96, 85, 21);
		panel_1_1.add(btnEliminar);
	}
}
