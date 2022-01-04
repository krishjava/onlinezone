<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp"%>
<style>
.error{
	color: red;
}
</style>
 <main id="main" class="main">

    <div class="pagetitle">
      <h1>Add New Subject</h1>
      <nav>
        <ol class="breadcrumb">
          <li class="breadcrumb-item"><a href='<c:out value="home" />'>Home</a></li>
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
                <div class="col-12">
                <p class="text-danger"> <c:out value="${addError}"></c:out> </p>
                  <label for="code" class="form-label">Subject Code</label>
                  <input type="number" class="form-control" id="subjectCode" name="subjectCode" value="${subject.subjectCode }"   required="required" " > 
                  <div class="form-text text-danger"><form:errors path="subjectData.subjectCode"/></div>
                </div>
                <div class="col-12">
                  <label for="subject" class="form-label">Subject</label>
                  <input type="text" class="form-control" id="subjectName" name="subjectName" value="${subject.subjectName }"  required="required" >
                  <div class="form-text text-danger"><form:errors path="subjectData.subjectName" /></div>
                  <span>  </span>
                </div>
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