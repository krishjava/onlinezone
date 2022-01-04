<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp"%>

 <h3 class="text-center mt-4">Question Details</h3>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-sm-6 col-lg-6">
                <!-- <form> -->
                    <div class="form-group">
                        <label for="username">Username</label>
                        <input type="text" class="form-control" value="${user.email.substring(0,user.email.indexOf('@'))}" readonly>
                    </div>
                    <div class="form-group">
                        <label for="question">Question</label>
                        <textarea class="form-control" id="question" name="question" rows="3" readonly>${fullQuestion.question}</textarea>
                    </div>
                    <div>
                         <button class="btn btn-success" data-toggle="modal" data-target="#answer">Save Changes</button>
                         <%-- <a href="${pageContext.request.contextPath}/onlinezone.com/answer/${fullQuestion.id}" class="btn btn-primary">Give answer</a> --%>
                        
 <div class="modal fade" id="answer" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="staticBackdropLabel">Answer</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
              <form action="${pageContext.request.contextPath}/onlinezone.com/saveanswer" method="post">
                <div class="form-group">
                    <label for="answer">Answer</label>
                    <textarea class="form-control" id="answer" name="answer" rows="5" ></textarea>
                    <small  class="form-text text-danger"><form:errors path="answer.answer"></form:errors></small>
                    <input type="hidden" name="user_id" value="${user.id}">
                    <input type="hidden" name="question_id" value="${fullQuestion.id}">
                </div>
                <div class="text-center"><button type="submit" class="btn btn-primary">Save Answer</button></div>
            </form>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
          </div>
        </div>
      </div>
                        
                    </div>
                <!-- </form> -->
            </div>
        </div>
    </div>
    <hr>
    <h3 class="text-center mt-4">User Answers</h3>
    <div class="container">
    
    <c:choose>
    	<c:when test="${answers.size()==0 }">
    		<h3 class="text-center text-danger mt-4">Answer Not Available</h3>
    	</c:when>
    	<c:when test="${answers.size()>0 }">
    		<c:forEach var="answer" items="${answers }">
		        <div class="row justify-content-center" >
		            <div class=" jumbotron" id="answers">
		                <p>@Username &emsp; </p>
		                <h6 class="">${answer.answer}</h6>
		                <%-- <span>${answer.added_date }</span> --%>
		                <div class="text-right"><button class="btn btn-success" data-toggle="modal" data-target="#editanswer">Edit</button></div>
		            </div>
		        </div>
	        </c:forEach>
    	</c:when>
    </c:choose>
    
   		
    </div>
    
    <div class="modal fade" id="editanswer" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title" id="staticBackdropLabel">Edit Answer</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
              <form>
                <div class="form-group">
                    <label for="question">Question</label>
                    <textarea class="form-control" id="question" name="question" rows="3" readonly>Lorem ipsum dolor sit amet consectetur adipisicing elit. Ut, amet?</textarea>
                </div>
                <div class="form-group">
                    <label for="answer">Question</label>
                    <textarea class="form-control" id="answer" name="answer" rows="3" required>Lorem ipsum dolor, sit amet consectetur adipisicing elit. Ex dolore, pariatur nisi temporibus amet nam reiciendis quod est deleniti maxime fugit, aut error enim optio quae facilis corporis. Vitae minus nesciunt laudantium officiis ullam amet provident reiciendis labore dolor animi eos repellendus quidem, non quos odio aliquid maiores atque dolore.</textarea>
                </div>
                <div class="text-center"><button type="submit" class="btn btn-primary">Save Answer</button></div>
            </form>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
          </div>
        </div>
      </div>

<%@include file="footer.jsp"%>