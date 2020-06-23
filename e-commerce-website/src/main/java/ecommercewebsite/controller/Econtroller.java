package ecommercewebsite.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ecommercewebsite.Dao_Class_And_Interface.EDao;
import ecommercewebsite.Dao_Class_And_Interface.eCommerce_Interface;
import ecommercewebsite.Models.Admin_Model;
import ecommercewebsite.Models.Orders_Model;
import ecommercewebsite.Models.Product_Model;
import ecommercewebsite.Models.User_Model;

@Controller
public class Econtroller
{
	   static eCommerce_Interface e=new EDao();
	    public final String cloud="D://cloud";
    	@RequestMapping("/adminloginform")
    	public String adminLoginPage()
    	{
    		return "AdminLogin.jsp";
    	}
    	@RequestMapping("/addproductsform")
    	public String addProductsPage()
    	{
    		return "AddProducts.jsp";
    	}
    	@RequestMapping("/adminoptions")
    	public String adminWelcomePage()
    	{
    		return "AdminWelcomepage.jsp";
    	}
    	@RequestMapping("/searchproductspage")
    	public String SearchProductsPage()
    	{
    		return "SearchProducts.jsp";
    	}
    	@RequestMapping("/ViewAllProducts")
    	public ModelAndView viewAllProducts()
    	{
    		ModelAndView mav=new ModelAndView();
    		ArrayList<Product_Model> al=new ArrayList<Product_Model>();
    		al=e.viewAllProducts();
    		if(al!=null)
    		{
    			mav.addObject("listofproducts", al); 
    			mav.setViewName("AllInOne.jsp");
    			return mav;
    		}
    		else
    		{
    			mav.addObject("msg","Products Not Available");
    			mav.setViewName("AllInOne.jsp");
    			return mav;
    		}
    	}
    	@RequestMapping("/upadteform")
    	public ModelAndView updateForm(@ModelAttribute("product_model") Product_Model p)		
    	{
    		ModelAndView mav=new ModelAndView();
    		ArrayList<Product_Model> al=new ArrayList<Product_Model>();
    		al=e.getProductDetails(p);
    		if(p!=null)
    		{
    			mav.addObject("productdetails",al);
    			mav.setViewName("AllInOne.jsp");
    			return mav;
    		}
    		else
    		{
    			mav.addObject("msg","Product Not Available");
    			mav.setViewName("AllInOne.jsp");
    			return mav;
    		}
    	}
    	@RequestMapping("/ViewOrdersList")
    	public ModelAndView viewOrdersList()
    	{
    		ModelAndView mav=new ModelAndView();
    		ArrayList<Orders_Model> al=new ArrayList<Orders_Model>();
    		al=e.viewAllOrders();
    		if(al!=null)
    		{
    			mav.addObject("orderslist",al);
    			mav.setViewName("AllInOne.jsp");
    			return mav;
    		}
    		else
    		{
    			mav.addObject("msg","No Orders From Customers");
    			mav.setViewName("AllInOne.jsp");
    			return mav;
    		}
    	}
    	@RequestMapping("/getproducts")
    	public ModelAndView getProducts(@ModelAttribute("product_model") Product_Model p,HttpSession ses)
    	{
    		p.setProductName(p.getBrand());
    		ses.setAttribute("searchvalue",p.getProductName());
    		ArrayList<Product_Model> al=new ArrayList<Product_Model>();
    		al=e.getSearchResult(p);
    		if(al!=null)
    		{
    			File f=new File("D://cloud");
    			File arr[]=f.listFiles();
    			ModelAndView mav=new ModelAndView("SearchProducts.jsp");
    			mav.addObject("searchresult", al);
    			mav.addObject("productimages",arr);
    			mav.setViewName("SearchProducts.jsp");
    			return mav;
    		}
    		else
    		{
    			ModelAndView mav=new ModelAndView("SearchProducts.jsp");
    			mav.addObject("msg","NO Products Available");
    			mav.setViewName("SearchProducts.jsp");
    			return mav;
    		}
    	}
    	@RequestMapping("/sorting")
    	public ModelAndView sortingSearchResult(@RequestParam("value") String value,HttpSession ss)
    	{
    		Product_Model p=new Product_Model();
    		ModelAndView mav=new ModelAndView();
    		ArrayList<Product_Model> al=new ArrayList<Product_Model>();
    		p.setProductName(ss.getAttribute("searchvalue").toString());
    		p.setBrand((ss.getAttribute("searchvalue").toString()));
    		al=e.sortedSearchResult(p,value);
    		mav.addObject("searchresult", al);
    		if(al!=null)
    		{
    			File f=new File("D://cloud");
    			File arr[]=f.listFiles();
    			mav.addObject("productimages",arr);
    			mav.setViewName("SearchProducts.jsp");
    			return mav;
    		}
    		else
    		{
    			mav.addObject("msg","NO Products Available");
    			mav.setViewName("SearchProducts.jsp");
    			return mav;
    		}
    	}
    	@RequestMapping("/getproductdetailstoupdate")
    	public ModelAndView getProductDetailsToUpdate(@ModelAttribute("product_model") Product_Model p)
    	{
    		ModelAndView mav=new ModelAndView();
    		ArrayList<Product_Model> al=new ArrayList<Product_Model>();
            al=e.getProductDetails(p);
            if(al!=null)
            {
            	mav.addObject("productdetailstoupdate",al);
            	File f=new File("D://cloud");
    			File arr[]=f.listFiles();
    			mav.addObject("productimages",arr);
    			mav.setViewName("UpdateProduct.jsp");
    			return mav;
            }
            else
            {
            	mav.addObject("msg","Invalid Product");
            	mav.setViewName("UpdateProduct.jsp");
    			return mav;
            }
    	}
    	@RequestMapping("/AdminLogin")
    	public ModelAndView adminLogin(@ModelAttribute("admin_model") Admin_Model a,HttpSession ss)
    	{
    		ModelAndView mav=new ModelAndView();
    		boolean b=e.adminLogin(a);
    		if(b)
    		{
    			ss.setAttribute("login",a.getUsername());
    			mav.setViewName("AdminWelcomepage.jsp");
    			return mav;
    		}
    		else
    		{
    			mav.addObject("msg","Invalid Username/Password");
    			mav.setViewName("AdminLogin.jsp");
    			return mav;
    		}
    	}
    	@RequestMapping("/AdminForgetPassword")
    	public ModelAndView adminForgotPassword(@ModelAttribute("admin_model") Admin_Model a)
    	{
    		ModelAndView mav=new ModelAndView();
    		boolean b=e.changePassword(a);
    		if(b)
    		{
    			mav.addObject("msg","Password Has Been Changed click here to <a href=adminloginform>Login</a>");
    			mav.setViewName("AdminForgetPassword.jsp");
    			return mav;
    		}
    		else
    		{
    			mav.addObject("msg","Invalid Username.....Try Again With Correct Username");
    			mav.setViewName("AdminForgetPassword.jsp");
    			return mav;
    		}
    	}
    	@RequestMapping("/AddProductDetails")
    	public ModelAndView addProducts(HttpServletRequest req,HttpServletResponse res)
    	{
    		Product_Model p=new Product_Model();
    		ModelAndView mav=new ModelAndView();
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
    						item.write(new File(cloud+File.separator+p.getImage()));
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
    					mav.addObject("msg","Product Added Sucessfully Click Here To<a href=adminoptions>Go Back</a> <br> Or Add Another Product");
    					mav.setViewName("AddProducts.jsp");
    					return mav;
    				}
    				else
    				{
    					mav.addObject("msg","Adding Product Is Failed.....Try Again!");
    					mav.setViewName("AddProducts.jsp");
    					return mav;
    				}
    			}
    			catch (Exception e)
    			{
    				mav.addObject("error","Request is not document type");
    				mav.setViewName("AddProducts.jsp");
					return mav;
				}
    		}
    	}   	
    	@RequestMapping("/UpdateProductDetails")
    	public ModelAndView updateProductDetails(HttpServletRequest req,HttpServletResponse res)
    	{
    		Product_Model p=new Product_Model();
    		ModelAndView mav=new ModelAndView();
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
    						item.write(new File(cloud+File.separator+p.getImage()));
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
    				boolean b=e.updateProductDetails(p);
    				if(b)
    				{
    					mav.addObject("msg","Product Updated Sucessfully Click Here To<a href=adminoptions>Go Back</a>");
    					mav.setViewName("ViewAllProducts");
    					return mav;
    				}
    				else
    				{
    					mav.addObject("msg","Updating Product Details Failed.....Try Again!");
    					mav.setViewName("ViewAllProducts");
    					return mav;
    				}
    	        }
    	        catch (Exception e)
    	        {
    	        	mav.addObject("error","Request is not document type");
    	        	mav.setViewName("ViewAllProducts");
					return mav;
		        }
            }    		
    	}
    	@RequestMapping("/DeleteProduct")
    	public ModelAndView deleteProduct(@ModelAttribute("product_model") Product_Model p)
    	{
            ModelAndView mav=new ModelAndView();
    		boolean b=e.deleteProduct(p);
    		if(b)
    		{
    			mav.addObject("msg","Product Deleted");
    			mav.setViewName("AllInOne.jsp");
    			return mav;
    		}
    		else
    		{
    			mav.addObject("msg","Product Not Deleted");
    			mav.setViewName("AllInOne.jsp");
    			return mav;
    		}
    	}
    	@RequestMapping("/getproductdetails")
		public ModelAndView getProductDetails(@ModelAttribute("product_model") Product_Model p,HttpSession ss) 
		{
			ArrayList<Product_Model> al=new ArrayList<Product_Model>();
			ModelAndView mav=new ModelAndView();
			al=e.getProductDetails(p);
			if(al!=null)
			{
				if(ss.getAttribute("login")!=null)
				{
					mav.addObject("productdetails",al); 
				    File f=new File("D://cloud");
    			    File arr[]=f.listFiles();
    			    mav.addObject("productimage",arr);
    			    mav.setViewName("viewproduct.jsp");
				    return mav;
				}
				else
				{
					mav.addObject("msg","Login To Check Product");
					mav.setViewName("UserAccount.jsp");
					return mav;
				}
			}
			else
			{
				mav.addObject("msg","Try Again");
				mav.setViewName("viewproduct.jsp");
			    return mav;
			}
		}
    	@RequestMapping(value="/useraccount",method = RequestMethod.POST)
    	public ModelAndView userSignInSignUpResetPassword(HttpServletRequest req,HttpServletResponse res,HttpSession ss)
    	{
        	User_Model u=new User_Model();
    		ModelAndView mav=new ModelAndView();
    		if(req.getParameter("rg").equals("signin"))
    		{
    			u.setUsername(req.getParameter("username"));
    			u.setPassword(req.getParameter("password"));
    			boolean b=e.userLogin(u);
    			if(b)
    			{
    				ss.setAttribute("login",u.getUsername());
    				mav.setViewName("index.jsp");
    				return mav;
    			}
    			else
    			{
    				req.setAttribute("msg","Invalid Email/Password");
    				mav.setViewName("UserAccount.jsp");
    				return mav;
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
    				   mav.addObject("msg","Login With Your Registered Details");
    				   mav.setViewName("UserAccount.jsp");
       				   return mav;
    			   }
    			   else
    			   { 
    				   mav.addObject("msg","Enter Proper Details");
    				   mav.setViewName("UserAccount.jsp");
       				   return mav;
    			   }
    		}
    		else if(req.getParameter("rg").equals("reset"))
    		{
    			u.setUsername(req.getParameter("username"));
    			u.setPassword(req.getParameter("password"));
    			boolean b=e.userResetPassword(u);
    			if(b)
    			{
    				mav.addObject("msg","Password Has Been Changed");
    				mav.setViewName("UserAccount.jsp");
    				return mav;
    			}
    			else
    			{
    				mav.addObject("msg","Invalid Email");
    				mav.setViewName("UserAccount.jsp");
    				return mav;
    			}
    		}
			return mav;
    }
}
