<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/head.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
.form-control{
	padding: 20px;
	width: 300px;
	border-radius: 5px;
	top: 50%;
	left: 50%
}
</style>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-2">
				</div>
				<div class="col-md-8">
					<form role="form" action="/jm/jm_contactManagerInsertRun" method="post">
					
						<div class="form-group">		 
							<label for="c_id">	
							</label>
							<input type="hidden" class="form-control" id="c_id" name="c_id"  value="${sessionScope.u_id}" readonly />
						</div>
						
						<div class="form-group">		 
							<label for="c_originnum">	
							</label>
							<input type="hidden" class="form-control" id="c_originnum" name="c_originnum"  value="${origin}" readonly />
						</div>
						
						<div class="form-group">		 
							<label for="c_subject">
								タイトル<span class="text-danger">*</span>	
							</label>
							<input type="text" class="form-control" id="c_subject" name="c_subject"  value="  ___Re:"/>
						</div>
						
						内容<span class="text-danger">*</span>	
						<div class="form-group">		 
							<label for="c_subject">
							</label>
							<textarea rows="10" cols="50" id="c_contents" name="c_contents" required></textarea>
						</div>
						<button type="submit" class="btn btn-primary">
							作成完了
						</button>
					</form>
				</div>
				<div class="col-md-2">
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="../include/foot.jsp" %>
