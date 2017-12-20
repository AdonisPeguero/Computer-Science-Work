<body>
<html>

<?php

$page_title = 'Federal Tax Calculator';
include ('header.html');

 session_start();

 if(empty($_POST['Income'])){$_POST['Income'] = 9275;}
 if(empty($_POST['formStatus'])){$_POST['formStatus'] = "Single";}


  //$CheckIfSet = "Single";
  $CheckIfSet = $_POST['formStatus'];

  
  //$_POST['Income'] = "0";
  //$_POST['formStatus']="Single";
// $CheckIfSet = $_POST['formStatus'];
 
 $CheckIfPrint = 0;

 if($CheckIfSet == "Single"){ $CheckIfPrint = 1;}
 if($CheckIfSet == "Married or Qualifying"){ $CheckIfPrint = 2;}

 if($CheckIfSet == null or !is_numeric($_POST['Income']))
 {
 echo '<h1>Error!</h1>
		<p class="error">Please enter a valid Income and Status.</p>';

$_SESSION = "9275";
}

if (isset($_POST['Income']) && is_numeric($_POST['Income']) && !empty($_REQUEST['formStatus']) and  $CheckIfSet == "Single" and $CheckIfPrint == 1 ){
//example

if( $_POST['Income'] <= "9275" )
{
 $Results = $_REQUEST['Income'] * 0.10;
 $Choice = $_REQUEST['formStatus'];
}


elseif( $_POST['Income'] >= "9276" and $_POST['Income'] <= "37650" )
{
 $Results = $_REQUEST['Income'] * 0.15 + 927.50 ;
 $Choice = $_REQUEST['formStatus'];
}


elseif( $_POST['Income'] >= "37651" and $_POST['Income'] <= "91150" )
{
 $Results = $_REQUEST['Income'] * 0.25 + 5183.75 ;
 $Choice = $_REQUEST['formStatus'];
}


elseif( $_POST['Income'] >= "91151" and $_POST['Income'] <= "190150" )
{
 $Results = $_REQUEST['Income'] * 0.28 + 18558.75 ;
 $Choice = $_REQUEST['formStatus'];
}


elseif( $_POST['Income'] >= "190151" and $_POST['Income'] <= "413350" )
{
 $Results = $_REQUEST['Income'] * 0.33 + 46278.75 ;
 $Choice = $_REQUEST['formStatus'];
}


elseif( $_POST['Income'] >= "413351" and $_POST['Income'] <= "415050" )
{
 $Results = $_REQUEST['Income'] * 0.35 + 119934.75 ;
 $Choice = $_REQUEST['formStatus'];
}


elseif( $_POST['Income'] >= "415051" )
{
 $Results = $_REQUEST['Income'] * 0.40 + 120529.75 ;
 $Choice = $_REQUEST['formStatus'];
}





//$hours = $_POST['Income']/65;

$_SESSION = $_POST['Income'];

//echo "$hours" ;

// Print the results:
echo '<h1>Total Estimated Cost</h1>
	Your Tax Rate is ' .  $Results. " as a ". $Choice . " Person" ;

	$CheckIfPrint = 1;

} 










if (isset($_POST['Income']) && is_numeric($_POST['Income']) && !empty($_REQUEST['formStatus']) and $CheckIfSet == "Married or Qualifying" and $CheckIfPrint == 2){
//example

if( $_POST['Income'] <= "18450" )
{
 $Results = $_REQUEST['Income'] * 0.10;
 $Choice = $_REQUEST['formStatus'];
}

elseif( $_POST['Income'] >= "18451" and $_POST['Income'] <= "74900")
{
 $Results = $_REQUEST['Income'] * 0.15 + 1845 ;
 $Choice = $_REQUEST['formStatus'];
}


elseif( $_POST['Income'] >= "74901" and $_POST['Income'] <= "151200")
{
 $Results = $_REQUEST['Income'] * 0.25 + 10312.50 ;
 $Choice = $_REQUEST['formStatus'];
}


elseif( $_POST['Income'] >= "151201" and $_POST['Income'] <= "230450" )
{
 $Results = $_REQUEST['Income'] * 0.28 + 29387.50 ;
 $Choice = $_REQUEST['formStatus'];
}


elseif( $_POST['Income'] >= "230451" and $_POST['Income'] <= "411500" )
{
 $Results = $_REQUEST['Income'] * 0.33 + 51577.50 ;
 $Choice = $_REQUEST['formStatus'];
}


elseif( $_POST['Income'] >= "411501" and $_POST['Income'] <= "464850" )
{
 $Results = $_REQUEST['Income'] * 0.35 + 111324 ;
 $Choice = $_REQUEST['formStatus'];
}


elseif( $_POST['Income'] >= "464851" )
{
 $Results = $_REQUEST['Income'] * 0.40 + 129996.50 ;
 $Choice = $_REQUEST['formStatus'];
}

//$hours = $_POST['Income']/65;

$_SESSION = $_POST['Income'];

//echo "$hours" ;

// Print the results:
echo '<h1>Total Estimated Cost</h1>
	Your Tax Rate is ' .  $Results. " as a ". $Choice . " Person" ;

	$CheckIfPrint = 1;

} 

?>


<h1>Federal Tax Calculator</h1>
<form action="calculator.php" method="post">
<p>
Status:
<select name="formStatus" >
<value = "Single">
  <option value="">Select...</option>
  <option value="Single" selected="selected"   >Single</option>
  <option value="Married or Qualifying">Married or Qualifying</option>
 
  
</select>
</p>


<p>Income <input type="text" name="Income" size="20"
maxlength="40" value="<?php echo $_POST['Income']; ?>"  />

<p><input type="submit" name="submit" value="Calculate!" /></p>

</form>

<?php include ('footer.html'); ?>