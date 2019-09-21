package com.dev.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="asset_status")
public class AssetStatus {
	@Id
	@Column(name="AllocationId")
private Integer allocationid;
	@Column(name="status")
private String status;
public Integer getAllocationid() {
	return allocationid;
}
public void setAllocationid(Integer allocationid) {
	this.allocationid = allocationid;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
@Override
public String toString() {
	return "AssetStatus [allocationid=" + allocationid + ", status=" + status + "]";
}

}
