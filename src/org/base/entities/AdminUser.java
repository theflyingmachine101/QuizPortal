package org.base.entities;

public class AdminUser {
	private int id;
	private String aname="",aemail="",apassword="";
	public AdminUser(int id,String aname, String aemail, String apassword) {
		super();
		this.id=id;
		this.aname = aname;
		this.aemail = aemail;
		this.apassword = apassword;
	}
	public AdminUser(String aname, String aemail, String apassword) {
		super();
		this.aname = aname;
		this.aemail = aemail;
		this.apassword = apassword;
	}
	public AdminUser(String aemail, String apassword) {
		super();
		this.aemail = aemail;
		this.apassword = apassword;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getAemail() {
		return aemail;
	}
	public void setAemail(String aemail) {
		this.aemail = aemail;
	}
	public String getApassword() {
		return apassword;
	}
	public void setApassword(String apassword) {
		this.apassword = apassword;
	}
}
