package com.dev.dao;


import com.dev.beans.Asset;
import com.dev.beans.AssetAllocation;
import com.dev.beans.Employee;
import com.dev.beans.UserMaster;

public interface DAO {
	public UserMaster login(Integer userid,String password);
	public Asset addAsset(Asset asset);
	public Asset removeAsset(int r);
	public Asset updateAsset(int a);
	public void getAllDetails();
	
	public Employee addEmployee(Employee emp);
	public void viewStatus(Integer id1);
	public void getAllAssetAllocation();
	public void setStatus(Integer allocationid);
	public AssetAllocation raiseRequest(AssetAllocation asetallocate);
}
