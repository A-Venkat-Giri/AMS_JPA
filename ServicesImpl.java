package com.dev.services;


import com.dev.beans.Asset;
import com.dev.beans.AssetAllocation;
import com.dev.beans.Employee;
import com.dev.beans.UserMaster;
import com.dev.dao.DAO;
import com.dev.dao.DAOImpl;

public class ServicesImpl implements Services {
	DAO d=new DAOImpl();
	@Override
	public UserMaster loginService(Integer userid, String password) {

		return d.login(userid, password);
	}
	@Override
	public Asset addAsset(Asset asset) {

		return d.addAsset(asset);
	}
	
	@Override
	public Asset updateAsset(int a) {
		
		return d.updateAsset(a);
	}
	@Override
	public void getAllDetails() {
		
		 d.getAllDetails();
	}
	

	@Override
	public Employee addEmployee(Employee emp) {
		
		return d.addEmployee(emp);
	}
	
	

	
public void getAllAssetAllocationService() {
		
		 d.getAllAssetAllocation();
	}
	@Override
	public void setStatusService(Integer allocationid) {
		
		 d.setStatus(allocationid);
	}
	
	@Override
	public AssetAllocation serviceRaiseReq(AssetAllocation asetallocate) {
		
		return d.raiseRequest(asetallocate);
	}
	@Override
	public Asset removeAsset(Integer r) {
		
		return d.removeAsset(r);
	}
	@Override
	public void viewStatusService(Integer allocationid) {
		
		d.viewStatus(allocationid);
	}

	
	

	


}
