<%@page import="college_Models.Student_Model"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Fee Student Structure</title>
</head>
<body bgcolor="#f4a261">
<br><br><br><br><br><br><br><br>
<center><table border=1 cellpading=7 bgcolor="#ffe066"><tr  bgcolor="#fdfcdc"><td>Student ID</td><td>Student Name</td><td>Email ID</td><td>DOB</td><td>Course</td><td>Fee</td><td>Paid</td><td>Due</td></tr>
<%
ArrayList<Student_Model>  al=new ArrayList<Student_Model>();
al=(ArrayList<Student_Model>)request.getAttribute("myfeestructure");
for(Student_Model s1: al)
{
	out.print("<tr><td>"+s1.getSid()+"</td><td>"+s1.getStudentName()+"</td><td>"+s1.getEmail()+"</td><td>"+s1.getDob()+"</td><td>"+s1.getCourse()+"</td><td>"+s1.getFee()+"</td><td>"+s1.getPaid()+"</td><td>"+s1.getDue()+"</td></tr>");
}
out.print("<body><center><h2>Click Here To<a href=StudentOptions.html>Go Back</a></h2></center></body>");
%>
</body>
</html>