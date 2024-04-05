package vtiger_CRM_testNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertion {
	
	@Test
	public void hardAssertion() {
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		
		Assert.assertEquals(true, true);        //comparison
		Assert.assertNotEquals(true, false);
		Assert.assertTrue(true);                //condition
		Assert.assertFalse(false);
		
		System.out.println("Step 4");
		System.out.println("Step 5");
		System.out.println("Step 6");
	}
	
	@Test
	public void softAssertion() {
		
		SoftAssert sa = new SoftAssert();
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		
		sa.assertEquals(true, true);
		sa.assertNotEquals(true, false);
		sa.assertTrue(true);
		sa.assertFalse(false);
		
		System.out.println("Step 4");
		System.out.println("Step 5");
		System.out.println("Step 6");
		
		sa.assertAll();    //mandatory for softassert
	}

}
