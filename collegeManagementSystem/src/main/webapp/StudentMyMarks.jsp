<%@page import="college_Models.Marks_Model"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Marks</title>
</head>
<body bgcolor="#bee3db">
<center>
<br><br><br><br><br><br><br>
<table border=1 cellpadding=7 bgcolor="#e8ddb5"><tr bgcolor=white><td>Student ID</td><td>Student Name</td><td>Course Name</td><td>Internal Marks</td><td>External Marks</td><td>Semester Marks</td><td>Total Marks</td><td>Grade</td></tr>
<%
ArrayList<Marks_Model> al=new ArrayList<Marks_Model>();
al=(ArrayList<Marks_Model>)request.getAttribute("mymarks");
if(al.size()!=0)
{
for(Marks_Model m: al)
{
	out.print("<tr><td>"+m.getSid()+"</td><td>"+m.getStudentname()+"</td><td>"+m.getCourse()+"</td><td>"+m.getInternalmarks()+"</td><td>"+m.getExternalmarks()+"</td><td>"+m.getSemestermarks()+"</td><td>"+m.getTotalmarks()+"</td><td>"+m.getGrade()+"</td></tr>");
}
out.print("<center><h3>Click Here to <a href=StudentOptions.html>Go Back</a></h3></center>");
}
else
{
	out.print("<body><center>Result Not Yet Released!!<br>Click Here To<a href=StudentOptions.html>Go Back</a></center></body>");
}
%>
</table>
</center>
</body>
</html>