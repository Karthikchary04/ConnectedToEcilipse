package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import Dao_Class_And_Interface.EDao;
import Models.Product_Model;
import Models.User_Model;


@WebServlet(urlPatterns = {"/useraccount","/getproductdetails"})
public class User_Controller extends HttpServlet
{
	EDao e;
	public final String cloud="D://cloud";
	public void init() throws ServletException
	{
		super.init();
		e=new EDao();
	}
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		String path=req.getServletPath();
		Product_Model p=new Product_Model();
		if(path.equals("/getproductdetails"))
		{
			p.setPid(Integer.parseInt(req.getParameter("pid")));
			ArrayList<Product_Model> al=new ArrayList<Product_Model>();
			al=e.getProductDetails(p);
			req.setAttribute("productdetails",al);
			if(p!=null)
			{
				File f=new File("D://cloud");
    			File arr[]=f.listFiles();
				req.setAttribute("productimage",arr);
				RequestDispatcher rd=req.getRequestDispatcher("viewproduct.jsp");
				rd.forward(req, res);
			}
			else
			{
				req.setAttribute("msg","Try Again");
				RequestDispatcher rd=req.getRequestDispatcher("viewproduct.jsp");
				rd.forward(req, res);
			}
		}
	}
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
    {
    	String path=req.getServletPath();
    	User_Model u=new User_Model();
    	if(path.equals("/useraccount"))
    	{
    		if(req.getParameter("rg").equals("signin"))
    		{
    			u.setUsername(req.getParameter("username"));
    			u.setPassword(req.getParameter("password"));
    			boolean b=e.userLogin(u);
    			if(b)
    			{
    				HttpSession ss=req.getSession();
    				ss.setAttribute("login",true);
    				RequestDispatcher rd=req.getRequestDispatcher("index.html");
    				rd.forward(req, res);
    			}
    			else
    			{
    				req.setAttribute("msg","Invalid Email/Password");
    				RequestDispatcher rd=req.getRequestDispatcher("UserAccount.jsp");
    				rd.include(req, res);
    			}
    		}	
    		else if(req.getParameter("rg").equals("signup"))
    		{
    			   u.setFullname(req.getParameter("name"));
    			   u.setDob(req.getParameter("dob"));
    			   u.setGender(req.getParameter("gender"));
    			   u.setMobile(Long.parseLong(req.getParameter("mobile")));
    			   u.setEmail(req.getParameter("email"));
    			   u.setUsername(req.getParameter("username"));
    			   u.setPassword(req.getParameter("password"));
       			   boolean b=e.userRegister(u);
    			   if(b)
    			   {
    				   req.setAttribute("msg","Login With Your Registered Details");
    				   RequestDispatcher rd=req.getRequestDispatcher("UserAccount.jsp");
    				   rd.include(req, res);
    			   }
    			   else
    			   { 
    				   req.setAttribute("msg","Enter Proper Details");
    				   RequestDispatcher rd=req.getRequestDispatcher("UserAccount.jsp");
    				   rd.include(req, res);
    			   }
    		}
    		else if(req.getParameter("rg").equals("reset"))
    		{
    			u.setUsername(req.getParameter("username"));
    			u.setPassword(req.getParameter("password"));
    			boolean b=e.userResetPassword(u);
    			if(b)
    			{
    				req.setAttribute("msg","Password Has Been Changed");
    				RequestDispatcher rd=req.getRequestDispatcher("UserAccount.jsp");
    				rd.include(req, res);
    			}
    			else
    			{
    				req.setAttribute("msg","Invalid Email");
    				RequestDispatcher rd=req.getRequestDispatcher("UserAccount.jsp");
    				rd.include(req, res);
    			}
    		}
    	}
    }
}
