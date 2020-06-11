package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import Dao_Class_And_Interface.EDao;
import Models.Admin_Model;
import Models.Product_Model;

@WebServlet(urlPatterns = {"/","/Adminlogin","/adminloginform","/AdminForgetPassword","/addproductsform","/AddProducts","/adminoptions"})
public class Econtroller extends HttpServlet
{
	EDao e;
	public final String siteImages="D://SiteImages";
	public void init() throws ServletException
	{
		super.init();
		e=new EDao();
	}
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
    {
    	String path=req.getServletPath();
    	if(path.equals("/"))
    	{
    		RequestDispatcher rd=req.getRequestDispatcher("index.jsp");
    		rd.forward(req, res);
    	}
    	else if(path.equals("/adminloginform"))
    	{
    		RequestDispatcher rd=req.getRequestDispatcher("AdminLogin.jsp");
    		rd.forward(req, res);
    	}
    	else if(path.equals("/addproductsform"))
    	{
    		RequestDispatcher rd=req.getRequestDispatcher("AddProducts.jsp");
    		rd.forward(req, res);
    	}
    	else if(path.equals("/adminoptions"))
    	{
    		RequestDispatcher rd=req.getRequestDispatcher("AdminOptions.jsp");
    		rd.forward(req, res);
    	}
    }
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
    {
    	String path=req.getServletPath();
    	Admin_Model a=new Admin_Model();
    	Product_Model p=new Product_Model();
    	if(path.equals("/AdminLogin"))
    	{
    		a.setUsername(req.getParameter("t1"));
    		a.setPassword(req.getParameter("t2"));
    		boolean b=e.adminLogin(a);
    		if(b)
    		{
    			RequestDispatcher rd=req.getRequestDispatcher("AdminOptions.jsp");
    			rd.forward(req, res);
    		}
    		else
    		{
    			req.setAttribute("msg","Invalid Username/Password");
    			RequestDispatcher rd=req.getRequestDispatcher("AdminLogin.jsp");
    			rd.forward(req, res);
    		}
    	}
    	else if(path.equals("/AdminForgetPassword"))
    	{
    		a.setUsername(req.getParameter("t1"));
    		a.setUsername(req.getParameter("t2"));
    		boolean b=e.changePassword(a);
    		if(b)
    		{
    			req.setAttribute("msg","Password Has Been Changed click here to <a href=adminloginform>Login</a>");
    			RequestDispatcher rd=req.getRequestDispatcher("AdminForgetPassword.jsp");
    			rd.forward(req, res);
    		}
    		else
    		{
    			req.setAttribute("msg","Invalid Username.....Try Again With Correct Username");
    			RequestDispatcher rd=req.getRequestDispatcher("AdminForgetPassword.jsp");
    			rd.forward(req, res);
    		}
    	}
    	else if(path.equals("/AddProducts"))
    	{
    		if(ServletFileUpload.isMultipartContent(req));
    		{
    			try
    			{
    				List<FileItem> multiparts=new ServletFileUpload(new DiskFileItemFactory()).parseRequest(req);
    				for(FileItem item:multiparts)
    				{
    					if(!item.isFormField())
    					{
    						p.setImage(new File(item.getName()).getName());
    						item.write(new File(siteImages+File.pathSeparator+p.getImage()));
    					}
    					else
    					{
    						if(item.getFieldName().equals("pid"))
    						{
    							p.setPid(Integer.parseInt(item.getString()));
    						}
    						if(item.getFieldName().equals("pname"))
    						{
    							p.setProductName(item.getString());
    						}
    						if(item.getFieldName().equals("catagory"))
    						{
    							p.setCatagory(item.getString());
    						}
    						if(item.getFieldName().equals("brand"))
    						{
    							p.setBrand(item.getString());
    						}
    						if(item.getFieldName().equals("stock"))
    						{
    							p.setStock(Integer.parseInt(item.getString()));
    						}
    						if(item.getFieldName().equals("sold"))
    						{
    							p.setSold(Integer.parseInt(item.getString()));
    						}
    						if(item.getFieldName().equals("price"))
    						{
    							p.setPrice(Integer.parseInt(item.getString()));
    						}
    						if(item.getFieldName().equals("info"))
    						{
    							p.setInfo(item.getString());
    						}
    					}
    				}
    				boolean b=e.addProducts(p);
    				if(b)
    				{
    					req.setAttribute("msg","Product Added Sucessfully Click Here To<a href=adminoptions>Go Back</a> <br> Or Add Another Product");
    					RequestDispatcher rd=req.getRequestDispatcher("addproductsform");
    					rd.forward(req, res);
    				}
    				else
    				{
    					req.setAttribute("msg","Adding Product Is Failed.....Try Again!");
    					RequestDispatcher rd=req.getRequestDispatcher("addproductsform");
    					rd.forward(req, res);
    				}
    			}
    			catch (Exception e)
    			{
					req.setAttribute("error","Request is not document type");
				}
    		}
    	}
    }
}
