package vTiger.Practice;

public class GenericMethodPractice {

	public static void main(String[] args) //caller
	{
	add(10,20);
	int c=sub(130,60);
	System.out.println(c);
	}

	public static int add(int a, int b)//called
	{
	
		int c= a+b;//addition is the point
		//System.out.println(c);
		return c;
		
	}
	public static int sub(int a,int b)//called
	{
		int c= a-b;//subraction is the point
		//System.out.println(c);
		return c;
	}
}
