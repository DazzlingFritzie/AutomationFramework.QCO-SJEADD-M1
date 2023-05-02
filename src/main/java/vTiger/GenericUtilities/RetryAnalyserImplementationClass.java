package vTiger.GenericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class is an implementation class for IRETRYANALYSER interface of testNg
 * @author Admin
 *
 */
public class RetryAnalyserImplementationClass implements IRetryAnalyzer
{
	int count =0;
	int retryCount =3;
	
public boolean retry(ITestResult result)
{
	//0<3,1<3,2<3--retry 3 times
	//3<3---false
	while(count<retryCount)
	{
		count++;//123
	return true;
}
return false;
}
}
