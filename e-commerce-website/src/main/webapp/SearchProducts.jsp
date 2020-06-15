<%@page import="java.io.File"%>
<%@page import="Models.Product_Model"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Products</title>
<style type="text/css">
.search
{
   background: #457b9d;
   margin: 10px;
   padding: 10px;
}
.result
{
   background-color: #f1faee;
   font-size: 20px;
   font-family: sans-serif;
   padding: 20px;
   
}
.search input[type="text"]
{
   width:50%;
   height:40px;
   font-size: 20px;
   font-family: sans-serif;
   border-radius:10px; 
}
.search input[type="submit"]
{
   width:10%;
   height:46px;
   font-size: 20px;
   font-family: sans-serif;
    border-radius:10px;
}
</style>
<body>
<center>
<div class="search">
<form action="getproducts">
<input type="text" name="search"  placeholder="Ex:Jeans,Watches"><input type="submit" value="search">
</form>
</div>
<div class="result">
<%
if(request.getAttribute("msg")!=null)
{
	out.print(request.getAttribute("msg"));
}
ArrayList<Product_Model> al=new ArrayList<Product_Model>();
al=(ArrayList<Product_Model>)request.getAttribute("searchresult");
if(al!=null)
{
	out.print("<table cellpadding:10px >");
	File arr[]=(File[])request.getAttribute("productimages");
	if(arr!=null)
	{
	for(Product_Model p:al)
	{
		for(File f:arr)
		{
			if(p.getImage().equals(f.getName()))
			{
				out.print("<tr><td><a href=getproductdetails?pid="+p.getPid()+"><img src='"+f+"' height=250 width=250></a></td><td><a href=getproductdetails?pid="+p.getPid()+">"+p.getProductName()+"</a><br>"+p.getPrice()+"<br>"+p.getBrand()+"<br>"+p.getInfo()+"</td></tr>");
			}
		}
	}
	}
}
%>
</div>
</center>
</body>
</html>