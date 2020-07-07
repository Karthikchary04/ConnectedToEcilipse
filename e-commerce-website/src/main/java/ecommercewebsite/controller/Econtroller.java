package ecommercewebsite.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ecommercewebsite.Dao_Class_And_Interface.EDao;
import ecommercewebsite.Dao_Class_And_Interface.eCommerce_Interface;
import ecommercewebsite.Models.Admin_Model;
import ecommercewebsite.Models.Catagory_Model;
import ecommercewebsite.Models.Filter_Model;
import ecommercewebsite.Models.Orders_Model;
import ecommercewebsite.Models.Product_Model;
import ecommercewebsite.Models.User_Model;

@Controller
public class Econtroller
{
	    static eCommerce_Interface e=new EDao();
	    public static String cloud="C:\\Users\\KARTHIK\\git\\ConnectedToEcilipse\\e-commerce-website\\src\\main\\webapp\\webcollection\\cloud";
	    @RequestMapping("/")   
	    public ModelAndView homePage()
	    {
	    	ModelAndView mav=new ModelAndView("index");
	    	mav.addObject("msg","signin");
	    	return mav;
	    }
	    @RequestMapping("/signout")
	    public ModelAndView signOut(HttpSession ss)
	    {
	    	ModelAndView mav=new ModelAndView("index");
	    	mav.addObject("msg","signin");
	    	ss.invalidate();
	    	return mav;
	    }
	    @RequestMapping("/loginforms")
	    public String loginForms()
	    {
	    	return "loginforms";
	    }
    	@RequestMapping("/adminloginform")
    	public ModelAndView adminLoginPage()
    	{
    		ModelAndView mav=new ModelAndView("UserAccount");
    		mav.addObject("login", "adminlogin");
    		return mav;
    	}
    	@RequestMapping("/addproductsform")
    	public ModelAndView addProductsPage()
    	{
    		ModelAndView mav=null;
    		ArrayList<Catagory_Model> al=new ArrayList<Catagory_Model>();
    		al=e.getAllCatagories();
    		if(al!=null)
    		{
    			mav=new ModelAndView("AdminWelcomepage");
    			mav.addObject("catagories",al);
        		mav.addObject("type", "addproducts");
        		return mav;
    		}
			return mav;
    	}
    	@RequestMapping("/adminoptions")
    	public String adminWelcomePage()
    	{
    		return "AdminWelcomepage";
    	}
    	@RequestMapping("/searchproductspage")
    	public String SearchProducts()
    	{
    		return "SearchProducts";
    	}
    	@RequestMapping("addcatagoryform")
    	public ModelAndView addCatagoryForm()
    	{
    		ModelAndView mav=new ModelAndView("AdminWelcomepage");
    		mav.addObject("type", "addcatagory");
    		return mav;
    	}
    	@RequestMapping("userloginpage")
    	public ModelAndView userLoginPage()
    	{
    		ModelAndView mav=new ModelAndView("UserAccount");
    		mav.addObject("login", "customerlogin");
    		return mav;
    	}
    	@RequestMapping("viewproductsbyfilterpage")
    	public String viewProductsByFilterPage()
    	{
    		return "ViewProductsByFilter";
    	}
    	@RequestMapping("AddCatagory")
    	public ModelAndView addCatagory(@ModelAttribute("catagory_model") Catagory_Model c)
    	{
    		ModelAndView mav=new ModelAndView();
    		boolean b=e.addCatagory(c);
    		if(b)
    		{
    			mav.addObject("msg","Catagory Added");
    			mav.setViewName("AdminWelcomepage");
    			return mav;
    		}
    		else
    		{
    			mav.addObject("msg","Adding Catagory Failed");
    			mav.setViewName("AdminWelcomepage");
    			return mav;
    		}
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
    			mav.setViewName("AllInOne");
    			return mav;
    		}
    		else
    		{
    			mav.addObject("msg","Products Not Available");
    			mav.setViewName("AllInOne");
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
    			mav.setViewName("AllInOne");
    			return mav;
    		}
    		else
    		{
    			mav.addObject("msg","Product Not Available");
    			mav.setViewName("AllInOne");
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
    			mav.setViewName("AllInOne");
    			return mav;
    		}
    		else
    		{
    			mav.addObject("msg","No Orders From Customers");
    			mav.setViewName("AllInOne");
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
    			File f=new File(cloud);
    			File arr[]=f.listFiles();
    			ModelAndView mav=new ModelAndView("SearchProducts");
    			mav.addObject("productdetails", al);
    			mav.addObject("productimages",arr);
    			mav.addObject("folderpath", cloud);
    			return mav;
    		}
    		else
    		{
    			ModelAndView mav=new ModelAndView("SearchProducts");
    			mav.addObject("msg","NO Products Available");
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
    		mav.addObject("productdetails", al);
    		if(al!=null)
    		{
    			File f=new File(cloud);
    			File arr[]=f.listFiles();
    			mav.addObject("folderpath", cloud);
    			mav.addObject("productimages",arr);
    			mav.setViewName("SearchProducts");
    			return mav;
    		}
    		else
    		{
    			mav.addObject("msg","NO Products Available");
    			mav.setViewName("SearchProducts");
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
            	File f=new File(cloud);
    			File arr[]=f.listFiles();
    			mav.addObject("folderpath", cloud);
    			mav.addObject("productimages",arr);
    			mav.setViewName("UpdateProduct");
    			return mav;
            }
            else
            {
            	mav.addObject("msg","Invalid Product");
            	mav.setViewName("UpdateProduct");
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
    			ss.setAttribute("login","adminlogin");
    			mav.setViewName("AdminWelcomepage");
    			return mav;
    		}
    		else
    		{
    			mav.addObject("msg","Invalid Username/Password");
    			mav.setViewName("AdminLogin");
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
    			mav.setViewName("AdminForgetPassword");
    			return mav;
    		}
    		else
    		{
    			mav.addObject("msg","Invalid Username.....Try Again With Correct Username");
    			mav.setViewName("AdminForgetPassword");
    			return mav;
    		}
    	}
    	@RequestMapping(value= {"/AddProductDetails"},method=RequestMethod.POST)
    	public ModelAndView addProducts(HttpServletRequest req)
    	{
    		Product_Model p=new Product_Model();
    		ModelAndView mav=new ModelAndView();
    		if(ServletFileUpload.isMultipartContent(req))
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
    						if(item.getFieldName().equals("productname")) 
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
    				boolean b=e.addProducts(p);
    				if(b)
    				{
    					mav.addObject("msg","Product Added Sucessfully");
    					mav.setViewName("AdminWelcomepage");
    					return mav;
    				}
    				else
    				{
    					mav.addObject("msg","Adding Product Is Failed.....Try Again!");
    					mav.setViewName("AdminWelcomepage");
    					return mav;
    				}
    			}
    			catch (Exception e)
    			{
    				mav.addObject("msg","Request is not multipart type");
    				mav.setViewName("AdminWelcomepage");
					return mav;
				}
    		}
			return mav;
    	}
    	@RequestMapping(value= {"/updateproductdetails"},method = RequestMethod.POST)
    	public ModelAndView updateProduct(HttpServletRequest req)
    	{
    		ModelAndView mav=null;
    		Product_Model p=new Product_Model();
    		if(ServletFileUpload.isMultipartContent(req))
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
    						if(item.getFieldName().equals("productname"))
    						{
    						    p.setProductName(item.getString());	
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
					p.setImage(new EDao().updateProductDetails(p));
					if(p.getImage()!=null)
					{
						File f=new File(cloud);
		    			File arr[]=f.listFiles();
		    			for(File f1:arr)
		    			{
		    				if(f1.getName().equals(p.getImage()))
		    				{
		    					if(f1.delete())
		    					{
		    						mav=new ModelAndView("SearchProducts");
		    						mav.addObject("msg","Product Details Updated");
		    		    			return mav;
		    					}
		    				}
		    			}
					}
					else
					{
						mav=new ModelAndView("SearchProducts");
						return mav;
					}
    			}
    			catch (Exception e)
    			{
					System.out.println(e);
				}
    		}
			return mav;   		
    	}
    	@RequestMapping("/DeleteProduct")
    	public ModelAndView deleteProduct(@ModelAttribute("product_model") Product_Model p)
    	{
            ModelAndView mav=new ModelAndView();
    		p.setImage(e.deleteProduct(p));
    		if(p.getImage()!=null)
    		{
    			File f=new File(cloud);
    			File arr[]=f.listFiles();
    			for(File f1:arr)
    			{
    				if(f1.getName().equals(p.getImage()))
    				{
    					if(f1.delete())
    					{
    						mav.addObject("msg","Product Deleted");
    		    			mav.setViewName("SearchProducts");
    		    			return mav;
    					}
    				}
    			}
    			
    		}
    		else
    		{
    			mav.addObject("msg","Product Not Deleted");
    			mav.setViewName("SearchProducts");
    			return mav;
    		}
			return mav;
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
					mav.addObject("logintype", ss.getAttribute("login"));
					mav.addObject("productdetails",al); 
				    File f=new File(cloud);
    			    File arr[]=f.listFiles();
    			    mav.addObject("folderpath", cloud);
    			    mav.addObject("productimage",arr);
    			    mav.setViewName("viewproduct");
				    return mav;
				}
				else
				{
					mav.addObject("msg","Login To Check Product");
					mav.setViewName("loginforms");
					return mav;
				}
			}
			else
			{
				mav.addObject("msg","Try Again");
				mav.setViewName("viewproduct");
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
    				ss.setAttribute("login","customerlogin");
    				mav.addObject("msg","signout");
    				mav.setViewName("index");
    				return mav;
    			}
    			else
    			{
    				mav.addObject("msg","Invalid Email/Password");
    				mav.setViewName("UserAccount");
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
    				   mav.setViewName("UserAccount");
       				   return mav;
    			   }
    			   else
    			   { 
    				   mav.addObject("msg","Enter Proper Details");
    				   mav.setViewName("UserAccount");
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
    				mav.setViewName("UserAccount");
    				return mav;
    			}
    			else
    			{
    				mav.addObject("msg","Invalid Email");
    				mav.setViewName("UserAccount");
    				return mav;
    			}
    		}
			return mav;
       }
       @RequestMapping("/reqfilter")
       public ModelAndView filter(HttpServletRequest req)
       {
    	  ModelAndView mav=null;
    	  Filter_Model fm=new Filter_Model();
    	  String arr[]=req.getParameterValues("catagories");
    	  ArrayList<String> al=new ArrayList<String>();
    	  for(String c:arr)
    	  {
    		  al.add(c);
    	  }
    	 fm.setCatagories(al);
    	 for(String c:req.getParameterValues("brands"))
     	 {
   		   al.add(c);
      	 }
    	   
    	   fm.setBrands(al);
    	   fm.setPrice(Integer.parseInt( req.getParameter("price")));
    	   ArrayList<Product_Model> al1=new ArrayList<Product_Model>();
    	   al1=e.filter(fm);
    	   if(al1!=null)
    	   {
    		   File f=new File(cloud);
   			File arr1[]=f.listFiles();
   			mav=new ModelAndView("SearchProducts");
   			mav.addObject("productdetails", al1);
   			mav.addObject("productimages",arr1);
   			mav.addObject("folderpath", cloud);
   			return mav;
    	   }
    	   return mav;
       }
}
