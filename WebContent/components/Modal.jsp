<!DOCTYPE html>
<html>
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
				<form class="form-signin" method="POST" action="index.html">
					<input type="email" name="email" id="loginEmail"
						class="form-control" placeholder="Email" required autofocus>
					<input name="password" type="password" id="loginPassword"
						class="form-control" placeholder="Password" required>
					<button class="btn btn-lg btn-primary btn-block" type="submit"
						id="IniciaSesion">Sign in</button>
				</form>

			</div>

			<div class="modal-footer">
				<p class="text-center">
					No account?<a href="#" id="gotoRegisterFromLogin"> Register</a>
				</p>
			</div>

		</div>
	</div>
</div>

<!-- Registro Modal -->
<div class="modal fade" id="RegistroModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">

			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h1 class="h3 mb-3 font-weight-normal">Enter your details</h1>
			</div>
			<div class="modal-body">
				<form class="form-registro" method="POST" action="index.html">
					<input name="email" type="email" id="inputEmail"
						class="form-control" placeholder="Email" required autofocus>
					<input name="name" id="inputName" class="form-control"
						placeholder="Name" required> <input name="surname"
						id="inputSurname" class="form-control" placeholder="Surname"
						required> <input name="password" type="password"
						id="inputPassword" class="form-control"
						placeholder="Set a password" required>
					<button class="btn btn-lg btn-primary btn-block" type="submit"
						id="Registrate">Register</button>
				</form>

			</div>

			<div class="modal-footer">
				<p class="text-center">
					You already have an account?<a href="#" id="goRegistroLogin">
						Sign in</a>
				</p>
			</div>

		</div>
	</div>
</div>

<!-- Logout Modal -->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
	<div class="modal-dialog modal-dialog-centered" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h1 class="h3 mb-3 font-weight-normal">Are you sure you want to
					logout?</h1>
			</div>
			<div class="modal-body">
				<form class="form-signin" method="POST" action="index.html">
				  	<input type="hidden" name="type" value="logout" />
					<button class="btn btn-lg btn-primary btn-block" type="submit"
						id="IniciaSesion">Yes</button>
				</form>
				<button class="btn btn-lg btn-primary btn-block" type="button"
					data-dismiss="modal">Cancel</button>
			</div>

		</div>
	</div>
</div>
</html>