package test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import classes.Book;
import classes.Exercices;
import classes.Material;
import logica.TableModelMostUseMaterial;

class TableModelUpdateTest {

	private TableModelMostUseMaterial tb;
	private List<Material> list;
	
	
	@BeforeEach
	void setUp() throws Exception {
		tb = new TableModelMostUseMaterial();
//		list = Arrays.asList(new Book("","","",Calendar.getInstance(), "","", null), new Exercices("", "", "", Calendar.getInstance(), 0, null));
	}

	@Test
	void test() {
		tb.actualizar(list);
	}

}
