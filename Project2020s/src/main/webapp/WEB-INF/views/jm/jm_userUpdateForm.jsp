<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/head.jsp"%>
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
	$("#u_pwCheck").click(function(){
		var u_pw = $("#u_pw").val();
		var u_pwCheck = $("#u_pw2").val();
		if(u_pw != u_pwCheck){
			$("#checkPwSpan").text("パスワードが一致しません。 再確認してください。");
		}else{
			$("#checkPwSpan").text("パスワードが一致しています。");		
		}		
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
					<form role="form" action="/jm/jm_updateUserByIdRun" method="post">
					
						<div class="form-group"> 
							<label for="u_id">
								ID
							</label>
							<input type="text" class="form-control" id="u_id" name="u_id"  value="${jmMemberVo.u_id}" readonly />
						</div>
						
						<div class="form-group">	 
							<label for="u_pw">
								パスワード
							</label>
							<input type="password" class="form-control" id="u_pw" name="u_pw" value="${jmMemberVo.u_pw }" required/>
						</div>
						
						<div class="form-group"> 
							<label for="u_pwCheck">
								パスワードの再確認
							</label>
							<input type="password" class="form-control" id="u_pw2" name="u_pw2"  required />
						</div>
							<button type="button" class="btn btn-sm btn-info" id="u_pwCheck">パスワードの確認</button>
							<span id="checkPwSpan"></span>
						
						<div class="form-group"> 
							<label for="u_name">
								名前
							</label>
							<input type="text" class="form-control"  id="u_name" name="u_name"  value="${jmMemberVo.u_name}" readonly />
						</div>
						
						<div class="form-group"> 
							<label for="u_gender">
								性別
							</label>
							<input type="text" class="form-control"  id="u_gender" name="u_gender"  value="${jmMemberVo.u_gender}" readonly />
						</div>
						
						<div class="form-group"> 
							<label for="u_email">
								メールアドレス
							</label>
							<input type="email" class="form-control"  id="u_email" name="u_email"  value="${jmMemberVo.u_email}" required />
						</div>
						
						<div class="form-group"> 
							<label for="u_address">
								住所
							</label>
							<input type="text" class="form-control"  id="u_address" name="u_address"  value="${jmMemberVo.u_address}" required />
						</div>
						
						<div class="form-group"> 
							<label for="u_phone">
								携帯番号
							</label>
							<input type="text" class="form-control"  id="u_phone" name="u_phone"  value="${jmMemberVo.u_phone}" required />
						</div>
						
						<button type="submit" class="btn btn-danger">
							個人情報修正する
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