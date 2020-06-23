<!DOCTYPE html>
<%@page import="java.io.File"%>
<%@page import="ecommercewebsite.Models.Product_Model"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Product</title>
</head>
<body>
<%
ArrayList<Product_Model> al=new ArrayList<Product_Model>();
al=(ArrayList<Product_Model>)request.getAttribute("productdetailstoupdate");
File arr[]=(File[])request.getAttribute("productimages");
for(Product_Model p:al)
{
	for(File f:arr)
	{
		if(p.getImage().equals(f.getName()))
		{
		   out.print("<table><form action=UpdateProductDetails enctype=multipart/form-data>");
		   out.print("<tr><td>Product ID:<input type=text name=pid readonly value="+p.getPid()+"></td></tr>");
		   out.print("<tr><td>Product Name:<input type=text name=pname value="+p.getProductName()+"></td></tr>");
		   out.print("<tr><td>Product Brand:<input type=text name=brand value="+p.getBrand()+"></td></tr>");
		   out.print("<tr><td>Product Catagory:<input type=text name=catagory value="+p.getCatagory()+"></td></tr>");
		   out.print("<tr><td>Stock:<input type=text name=pid value="+p.getStock()+"></td></tr>");
		   out.print("<tr><td>Product Picture:<input type=text name=picture value=<img src="+f+" height=150 width=150></td></tr>");
		   out.print("<tr><td>Price:<input type=file name=price value="+p.getPrice()+"></td></tr>");
		   out.print("<tr><td>Product Info:<input type=text name=info value="+p.getInfo()+"></td></tr>");
		   out.print("</form></table>");
		}
	}
}
%>
</body>
</html>