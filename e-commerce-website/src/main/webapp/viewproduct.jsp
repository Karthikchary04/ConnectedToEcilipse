<%@page import="Models.Product_Model"%>
<%@page import="java.io.File"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Product</title>
<style type="text/css">
.row {
  display: flex;
}
.column {
  flex: 50%;
  float: left;
  width: 50%;
  float: left;
  font-size: 30px;
  margin:10px;
  padding: 10px;
}
.column input[type="submit"]
{
   width:50%;
   height:40px;
   font-size: 20px;
   font-family: sans-serif;
   border-radius:10px;
}
</style>
</head>
<body>
<div class="row">
  <div class="column">
  <%
    ArrayList<Product_Model> al=new ArrayList<Product_Model>();
    al=(ArrayList<Product_Model>)request.getAttribute("productdetails");
    File arr[]=(File[])request.getAttribute("productimage");
    for(Product_Model p:al)
    {
    	for(File f:arr)
    	{
    		if(p.getImage().equals(f.getName()))
    		out.print("<img src='"+f+"' height=600 width=600>");
    	}
    }
  %>
  </div>
  
  
  <div class="column">
  <%
    ArrayList<Product_Model> al1=new ArrayList<Product_Model>();
    al1=(ArrayList<Product_Model>)request.getAttribute("productdetails");
    for(Product_Model p:al)
    {
    	out.print(p.getProductName()+"<br><br>"+p.getBrand()+"<br><br>"+p.getCatagory()+"<br><br>"+p.getPrice()+"Rs/-<br><br>"+p.getInfo()+"<br><br>");
    }
    %>
    <input type="submit" value="Add To Cart"><br>
    <br><input type="submit" value="Buy Now">
  </div>
</div>
</body>
</html>