<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>Admin Login</title>
<meta content="" name="description">
<meta content="" name="keywords">

<!-- Favicons -->
<link href="/onlinezone/admin/asset/image/favicon.png" rel="icon">
<link href="/onlinezone/admin/asset/image/apple-touch-icon.png" rel="apple-touch-icon">

<!-- Google Fonts -->
<link href="https://fonts.gstatic.com" rel="preconnect">
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link href="/onlinezone/admin/asset/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="/onlinezone/admin/asset/vendor/bootstrap-icons/bootstrap-icons.css"
	rel="stylesheet">
<link href="/onlinezone/admin/asset/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet">
<link href="/onlinezone/admin/asset/vendor/quill/quill.snow.css" rel="stylesheet">
<link href="/onlinezone/admin/asset/vendor/quill/quill.bubble.css" rel="stylesheet">
<link href="/onlinezone/admin/asset/vendor/remixicon/remixicon.css" rel="stylesheet">
<link href="/onlinezone/admin/asset/vendor/simple-datatables/style.css" rel="stylesheet">

<!-- Template Main CSS File -->
<link href="/onlinezone/admin/asset/css/style.css" rel="stylesheet">
<style type="text/css">
body {
	background: #afb6c5;
}
</style>

</head>
<body>
	<main>
		<div class="container">
			<section
				class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
				<div class="container">
					<div class="row justify-content-center">
						<div
							class="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">
							<div class="d-flex justify-content-center py-4">
								<a href="index.html"
									class="logo d-flex align-items-center w-auto"> <img
									src="assets/img/logo.png" alt=""> <span
									class="d-none d-lg-block text-white">Online-Zone</span>
								</a>
							</div>
							<div class="card mb-3">
								<div class="card-body">
									<div class="pt-4 pb-2">
										<h5 class="card-title text-center pb-0 fs-4">Admin Login</h5>
									</div>

									<form class="row g-3 needs-validation" action="${pageContext.request.contextPath }/onlinezone.com/admin/formprocess" method="post">

										<div class="col-12">
											<label for="email" class="form-label">Email</label>
											<input type="email" name="email" class="form-control"
												id="email"  placeholder="Enter Your Email">
										</div>
										<div class="col-12">
											<label for="password" class="form-label">Password</label>
											<input type="password" name="password" class="form-control"
												id="password"  placeholder="Enter Your Password">
											<div class="text-danger">${loginerror}</div>
										</div>
										<div class="col-12">
											<div class="form-check">
												<input class="form-check-input" type="checkbox"
													name="remember" value="true" id="rememberMe"> 
													<label class="form-check-label" for="rememberMe">Remember me</label>
											</div>
										</div>
										<div class="col-12">
											<button class="btn btn-primary w-100" type="submit">Login</button>
										</div>
									</form>

								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
		</div>
	</main>

	<script src="/onlinezone/asset/vendor/apexcharts/apexcharts.min.js"></script>
	<script src="/onlinezone/asset/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="/onlinezone/asset/vendor/chart.js/chart.min.js"></script>
	<script src="/onlinezone/asset/vendor/echarts/echarts.min.js"></script>
	<script src="/onlinezone/asset/vendor/quill/quill.min.js"></script>
	<script src="/onlinezone/asset/vendor/simple-datatables/simple-datatables.js"></script>
	<script src="/onlinezone/asset/vendor/tinymce/tinymce.min.js"></script>
	<script src="/onlinezone/asset/vendor/php-email-form/validate.js"></script>

	<!-- Template Main JS File -->
	<script src="assets/js/main.js"></script>

</body>

</html>