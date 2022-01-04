<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp"%>

 <main id="main" class="main">

    <div class="pagetitle">
      <h1>Update Subject Details</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href='<c:out value="${pageContext.request.contextPath }/onlinezone.com/admin/home" />'>Home</a></li>
        </ol>
      </nav>
    </div><!-- End Page Title -->
    <section class="section">
      <div class="row justify-content-center">

        <div class="col-lg-6">

          <div class="card">
            <div class="card-body">
              <h5 class="card-title">Add Subject</h5>

              <form class="row g-3" action="${pageContext.request.contextPath }/onlinezone.com/admin/addsubject" method="post">
              	<input type="hidden" value="${id }" name="id">
                <div class="col-12">
                  <label for="code" class="form-label">Subject Code</label>
                  <input type="text" class="form-control" id="code" name="subjectCode" value="${subjectDetail.subjectCode }">
                </div>
                <div class="col-12">
                  <label for="subject" class="form-label">Subject</label>
                  <input type="text" class="form-control" id="subject" name="subjectName" value="${subjectDetail.subjectName }">
                </div>
              	<%--  
              	<input type="text" value="${id }" name="subjectId">
                 <input type="text" value="${status }" name="status"> --%>
                <div class="text-center">
                  <button type="submit" class="btn btn-primary">Submit</button>
                  <button type="reset" class="btn btn-secondary">Reset</button>
                </div>
              </form>

            </div>
          </div>
        </div>
      </div>
    </section>
  </main>

<%@include file="footer.jsp"%>