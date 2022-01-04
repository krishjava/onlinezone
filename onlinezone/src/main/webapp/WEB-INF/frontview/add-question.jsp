<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp"%>

<h3 class="text-center mt-4">Add Question</h3>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-sm-6 col-lg-6">
                <form action="${pageContext.request.contextPath}/onlinezone.com/save-question" method="post">
                    <div class="form-group">
                      <label for="question">Question</label>
                      <textarea class="form-control" id="question" name="question" rows="5" cols="5" ></textarea>
                      <small  class="form-text text-danger fs-13" ><form:errors path="questionFrom.question"></form:errors></small>
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    </div>

<%@include file="footer.jsp"%>