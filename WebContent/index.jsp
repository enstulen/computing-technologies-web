<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

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
<title>FakeBnB</title>
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
			<div class="fh5co-hero">
				<div class="fh5co-overlay"></div>
				<div class="fh5co-cover" data-stellar-background-ratio="0.5"
					style="background-image: url(images/cover_bg_5.jpg);">
					<div class="desc">
						<div class="container">
							<div class="row">
								<div class="col-sm-5 col-md-5">
									<!-- <a href="index.html" id="main-logo">Travel</a> -->
									<div class="tabulation animate-box">

										<!-- Nav tabs -->
										<ul class="nav nav-tabs" role="tablist">
											<li role="presentation" class="active"><a
												href="#alojamientos" aria-controls="alojamientos" role="tab"
												data-toggle="tab">Accommodations</a></li>
										</ul>

										<!-- Tab panes -->
										<div class="tab-content">
											<div role="tabpanel" class="tab-pane active" id="hotels">
												<form action="searchResults.html" method="post">

													<div class="row">
														<div class="col-xxs-12 col-xs-12 mt">
															<div class="input-field">
																<label for="from">City:</label> <input type="text"
																	class="form-control" id="from-place" name="from-place"
																	placeholder="Madrid, SPAIN" />
															</div>
														</div>
														<div class="col-xxs-12 col-xs-6 mt alternate">
															<div class="input-field">
																<label for="date-start">Start of stay:</label> <input
																	type="text" class="form-control" id="date-start"
																	name="date-start" placeholder="mm/dd/yyyy" />
															</div>
														</div>
														<div class="col-xxs-12 col-xs-6 mt alternate">
															<div class="input-field">
																<label for="date-end">End of stay:</label> <input
																	type="text" class="form-control" id="date-end"
																	name="date-end" placeholder="mm/dd/yyyy" />
															</div>
														</div>

														<div class="col-sm-12 mt">
															<section>
																<label for="class">Price</label> <select name="price"
																	class="cs-select cs-skin-border">
																	<option value="" disabled selected>Less than
																		35€</option>
																	<option value="P1">Less than 35€</option>
																	<option value="P2">36€ - 69€</option>
																	<option value="P3">70€ - 130€</option>
																	<option value="P4">131€ or more</option>
																</select>
															</section>
														</div>

														<div class="col-sm-12 mt">
															<section>
																<label for="class">Type of apartment</label> <select
																	class="cs-select cs-skin-border" name="type">
																	<option value="" disabled selected>Entire
																		accommodation</option>
																	<option value="entire">Entire accommodation</option>
																	<option value="private">Private room</option>
																	<option value="shared">Shared room</option>
																</select>
															</section>
														</div>

														<div class="col-xxs-12 col-xs-6 mt">
															<section>
																<label for="class">Adults:</label> <select
																	class="cs-select cs-skin-border" name="adults">
																	<option value="" disabled selected>1</option>
																	<option value="1">1</option>
																	<option value="2">2</option>
																	<option value="3">3</option>
																	<option value="4">4</option>
																</select>
															</section>
														</div>
														<div class="col-xxs-12 col-xs-6 mt">
															<section>
																<label for="class">Kids:</label> <select
																	class="cs-select cs-skin-border" name="kids">
																	<option value="" disabled selected>0</option>
																	<option value="0"></option>
																	<option value="1">1</option>
																	<option value="2">2</option>
																	<option value="3">3</option>
																	<option value="4">4</option>
																</select>
															</section>
														</div>
														<div class="col-xs-12">
															<input type="submit" class="btn btn-primary btn-block"
																value="Search">
														</div>
													</div>
												</form>
											</div>
										</div>


									</div>
								</div>
								<div class="desc2 animate-box">
									<div class="col-sm-7 col-sm-push-1 col-md-7 col-md-push-1">
										<h3>FakeBnB</h3>
										<h2>Plan your stay</h2>
										<h3>Choose from thousands of available accommodations</h3>
										<p>
											From <span class="price">35€</span> per night
										</p>
										<!-- <p><a class="btn btn-primary btn-lg" href="#">Get Started</a></p> -->
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>

			</div>


			<!-- Login Modal -->
			<div class="modal fade" id="loginModal" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
				<div class="modal-dialog modal-dialog-centered" role="document">
					<div class="modal-content">

						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
							<h1 class="h3 mb-3 font-weight-normal">Sign in to continue</h1>
						</div>
						<div class="modal-body">
							<form class="form-signin" name = "login" action= "login" method = "post">
								<input type="email" id="loginEmail" class="form-control"
									placeholder="Email" required
									autofocus> <input type="password" id="loginPassword"
									class="form-control" placeholder="Password" required>
								<div class="checkbox mb-3">
									<label> <input type="checkbox" value="remember-me">
										Remember me
									</label>
								</div>
								<button class="btn btn-lg btn-primary btn-block" type="submit"
									id="IniciaSesion">Sign in</button>
							</form>

						</div>

						<div class="modal-footer">
							<p class="text-center">
								No account?<a href="index.jsp"> Regíster</a>
							</p>
							<p class="text-center">
								<a href="index.jsp"> Back </a>
							</p>
						</div>

					</div>
				</div>
			</div>
		<%@ include file="/components/Modal.jsp" %>

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


</body>
</html>

