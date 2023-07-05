package custom_components;

import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings({ "rawtypes", "unchecked" })
//Modificador final para que no se pueda heredar de la clase
public final class Auxiliary {

	public static final DefaultTableCellRenderer CellRenderCenter = getCellRenderCenter();
	private static final Random RAND = new Random();
	private static final HashMap<Component, Color> obscureContainer = new HashMap<Component, Color>();
	private static int pX;
	private static int pY;

	// Constructor privado para que no se pueda instanciar la clase
	private Auxiliary() {
	}

	/**
	 * Limpia los datos de una tabla
	 * 
	 * @param tableModel TableModel de la tabla
	 */
	public static void limpiar(DefaultTableModel tableModel) {
		int count = tableModel.getRowCount();
		for (int i = 0; i < count; i++) {
			tableModel.removeRow(0);
		}
	}

	/**
	 * Filtra los datos de una Tabla
	 * 
	 * Actualizar la tabla antes cada vez que se valla a usar éste método
	 * 
	 * @param txtField   De donde se extrae el texto a Filtrar
	 * @param tableModel TableModel de la Tabla
	 * @param column     columna que se va a filtrar
	 * @param arrayLimit tamaño de la lista con la cual se actualiza la tabla
	 */

	public static void filtro(String filterText, DefaultTableModel tableModel, int column, int arrayLimit) {
		Vector<Vector> vectorObjectDuplicado = new Vector<Vector>(tableModel.getDataVector());
		// Da una lista duplicada
		List<Vector> listaObject = vectorObjectDuplicado.subList(0, arrayLimit);
		// Arregla la lista duplicada
		List<Vector<Object>> subList = new ArrayList<Vector<Object>>();
		// Filtra los datos
		for (Vector<Object> vector : listaObject) {
			String field = vector.get(column).toString();
			if (field.toLowerCase().contains(filterText.toLowerCase())) {
				subList.add(vector);
			}
		}
		limpiar(tableModel);
		// Muestra en la tabla los datos filtrados
		if (!subList.isEmpty()) {
			for (Vector<Object> object : subList) {
				Vector<Object> v = object;
				ArrayList<Object> lista = new ArrayList<Object>();
				for (int j = 0; j < v.size(); j++) {
					lista.add(v.get(j));
				}
				tableModel.addRow(lista.toArray());
			}
		}
	}

	/**
	 * Selecciona todos los checkBox de una tabla
	 * 
	 * @param tableModel TableModel de la Tabla
	 * @param checkBox   CheckBox principal
	 * @param column     columna que contiene los checkboxs
	 */
	public static void selectAll(DefaultTableModel tableModel, JCheckBox checkBox, int column) {
		if (tableModel.getRowCount() > 0) {
			for (int i = 0; i < tableModel.getRowCount(); i++) {
				tableModel.setValueAt(checkBox.isSelected(), i, column);
			}
		}
	}

	/**
	 * Borra las filas seleccionadas de una tabla. Dicha tabla debe tener una
	 * columna enumerada que indique el número de la fila (desde 1)
	 * 
	 * @param table
	 * @param lista
	 */
	public static void borrarSeleccion(JTable table, ArrayList<?> lista) {

		ArrayList<Object> lista2 = new ArrayList<Object>();
		if (table != null && lista != null) {
			for (int i : table.getSelectedRows()) {
				lista2.add(lista.get(Integer.parseInt(table.getValueAt(i, 0).toString()) - 1));
			}
			lista.removeAll(lista2);
		}
	}


	/**
	 * Borra las filas seleccionadas de una tabla. La tabla no tiene que tener
	 * necesariamente la columna enumerada, pero si se filtra, éste método deja de
	 * funcionar
	 * 
	 * @param table
	 * @param lista
	 */
	public static void borrarSeleccionSimple(JTable table, ArrayList<?> lista) {

		ArrayList<Object> lista2 = new ArrayList<Object>();
		if (table != null && lista != null) {
			for (int i : table.getSelectedRows()) {
				lista2.add(lista.get(i));
			}
			lista.removeAll(lista2);
		}
	}

	/**
	 * Genera un String de tamaño size con numero aleatorios enteros
	 * 
	 * @param size Tamaño que se desea
	 * @throws IllegalArgumentException
	 */
	public static String random(int size) throws IllegalArgumentException {
		StringBuilder code = new StringBuilder();
		if (size > 0) {
			for (int i = 0; i < size; i++) {
				code.append(RAND.nextInt(10));
			}
		}
		return code.toString();
	}

