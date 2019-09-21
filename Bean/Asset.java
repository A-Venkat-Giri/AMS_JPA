package com.dev.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="asset")
public class Asset 
{
	@Id
	@Column(name="AssetId")
private Integer assetid;
	@Column(name="AssetName")
private String assetname;
	@Column(name="AssetDes")
private String assetdes;
	@Column(name="Quantity")
private Integer quantity;
	@Column(name="Status")
private String status;
public Integer getAssetid() {
	return assetid;
}
public void setAssetid(Integer assetid) {
	this.assetid = assetid;
}
public String getAssetname() {
	return assetname;
}
public void setAssetname(String assetname) {
	this.assetname = assetname;
}
public String getAssetdes() {
	return assetdes;
}
public void setAssetdes(String assetdes) {
	this.assetdes = assetdes;
}
public Integer getQuantity() {
	return quantity;
}
public void setQuantity(Integer quantity) {
	this.quantity = quantity;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
@Override
public String toString() {
	return "Asset [assetid=" + assetid + ", assetname=" + assetname + ", assetdes=" + assetdes + ", quantity="
			+ quantity + ", status=" + status + "]";
}

}
