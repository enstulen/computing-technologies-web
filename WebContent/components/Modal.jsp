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
					<form class="form-signin">
						<input type="email" id="loginEmail" class="form-control"
							placeholder="Email" required autofocus> <input
							type="password" id="loginPassword" class="form-control"
							placeholder="Password" required>
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
					<form class="form-registro">
						<input type="email" id="inputEmail" class="form-control"
							placeholder="Email" required autofocus> <input
							type="name" id="inputName" class="form-control"
							placeholder="Name" required> <input type="surname"
							id="inputSurname" class="form-control" placeholder="Surname"
							required> <input type="password" id="inputPassword"
							class="form-control" placeholder="Set a password" required>
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
</html>