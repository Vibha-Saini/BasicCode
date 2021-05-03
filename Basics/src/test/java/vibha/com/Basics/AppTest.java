package vibha.com.Basics;

import hashmaptest.HashMap;
import hashmaptest.Map;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */

	public void testApp() {
		Map<String, Integer> map = new HashMap();
		map.put("one", 1);
		map.put("two", 2);
		map.put("three", 3);
		map.put("four", 4);

		/*
		 * assertEquals(new Integer(1), map.get("one")); assertEquals(new Integer(3),
		 * map.get("three"));
		 */
//		assertEquals(new Integer(2), map.get("two"));

		map.put("two", 20);
		assertEquals(new Integer(20), map.get("two"));

//		assertTrue(true);
	}

	public void replaceTest() {

	}
}
