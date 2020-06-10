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
<body  bgcolor="#fcbf49">
<br><br><br><br><br><br><br><br>
<center>
<table border=1 cellpadding=7><tr><td>Course Name</td><td>View Students</td></tr>
<%
ArrayList<Course_Model> al=new ArrayList<Course_Model>();
al=(ArrayList<Course_Model>)request.getAttribute("reciptionistviewcources");
for(Course_Model c1: al)
{
	out.print("<tr><td>"+c1.getCoursename()+"</td><td><a href=viewstudentsbycourse?id="+c1.getCoursename()+">View Students</a></td></tr>");
}
out.print("<body><center>Click Here To<a href=ReciptionistOptions.html>Go Back</a></center>");
%>
</body>
</html>