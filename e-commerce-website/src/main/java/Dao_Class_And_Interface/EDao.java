package Dao_Class_And_Interface;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Models.Admin_Model;
import Models.Orders_Model;
import Models.Product_Model;

public class EDao implements eCommerce_Interface
{

	SessionFactory sf=null;
	public EDao()
	{
		Configuration cfg=new Configuration().configure().addAnnotatedClass(Admin_Model.class);
		sf=cfg.buildSessionFactory();
	}
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
	public Product_Model getProductDetails(Product_Model p) 
	{
		Session s=sf.openSession();
		p=(Product_Model) s.get(Product_Model.class,p.getPid());
		return p;
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

}
