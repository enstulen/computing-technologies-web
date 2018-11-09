<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="entities.Home"%>
<%
	Home home = (Home) request.getAttribute("home");

	String typeOfHouse = "default";
	int typeId = home.getType();
	switch (typeId) {
		case 1 :
			typeOfHouse = "Private home";
		case 2 :
			typeOfHouse = "Private room";
		case 3 :	
			typeOfHouse = "Shared room";
			break;
		default :
			typeOfHouse = "not stated";
			break;
	}
%>

<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>${home.getName()}</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="Free HTML5 Template by FREEHTML5.CO" />
<meta name="keywords"
	content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />
<meta name="author" content="FREEHTML5.CO" />

<!-- 
	//////////////////////////////////////////////////////

	FREE HTML5 TEMPLATE 
	DESIGNED & DEVELOPED by FREEHTML5.CO
		
	Website: 		http://freehtml5.co/
	Email: 			info@freehtml5.co
	Twitter: 		http://twitter.com/fh5co
	Facebook: 		https://www.facebook.com/fh5co

	//////////////////////////////////////////////////////
	 -->

<!-- Facebook and Twitter integration -->
<meta property="og:title" content="" />
<meta property="og:image" content="" />
<meta property="og:url" content="" />
<meta property="og:site_name" content="" />
<meta property="og:description" content="" />
<meta name="twitter:title" content="" />
<meta name="twitter:image" content="" />
<meta name="twitter:url" content="" />
<meta name="twitter:card" content="" />

<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
<link rel="shortcut icon" href="favicon.ico">

<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,700,300'
	rel='stylesheet' type='text/css'>

<!-- Animate.css -->
<link rel="stylesheet" href="css/animate.css">
<!-- Icomoon Icon Fonts-->
<link rel="stylesheet" href="css/icomoon.css">
<!-- Bootstrap  -->
<link rel="stylesheet" href="css/bootstrap.css">
<!-- Superfish -->
<link rel="stylesheet" href="css/superfish.css">
<!-- Magnific Popup -->
<link rel="stylesheet" href="css/magnific-popup.css">
<!-- Date Picker -->
<link rel="stylesheet" href="css/bootstrap-datepicker.min.css">
<!-- CS Select -->
<link rel="stylesheet" href="css/cs-select.css">
<link rel="stylesheet" href="css/cs-skin-border.css">

<link rel="stylesheet" href="css/style.css">


<!-- Modernizr JS -->
<script src="js/modernizr-2.6.2.min.js"></script>
<!-- FOR IE9 below -->
<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->

</head>
<body>
	<div id="fh5co-wrapper">
		<div id="fh5co-page">
			<%@ include file="/components/Navbar.jsp"%>
			<div id="fh5co-tours" class="fh5co-section-gray">
				<div class="container">

					<div id="fh5co-tours" class="fh5co-section-gray">
						<div class="container">

							<div class="row">
								<div class="col-md-12 animate-box">
									<h2 class="heading-title">${home.getName()}</h2>
								</div>
								<div class="col-md-6 animate-box">
									<span class="description">
										<p>${home.getFull_description()}</p>
									</span>
									<table class="table">
										<tbody>
											<tr>
												<th scope="row">Owner:</th>
												<td><span class="host">${home.getUser().getName()}</span></td>
											</tr>

											<tr>
												<th scope="row">Price:</th>
												<td><span class="price">${home.getPrice()}€</span></td>
											</tr>
											<tr>
												<th scope="row">Number of guests:</th>
												<td><span class="beds">${home.getNumber_of_guests()}</span></td>
											</tr>
											<tr>
												<th scope="row">Home type:</th>
												<td><span class="type"><% out.println(typeOfHouse); %> </span></td>
											</tr>
										</tbody>
									</table>
									<div class="col-xxs-12 col-xs-6 mt">
										<input type="book" class="btn btn-primary btn-block"
											value="Book">
									</div>
									<div class="col-xxs-12 col-xs-6 mt">
										<input type="contact" class="btn btn-primary btn-block"
											value="Contact host">
									</div>

								</div>
								<div class="col-md-6 animate-box">
									<img class="img-responsive" src="images/cover_bg_2.jpg"
										alt="travel">
								</div>
							</div>
						</div>
					</div>

					<footer>
						<div id="footer">
							<div class="container">
								<div class="row row-bottom-padded-md">
									<div class="col-md-2 col-sm-2 col-xs-12 fh5co-footer-link">
										<h3>About FakeBnB</h3>
										<p>Unforgettable trips start with FakeBnb. Find adventures
											nearby or in faraway places and access unique homes,
											experiences, and places around the world.</p>
									</div>
									<div class="col-md-2 col-sm-2 col-xs-12 fh5co-footer-link">
										<h3>FakeBnb</h3>
										<ul>
											<li><a href="#">Careers</a></li>
											<li><a href="#">Press</a></li>
											<li><a href="#">Policies</a></li>
											<li><a href="#">Help</a></li>
										</ul>
									</div>
									<div class="col-md-2 col-sm-2 col-xs-12 fh5co-footer-link">
										<h3>Discover</h3>
										<ul>
											<li><a href="#">Trust & Safety</a></li>
											<li><a href="#">Travel Credit</a></li>
											<li><a href="#">Business Travel</a></li>
											<li><a href="#">Guidebooks</a></li>
										</ul>
									</div>
									<div class="col-md-2 col-sm-2 col-xs-12 fh5co-footer-link">
										<h3>Hosting</h3>
										<ul>
											<li><a href="#">Hospitality</a></li>
											<li><a href="#">Hosting</a></li>
											<li><a href="#">Community Center</a></li>
											<li><a href="#">Host an Experience</a></li>
										</ul>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6 col-md-offset-3 text-center">
										<p class="fh5co-social-icons">
											<a href="#"><i class="icon-twitter2"></i></a> <a href="#"><i
												class="icon-facebook2"></i></a> <a href="#"><i
												class="icon-instagram"></i></a> <a href="#"><i
												class="icon-dribbble2"></i></a> <a href="#"><i
												class="icon-youtube"></i></a>
										</p>
									</div>
								</div>
							</div>
						</div>
					</footer>


				</div>
				<!-- END fh5co-page -->

			</div>
			<!-- END fh5co-page -->

		</div>
		<%@ include file="/components/Modal.jsp"%>

		<!-- END fh5co-wrapper -->


		<!-- jQuery -->

		<script src="js/jquery.min.js"></script>
		<!-- jQuery Easing -->
		<script src="js/jquery.easing.1.3.js"></script>
		<!-- Bootstrap -->
		<script src="js/bootstrap.min.js"></script>
		<!-- Waypoints -->
		<script src="js/jquery.waypoints.min.js"></script>
		<script src="js/sticky.js"></script>

		<!-- Stellar -->
		<script src="js/jquery.stellar.min.js"></script>
		<!-- Superfish -->
		<script src="js/hoverIntent.js"></script>
		<script src="js/superfish.js"></script>
		<!-- Magnific Popup -->
		<script src="js/jquery.magnific-popup.min.js"></script>
		<script src="js/magnific-popup-options.js"></script>
		<!-- Date Picker -->
		<script src="js/bootstrap-datepicker.min.js"></script>
		<!-- CS Select -->
		<script src="js/classie.js"></script>
		<script src="js/selectFx.js"></script>

		<!-- Main JS -->
		<script src="js/main.js"></script>


		<script>
			
		</script>
</body>
</html>

