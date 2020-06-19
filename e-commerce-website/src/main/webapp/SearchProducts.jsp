<%@page import="java.io.File"%>
<%@page import="Models.Product_Model"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
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
.search select
{
   width:12%;
   height:26px;
   font-size: 20px;
   font-family: sans-serif;
   border-radius:10px;
}
.dropdown-button {
    color: black;
    padding: 13px;
    font-size: 16px;
    border-radius:10px;
}
.dropdown {
    position: relative;
    display: inline-block;
}
.dropdown-list {
    display: none;
    position: absolute;
    background-color: #f1f1f1;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}
.dropdown-list a {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
    font-family: sans-serif;
}
.dropdown-list a:hover {
    background-color: #ddd;
}
.dropdown:hover .dropdown-list {
    display: block;
}

.dropdown:hover .dropdown-button {
    background-color: #adb5bd;
}
</style>
<body>
<center>
<div class="search">
<form action="getproducts">
<input type="text" name="search"  placeholder="Ex:Jeans,Watches"><input type="submit" value="search"> <div class="dropdown">
		<button class="dropdown-button">Sort</button>
		<div class="dropdown-list">
			<a href="sorting?value=lowtohigh">Low To High</a>
			<a href="sorting?value=hightolow">High To Low</a>
		</div>
	</div>
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