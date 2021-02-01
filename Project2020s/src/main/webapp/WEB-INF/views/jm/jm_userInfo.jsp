<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/head.jsp" %>

<style>
.form-control{
	padding: 20px;
	width: 300px;
	border-radius: 5px;
	top: 50%;
	left: 50%;
}
</style>

<script>
$(function(){
	$("#btnDelete").click(function(){
		alert("これまで本サイトをご利用いただきありがとうございます。");
	});
});
</script>

 <div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-2">
				</div>
				<div class="col-md-8">
					<form role="form">
					
						<div class="form-group">		 
							<label for="u_id">
								ID
							</label>
							<input type="text" class="form-control" value="${jmMemberVo.u_id}" readonly />
						</div>
						
						<div class="form-group">		 
							<label for="u_name">
								名前
							</label>
							<input type="text" class="form-control" value="${jmMemberVo.u_name}" readonly />
						</div>
						
						<div class="form-group">		 
							<label for="u_gender">
								性別
							</label>
							<input type="text" class="form-control" value="${jmMemberVo.u_gender}" readonly />
						</div>
						
						<div class="form-group">		 
							<label for="u_email">
								メールアドレス
							</label>
							<input type="email" class="form-control" value="${jmMemberVo.u_email}" readonly />
						</div>
						
						<div class="form-group">		 
							<label for="u_address">
								住所
							</label>
							<input type="text" class="form-control" value="${jmMemberVo.u_address}" readonly />
						</div>
						
						<div class="form-group">		 
							<label for="u_phone">
								携帯番号
							</label>
							<input type="text" class="form-control" value="${jmMemberVo.u_phone}" readonly />
						</div>
						
						<div class="form-group">		 
							<label for="u_grade">
								等級
							</label>
							<input type="text" class="form-control" value="${jmMemberVo.u_grade}" readonly />
						</div>				
						<a href="/jm/jm_userUpdateForm" class="btn btn-sm btn-danger">個人情報修正</a>
						<a href="/jm/jm_userInfoDelete?u_id=${jmMemberVo.u_id}" class="btn btn-sm btn-info" id="btnDelete">会員脱退</a>
					</form>
				</div>
				<div class="col-md-2">
				</div>
			</div>
		</div>
	</div>
</div>

<%@ include file="../include/foot.jsp"%>