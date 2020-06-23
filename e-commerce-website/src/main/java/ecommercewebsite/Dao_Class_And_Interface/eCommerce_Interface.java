package ecommercewebsite.Dao_Class_And_Interface;

import java.util.ArrayList;

import ecommercewebsite.Models.Admin_Model;
import ecommercewebsite.Models.Orders_Model;
import ecommercewebsite.Models.Product_Model;
import ecommercewebsite.Models.User_Model;

public interface eCommerce_Interface
{
	//Administrator Modules
   public boolean adminLogin(Admin_Model a);
   public boolean changePassword(Admin_Model a);
   public boolean addProducts(Product_Model p);
   public ArrayList<Product_Model> viewAllProducts();
   public boolean updateProductDetails(Product_Model p);
   public boolean deleteProduct(Product_Model p);
   public ArrayList<Orders_Model> viewAllOrders();
   public ArrayList<Product_Model> getSearchResult(Product_Model p);
   public ArrayList<Product_Model> getProductDetails(Product_Model p);
   public ArrayList<Product_Model> sortedSearchResult(Product_Model p, String sortingType);
   
   //User Modules
   public boolean userLogin(User_Model u);
   public boolean userRegister(User_Model u);
   public boolean userResetPassword(User_Model u);
}
