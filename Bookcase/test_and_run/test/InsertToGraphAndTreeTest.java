package test;

import java.util.Arrays;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import classes.Bookcase;
import classes.Document;

class InsertToGraphAndTreeTest {

	private static Bookcase instance;
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		instance = Bookcase.getInstance();
		
		instance.newCarreer("Informática", 4);
		instance.newSubject("001", "Maemática1");
		instance.newMaterial(Document.class, Arrays.asList("00100"), "","",new GregorianCalendar(),"");
	}

	@Test
	void test() {
		
		System.out.println();
		
	}

}