	/**
	 * Activa el botón Borrar cuando hay una o más filas seleccionadas en la tabla
	 */
	public static void activarBotonBorrar(final JButton borrar, final JTable table) {
		if (borrar != null && table != null) {

			table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

				public void valueChanged(ListSelectionEvent e) {
					boolean check = false;
					if (table.getSelectedRowCount() > 0) {
						check = true;
					}
					borrar.setEnabled(check);
				}

			});
		}
	}

	/**
	 * Activa el botón Editar cuando hay solo una fila seleccionada en la tabla
	 */
	public static void activarBotonEditar(final JButton editar, final JTable table) {
		if (editar != null && table != null) {
			table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

				public void valueChanged(ListSelectionEvent e) {
					boolean check = false;
					if (table.getSelectedRowCount() == 1) {
						check = true;
					}
					editar.setEnabled(check);
				}

			});
		}
	}

	/**
	 * Centra las columnas de una tabla
	 * 
	 * @param listaColumnas Lista de los números de las columnas que van a ser
	 *                      centradas
	 */
	public static void centrarColumnas(JTable table, int[] listaColumnas) {
		for (int i : listaColumnas) {
			table.getColumnModel().getColumn(i).setCellRenderer(CellRenderCenter);
		}
	}

	private static DefaultTableCellRenderer getCellRenderCenter() {
		DefaultTableCellRenderer cellRender = new DefaultTableCellRenderer();
		cellRender.setHorizontalAlignment(SwingConstants.CENTER);
		return cellRender;
	}

	public static void quitarReordenamientoTabla(JTable table) {
		table.getTableHeader().setReorderingAllowed(false);
	}

	// Validations for JTextFields
	////////////////////////////////////////////////////////////////

	// unable to enter data
	public static void noData(final JTextField c) {
		// Oculta el cursor
		c.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				c.getCaret().setVisible(false);
			}
		});

		// unable to enter data manually
		c.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				e.consume();
			}
		});
	}

	// Only Letters
	public static void onlyLetters(final JTextField c, final boolean espacios) {
		c.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				Character c = e.getKeyChar();

				// Sólo letras y espacios
				if (!(Character.isLetter(c) || (espacios && c == KeyEvent.VK_SPACE))) {
					e.consume();
				}
			}
		});
	}

	/**
	 * Valida un JTextField para que sólo se puedan introducir números enteros o
	 * decimales
	 * 
	 * @param textField JTextField
	 * @param decimal   Si es False sólo se podran introducir números enteros
	 */
	public static void onlyNumbers(final JTextField textField, final boolean decimal) {
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				String string = textField.getText();
				Character c = e.getKeyChar();

				boolean isDigit = Character.isDigit(c);
				boolean isDot = c == KeyEvent.VK_PERIOD;

				// Check if the JTextField has a dot
				boolean haveDot = false;
				for (char ch : string.toCharArray()) { // to find a dot
					if (ch == KeyEvent.VK_PERIOD) {
						haveDot = true;
					}
				}

				if (decimal) {
					// Consumes if the first character is a dot
					if (string.isEmpty() && isDot) {
						e.consume();
					}

					// If the only character in the JTextField is a 0 and is inserted a number,
					// clean the JTextField
					if (string.length() == 1 && string.charAt(0) == KeyEvent.VK_0 && isDigit) {
						textField.setText("");

					}
				}

				// Consumes if is inserted anything that is not a number or a dot
				// In the case that is a dot, decimal must be True
				if (!(isDigit || (decimal && isDot && !haveDot))) {
					e.consume();

				}
			}

			// Small fix, because if the text is selected, copied and overwrited imself,
			// codes can be break
			@Override
			public void keyReleased(KeyEvent e) {
				if (decimal) {
					String string = textField.getText();
					// If overwritted imself with a dot and is the first characted, it's deleted
					if (string.length() > 0 && string.charAt(0) == KeyEvent.VK_PERIOD) {
						string = string.substring(1);
						textField.setText(string);
					}
				}

			}
		});
	}

	// Only Letters and Spaces and Numbers
	public static void onlyLettersAndNumbers(final JTextField c, final boolean espacios) {
		c.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				Character c = e.getKeyChar();

				if (!(Character.isLetter(c) || (espacios && c == KeyEvent.VK_SPACE) || Character.isDigit(c))) {
					e.consume();
				}
			}
		});
	}

	// Set a limit to what characters can be typed on this JTextField
	public static void limite(final JTextField t, final int limit) {
		t.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (t.getText().length() >= limit) {
					e.consume();
				}
			}
		});
		t.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (t.getText().length() > limit) {
					t.setText(t.getText().substring(0, limit));
				}
			}
		});
	}

	// Validations for JSpinners
	////////////////////////////////////////////////////////////////

	/**
	 * The listener spinner change its value according to the triggering spinner
	 * 
	 * @param trigger  JSpinner que desencadena la acción
	 * @param listener JSpinner que cambia en consecuencia de la accion
	 * @param check    Variable que controla el último valor del JSpinner
	 *                 accionador, es necesario que esta variable sea un campo de su
	 *                 clase
	 */

	public static void linkSpinners(final JSpinner trigger, final JSpinner listener, final AtomicInteger check) {

		trigger.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				final int value = (Integer) trigger.getValue();
				if (trigger.getPreviousValue() != null) {
					if (check.get() > value) {
						listener.setValue((Integer) listener.getValue() - 1);
					} else {
						listener.setValue((Integer) listener.getValue() + 1);
					}
				} else {
					listener.setValue((Integer) listener.getValue() - 1);
				}
				check.set(value);

			}
		});
	}

	// Métodos para la validación del CI
	// //////////////////////////////////////////////////////////////////////////////

	public static int extractDayOfCI(String ci) throws NumberFormatException {
		if (ci == null || ci.length() != 11) {
			throw new IllegalArgumentException("El CI debe tener 11 caracteres");
		}
		return Integer.parseInt(ci.substring(4, 6));
	}

	public static int extractMonthOfCI(String ci) throws NumberFormatException {
		if (ci == null || ci.length() != 11) {
			throw new IllegalArgumentException("El CI debe tener 11 caracteres");
		}
		return Integer.parseInt(ci.substring(2, 4));
	}

	public static String extractYearOfCI(String ci) throws NumberFormatException {
		if (ci == null || ci.length() != 11) {
			throw new IllegalArgumentException("El CI debe tener 11 caracteres");
		}
		String year = ci.substring(0, 2);
		int century = Integer.parseInt(ci.substring(6, 7));

		if (century == 9) {
			year = "18" + year;
		} else if (century > 5 && century < 9) {
			year = "20" + year;

		} else {
			year = "19" + year;
		}
		return year;
	}

	public static Period calculateAge(int date, int month, String year) throws NumberFormatException {
		return Period.between(LocalDate.of(Integer.parseInt(year), month, date),
				LocalDate.of(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH) + 1,
						Calendar.getInstance().get(Calendar.DATE)));
	}

	/**
	 * Aplica el efecto de arrastrar el Frame cuando se presiona sobre un componente
	 * y éste se arrastra por la pantalla
	 * 
	 * @param window Ventanta que recibe el efecto de arrastrado
	 * @param arg    Componentes que al precionar sobre ellos y arrastrarlos, la
	 *               ventana también se moverá
	 * @throws IllegalArgumentException En caso de que window sea null o arg
	 *                                  contenga algún elemento en null
	 */
	public static void dragEffect(final Window window, Component... arg) throws IllegalArgumentException {
		if (window == null) {
			throw new IllegalArgumentException("window no puede ser null");
		}

		for (Component component : arg) {
			if (component != null) {
				component.addMouseMotionListener(new MouseMotionAdapter() {
					@Override
					public void mouseDragged(MouseEvent e) {
						Point p = window.getLocation();
						window.setLocation(p.x + e.getX() - pX, p.y + e.getY() - pY);
					}
				});
				component.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						pX = e.getX();
						pY = e.getY();
					}
				});
			}
		}
	}

	/**
	 * Mueve el primer elemento de una lista hacia el final, creando un efecto de
	 * rotación
	 * 
	 * @param arrayList
	 * @throws IllegalArgumentException En caso de que arrayList sea null o esté
	 *                                  vacío
	 */
	public static void rotateArrayList(ArrayList arrayList) throws IllegalArgumentException {
		if (arrayList == null) {
			throw new IllegalArgumentException("array no puede ser null");
		}

		if (arrayList.isEmpty()) {
			throw new IllegalArgumentException("array no puede estar vacío");
		}

		if (arrayList.size() > 1) {
			arrayList.add(arrayList.get(0));
			arrayList.remove(0);
		}
	}

	public static void obscure(final Component comp) {
		obscureContainer.put(comp, comp.getBackground());
		comp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				comp.setBackground(comp.getBackground().darker());
			}

			@Override
			public void mouseExited(MouseEvent e) {
				comp.setBackground(obscureContainer.get(comp));
			}
		});
	}
}
