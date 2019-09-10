package com.revature.checkeven;

//Java program to check for even or odd int without using modulus %
class CheckEven 
{   
	// Returns true if n  
	// is even, else is odd 
	static boolean isEven(int n) 
	{ 
		boolean isEven = true; 

		for (int i = 1; i <= n; i++)  
			isEven = !isEven; 

		return isEven; 
	} 


	// Driver Code 
	public static void main(String args[]) 
	{ 

		int n = 100; 
		if(isEven(n)) 
			System.out.println("Even"); 
		else
			System.out.println("Odd"); 

	} 
} 