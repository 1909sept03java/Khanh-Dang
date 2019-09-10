package com.revature.commandline;

public class CommandLine 
{
	public static void main(String[] args) 
	{
		// populating args into for loop
		for (String arg: args) 
		{
			System.out.print("The number of characters in the String " + arg + " is: ");
			System.out.println(arg.length());
		}
	}

}