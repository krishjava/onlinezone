<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp"%>

<main id="main" class="main">
	<div class="pagetitle">
	      <h1>Subject Tables</h1>
	      <nav>
	        <ol class="breadcrumb">
	          <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/admin/home">Home</a></li>
	        </ol>
	      </nav>
	    </div>

	<div class="card">
		<div class="card-body">
			<h5 class="card-title"><a class="btn btn-primary btn-sm" href='<c:out value="${pageContext.request.contextPath }/onlinezone.com/admin/subject-form" />'>New Subject</a></h5>
	
			<!-- Dark Table -->
			<table class="table table-dark">
				<thead>
					<tr>
						<th scope="col">S.No.</th>
						<th scope="col">Subject Code</th>
						<th scope="col">Subject Name</th>
						<th scope="col">Action</th>
					</tr>
				</thead>
				<tbody>
					<c:choose>
						<c:when test="${notFound==false }">
							<tr>
								<th scope="row"></th>
								<td></td>
								<td>Data Not Found</td>
								<td>	</td>
							</tr>	
						</c:when>
						<c:when test="${notFound!=false }">
							<c:forEach var="subject" items="${subjectData}">
								<tr>
									<th scope="row">${subject.id }</th>
									<td>${subject.subjectCode}</td>
									<td>${subject.subjectName}</td>
									<td>
										<a class="btn btn-outline-warning" href='<c:out value="${pageContext.request.contextPath }/onlinezone.com/admin/update-subject/update/${subject.id }" />'>Edit</a> 
										<a class="btn btn-outline-danger" href='<c:out value="${pageContext.request.contextPath }/onlinezone.com/admin/delete-subject/delete/${subject.id }" />'>Delete</a>
									</td>
								</tr>
							</c:forEach>
						</c:when>
					</c:choose>
				</tbody>
			</table>
			<!-- End Dark Table -->
	
		</div>
	</div>
</main>

<%@include file="footer.jsp"%>