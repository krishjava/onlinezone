<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp"%>

<main id="main" class="main">

	<div class="pagetitle">
		<h1>Form Elements</h1>
		<nav>
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/admin/home">Home</a></li>
			</ol>
		</nav>
	</div>
	<!-- End Page Title -->

	<section class="section">
		<div class="row justify-content-center">
			<div class="col-lg-8">
				<div class="card">
					<div class="card-body">
						<h5 class="card-title">Answer Details</h5>
							<form>
								<div class="row mb-3">
									<label for="id" class="col-sm-2 col-form-label">Student Id</label>
									<div class="col-sm-10">
										<input type="text" class="form-control" readonly="readonly" value="${answer.student_id }">
									</div>
								</div>
								<div class="row mb-3">
									<label for="date" class="col-sm-2 col-form-label">Question Id</label>
									<div class="col-sm-10">
										<input type="text" readonly="readonly" class="form-control" value="${answer.question_id }">
									</div>
								</div>
								<div class="row mb-3">
									<label for="date" class="col-sm-2 col-form-label">Added Date</label>
									<div class="col-sm-10">
										<input type="text" readonly="readonly" class="form-control" value="${answer.added_date }">
									</div>
								</div>
								<div class="row mb-3">
				                  <label for="question" class="col-sm-2 col-form-label">Answer</label>
				                  <div class="col-sm-10">
				                    <textarea class="form-control" style="height: 100px" readonly="readonly">${answer.answer}</textarea>
				                  </div>
				                </div>
							</form>
					</div>
				</div>
			</div>
		</div>
	</section>
</main>


	<%@include file="footer.jsp"%>