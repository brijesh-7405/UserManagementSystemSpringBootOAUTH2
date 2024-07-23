<#import "spring.ftl" as spring />
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="<@spring.url 'assets/library/bootstrap/css/bootstrap.min.css' />"
		  rel="stylesheet" >
<link href="<@spring.url 'assets/css/custom.css' />"
		  rel="stylesheet" >
<link href="<@spring.url 'assets/css/responsive.css' />"
		  rel="stylesheet" >
</head>
<body>
<#include "Header.ftl"> 
<section>
	<div class="container">
		<div class="row">
			<div class="col-md-3 col-sm-3"></div>
			<div class="col-md-4 col-sm-4 login">
				<h1 class="heading" style="text-decoration: underline">Reset Password</h1>
				<form action="resetPassword" method="POST">
					<div class="form-group">
					Password:<input type="password" placeholder="Enter Password" id="pwd" class="form-control" name="password" required>
					</div>
					<div class="form-group">
					 Confirm password:<input type="password" name="repass" id="repwd" class="form-control" placeholder="Enter Confirm Password" required>
					</div>
					<div class="form-group">
						<input type="submit" class="form-control login-btn" value="Reset">
					</div>
						<input type="hidden" name="usermail" value="${email!""}" required>
				</form>
			 </div>
			 <div class="col-md-5 col-sm-5"></div>
		</div>
	</div>
</section>
<#include "Footer.ftl"> 
<script type="text/javascript" src="<@spring.url 'assets/js/jquery-3.6.0.min.js' />"></script>
<script type="text/javascript" src="<@spring.url 'assets/js/validation.js' />"></script>
</body>
</html>