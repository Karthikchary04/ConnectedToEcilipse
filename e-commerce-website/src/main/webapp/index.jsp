<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<style type="text/css">
*
{
   margin: 0;
   padding: 0;
   box-sizing: border-box;
}

header
{
   width:100%;
   background-color: #fdfffc;
}
.head
{
   width:100%;
   height:100%;
   display: flex;
   align-items: center; 
}
.logo
{
   width:30%;
   text-align: center;
   color:black;
   font-size: 45px;
}
.nav
{
   width:70%;
   text-align: right;
   padding-right: 50px;
}
.nav li
{
   display: inline-block;
   padding: 8px;
   list-style: none;
}
.nav li a
{
   text-decoration: none;
   color: black;
   font-size: 25px;
}
.img_box img
{
   width:100%;
   height: 90vh;
}
.img_box h1
{
   position:absolute;
   top:70%;
   color:#d90429;
   left: 13%;
   font-size: 45px;
}
.img_box button
{
   position: absolute;
   top: 85%;
   left: 13%;
   padding: 5px;
   border: none;
   background-color: orange;
}
.head2
{
   position:relative;
   display: flex;
   justify-content: space-around;
   align-items: center;
}
.first
{
   position:relative;
   width: 30%;
   height: 300px;
}
.first img
{
   width:100%;
   height: 300px;
}
.first h3
{
   position:absolute;
   top:20%;
   left:2%;
   font-size: 30px;
   color:white;
}
.first button
{
   position:absolute;
   top:55%;
   left: 2%;
   padding: 5%;
   border:none;
}
.second
{
   position:relative;
   width: 30%;
   height: 300px;
}
.second img
{
   width:100%;
   height: 300px;
}
.second h3
{
   position: absolute;
   top:20%;
   left:57%;
   font-size: 30px;
   color:white;
}
.second button
{
   position:absolute;
   top:55%;
   left: 57%;
   padding: 5%;
   border:none;
}
.third
{
   position:relative;
   width: 30%;
   height: 300px;
}
.third img
{
   width:100%;
   height: 300px;
}
.third h3
{
   position:absolute;
   top:10%;
   left:2%;
   font-size: 30px;
   color:white;
}
.third button
{
   position:absolute;
   top:55%;
   left: 2%;
   padding: 5%;
   border:none;
}
footer
{
   text-align: center;
   padding:10px;
   background-color: black;
}
footer h3
{
   color:white;
}
@media screen and (max-width:900px)
{
    .img_box h1
    {
       color:red;
    }
    .head2
    {
       flex-direction: column;
    }	
    .first
    {
       width: 50%;
    }
    .second
    {
       width: 50%;
    }
    .third
    {
       width: 50%;
    }
}
</style>
</head>
<body>
       <header>
       <div class="head">
       <div class="logo">Online Shopping</div>
       <div class="nav">
                 <ul>
                     <li><a href=searchproductspage>Search Products</a></li>
                     <li><a href=#>Cart</a></li>
                     <li><a href=#>About</a></li>
                     <li><a href=adminloginform>Admin</a></li>
                     <li><a href=UserAccount.jsp>User</a></li>
                 </ul>
       </div>
       </div>
       </header>
       <div class="img_box">
            <img src="C:\Users\KARTHIK\git\ConnectedToEcilipse\e-commerce-website\src\main\webapp/peter-england white t-shirt.jpg">
            <h1>Enjoy this <br> Trending Collection</h1>
            <button>Shop Now</button>
       </div>
       <div class="head2">
           <div class="first">
               <img  src="C:\Users\KARTHIK\git\ConnectedToEcilipse\e-commerce-website\src\main\webapp/women1.jpg"/>
               <h3>New Style</h3>
               <button>Shop Now</button>
            </div>   
           <div class="second">
               <img src="C:\Users\KARTHIK\git\ConnectedToEcilipse\e-commerce-website\src\main\webapp/women2.jpg"/>
               <h3>Summer Collection</h3>
               <button>Shop Now</button>
           </div>    
           <div class="third">
               <img src="C:\Users\KARTHIK\git\ConnectedToEcilipse\e-commerce-website\src\main\webapp/nikeshoes.jpg"/>
               <h3>Elegant Shoes</h3>
               <button>Shop Now</button>
           </div>    
       </div>
       <footer>
            <h3>2020 Online Shopping. All Rights Reserved</h3>
       </footer>
</body>
</html>