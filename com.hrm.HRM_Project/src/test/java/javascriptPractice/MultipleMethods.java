package javascriptPractice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MultipleMethods {

	@Parameters ("a")
	@Test
	public void testMethod(String a) {
		System.out.println(a);
	}
	
	@Parameters ("a b")
	@Test
	public void testMethod(String a, String b) {
		System.out.println(a);
	}
}
