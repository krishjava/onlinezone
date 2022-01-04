<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp"%>

<h3 class="text-center mt-4">Login From</h3>
<h5 class="text-center mt-4 text-danger">${invalidUser}</h5>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-sm-6 col-lg-6">
                <form action="${pageContext.request.contextPath}/onlinezone.com/loginprocess" method="post">
                    <div class="form-group">
                      <label for="email">Email</label>
                      <input type="text" class="form-control" id="email" name="email" placeholder="Enter Email">
                      <small  class="form-text text-danger"><form:errors path="user.email"></form:errors></small>
                    </div>
                    <div class="form-group">
                      <label for="password">Password</label>
                      <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password">
                      <small  class="form-text text-danger"><form:errors path="user.password"></form:errors></small>
                    </div>
                    <button type="submit" class="btn btn-primary">Login</button>
                </form>
            </div>
        </div>
    </div>

<%@include file="footer.jsp"%>