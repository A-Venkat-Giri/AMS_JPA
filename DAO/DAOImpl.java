package com.dev.dao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder.In;

import com.dev.beans.Asset;
import com.dev.beans.AssetAllocation;
import com.dev.beans.AssetStatus;
import com.dev.beans.Employee;
import com.dev.beans.UserMaster;
import com.dev.exceptions.EmployeeException;
import com.dev.exceptions.InvalidDepartmentException;
import com.dev.exceptions.LoginException;
import com.dev.exceptions.RemoveAssetException;
import com.dev.exceptions.SetStatusExcption;
import com.dev.exceptions.StatusExcpetion;
import com.dev.exceptions.UpdateAssetException;
import com.mysql.jdbc.Driver;
//import com.tyss.dto.Student;
//import com.tyss.dto.Student;
//import com.tyss.dto.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DAOImpl implements DAO 
{
	EntityManagerFactory entityManagerFactory=null;
	EntityManager entityManager=null;
	EntityTransaction entityTransaction=null;
	Scanner sc=new Scanner(System.in);
	Asset asset=new Asset();
	UserMaster um=new  UserMaster();
	EmployeeException employeeException=new EmployeeException();
	StatusExcpetion statusExcpetion=new StatusExcpetion();
	LoginException loginException=new LoginException();
	InvalidDepartmentException invalidDepartmentException=new InvalidDepartmentException();
	RemoveAssetException removeAssetException=new RemoveAssetException();
	SetStatusExcption statusExcption=new SetStatusExcption();
	UpdateAssetException updateAssetException=new UpdateAssetException();

	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	Integer result=null;
/**This function is used for login purpose**/
	@Override
	public UserMaster login(Integer userid, String password) {

		try 
		{
  /**EntityManagerFactory is used to access the database in a particular application
   * and it is used to manage persistent entuty instances**/
			entityManagerFactory=Persistence.createEntityManagerFactory("AssetManagementJPA");
			entityManager=entityManagerFactory.createEntityManager();
			String jpql="select usertype from UserMaster where userid=:uid and userpassword=:upwd";
			Query query=entityManager.createQuery(jpql);
			query.setParameter("uid", userid);
			query.setParameter("upwd",password);
			List<String> list=query.getResultList();
			for (String stud : list) 
			{

				System.out.println(stud);
				um.setUsertype(stud);

			}
		}
		catch (Exception e) 
		{

			e.printStackTrace();
		}
		entityManager.close();
		return um;
	}

	/**This function is used for raising the request**/
	@Override
	public AssetAllocation raiseRequest(AssetAllocation asetallocate) 
	{
		try 
		{
			entityManagerFactory=Persistence.createEntityManagerFactory("AssetManagementJPA");
			entityManager=entityManagerFactory.createEntityManager();
			entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();

			entityManager.persist(asetallocate);
			entityTransaction.commit();

		}

		catch (Exception e) 
		{
			e.printStackTrace();
		}
		entityManager.close();
		return asetallocate;
	}

	/**This function is used for adding the employee**/
	@Override
	public Employee addEmployee(Employee emp) 
	{
		try 
		{
			entityManagerFactory=Persistence.createEntityManagerFactory("AssetManagementJPA");
			entityManager=entityManagerFactory.createEntityManager();
			
			String q="select deptid from Department ";
			
			Query query=entityManager.createQuery(q);
			List<Integer> list=query.getResultList();
			Integer f=0;
			for (Integer stud : list) 
			{

				if(emp.getDeptid()==stud)
				{
					f=1;
				}
			}
			if(f!=1)
			{
				System.out.println("Inavalid Dept id");
				throw invalidDepartmentException;
			}
			
			entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();

			entityManager.persist(emp);
			entityTransaction.commit();

		}
			
		catch (Exception e) 
		{

			e.printStackTrace();
		}
		return emp;
	}


	/**This function is used for adding the asset**/
	@Override
	public Asset addAsset(Asset asset) 
	{
		try {

			entityManagerFactory=Persistence.createEntityManagerFactory("AssetManagementJPA");
			entityManager=entityManagerFactory.createEntityManager();
			entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();

			entityManager.persist(asset);
			entityTransaction.commit();

		}
		catch (Exception e) 
		{

			e.printStackTrace();
		}
		return asset;
	}



	/**This function is used for removing the asset**/
	@Override
	public Asset removeAsset(int r) 
	{

		try
		{
			entityManagerFactory=Persistence.createEntityManagerFactory("AssetManagementJPA");
			entityManager=entityManagerFactory.createEntityManager();
			entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
            String jpql="Delete from Asset where assetid=:asi";
            
            Query query=entityManager.createQuery(jpql);
            query.setParameter("asi", r);
            Integer i=query.executeUpdate();
			entityTransaction.commit();

		}
			
			
		catch (Exception e) 
		{

			e.printStackTrace();
		}
		return null;
	}
	/**This function is used for viewing all the assets**/
	@Override
	public void viewStatus(Integer id1)
	{
		try 
		{
			entityManagerFactory=Persistence.createEntityManagerFactory("AssetManagementJPA");
			entityManager=entityManagerFactory.createEntityManager();
			String jpql="from AssetStatus where allocationid=:aid";
			Query query=entityManager.createQuery(jpql);
			query.setParameter("aid", id1);
			List<AssetStatus> list=query.getResultList();
			for (AssetStatus stud : list) 
			{
				System.out.println(stud.getAllocationid());
				if(stud.getStatus()==null)
				{
					System.out.println("Status not updated till now");
				}
				else
				{
					System.out.println("status: "+stud.getStatus());
				}
			}
		}
			
	
		catch (Exception e) 
		{

			e.printStackTrace();
		}
		finally 
		{
			if(conn!= null)
			{
				try 
				{
					conn.close();
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			if(pstmt!=null)
			{
				try
				{
					pstmt.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}                                                                                   

	}
	/**This function is used for updating the asset**/
	@Override
	public Asset updateAsset(int a) 
	{
		Asset asset=new Asset();
		int option=0;
		System.out.println("Press 1:To update asset name");
		System.out.println("Press 2:To update asset description");
		System.out.println("Press 3:To update Asset quantity");
		System.out.println("Press 4:To update Asset Status");
		option=sc.nextInt();
		switch(option)
		{
		
		/**This case is used for updating the asset name**/
			case 1:
			try 
			{
				
				
				System.out.println("Enter new Asset Name");
				String aname=sc.next();
				entityManagerFactory=Persistence.createEntityManagerFactory("AssetManagementJPA");
				entityManager=entityManagerFactory.createEntityManager();
				entityTransaction=entityManager.getTransaction();
				entityTransaction.begin();
				String jpql="UPDATE Asset SET assetname=:asname WHERE assetid=:aid";
				
				Query query=entityManager.createQuery(jpql);
				query.setParameter("asname", aname);
				query.setParameter("aid",a);
                Integer i= query.executeUpdate();
                System.out.println("update");
               
				entityTransaction.commit();
				 System.out.println("Query issued");
				if(i>0)
				{
					System.out.println("done");
				}
				else
				{
					System.out.println("not updated");
				}
			}
			catch (Exception e) 
			{

				e.printStackTrace();
			}
			break;
			
			/**This case is used for updating the asset description**/
			case 2:
			try 
			{
				System.out.println("Enter new Asset Description");
				String asdes=sc.next();
			
				entityManagerFactory=Persistence.createEntityManagerFactory("AssetManagementJPA");
				entityManager=entityManagerFactory.createEntityManager();
				entityTransaction=entityManager.getTransaction();
				entityTransaction.begin();
				String jpql="UPDATE Asset SET assetdes=:asname WHERE assetid=:aid";
				
				Query query=entityManager.createQuery(jpql);
				query.setParameter("asname", asdes);
				query.setParameter("aid",a);
                Integer i= query.executeUpdate();
                System.out.println("update");
               
				entityTransaction.commit();
				 System.out.println("Query issued");
				if(i>0)
				{
					System.out.println("done");
				}
				else
				{
					System.out.println("not updated");
				}				
							
			}
			catch (Exception e) 
			{

				e.printStackTrace();
			}
			break;
			/**This case is used for updating the asset quantity**/
			case 3:
			try 
			{
				System.out.println("Enter new Asset Quantity");
				Integer asq=sc.nextInt();
				
				entityManagerFactory=Persistence.createEntityManagerFactory("AssetManagementJPA");
				entityManager=entityManagerFactory.createEntityManager();
				entityTransaction=entityManager.getTransaction();
				entityTransaction.begin();
				String jpql="UPDATE Asset SET quantity=:asname WHERE assetid=:aid";
				
				Query query=entityManager.createQuery(jpql);
				query.setParameter("asname", asq);
				query.setParameter("aid",a);
                Integer i= query.executeUpdate();
                System.out.println("update");
               
				entityTransaction.commit();
				 System.out.println("Query issued");
				if(i>0)
				{
					System.out.println("done");
				}
				else
				{
					System.out.println("not updated");
				}
			}

			catch (Exception e) 
			{

				e.printStackTrace();
			}
			break;
			/**This case is used for updating the asset status**/
			case 4:
			try 
			{
				System.out.println("Enter new Asset AssetStatus");
				String asst=sc.next();
				entityManagerFactory=Persistence.createEntityManagerFactory("AssetManagementJPA");
				entityManager=entityManagerFactory.createEntityManager();
				entityTransaction=entityManager.getTransaction();
				entityTransaction.begin();
				String jpql="UPDATE Asset SET status=:asname WHERE assetid=:aid";
				
				Query query=entityManager.createQuery(jpql);
				query.setParameter("asname", asst);
				query.setParameter("aid",a);
                Integer i= query.executeUpdate();
                System.out.println("update");
               
				entityTransaction.commit();
				 System.out.println("Query issued");
				if(i>0)
				{
					System.out.println("Updated Successfully");
				}
				else
				{
					System.out.println("Not updated properly");
				}
				
			}

			catch (Exception e) 
			{

				e.printStackTrace();
			}
			break;
		default:
			System.out.println("Choose the correct option");

		}
		return asset;

	}

	/**This function is used for getting all the asset details**/
	@Override
	public void getAllDetails()
	{
		try 
		{
			entityManagerFactory=Persistence.createEntityManagerFactory("AssetManagementJPA");
			entityManager=entityManagerFactory.createEntityManager();
			String jpql="from Asset";
			Query query=entityManager.createQuery(jpql);
			List<Asset> list=query.getResultList();
			/**for (Asset stud : list) 
			{
				System.out.println("Asset Id:"+stud.getAssetid());                                                                              
				System.out.println("Asset Name:"+stud.getAssetname());
				System.out.println("Asset Description:"+stud.getAssetdes());
				System.out.println("Asset Quantity:"+stud.getQuantity());
				System.out.println("Asset Status:"+stud.getStatus());
				System.out.println("*********************");

			}**/
			}
		catch (Exception e) 
		{

			e.printStackTrace();
		}
		finally 
		{
			if(conn!= null)
			{
				try 
				{
					conn.close();
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			if(pstmt!=null)
			{
				try 
				{
					pstmt.close();
				}
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}                                                                                   


	}


	/**This function is used for getting all the asset allocation**/
	@Override
	public void getAllAssetAllocation()
	{
		try
		{
			entityManagerFactory=Persistence.createEntityManagerFactory("AssetManagementJPA");
			entityManager=entityManagerFactory.createEntityManager();
			String jpql="from AssetAllocation";
			Query query=entityManager.createQuery(jpql);
			List<AssetAllocation> list=query.getResultList();
			/**for (AssetAllocation stud : list) 
			{
				System.out.println("Allocation Id:"+stud.getAllocationid());                                                                              
				System.out.println("Asset id:"+stud.getAssetid());
				System.out.println("Employee Number:"+stud.getEmpno());
				System.out.println("Allocation Date:"+stud.getAllocationdate());
				System.out.println("Release Date:"+stud.getReleasedate());
				System.out.println("*********************");

			}**/
		}
		catch (Exception e) 
		{

			e.printStackTrace();
		}
		finally 
		{
			if(conn!= null)
			{
				try 
				{
					conn.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
			if(pstmt!=null)
			{
				try 
				{
					pstmt.close();
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}                                                                                   

	}
	/**This function is used for setting the status**/
	@Override
	public void setStatus(Integer allocationid) 
	{
		try 
		{  
			System.out.println("Enter The Status");
			String a=sc.next();
			entityManagerFactory=Persistence.createEntityManagerFactory("AssetManagementJPA");
			entityManager=entityManagerFactory.createEntityManager();
			entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			String jpql="UPDATE AssetStatus SET status=:asname WHERE allocationid=:aid";
			
			Query query=entityManager.createQuery(jpql);
			query.setParameter("asname", a);
			query.setParameter("aid",allocationid);
            Integer i= query.executeUpdate();
            System.out.println("update");
           
			entityTransaction.commit();
			 System.out.println("Query issued");
			if(i>0)
			{
				System.out.println("Updated Successfully");
			}
			else
			{
				System.out.println("Not updated");
			}
		}
		catch (Exception e) 
		{

			e.printStackTrace();
		}

	}

}





