<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Products Page</title>
<script type="text/javascript">
function login()
{
   var pid=document.addProducts.pid.value;
   var productname=document.addProducts.pname.value;
   var catagory=document.addProducts.catagory.value;
   var Brand=document.addProducts.brand.value;
   var stock=document.addProducts.stock.value;
   var sold=document.addProducts.sold.value;
   var price=document.addProducts.price.value;
   var info=document.addProducts.info.value;
   if(pid=="")
   {
	  alert("Please Enter Product ID:");
	  document.addProducts.t1.focus();
	  return false;
   }
   if(productname=="")
   {
	   alert("Please Enter Product Name:");
	   document.addProducts.t2.focus();
	   return false;
   }
   if(catagory=="")
   {
	  alert("Please Enter Catagory:");
	  document.addProducts.t1.focus();
	  return false;
   }
   if(Brand=="")
   {
	   alert("Please Enter Brand:");
	   document.addProducts.t2.focus();
	   return false;
   }
   if(stock=="")
   {
	  alert("Please Enter Stock:");
	  document.addProducts.t1.focus();
	  return false;
   }
   if(sold=="")
   {
	   alert("Please Enter Sold:");
	   document.addProducts.t2.focus();
	   return false;
   }
   if(price=="")
   {
	  alert("Please Enter Price:");
	  document.addProducts.t1.focus();
	  return false;
   }
   if(info=="")
   {
	   alert("Please Enter Info:");
	   document.addProducts.t2.focus();
	   return false;
   }
}
</script>
<style>
body
{
   margin:0;
   padding:0;
   font-family:'montserrat';
   background:linear-gradient(120deg,#2980b9,#8e44ad);
   height:100vh;
}
.center
{
   position:absolute;
   top:70%;
   left:50%;
   transform:translate(-50%,-50%);
   width:400px;
   background:white;
   border-radius:10px;
}
.center h1
{
   text-align:center;
   padding: 0 0 20px 0;
   border-bottom:1px solid silver;
}
.center form
{
  padding:0 10px;
  box-sizing:border-box;
}
form .txt_field
{
   position:relative;
   border-bottom:2px #adadad;
   margin:10px 0;
}
.txt_field input
{
  width:100%;
  height:35px;
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
  font-size:25px;
  pointer-events:none;
  transition:.5s;
}
.txt_field span::before 
{
   content:'';
   position:absolute;
   top:25px;
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
.pass
{
  margin:-5px 0 20px 5px;
  color:#a6a6a6;
  cursor:pointer;
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
<h1>Add Product</h1>
<form action="AddProductDetails" method="post" name="addProducts" onsubmit="return login();" enctype="multipart/form-data">

<div class="txt_field">
<input type="text" name="pid">
<span></span>
<label>Product ID:</label>
</div>

<div class="txt_field">
<input type="text" name="productName">
<span></span>
<label>Product Name:</label>
</div>

<div class="txt_field">
<input type="text" name="catagory">
<span></span>
<label>Catagory:</label>
</div>

<div class="txt_field">
<input type="text" name="brand">
<span></span>
<label>Brand:</label>
</div>

<div class="txt_field">
<input type="text" name="stock">
<span></span>
<label>Stock:</label>
</div>

<div class="txt_field">
<input type="text" name="sold">
<span></span>
<label>Sold:</label>
</div>

<div class="txt_field">
<input type="text" name="price">
<span></span>
<label>Price:</label>
</div>

<div class="txt_field">
<input type="text" name="info">
<span></span>
<label>Info:</label>
</div>

<div class="txt_field">
<input type="file" name="image">
</div>

<input type="submit" value="Add Product">
</form>
</div>
</body>
</html>