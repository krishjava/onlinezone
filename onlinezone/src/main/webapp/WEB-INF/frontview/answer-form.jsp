<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp"%>

<h3 class="text-center mt-4">Registeration From</h3>
<h5 class="text-center mt-4 text-danger">${userExist}</h5>
<div class="container">
	<div class="row justify-content-center">
		<div class="col-sm-6 col-lg-6">
			<form action="${pageContext.request.contextPath}/onlinezone.com/add-answer" method="post">
				<div class="form-group">
					<label for="answer">Answer</label>
					<input type="text" class="form-control" id="answer" name="answer" />
					<small class="text-center text-danger"><form:errors path="ans.answer"></form:errors></small>
				</div>
				<div class="form-group">
					<input type="text" class="form-control" value="1"	name="user_id">
					<input type="text" class="form-control" value="${id }"	name="question_id">
				</div>
				<div class="text-center">
					<button type="submit" class="btn btn-primary">Save</button>
				</div>
			</form>
		</div>
	</div>
</div>


<%@include file="footer.jsp"%>


