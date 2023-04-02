package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for the Event class
 */
public class EventTest {
	private Event e;
	private Calendar c;
	
	//NOTE: these tests might fail if time at which line (2) below is executed
	//is different from time that line (1) is executed.  Lines (1) and (2) must
	//run in same millisecond for this test to make sense and pass.
	
	@BeforeEach
	public void runBefore() {
		e = new Event("Sensor open at door");   // (1)
        c = Calendar.getInstance();   // (2)
	}
	
	@Test
	public void testEvent() {
		assertEquals("Sensor open at door", e.getDescription());
        c.add(Calendar.MILLISECOND, -50);
		assertTrue(e.getDate().after(c.getTime()));
        c.add(Calendar.MILLISECOND, 100);
        assertTrue(e.getDate().before(c.getTime()));
	}

	@Test
	public void testToString() {
		assertEquals(c.getTime().toString() + "\n" + "Sensor open at door", e.toString());
	}
}
