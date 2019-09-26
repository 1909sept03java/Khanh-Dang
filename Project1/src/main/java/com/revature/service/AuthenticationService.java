package com.revature.service;

import com.revature.beans.CredentialsBeans;
import com.revature.beans.UsersBeans;

public class AuthenticationService 
{	
	// if credentials are not recognized, return null
	// if they are, return user associated with them
	public UsersBeans authenticateUser(CredentialsBeans creds)
	{
		UsersBeans u = null;
		if (creds.getUsername().equals("kd") && creds.getPassword().equals("blaze")) {
			u = new UsersBeans(7, "Khanh", "Dang");
		}
		return u;
	}

}