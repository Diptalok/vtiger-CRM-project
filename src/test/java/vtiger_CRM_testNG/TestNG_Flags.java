package vtiger_CRM_testNG;

import org.testng.annotations.Test;

public class TestNG_Flags {

	@Test(priority = 1)
	public  void create() {
		System.out.println("C");
	}
	@Test(priority = 2)
	public  void Modify() {
		System.out.println("M");
	}
	@Test(priority = 3)
	public  void delete() {
		System.out.println("D");
	}
	@Test(invocationCount = 3)
	public  void elete() {
		System.out.println("E");
	}
	@Test(invocationCount = -3)
	public  void lete() {
		System.out.println("F");
	}
	@Test(enabled = false)
	public  void ete() {
		System.out.println("G");
	}
	@Test(dependsOnMethods = "Modify")
	public  void tete() {
		System.out.println("H");
	}
	

}

//1. invocationCount test
//2. priority test
//3. capital or small letter test
//4. ascii value or alphabetical test
//5. dependsOnMethods test-execute after dependant method
//6. enable test false - skipping without execution
//7. -ve invocationCount - skip with execution 