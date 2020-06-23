package ecommercewebsite.Models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product_Model 
{
   @Id
   private int pid;
   private String productName,brand,catagory,image,info;
   private int stock,sold,price;
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public String getCatagory() {
	return catagory;
}
public void setCatagory(String catagory) {
	this.catagory = catagory;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}
public int getSold() {
	return sold;
}
public void setSold(int sold) {
	this.sold = sold;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public String getInfo() {
	return info;
}
public void setInfo(String info) {
	this.info = info;
}
   
}
