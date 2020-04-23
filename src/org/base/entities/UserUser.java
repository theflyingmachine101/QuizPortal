package org.base.entities;

public class UserUser {
	private int id;
	private String uname="",uemail="",upassword="";
	public UserUser(int id, String uname, String uemail, String upassword) {
		super();
		this.id = id;
		this.uname = uname;
		this.uemail = uemail;
		this.upassword = upassword;
	}
	public UserUser(String uname, String uemail, String upassword) {
		super();
		this.uname = uname;
		this.uemail = uemail;
		this.upassword = upassword;
	}
	public UserUser(String uemail, String upassword) {
		super();
		this.uemail = uemail;
		this.upassword = upassword;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUemail() {
		return uemail;
	}
	public void setUemail(String uemail) {
		this.uemail = uemail;
	}
	public String getUpassword() {
		return upassword;
	}
	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}
}
