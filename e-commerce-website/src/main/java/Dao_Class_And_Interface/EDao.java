package Dao_Class_And_Interface;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Models.Admin_Model;
import Models.Orders_Model;
import Models.Product_Model;
import Models.User_Model;

public class EDao implements eCommerce_Interface
{

	SessionFactory sf=null;
	public EDao()
	{
		Configuration cfg=new Configuration().configure().addAnnotatedClass(Admin_Model.class);
		sf=cfg.buildSessionFactory();
	}
	//Administrator Related Methods
	public boolean adminLogin(Admin_Model a)
	{
		boolean b=false;
		Session s=sf.openSession();
		ArrayList<Admin_Model> al=(ArrayList<Admin_Model>) s.createQuery("from Admin_Model where username='"+a.getUsername()+"' and password='"+a.getPassword()+"'").list();
		for(Admin_Model am:al)
		{
			b=true;
		}
		s.close();
		return b;
	}
	public boolean changePassword(Admin_Model a) 
	{
		boolean b=false;
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		s.update(a);
		t.commit();
		b=true;
		s.close();
		return b;
	}
	public boolean addProducts(Product_Model p) 
	{
		boolean b=false;
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		Object obj=s.save(p);
		t.commit();
		if(obj!=null)
		{
			b=true;
		}
		s.close();
		return b;
	}
	public ArrayList<Product_Model> viewAllProducts() 
	{
		ArrayList<Product_Model> al=new ArrayList<Product_Model>();
		Session s=sf.openSession();
		al=(ArrayList<Product_Model>) s.createQuery("from Product_Model").list();
		s.close();
		return al;
	}
	public ArrayList<Product_Model> getProductDetails(Product_Model p) 
	{
		Session s=sf.openSession();
		ArrayList<Product_Model> al=new ArrayList<Product_Model>();
		p=(Product_Model) s.get(Product_Model.class,p.getPid());
		al.add(p);
		s.close();
		return al;
	}
	public boolean updateProductDetails(Product_Model p)
	{
		boolean b=false;
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		s.update(p);
		t.commit();
		b=true;
		s.close();
		return b;
	}
	public boolean deleteProduct(Product_Model p)
	{
		boolean b=false;
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		s.delete(p);
		t.commit();
		b=true;
		s.close();
		return b;
	}
	public ArrayList<Orders_Model> viewAllOrders()
	{
		ArrayList<Orders_Model> al=new ArrayList<Orders_Model>();
		Session s=sf.openSession();
		al=(ArrayList<Orders_Model>) s.createQuery("from Orders_Model").list();
		return al;
	}
	public ArrayList<Product_Model> getSearchResult(Product_Model p)
	{
		ArrayList<Product_Model> al=new ArrayList<Product_Model>();
		Session s=sf.openSession();
		al=(ArrayList<Product_Model>) s.createQuery("from Product_Model where productName like '%"+p.getProductName()+"%' or brand like '%"+p.getBrand()+"%'").list();
		s.close();
		return al;
	}
	
	
	//User Related Methods
	public boolean userLogin(User_Model u) 
	{
		boolean b=false;
		Session s=sf.openSession();
		u=(User_Model) s.get(User_Model.class,u.getUsername());
		if(u!=null)
		{
			b=true;
		}
		s.close();
		return b;
	}
	public boolean userRegister(User_Model u) 
	{
		boolean b=false;
		Session s=sf.openSession();
		Transaction t=s.beginTransaction();
		Object obj=s.save(u);
		t.commit();
		if(obj!=null)
		{
			b=true;
		}
		s.close();
		return b;
	}
	public boolean userResetPassword(User_Model u) 
	{
		boolean b=false;
		Session s=sf.openSession();
		User_Model u1=new User_Model();
		u1=(User_Model) s.get(User_Model.class,u.getUsername());
		u1.setPassword(u.getPassword());
		s.close();
		if(u1!=null)
		{
			Session ss=sf.openSession();
			Transaction t=ss.beginTransaction();
			ss.update(u1);
			t.commit();
			b=true;
			ss.close();
		}
		return b;
	}
	public ArrayList<Product_Model> sortedSearchResult(Product_Model p, String sortingType) 
	{
		ArrayList<Product_Model> al=new ArrayList<Product_Model>();
		Session s=sf.openSession();
		if(sortingType.equals("lowtohigh"))
		{
		   al=(ArrayList<Product_Model>) s.createQuery("from Product_Model where productName like '%"+p.getProductName()+"%' or brand like '%"+p.getBrand()+"%' order by price").list();
		}
		else
		{
		   al=(ArrayList<Product_Model>) s.createQuery("from Product_Model where productName like '%"+p.getProductName()+"%' or brand like '%"+p.getBrand()+"%' order by price desc").list();
		}
		return al;
	}

}
