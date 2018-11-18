<%@page import="entities.Message"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- Access bean placed in the request by MessagesRequestHandler --%>
<jsp:useBean id="Messages" scope="request" type="List<Message>" />

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
<title>FakeBnb</title>
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

<link rel="stylesheet" href="css/messaging.css">

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

			<div id="message-container" class="fh5co-section-gray">
				<div class="container">
					<div class="row">
						<div
							class="col-md-8 col-md-offset-2 text-center heading-section animate-box">
							<h3>Messages</h3>
							<p>These are the messages you have received until now.</p>
						</div>
					</div>

					<div class="row row-bottom-padded-md">
						<div class="col-md-8 col-md-offset-2">
							<div class="panel panel-default">
								<div class="panel-body">
									<div class="pull-right">
										<a href="readmessage.html"> Read new messages</a>
										<div class="btn-group">
											<button type="button" class="btn btn-success btn-filter"
												data-target="leido"">Read</button>
											<button type="button" class="btn btn-warning btn-filter"
												data-target="no-leido">Unread</button>
											<button type="button" class="btn btn-default btn-filter"
												data-target="all">All</button>
											<button type="button" class="btn btn-default" id="NewMessage">New
												Message</button>
										</div>
									</div>
									<div class="table-container">
										<table class="table table-filter">
											<tbody>
												<%
													for (Message message : Messages) {
												%>
												<%
													String readstatus;
														if (message.isMessage_read()) {
															readstatus = "leido";
														} else {
															readstatus = "no-leido";
														}
												%>
												<tr data-status=<%out.println(readstatus);%>
													class=<%out.println(readstatus);%>>
													<td><a href="javascript:;" class="star"> <i
															class="glyphicon glyphicon-star"></i>
													</a></td>
													<td>
														<div class="media">
															<h4 class="title">
																Sender ID:
																<%
																out.println(message.getSender());
															%>
															</h4>
														</div>
													</td>
													<td>
														<div class="media">
															<p class="summary">
																Text:
																<%
																out.println(message.getText());
															%>
															</p>
															<p class="meta">
																Date:
																<%
																out.println(message.getTime_stamp());
															%>
															</p>
														</div>
													</td>
													<%
														String messageString = message.getText();
															String[] parts = messageString.split(" ");
															session.setAttribute("booking", parts[0]);
																						%>
													<c:if test="${sessionScope.booking == 'Booking:'}">
														<td>

															<div class="media">
																<div class="btn-group">
																	<form method="POST" action="messages.html">
																		<input type="hidden" name="type" value="acceptBooking" />
																		<input type="hidden" name="messageid"
																			value=<%out.println(message.getMessageid());%> />
																		<input type="hidden" name="message"
																			value="<%out.println(message.getText());%>" />
																		<button type="submit" class="btn btn-default">Accept</button>
																	</form>
																	<form method="POST" action="messages.html">
																		<input type="hidden" name="type"
																			value="declineBooking" /> <input type="hidden"
																			name="messageid"
																			value=<%out.println(message.getMessageid());%> />
																		<input type="hidden" name="message"
																			value="<%out.println(message.getText());%>" />
																		<button type="submit" class="btn btn-default">Decline</button>
																	</form>
																</div>
															</div>
														</td>
													</c:if>
													<c:if test="${sessionScope.booking != 'Booking:'}">
														<td>
															<div class="media">
																														<div class="btn-group">

																											<form method="POST" action="mark-as-read.html">
																<input type="hidden" name="readStatus" value=<%out.println(message.getMessageid());%>/>
																	<button type="submit" class="btn btn-default">Mark as read</button>
																</form>
															
															</div>
																														</div>

														</td>
													</c:if>
												</tr>
												<%
													}
												%>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<%@ include file="/components/Footer.jsp"%>


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


	<!-- Main JS -->
	<script src="js/main.js"></script>


	<script type="text/javascript">
		$(document).ready(
				function() {

					$('.star').on('click', function() {
						$(this).toggleClass('star-checked');
					});

					$('.btn-filter').on(
							'click',
							function() {
								var $target = $(this).data('target');
								if ($target != 'all') {
									$('.table tr').css('display', 'none');
									$(
											'.table tr[data-status="' + $target
													+ '"]').fadeIn('slow');
								} else {
									$('.table tr').css('display', 'none')
											.fadeIn('slow');
								}
							});

				});
		$(document).on('click', '#NewMessage', function() {
			$("#MessageModal").modal("show");
		});
	</script>

</body>
</html>

