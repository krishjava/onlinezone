<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp"%>

                 <!--show all questions  -->
                  <h3 class="mt-2 text-center">All Question</h3>  
                  <div class="container">
                    <div class="row mt-2 ml-4 justify-content-center">
                    	<c:choose>
                    		<c:when test="${questionRows.size()>0 }">
                    			<c:forEach var="question" items="${questionRows }">
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
                    		</c:when>
                    		<c:when test="${questionRows.size()==0 }">
						            <div class="mb-2" style="padding: 2rem 1rem;    background-color: #e9ecef;">
						                <div class="text-center"> <h3>No Data Found</h3> </div>
						            </div>
                    		</c:when>
                    	</c:choose>
                    </div>
                     <div class="text-center">
                     <c:choose>
                     	<c:when test="${pageNumber<paginationButtons and (lastPage == paginationButtons or lastPage> paginationButtons) }">
                     		<c:forEach begin="1" end="${ paginationButtons}" varStatus="loop1">
                     				<c:choose>
                     					<c:when test="${loop1.index==pageNumber }">
                     						 <a href="${pageContext.request.contextPath}/onlinezone.com/question/page/${loop1.index}" class="btn btn-outline-dark active">${loop1.index}</a>
                     					</c:when>
                     					<c:when test="${loop1.index!=pageNumber }">
                     						 <a href="${pageContext.request.contextPath}/onlinezone.com/question/page/${loop1.index}" class="btn btn-outline-dark">${loop1.index}</a>
                     					</c:when>
                     				</c:choose>
                     		</c:forEach>
                     		
                     		<c:if test="${lastPage > paginationButtons }">
                     			<a href="${pageContext.request.contextPath}/onlinezone.com/question/page/${paginationButtons+1}" class="btn btn-outline-dark">&raquo;</a>
                     		</c:if>
                     	</c:when>
                     	
                     	<c:when test="${pageNumber >= paginationButtons and lastPage > paginationButtons }">
                     		
                     		<c:choose>
                     		
                     			<c:when test="${(pageNumber+half) >= lastPage }">
                     					  <a href="${pageContext.request.contextPath}/onlinezone.com/question/page/${lastPage-paginationButtons}" class="btn btn-outline-dark">&laquo;</a>
				                     		
				                     		<c:forEach begin="${(lastPage-paginationButtons)+1 }" end="${lastPage }" varStatus="loop2">
				                     			<c:choose>
				                     				<c:when test="${loop2.index==pageNumber }">
				                     					<a href="${pageContext.request.contextPath}/onlinezone.com/question/page/${loop2.index}" class="btn btn-outline-dark active">${loop2.index}</a>
				                     				</c:when>
				                     				<c:when test="${loop2.index!=pageNumber }">
				                     					<a href="${pageContext.request.contextPath}/onlinezone.com/question/page/${loop2.index}" class="btn btn-outline-dark">${loop2.index}</a>
				                     				</c:when>
				                     			</c:choose>
				                     		</c:forEach>
                     			</c:when>
                     				
                     			<c:when test="${(pageNumber+half) < lastPage }">
                     					
                     					<a href="${pageContext.request.contextPath}/onlinezone.com/question/page/${(pageNumber)-1}" class="btn btn-outline-dark">&laquo;</a>
                     					
                     					<c:forEach begin="${(pageNumber-half) }" end="${(pageNumber+half) }" varStatus="loop3">
				                     			<c:choose>
				                     				<c:when test="${loop3.index==pageNumber }">
				                     					<a href="${pageContext.request.contextPath}/onlinezone.com/question/page/${loop3.index}" class="btn btn-outline-dark active">${loop3.index}</a>
				                     				</c:when>
				                     				<c:when test="${loop3.index!=pageNumber }">
				                     					<a href="${pageContext.request.contextPath}/onlinezone.com/question/page/${loop3.index}" class="btn btn-outline-dark">${loop3.index}</a>
				                     				</c:when>
				                     			</c:choose>
				                     		</c:forEach>
                     					
                     					<a href="${pageContext.request.contextPath}/onlinezone.com/question/page/${(pageNumber)+1}" class="btn btn-outline-dark">&raquo;</a>
                     					
                     			</c:when>
                     			
                     		</c:choose>
                     	</c:when>
                     	
                     </c:choose>
                     
                    </div> 
                </div>



<%@include file="footer.jsp"%>