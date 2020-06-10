<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="college_Models.Marks_Model"%>
    <%@page import="college_Models.Student_Model"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!-- LecturerMyStudentsMarks -->
<%
ArrayList<Marks_Model> al=new ArrayList<Marks_Model>();
al=(ArrayList<Marks_Model>)request.getAttribute("mystudentsmarks");
if(al!=null)
{
    out.print("<body bgcolor=#3d5a80>");
    out.print("<center>");
    out.print("<br><bri><br><br><br><br><br>");
    out.print("<table border=1 cellpadding=7 bgcolor=#f2e9e4><tr bgcolor=#ffe066><td>Student ID</td><td>Student Name</td><td>Course Name</td><td>Internal Marks</td><td>External Marks</td><td>Semester Marks</td><td>Total Marks</td><td>Grade</td></tr>");
    for(Marks_Model m1: al)
    {
	    out.print("<tr><td>"+m1.getSid()+"</td><td>"+m1.getStudentname()+"</td><td>"+m1.getCourse()+"</td><td>"+m1.getInternalmarks()+"</td><td>"+m1.getExternalmarks()+"</td><td>"+m1.getSemestermarks()+"</td><td>"+m1.getTotalmarks()+"</td><td>"+m1.getGrade()+"</td></tr>");
    }
    out.print("<center><h3>Click Here to <a href=LecturerOptions.html>Go Back</a></h3></center>");
}
%>


<!-- LecturerTotalMarks -->
<%
ArrayList<Marks_Model> al1=new ArrayList<Marks_Model>();
al=(ArrayList<Marks_Model>)request.getAttribute("totalmarks");
if(al1!=null)
{
    out.print("<center><h3>Enter Marks Of Student</h3><center>");
    for(Marks_Model m1: al1)
    {
	   out.print("<body><center><form action=updateTotalMarks><table border=1 cellpadding=7 bgcolor=#fcbf49><tr><td>Student ID</td><td><input type=text name=t1 readonly value="+m1.getSid()+"></td></tr>");
	   out.print("<tr><td>Student Name</td><td><input type=text name=t2 readonly value="+m1.getStudentname()+"></td>");
	   out.print("<tr><td>Course Name</td><td><input type=text name=t3 readonly value="+m1.getCourse()+"></td>");
	   out.print("<tr><td>Internal Marks</td><td><input type=text name=t4  value=EnterMarksOutOf20></td>");
	   out.print("<tr><td>External Marks</td><td><input type=text name=t5  value=EnterMarksOutOf20></td>");
	   out.print("<tr><td>Semester Marks</td><td><input type=text name=t6  value=EnterMarksOutOf60></td>");
	   out.print("<tr><td><input type=submit value=Submit></td><td><input type=reset value=clear></td></table></form></center></body>");
    }
}
%>

<!-- LecturerViewStudents -->
<%
ArrayList<Student_Model> al2=new ArrayList<Student_Model>();
al2=(ArrayList<Student_Model>)request.getAttribute("mystudents");
if(al2!=null)
{
	out.print("<body bgcolor=#ffe066><br><br><br><br><br><br><br><center>");
	out.print("<table border=1 cellpadding=7 bgcolor=#edeff2><tr bgcolor=#f25f5c><td>Student ID</td><td>Student Name</td><td>Email ID</td><td>DOB</td><td>Course</td><td>Enter Marks</td></tr>");
    for(Student_Model s1: al2)
    {
	    out.print("<tr><td>"+s1.getSid()+"</td><td>"+s1.getStudentName()+"</td><td>"+s1.getEmail()+"</td><td>"+s1.getDob()+"</td><td>"+s1.getCourse()+"</td><td><a href=totalmarks?tm="+s1.getSid()+">Enter Marks</a></td></tr>");
    }
    out.print("<body><center><h2>Click Here To<a href=LecturerOptions.html>Go Back</a></h2>");
}
%>


<!-- ReciptionistViewAllStudents -->
<%
ArrayList<Student_Model> al3=new ArrayList<Student_Model>();
al3=(ArrayList<Student_Model>)request.getAttribute("reciptionistviewallstudents");
if(al3!=null)
{
	out.print("<body bgcolor=#edeff2><br><br><br><br><br><br><br><center>");
	out.print("<table border=1 cellpading=7 bgcolor=#fdfffc><tr bgcolor=#ff1654><td>Student ID</td><td>Student Name</td><td>Email ID</td><td>DOB</td><td>Course</td><td>Fee</td><td>Paid</td><td>Due</td><td>Fee Payment Remainder</td></tr>");
    for(Student_Model s1: al3)
    {
	   out.print("<tr><td>"+s1.getSid()+"</td><td>"+s1.getStudentName()+"</td><td>"+s1.getEmail()+"</td><td>"+s1.getDob()+"</td><td>"+s1.getCourse()+"</td><td>"+s1.getFee()+"</td><td>"+s1.getPaid()+"</td><td>"+s1.getDue()+"</td><td><a href=feeremainder?id="+s1.getSid()+">Remaind Student</a></td></tr>");
    }
    out.print("<body><center><h2>Click Here To<a href=ReciptionistOptions.html>Go Back</a></h2></center>");
}
%>
</body>
</html>