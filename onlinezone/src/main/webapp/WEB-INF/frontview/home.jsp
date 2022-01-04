<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp"%>

 <div class="jumbotron jumbotron-fluid vh-100" id="backimg">
    <div class="container">
      <h1 class="display-4">Hello World</h1>
      <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Dicta hic quas maiores harum nihil officia soluta, veritatis sit minus alias!</p>
    </div>
  </div>
    <!-- Login model start -->

<div class="modal fade" id="loginmodel" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="staticBackdropLabel">Login Form</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form>
          <div class="form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control" id="email" name="email" placeholder="Enter Email" aria-describedby="emailHelp" required>
            <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
          </div>
          <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password" required>
          </div>
          <div class="text-center"><button type="submit" class="btn btn-primary">Login</button></div>
      </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
    
    <h3 class="mt-2 text-center">Recently Added Questions</h3>  
        <div class="container">
            <div class="row mt-4 ml-4">
                <c:forEach var="question" items="${recentRows }">
		                        <div class="col-sm-4 col-lg-4">
		                            <div class="card" style="width: 18rem;">
		                                <div class="card-body">
		                                  <h5 class="card-title">Username</h5>
		                                  <h6 class="card-subtitle mb-2 text-muted" style="font-size: 11px">${question.added_date}</h6>
		                                  <div class="card-text text-dark" style="width: inherit;  height: 63px;  overflow: hidden;">${question.question}</div>
		                              	<hr style="height: 0px;">
		                                  <a href="#" class="card-link">Card link</a>
		                                  <a href="${pageContext.request.contextPath}/onlinezone.com/question-detail/${question.id}" class="card-link text-dark">Question Details</a>
		                                </div>
		                              </div>
		                        </div>
	                        </c:forEach>
            </div>
        </div>

<%@include file="footer.jsp"%>