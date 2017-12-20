<body>
<html>

<?php
$foo = "Wrong username or password";
$x = 0;


if(!empty($_REQUEST['username']) || !empty($_REQUEST['Password'])){

if($_REQUEST['username'] !== "Adonis151" ){

print $foo;
$x=1;
}
 
}

else
{
echo '<p class="error">You forgot to enter your username!</p>';
}





if(!empty($_REQUEST['Password']) || !empty($_REQUEST['username'])){

if($_REQUEST['Password'] !== "Peguero151" || $_REQUEST['username'] !== "Adonis151"){

if($x ==1){
echo '<p  </p>'; 
}
else{
print $foo;
}
 
}

elseif($_REQUEST['username'] == "Adonis151"){
header("location: index.html");
}

}

else
{
echo '<p class="error">You forgot to enter your password!</p>';
}



?>

</body>
</html>

  

   