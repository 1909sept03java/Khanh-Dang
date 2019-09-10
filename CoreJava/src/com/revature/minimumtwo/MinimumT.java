package com.revature.minimumtwo;

// Java Implementation to finding the minimum of two number using Ternary Operators
public class MinimumT
{

	public static void main(String[] args)
	{

		int val1 = 4;
		int val2 = 5;
		System.out.println("The minimum value of "+val1+" and "+val2+" is: ");
		int minVal = (val1 < val2) ? val1 : val2;
		System.out.println(minVal);
	}
}