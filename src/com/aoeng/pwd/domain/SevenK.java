package com.aoeng.pwd.domain;

public class SevenK {
	int id;
	String uname;
	String pwd;
	String md5;
	String sha1;
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
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getMd5() {
		return md5;
	}
	public void setMd5(String md5) {
		this.md5 = md5;
	}
	public String getSha1() {
		return sha1;
	}
	public void setSha1(String sha1) {
		this.sha1 = sha1;
	}
	@Override
	public String toString() {
		return "SevenK [id=" + id + ", uname=" + uname + ", pwd=" + pwd
				+ ", md5=" + md5 + ", sha1=" + sha1 + "]";
	}
	
	

}
