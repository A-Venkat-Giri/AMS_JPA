package com.dev.app;
/**Imported all the packages which are required  **/
import java.util.Scanner;
import com.dev.beans.Asset;
import com.dev.beans.AssetAllocation;
import com.dev.beans.Employee;
import com.dev.beans.UserMaster;
import com.dev.services.Services;
import com.dev.services.ServicesImpl;
import com.dev.validations.Validate;

public class App 
{
	public static void main(String[] args) 
	{
		Services serve=new ServicesImpl();
		Scanner scn=new Scanner(System.in);
		Validate validate=new Validate(); 
		System.out.println("Welcome To Asset Management System:");
		System.out.println("------------------------------------------");
		jump: while(true)
		{
			System.out.println("Select any one option from the below ");
			System.out.println("1. Go to Manager's page");
			System.out.println("2. Go to Admin's page");
			System.out.println("3. Exit from the portal");
			Integer op = Integer.parseInt(validate.integerValidation((scn.next())));
			/**In the below If statement, if we enter 1 then it will go to Manager's page
			 * and if we enter 2 then it will go to Admin's's page**/
			if(op== 1| op==2)
			{
				System.out.println("Welcome To Login Page");
				System.out.println("----------------------------------");
				System.out.println("Enter the User Id");
				Integer userid=scn.nextInt();
				System.out.println("Enter Password");
				String password=scn.next();
				UserMaster um=serve.loginService(userid, password);
				if(um.getUsertype().equalsIgnoreCase("manager"))
				{
					System.out.println("Welcome to Manager's page");
					System.out.println("---------------------------");
					jp: while(true)
					{
						System.out.println("Enter any one option form the below:-");
						System.out.println("1.Raise the Request");
						System.out.println("2.View the Status of Raised request");
						System.out.println("3.Add newly joined Employee Details"); 
						System.out.println("4.Get all raised request");
						System.out.println("5.SignOut from Manager's page");
						System.out.println("6.Exit from the portal ");
						Integer option = Integer.parseInt(validate.integerValidation((scn.next())));
						Employee emp=new Employee();
						switch(option)
						{
						/**This case is used for raising the request**/
						case 1:
							AssetAllocation asetallocate=new AssetAllocation();
							System.out.println("Raise the request");
							System.out.println("Enter Asset Id");
							asetallocate.setAssetid(Integer.parseInt(validate.integerValidation((scn.next()))));
							System.out.println("Enter Employeee Number");
							asetallocate.setEmpno(Integer.parseInt(validate.integerValidation((scn.next()))));
							System.out.println("Enter Allocation Date In The Form YYYY-MM-DD");
							asetallocate.setAllocationdate(validate.checkDate(scn.next()));
							System.out.println("Enter Release Date In The Form YYYY-MM-DD");
							asetallocate.setReleasedate(validate.checkDate(scn.next()));
							System.out.println("Enter Quantity");
							asetallocate.setQuantity(Integer.parseInt(validate.integerValidation((scn.next()))));
							Integer min=500;
							Integer max=2000;
							Integer random = (int) ((Math.random()*((max-min)+1))+min);
							asetallocate.setAllocationid(random);
							System.out.println("Raised allocation request :"+serve.serviceRaiseReq(asetallocate));
							System.out.println("Randomly Generated Allocation Id :"+asetallocate.getAllocationid());
							break;
							/**This case is used for viewing the status of raised request**/
						case 2:
							System.out.println("enter the allocation id");
							Integer identity=Integer.parseInt(validate.integerValidation((scn.next())));
							serve.viewStatusService(identity);
							break;
							/**This case is used for adding the details of newly joined employees**/
						case 3:
							System.out.println("Enter Employee Number");
							emp.setEmpno(Integer.parseInt(validate.integerValidation((scn.next()))));
							System.out.println("Employee Name");
							emp.setEname(validate.stringValidation(scn.next()));
							System.out.println("Employee Hiredate in the form YYYY-MM-DD");
							emp.setHiredate(validate.checkDate(scn.next()));
							System.out.println("Enter Job");
							emp.setJob(validate.stringValidation(scn.next()));
							System.out.println("Manager Number");
							emp.setMgrno(Integer.parseInt(validate.integerValidation((scn.next()))));
							System.out.println("Department ID");
							emp.setDeptid(Integer.parseInt(validate.integerValidation((scn.next()))));
							System.out.println("Added Employee :"+serve.addEmployee(emp));
							break;
							/**This case is used for getting all the raised request**/
						case 4:
							serve.getAllAssetAllocationService();
							break;
						case 5:
							/**This case helps to sign-out from the managers's page**/
							System.out.println("LoggedOut from Manager's page");
							break;
						case 6:
							/**This case helps to exit from the portal**/
							scn.close();
							System.out.println("Exited from the portal ");
							break jump;
						
						}

					}
				}
				else if(um.getUsertype().equalsIgnoreCase("admin"))
				{
					
					System.out.println("Welcome to Admin's page");
					System.out.println("-------------------------------");
					always:	while(true)
					{
						System.out.println("Enter your choice");
						System.out.println("1.Add the asset");
						System.out.println("2.Remove the asset");
						System.out.println("3. Update the  asset");
						System.out.println("4. View all asset");
						System.out.println("5. View all allocation request");
						System.out.println("6. Set the allocation status");
						System.out.println("7. SignOut from Admin's page");
						System.out.println("8:Exit from thte portal");
						Integer choice=(Integer.parseInt(validate.integerValidation((scn.next()))));
						switch(choice)
						{
						/**This case is used for adding the Asset**/
						case 1:
							Asset as=new Asset();
							System.out.println("Enter Asset id");
							as.setAssetid(Integer.parseInt(validate.integerValidation((scn.next()))));
							System.out.println("Asset name");
							as.setAssetname(validate.stringValidation(scn.next()));
							System.out.println("Asset des");
							as.setAssetdes(validate.stringValidation(scn.next()));
							System.out.println("Asset Quantity");
							as.setQuantity(Integer.parseInt(validate.integerValidation((scn.next()))));
							System.out.println("Status");
							as.setStatus(validate.stringValidation(scn.next()));
							System.out.println(serve.addAsset(as));
							break;
							/**This case is used for removing the asset**/
						case 2:
							System.out.println("enter the asset id you want to remove");
							serve.removeAsset(Integer.parseInt(validate.integerValidation((scn.next()))));
							break;
							/**This case is used for updating the asset**/
						case 3:
							Asset asu=new Asset();
							System.out.println("Enter asset you want to  Update");
							int a=Integer.parseInt(validate.integerValidation((scn.next())));
							if(asu!=null)
							{ 
								serve.updateAsset(a);
							}
							break;
							/**This case is used for viewing all the assets**/
						case 4:
							serve.getAllDetails();
							break;
							/**This case is used for viewing all the allocation request**/
						case 5:
							serve.getAllAssetAllocationService();
							break;
							/**This case is used for setting the allocation status**/
						case 6:
							System.out.println("enter allocation id to set status");
							Integer allocationid=Integer.parseInt(validate.integerValidation((scn.next())));
							serve.setStatusService(allocationid);
							break;
							/**This case is used for signing out from Admin's page**/
						case 7:
							System.out.println("Logged Out Sucessully");
							break always;
							/**This case is used to exit from the portal**/
						case 8:
							System.out.println("Exited from the portal");
							break jump;
						}
					}
				}
			}
			if(op==3)
			{
				System.out.println("Exited Sucessfully");
			}
			else
			{
				System.out.println("Enter valid Input");
			}
		}
	}
}
