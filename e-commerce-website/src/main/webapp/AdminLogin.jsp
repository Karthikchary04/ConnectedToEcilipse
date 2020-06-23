<!DOCTYPE html>
<html>
<head>
<title>Admin Login Page</title>
<script type="text/javascript">
function login()
{
   var username=document.principalLogin.t1.value;
   var password=document.principalLogin.t2.value;
   if(username=="")
   {
	  alert("Please Enter Username:");
	  document.principalLogin.t1.focus();
	  return false;
   }
   if(password=="")
   {
	   alert("Please Enter Password:");
	   document.principalLogin.t2.focus();
	   return false;
   }
}
</script>
<style type="text/css">
body
{
   margin:0;
   padding:0;
   font-family:'montserrat';
   background:linear-gradient(120deg,#FFFFFF,#000000);
   height:100vh;
   overflow:hidden;
}
.center
{
   position:absolute;
   top:50%;
   left:50%;
   transform:translate(-50%,-50%);
   width:400px;
   background:white;
   border-radius:10px;
}
.center h1
{
   font-size:25px;
   text-align:center;
   padding: 0 0 20px 0;
   border-bottom:1px solid silver;
}
.center form
{
  padding:0 40px;
  box-sizing:border-box;
}
form .txt_field
{
   position:relative;
   border-bottom:2px #adadad;
   margin:30px 0;
}
.txt_field input
{
  width:100%;
  height:40px;
  padding:0 5px;
  font-size: 16px;
  border: none;
  background:none;
  outline:none;
}
.txt_field label
{
  position:absolute;
  top:50%;
  left:5px;
  color:#adadad;
  transform:translateY(-50%);
  font-size:16px;
  pointer-events:none;
  transition:.5s;
}
.txt_field span::before 
{
   content:'';
   position:absolute;
   top:40px;
   left:0;
   width:0%;
   height:2px;
   background:#2691d9;
   transition:.5s;	
}
.txt_field input:focus~label,
.txt_field input:valid~label 
{
	top:-5px;
	color:#2691d9;
	font-size:14px;
}
.txt_field input:focus~span::before,
.txt_field input:valid~span::before 
{
   width:100%;	
}
.pass:hover{text-decoration:underline;}
input[type="submit"]
{
  width:100%;
  height:50px;
  border:1px solid;
  background:#2691d9;
  border-radius:25px;
  font-size:18px;
  color:#e9f4fb;
  font-weight:700;
  cursor:pointer;
  outline:none;
}
input[type="submit"]:hover 
{
  border-color:#2691d9;
  transistion:.5s;	
}
input[type="button"]
{
  width:100%;
  height:50px;
  border:1px solid;
  background:#2691d9;
  border-radius:25px;
  font-size:18px;
  color:#e9f4fb;
  font-weight:700;
  cursor:pointer;
  outline:none;
}
input[type="button"]:hover 
{
  border-color:#2691d9;
  transistion:.5s;	
}
.signup_link
{
  margin:30px 0;
  text-align:center;
  font-size: 16px;
  color:#666666;
}
.signup_link a
{
  color:#2691d6;
  text-decoration:none;
  padding-left:5px;
}
.signup_link a:hover {text_decoration:underline;}

</style>
</head>
<body>
<center>
<br><br><br>
<%
if(request.getAttribute("msg")!=null)
{
	out.print(request.getAttribute("msg"));
}
%>
</center>
<div class="center">
<h1>Enter Details And Login</h1>
<form action="AdminLogin" method="post" name="principalLogin" onsubmit="return login();">

<div class="txt_field">
<input type="text" name="username">
<span></span>
<label>Username</label>
</div>

<div class="txt_field">
<input type="password" name="password">
<span></span>
<label>Password</label>
</div>

<a href="AdminOptions.html"></a><input type="submit" value="Login">
</form>
</div>
</body>
</html>