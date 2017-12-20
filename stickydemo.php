<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Sticky Validation</title>
<link rel="stylesheet" type="text/css" href="style.css" />
</head>	
<body>
<h2>A Simple Form for Sticky Validation</h2>
	<?php
		//get variables from form submission
		$name = $_POST['name'];
		$email = $_POST['email'];
					
		if(empty($name)){
			$firstname = NULL;
			print "<p>Please enter your first name.</p>";
		}
		if(empty($email)){
			$email = NULL;
			print "<p>Please enter your email address.</p>";
		}					
		if($name && $email ){
		//display an output message to user
		print "Thanks for signing up for our mailing list <b> $name.</b>";
		print "<p>We will send our newsletter to you at <b>$email</b>.</p>";
		}
	?>
<!-- show html form -->	
<form method="post" action="">
    <div>
    <label for="name">*Name:</label>
    <input name="name" type="text" id="name" placeholder="name" >
    </div>
    
    <div class="clear">
    <label for="email">*What is your email address?</label>
    <input name="email" type="email" id="email" placeholder="email" >
    </div>
    
    <div class="clear">
    <input type="submit" value="Sign Up" name="submit" />
    </div>
</form>
<!-- end form -->
	
	</body>
</html>


