package com.dev.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee
{
	@Id
	@Column(name="Empno")
private Integer empno;
	@Column(name="Ename")
private String ename;
	@Column(name="job")
private String job;
	@Column(name="mgr")
private Integer mgrno;
	@Column(name="hiredate")
private String hiredate;
	@Column(name="Dept_ID")
private Integer deptid;
public Integer getEmpno() {
	return empno;
}
public void setEmpno(Integer empno) {
	this.empno = empno;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public String getJob() {
	return job;
}
public void setJob(String job) {
	this.job = job;
}
public Integer getMgrno() {
	return mgrno;
}
public void setMgrno(Integer mgrno) {
	this.mgrno = mgrno;
}
public String getHiredate() {
	return hiredate;
}
public void setHiredate(String hiredate) {
	this.hiredate = hiredate;
}
public Integer getDeptid() {
	return deptid;
}
public void setDeptid(Integer deptid) {
	this.deptid = deptid;
}
@Override
public String toString() {
	return "Employee [empno=" + empno + ", ename=" + ename + ", job=" + job + ", mgrno=" + mgrno + ", hiredate="
			+ hiredate + ", deptid=" + deptid + "]";
}

}
