package vTiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
public class AssertPractice

{
	@Test
	public void assertPractice()
	{
	SoftAssert sa= new SoftAssert();
	
	System.out.println("Step 1");
	Assert.assertEquals("hi", "hello");//failed
	
	System.out.println("Step 2");
	//sa.assertEquals(false,true);//failed
	sa.assertEquals(1,1);//passed
	
	System.out.println("Step 3");
	sa.assertTrue(false);//failed
	
	System.out.println("Step 4");
	sa.assertAll();//logout of all failed assertion
}
@Test
public void Practice()
{
	System.out.println("Second script Step1");
	Assert.assertEquals(true, true);//passed
	System.out.println("Second script Step2");
}
}
