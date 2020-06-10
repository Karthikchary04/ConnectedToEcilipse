<%@page import="college_Models.Fee_Remainder_Model"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fee Remainder</title>
</head>
<body bgcolor="#edeff2">
<br><br><br><br><br><br><br>
<center>
<table border=1 cellpading=7 bgcolor="#e9c46a"><tr bgcolor="#edeff2"><td>Student ID</td><td>Student Name</td><td>Course</td><td>Fee</td><td>Paid</td><td>Due</td><td>Pay Fee</td></tr>
<%
ArrayList<Fee_Remainder_Model> al=new ArrayList<Fee_Remainder_Model>();
al=(ArrayList<Fee_Remainder_Model>)request.getAttribute("myfeeremainder");
if(al.size()!=0)
{
    for(Fee_Remainder_Model f1: al)
    {
    	out.print("<tr><td>"+f1.getSid()+"</td><td>"+f1.getStudentname()+"</td><td>"+f1.getCourse()+"</td><td>"+f1.getFee()+"</td><td>"+f1.getPaid()+"</td><td>"+f1.getDue()+"</td><td><a href=feepayment?id="+f1.getSid()+">Pay Due Amount</a></td></tr>");
    }
    out.print("<body><center><h3>Click Here To<a href=StudentOptions.html>Go Back</a></h3></center></body>");
}
else
{
   	out.print("<body><center>No Fee Remainders!! <br>Click Here To<a href=StudentOptions.html>Go Back</a></center></body>");
}
%>
</body>
</html>