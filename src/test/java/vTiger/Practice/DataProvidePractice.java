package vTiger.Practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvidePractice 
{
	@Test(dataProvider="getData")
	public void sampleTest(String BrandName, int price, int size)
	{
		System.out.println(BrandName+"-->"+price+"-->"+size);
	}
	@DataProvider
	public Object[][] getData()
	{                              //row//cell   
		Object[][] data= new Object[5][3];
		
		data [0][0]="ParkAvenu";
		data[0][1]= 4999;
		data[0][2] = 28;

		data [1][0]="Raymond";
		data[1][1]= 2999;
		data[1][2] = 30;


		data [2][0]="Livis";
		data[2][1]=1499;
		data[2][2] = 32;
 
		data [3][0]="FabIndia";
		data[3][1]=3999;
		data[3][2] = 34;

		data [4][0]="PeterEngland";
		data[4][1]=1099;
		data[4][2] = 36;

		return data;
	}
	}


