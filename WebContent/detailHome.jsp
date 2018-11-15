<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ page import="entities.Home"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
										<td><span class="type"> <% out.println(typeOfHouse); %>
										</span></td>
									</tr>
								</tbody>
							</table>
							<c:if test="${sessionScope.user != null }">
								<div class="col-xxs-12 col-xs-6 mt">
									<input id="book-home-button" type="submit"
										class="btn btn-primary btn-block" value="Book">
								</div>
								<div class="col-xxs-12 col-xs-6 mt">
									<input id="contact-host-button" type="submit"
										class="btn btn-primary btn-block" value="Contact host">
								</div>
							</c:if>
							<c:if test="${sessionScope.user == null }">
								<h3>Log in to book this home</h3>
							</c:if>
						</div>
						<div class="col-md-6 animate-box">
							<% String image = home.getImage(); %>
							<img class="img-responsive" src= <%out.println(image); %>
								alt="travel">
						</div>
						<!-- END fh5co-page -->

					</div>
				</div>
			</div>
			<%@ include file="/components/Footer.jsp"%>

		</div>
	</div>

	<jsp:include page="/components/Modal.jsp">
		<jsp:param name="homeid" value="${home.getHomeid()}" />
		<jsp:param name="hostid" value="${home.getUser().getUserid()}" />
	</jsp:include>
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


	<script type="text/javascript">
		$(document).on('click', '#contact-host-button', function() {
			$("#MessageModalWithoutReciever").modal("show");
		});
		$(document).on('click', '#book-home-button', function() {
			$("#bookModal").modal("show");
		});
	</script>
</body>
</html>

