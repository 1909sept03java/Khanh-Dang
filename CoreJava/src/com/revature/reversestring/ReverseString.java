package com.revature.reversestring;

//Java Implementation to Reverser a String without any temporary var and StringBuilder
public class ReverseString 
{
	public static void main(String[] args) 
	{
		String reverseMe = "Hello World!";
		for (int i = 0; i < reverseMe.length(); i++) 
		{
			reverseMe = reverseMe.substring(1, reverseMe.length() - i)
					+ reverseMe.substring(0, 1)
					+ reverseMe.substring(reverseMe.length() - i, reverseMe.length());
		}
		System.out.println(reverseMe);

	}

}
