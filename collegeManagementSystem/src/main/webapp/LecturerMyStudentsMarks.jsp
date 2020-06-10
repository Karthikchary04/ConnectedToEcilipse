<%@page import="college_Models.Marks_Model"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Marks Of Students</title>
</head>
<body bgcolor="#3d5a80">
<br><br><br><br><br><br><br>
<center>
<table border=1 cellpadding=7 bgcolor=#f2e9e4><tr bgcolor="#ffe066"><td>Student ID</td><td>Student Name</td><td>Course Name</td><td>Internal Marks</td><td>External Marks</td><td>Semester Marks</td><td>Total Marks</td><td>Grade</td></tr>
<%
ArrayList<Marks_Model> al=new ArrayList<Marks_Model>();
al=(ArrayList<Marks_Model>)request.getAttribute("mystudentsmarks");
for(Marks_Model m1: al)
{
	out.print("<tr><td>"+m1.getSid()+"</td><td>"+m1.getStudentname()+"</td><td>"+m1.getCourse()+"</td><td>"+m1.getInternalmarks()+"</td><td>"+m1.getExternalmarks()+"</td><td>"+m1.getSemestermarks()+"</td><td>"+m1.getTotalmarks()+"</td><td>"+m1.getGrade()+"</td></tr>");
}
out.print("<center><h3>Click Here to <a href=LecturerOptions.html>Go Back</a></h3></center>");
%>
</center>
</body>
</html>