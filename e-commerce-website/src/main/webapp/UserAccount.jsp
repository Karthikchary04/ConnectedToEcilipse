<!DOCTYPE html>
<html>
<head>
<title>User Account</title>
<style type="text/css">
html
{
  box-sizing: border-box;
}
body
{
  background-color: coral;
  font-size: 16px;
}
*,
*:before,
*:after
{
   box-sizing: inherit;
}
input,fieldset
{
   -webkit-appearance:none;
   -moz-appearance:none;
   appearance:none;
   border: 0;
   padding: 0;
   margin: 0;
   min-width: 0;
   font-size: 1rem;
   font-family: inherit;
}
.no-touchevents .btn.btn--secondary:hover
{
   -webkit-transform:none;
   transform:none;
}
input[type="radio"]
{
  position:fixed;
  left:-100px;
}
[id="sign-in"]:checked ~ input.sign-in,[id="sign-up"]:checked ~ input.sign-up,[id="reset"]:checked ~ input.reset
{
  max-height: 40px;
  padding:10px;
  margin: 10px;
  opacity: 1;
}
[id="sign-in"]:checked ~button:before
{
  content: "Sign-In";
}
[id="sign-up"]:checked ~button:before
{
  content: "Sign-Up";
}
[id="reset"]:checked ~button:before
{
  content: "Reset Password";
}
input:not([type="radio"])
{
  -webkit-appearance:none;
  -moz-appearance:none;
   appearance:none;
   background-color: #fff;
   display: block;
   -webkit-transition:300ms ease;
   transition:300ms ease;
   border-radius:7px;
   border: 0;
   max-height: 0;
   margin: 0;
   padding: 0 10px;
   width: 250px;
   opacity: 0;
   font-size: 16px;
   text-align: center;
   outline: 0; 
}
.no-touchevents .btn.btn--main-cta:hove
{
   -webkit-transform:scale(1.03);
   transform:scale(1.03);
}
label:after
{
	content: "";
	border: 10px solid transparent;
	position: absolute;
	bottom: -10px;
	left: calc(50% - 10px);
	-webkit-transition:inherit;
	transition:inherit;
}
[id="sign-in"]:checked ~ [for="sign-in"]:after,[id="sign-up"]:checked ~ [for="sign-up"]:after,[id="reset"]:checked ~ [for="reset"]:after
{
    border-bottom-color: #fff;
}
.flex-wrap
{
   display: -webkit-box;
   display: flex;
   -webkit-box-pack:center;
   justify-content: center;
   -webkit-box-align:center;
   align-items: center;
   flex-wrap:wrap;
   height: 300px;
   text-align: center; 
}
button
{
   width: 250px;
   height: 40px;
   border-radius:7px;
   background-color: cornflwerblue;
   font-size: 0;
   color: black;
   border: 0;
   font-weight: 700;
   -webkkit-appearance:none;
   -moz-appearance:none;
   appearance:none; 
}
button:before
{
  font-size: 16px;
}
label
{
  position: relative;
  display: inline-block;
  text-align: center;
  font-weight: 700;
  cursor: pointer;
  -webkit-transition:300ms ease;
   transition:300ms ease;
   width: calc(100%/3 - 4px);	
}
</style>
</head>
<body>
<br><br><br><br><br><br><br>
<center>
<%
if(request.getAttribute("msg")!=null)
{
	out.print(request.getAttribute("msg"));
}
%>
</center>
        <div class="flex-wrap">
               <fieldset>               
                      <form action="useraccount" method="post">
                      <input type="radio" name="rg" id="sign-in" value="signin" checked/>
                      <input type="radio" name="rg" id="sign-up" value="signup"/>
                      <input type="radio" name="rg" id="reset" value="reset"/>
                      <label for="sign-in">Sign-In</label>
                      <label for="sign-up">Sign-up</label>
                      <label for="reset">Reset</label>
                      <input class="sign-up" type="text" name="name" placeholder="Name"/>
                       <input class="sign-up" type="text" name="gender" placeholder="Gender"/>
                       <input class="sign-up" type="date" name="dob" placeholder="DD-MM-YYYY"/>
                      <input class="sign-up" type="text" name="mobile" placeholder="Mobile"/>
                      <input class="sign-up" type="email" name="email" placeholder="Email"/>
                      <input class="sign-up sign-in reset" type="text" name="username" placeholder="username"/>
                      <input class="sign-up sign-in" type="password" name="password"  placeholder="Password"/>
                       <input class="reset" type="password" name="password"  placeholder="Password"/>
                      <button>Submit</button>
                      </form>
               </fieldset>
        </div>
</body>
</html>