<body>
<html>
<p> Successful Registration </p>

First name <?php echo  htmlspecialchars($_POST["firstname"]); ?> <br>
Last name <?php echo  htmlspecialchars($_POST["lastname"]); ?> <br>
Username <?php echo  htmlspecialchars($_POST["username"]); ?> <br>
Your password is: <?php echo $_POST["password"]; ?> <br>
Email Address <?php echo  htmlspecialchars($_POST["email"]); ?> <br>
Gender <?php echo  htmlspecialchars($_POST["formGender"]); ?> <br>
Address <?php echo  htmlspecialchars($_POST["address"]); ?> <br>

</body>
</html>

  

   