package com.dev.services;


import com.dev.beans.Asset;
import com.dev.beans.AssetAllocation;
import com.dev.beans.Employee;
import com.dev.beans.UserMaster;

public interface Services {
	public UserMaster loginService(Integer userid,String password);
	public Asset addAsset(Asset asset);
	public Asset removeAsset(Integer r);
	public Asset updateAsset(int a);
	public void getAllDetails();
	public Employee addEmployee(Employee emp);
	public void getAllAssetAllocationService();
	public void setStatusService(Integer allocationid);
	public void viewStatusService(Integer allocationid);
	public AssetAllocation serviceRaiseReq(AssetAllocation asetallocate);
}
