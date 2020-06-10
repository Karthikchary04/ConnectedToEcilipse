<%@page import="college_Models.Fee_Remainder_Model"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Form</title>
</head>
<body bgcolor="#ffe066">
<center>
<form action=payment>
<br><br><br><br><br><br><br>
<h3>PAYMENT FORM</h3>
<table border=1 cellpading=7 bgcolor="#edf2f4">
<%
ArrayList<Fee_Remainder_Model> al=new ArrayList<Fee_Remainder_Model>();
al=(ArrayList<Fee_Remainder_Model>)request.getAttribute("paymentform");
for(Fee_Remainder_Model f1: al)
{

	out.print("<tr><td>Sid:</td><td><input type=text name=t1 readonly value="+f1.getSid()+"></td></tr>");
	out.print("<tr><td>Fee:</td><td><input type=text name=t2 readonly value="+f1.getFee()+"></td></tr>");
	out.print("<tr><td>Paid:</td><td><input type=text name=t3 readonly value="+f1.getPaid()+"></td></tr>");
	out.print("<tr><td>Due:</td><td><input type=text name=t4  value="+f1.getDue()+"></td></tr>");
	out.print("<tr><td>Pay:</td><td><input type=text name=t5></td></tr>");
	out.print("<tr><td><input type=submit value=Pay Fee></td><td><input type=reset value=Clear></td></tr>");
}

%>
</table>
</form>
</center>
</body>
</html>