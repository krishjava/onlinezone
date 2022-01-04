<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp" %>

  <main id="main" class="main">

    <div class="pagetitle">
      <h1>Questions Tables</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/admin/home">Home</a></li>
          <li class="breadcrumb-item">Tables</li>
          <li class="breadcrumb-item active">Data</li>
        </ol>
      </nav>
    </div><!-- End Page Title -->

    <section class="section">
      <div class="row">
        <div class="col-lg-12">

          <div class="card">
            <div class="card-body">
              <h5 class="card-title">Question</h5>

              <!-- Table with stripped rows -->
              <table class="table datatable">
                <thead>
                  <tr>
                    <th scope="col">S.No.#</th>
                    <th scope="col">Question</th>
                    <th scope="col">Student Id</th>
                    <th scope="col">Added Date</th>
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
							<c:forEach var="question" items="${questions}">
								<tr>
									<td scope="row"><a href="${pageContext.request.contextPath }/onlinezone.com/admin/question-detail/${question.student_id}/${question.id }" >${question.id }</a></td>
			
									<c:choose>
										<c:when test="${ question.question.length() > 12}">
											<td>${ question.question.substring(0,10) }...</td>
										</c:when>
										<c:when test="${ question.question.length() <= 12}">
											<td>${ question.question}</td>
										</c:when>
									</c:choose>
			
									<td>${question.student_id}</td>
									<td>${question.added_date}</td>
									<td>
										<a class="btn btn-outline-danger" href="#">Delete</a>
									</td>
								</tr>
							</c:forEach>
						</c:when>
					</c:choose>
				</tbody>
              </table>

            </div>
          </div>

        </div>
      </div>
    </section>

  </main><!-- End #main -->

<%@include file="footer.jsp" %>