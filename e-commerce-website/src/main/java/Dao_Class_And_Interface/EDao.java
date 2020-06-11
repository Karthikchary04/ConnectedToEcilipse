package Dao_Class_And_Interface;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Models.Admin_Model;
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

}