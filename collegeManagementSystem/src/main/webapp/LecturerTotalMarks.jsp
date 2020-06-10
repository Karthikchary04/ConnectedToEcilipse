<%@page import="college_Models.Marks_Model"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Total Marks</title>
</head>
<body bgcolor="#e63946">
<br><br><br><br><br><br><br>
<%
ArrayList<Marks_Model> al=new ArrayList<Marks_Model>();
al=(ArrayList<Marks_Model>)request.getAttribute("totalmarks");
out.print("<center><h3>Enter Marks Of Student</h3><center>");
for(Marks_Model m1: al)
{
	out.print("<body><center><form action=updateTotalMarks><table border=1 cellpadding=7 bgcolor=#fcbf49><tr><td>Student ID</td><td><input type=text name=t1 readonly value="+m1.getSid()+"></td></tr>");
	out.print("<tr><td>Student Name</td><td><input type=text name=t2 readonly value="+m1.getStudentname()+"></td>");
	out.print("<tr><td>Course Name</td><td><input type=text name=t3 readonly value="+m1.getCourse()+"></td>");
	out.print("<tr><td>Internal Marks</td><td><input type=text name=t4  value=EnterMarksOutOf20></td>");
	out.print("<tr><td>External Marks</td><td><input type=text name=t5  value=EnterMarksOutOf20></td>");
	out.print("<tr><td>Semester Marks</td><td><input type=text name=t6  value=EnterMarksOutOf60></td>");
	out.print("<tr><td><input type=submit value=Submit></td><td><input type=reset value=clear></td></table></form></center></body>");
}
%>
</body>
</html>