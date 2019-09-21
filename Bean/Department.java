package com.dev.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="department")
public class Department 
{
	@Id
	@Column(name="dept_id")	
private Integer deptid;
	@Column(name="dept_name")
private String deptname;

public Integer getDeptid() {
	return deptid;
}
public void setDeptid(Integer deptid) {
	this.deptid = deptid;
}
public String getDeptname() {
	return deptname;
}
public void setDeptname(String deptname) {
	this.deptname = deptname;
}
@Override
public String toString() {
	return "Department [deptid=" + deptid + ", deptname=" + deptname + "]";
}
}
