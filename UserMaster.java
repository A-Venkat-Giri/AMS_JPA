package com.dev.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_master")
public class UserMaster 
{
	@Id
	@Column(name="UserId")
private Integer userid;
	@Column(name="UserName")
private String username;
	@Column(name="UserPassword")
private String userpassword;
	@Column(name="UserType")
private String usertype;
	
public Integer getUserid() {
	return userid;
}
public void setUserid(Integer userid) {
	this.userid = userid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getUserpassword() {
	return userpassword;
}
public void setUserpassword(String userpassword) {
	this.userpassword = userpassword;
}
public String getUsertype() {
	return usertype;
}
public void setUsertype(String usertype) {
	this.usertype = usertype;
}
@Override
public String toString() {
	return "UserMaster [userid=" + userid + ", username=" + username + ", userpassword=" + userpassword
			+ ", usertype=" + usertype + "]";
}

}
