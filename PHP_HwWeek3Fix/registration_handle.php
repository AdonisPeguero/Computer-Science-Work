<body>
<html>
<?php 
$X = "Seccessful Registration"; ?>

<?php
if(is_numeric($_REQUEST['firstname'])){
$X = "Registration failed";
echo '<p class="error">First name: No numbers or special characters are allowed</p>';
}
else
{
echo 'First name: '. htmlspecialchars($_POST["firstname"])."<br>"; 
}


if(empty($_REQUEST['firstname'])){
$X = "Registration failed";
echo '<p class="error">You forgot to enter your first name!</p>';
}

/*----------------------------------------------------------------------------------------------*/
if(is_numeric($_REQUEST['lastname'])){
$X = "Registration failed";
echo '<p class="error">Last name: No numbers or special characters are allowed</p>';
}
else
{
echo 'Last name: '. htmlspecialchars($_POST["lastname"])."<br>"; 
}


if(empty($_REQUEST['lastname'])){
$X = "Registration failed";
echo '<p class="error">You forgot to enter your last name!</p>';
}
/*----------------------------------------------------------------------------------------------*/
if(!empty($_REQUEST['username'])){

echo 'Username: '. htmlspecialchars($_POST["username"])."<br>"; 
}

else
{
$X = "Registration failed";
echo '<p class="error">You forgot to enter your username!</p>';
}
/*----------------------------------------------------------------------------------------------*/
if(!empty($_REQUEST['password'])){

echo 'Password: '. htmlspecialchars($_POST["password"])."<br>"; 
}

else
{
$X = "Registration failed";
echo '<p class="error">You forgot to enter your password!</p>';
}
/*----------------------------------------------------------------------------------------------*/
if(!empty($_REQUEST['email'])){

echo 'Email: '. htmlspecialchars($_POST["email"])."<br>"; 
}

else
{
$X = "Registration failed";
echo '<p class="error">You forgot to enter your email address!</p>';
}
/*----------------------------------------------------------------------------------------------*/
if(!empty($_REQUEST['formGender'])){

echo 'Gender: '. htmlspecialchars($_POST["formGender"])."<br>"; 
}

else
{
$X = "Registration failed";
echo '<p class="error">You forgot to enter your Gender!</p>';
}
/*----------------------------------------------------------------------------------------------*/
if(!empty($_REQUEST['address'])){

echo 'Address: '. htmlspecialchars($_POST["address"])."<br>"; 
}

else
{
$X = "Registration failed";
echo '<p class="error">You forgot to enter your address!</p>';
}
?>


<br>
<?php echo $X; ?>

</body>
</html>

  

   