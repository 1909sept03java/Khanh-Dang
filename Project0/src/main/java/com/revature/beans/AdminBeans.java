package com.revature.beans;

public class AdminBeans 
{
	private String sudoPassword;
	private String superuser;
	
	public AdminBeans() 
	{
		super();
	}
	public AdminBeans (String sudoPassword,  String superuser) 
	{
		super();
		this.setSudoPassword(sudoPassword);
		this.setSuperuser(superuser);
	}
	public String getSudoPassword() {
		return sudoPassword;
	}
	public void setSudoPassword(String sudoPassword) {
		this.sudoPassword = sudoPassword;
	}
	public String getSuperuser() {
		return superuser;
	}
	public void setSuperuser(String superuser) {
		this.superuser = superuser;
	}
	public String getSudoInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
