package com.revature.junit;

@SuppressWarnings("serial")
public class BankAppException extends Exception 
{
	public BankAppException() 
	{	
		super();
	}
	
	public BankAppException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public BankAppException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public BankAppException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public BankAppException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
