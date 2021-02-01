<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/head.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
.form-control{
	padding: 20px;
	width: 300px;
	border-radius: 5px;
	top: 50%;
	left: 50%;
}
</style>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-2">
				</div>
				<div class="col-md-8">
					<form role="form" action="/jm/jm_updateContactRun" method="post">
					
						<div class="form-group">		 
							<label for="c_info">
								Q&A番号
							</label>
							<input type="text" class="form-control" id="c_info" name="c_info" value="${jmContactVo.c_info}" readonly/>
						</div>
						
						<div class="form-group">	 
							<label for="c_id">
								ID
							</label>
							<input type="text" class="form-control" id="c_id" name="c_id" value="${jmContactVo.c_id}" readonly/>
						</div>
						
						<div class="form-group">	 
							<label for="c_id">
								タイトル
							</label>
							<input type="text" class="form-control" id="c_subject" name="c_subject" value="${jmContactVo.c_subject}"/>
						</div>
						
						内容
						<div class="form-group">	 
							<label for="c_id">
							</label>
							<textarea rows="10" cols="50" id="c_contents" name="c_contents">${jmContactVo.c_contents}</textarea>
						</div>
						
						<button type="submit" class="btn btn-primary">
							修正完了
						</button>
					</form>
				</div>
				<div class="col-md-2">
				</div>
			</div>
		</div>
	</div>
</div>





<%@ include file="../include/foot.jsp"%>