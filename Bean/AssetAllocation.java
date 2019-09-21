package com.dev.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="asset_allocation")
public class AssetAllocation 
{
	@Id
	@Column(name="AllocationId")
private Integer allocationid;
	@Column(name="AssetId")
private Integer assetid;
	@Column(name="Empno")
private Integer empno;
	@Column(name="Allocation_date")
private String allocationdate;
	@Column(name="Release_date")
private String releasedate;
	@Column(name="Quantity")
private Integer quantity;
public Integer getAllocationid() {
	return allocationid;
}
public void setAllocationid(Integer allocationid) {
	this.allocationid = allocationid;
}
public Integer getAssetid() {
	return assetid;
}
public void setAssetid(Integer assetid) {
	this.assetid = assetid;
}
public Integer getEmpno() {
	return empno;
}
public void setEmpno(Integer empno) {
	this.empno = empno;
}
public String getAllocationdate() {
	return allocationdate;
}
public void setAllocationdate(String string) {
	this.allocationdate = string;
}
public String getReleasedate() {
	return releasedate;
}
public void setReleasedate(String string) {
	this.releasedate = string;
}
public Integer getQuantity() {
	return quantity;
}
public void setQuantity(Integer quantity) {
	this.quantity = quantity;
}
@Override
public String toString() {
	return "AssetAllocation [allocationid=" + allocationid + ", assetid=" + assetid + ", empno=" + empno
			+ ", allocationdate=" + allocationdate + ", releasedate=" + releasedate + ", quantity=" + quantity + "]";
}


}
