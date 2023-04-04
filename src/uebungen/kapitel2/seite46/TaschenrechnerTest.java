package uebungen.kapitel2.seite46;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TaschenrechnerTest {
	private Taschenrechner t;
	
	@BeforeEach
	public void setup() {
		t = new Taschenrechner();
	}

	@Test
	public void testAdd() {
		int z = t.add(3, 4);
		assertEquals(7, z);
		assertEquals(-15, t.add(-20,  5));
	}
	
	@Test
	void testDiv() {
		assertEquals(2, t.div(10, 5));
		try {
			t.div(5, 0);
			fail("Exception erwartet.");
		}
		catch (RuntimeException rt) {
			assertTrue(true);
		}
	}
}
