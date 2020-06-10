<%@page import="college_Models.Lecturer_Model"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Of Lecturers</title>
</head>
<body bgcolor="#9ac6c5">
<br><br><br><br><br><br><br>
<%
ArrayList<Lecturer_Model> al=new ArrayList<Lecturer_Model>();
al=(ArrayList<Lecturer_Model>)request.getAttribute("lecturers");
out.print("<center><table border=1 cellpadding=7 bgcolor:yellow><tr><td>Lid</td><td>Lecturer Name</td><td>Username</td><td>Email ID</td><td>Subject</td></tr>");
for(Lecturer_Model l1:al)
{
	out.print("<tr><td>"+l1.getFullname()+"</td><td>"+l1.getUsername()+"</td><td>"+l1.getEmail()+"<td>"+l1.getSubject()+"</td></tr>");
}
out.print("<body><center><h3>Click Here To<a href=PrincipalOptions.html>Go Back</a></h3></center></body>");
%>
</body>
</html>