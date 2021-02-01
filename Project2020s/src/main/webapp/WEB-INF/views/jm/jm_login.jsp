<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/head.jsp" %>

<script>
$(document).ready(function(){
	var msg = "${msg}";
	if(msg =="success"){
		alert("会員退会が完了しました。");
	}
});

</script>


<div class="container-fluid">
	<div class="row">
		<div class="col-md-3">
		</div>
		<div class="col-md-6">
			<form id="formIdPw" role="form" action="/jm/jm_login" method="post">
			
			<div class="text-center">
				<h3>ログイン</h3>
			</div>

				<div class="form-group">
					 
					<label for="u_id">
						ID <span class="text-danger">*</span>
					</label>
					<input type="text" class="form-control" id="u_id" name="u_id" required/>
				</div>
				
				<div class="form-group">
					 
					<label for="u_pw">
						パスワード <span class="text-danger">*</span>
					</label>
					<input type="password" class="form-control" id="u_pw" name="u_pw" required/>
				</div>
				
				<button type="submit" class="btn btn-danger">
					ログイン
				</button>
				<a type="button" class="btn btn-sm btn-warning" href="/jm/jm_signUp">会員登録</a>
				<a type="button" class="btn btn0sm btn-info" href="/jm/jm_userPw">パスワードを探す</a>
			</form>
		</div>
		<div class="col-md-3">
		</div>
	</div>
</div>








<%@ include file="../include/foot.jsp" %>