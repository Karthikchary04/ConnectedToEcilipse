<%@page import="college_Models.Course_Model"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Of Cources</title>
</head>
<body bgcolor="#c6ac8f">
<center>
<br><br><br><br><br><br><br>
<table border=1 cellpadding=7 bgcolor:yellow><tr><td>Course ID</td><td>Course Name</td><td>Course Fee</td></tr>
<%
ArrayList<Course_Model> al=new ArrayList<Course_Model>();
al=(ArrayList<Course_Model>)request.getAttribute("cources");
for(Course_Model c1: al)
{
	out.print("<tr><td>"+c1.getCoursename()+"</td><td>"+c1.getCoursefee()+"</td></tr>");
}
out.print("<body><center><h3>Click Here To<a href=PrincipalOptions.html>Go Back</a></h3></center></body>");
%>
</table>
</center>
</body>
</html>