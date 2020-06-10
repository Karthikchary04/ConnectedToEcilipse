<%@page import="college_Models.Recption_Model"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Of Reciptionist</title>
</head>
<body bgcolor="#87b6a7">
<br><br><br><br><br><br><br><br>
<%
ArrayList<Recption_Model> al=new ArrayList<Recption_Model>();
al=(ArrayList<Recption_Model>)request.getAttribute("reciptionist");
out.print("<center><table border=1 cellpadding=7 bgcolor:yellow><tr><td>Rid</td><td>Reciptionist Name</td><td>Username</td><td>Email ID</td></tr>");
for(Recption_Model r1:al)
{
	out.print("<tr><td>"+r1.getFullname()+"</td><td>"+r1.getUsername()+"</td><td>"+r1.getEmail()+"</td></tr>");
}
out.print("<body><center><h3>Click Here To<a href=PrincipalOptions.html>Go Back</a></h3></center></body>");
%>
</body>
</html>