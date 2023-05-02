package vTiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionPracticee 
{
	@Test
	public void assertPractice()
	{
		/*System.out.println("Hi");
		//Assert.assertEquals(true, false);
		Assert.assertEquals(true, true);
		System.out.println("Hello");*/
		
		System.out.println("Step 1");
		System.out.println("Step 2");
		//Assert.assertEquals(true, true);//passed
		Assert.assertEquals(false, true);//failed
		System.out.println("Step 3");
		System.out.println("Step 4");
}
	@Test
	public void Practice()
	{
		System.out.println("Second script Step1");
		System.out.println("Second script Step2");
	}
}