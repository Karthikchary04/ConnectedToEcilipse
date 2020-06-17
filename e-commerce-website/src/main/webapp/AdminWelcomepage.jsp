<!DOCTYPE html>
<html>
<head>
<title>Admin Welcome Page</title>
<style type="text/css">
body
{
   background: #2c3e50;
   font-family: sans-serif;
}
nav
{
   position: relative;
   margin: 100px auto 0;
   width: 930px;
   height: 50px;
   background: #34495e;
   border-radius: 8px;
   font-size: 0;
   box-shadow: 0 2px 3px rgba(0,0,0, .1);
}
nav a
{
   font-size: 15px;
   text-transform: uppercase;
   color: white;
   text-decoration: none;
   line-height: 50px;
   position: relative;
   z-index: 1;
   display: inline-block;
   text-align: center;
}
nav .animation
{
   position: absolute;
   height: 100%;
   top: 0;
   z-index: 0;
   background: #1abc9c;
   border-radius: 8px;
   transition:all .5s ease 0s;
}
a:nth-child(1){width:200px;} 
nav .start-Add-Products , a:nth-child(1):hover~ .animation 
{
	width:200px;
	left:0;
}
a:nth-child(2){width:200px;} 
nav .start-View-Products , a:nth-child(2):hover~ .animation 
{
	width:200px;
	left:200px;
}
a:nth-child(3){width:200px;} 
nav .start-Check-Sales , a:nth-child(3):hover~ .animation 
{
	width:200px;
	left:400px;
}
a:nth-child(4){width:200px;} 
nav .start-Manage-Orders , a:nth-child(4):hover~ .animation 
{
	width:200px;
	left:600px;
}
a:nth-child(5){width:100px;} 
nav .start-Search , a:nth-child(5):hover~ .animation 
{
	width:130px;
	left:800px;
}
</style>
</head>
<body>
         <nav>
            <a href=addproductsform>Add Products</a>
            <a href=#>View Products</a>
            <a href=#>Check Sales</a>
            <a href=#>Manage Orders</a>
            <a href=searchproductspage>Search</a>
            <div class="animation start-home"></div>
         </nav>     
</body>
</html>