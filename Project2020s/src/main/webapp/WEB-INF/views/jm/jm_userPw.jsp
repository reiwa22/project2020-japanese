<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/head.jsp" %>
<style>
.form-contol{

padding: 20px;
width: 300px;
border-radius: 5px;
top: 50%;
left: 50%; 
}
</style>

<script>
$(function(){
	$("#btnOk").click(function(e){
		console.log(e);
		
		var u_id = $("#u_id").val();
		console.log(u_id);
		
		var url ="/jm/jm_userPwEmail";
		sendData = {"u_id":u_id};
		
		$.get(url,sendData,function(rData){
			console.log(rData);
			
			var email = rData.u_email;
			var pw = rData.u_pw;
			
			$("#to").val(email);
			$("#contents").val("パスワードは" +pw+"となります。")		
		});
	});
});

</script>


<div class="container-fluid">
	<div class="row">
		<div class="col-md-3">
		</div>
		<div class="col-md-6">
			<form  id="mailFrom" role="form" action="/email/sendPwMail" method="post">
				<div class="form-group">
					<label for="u_id">
						ID
					</label>
					<input type="text" class="form-control" id="u_id" name="u_id" placeholder="IDを入力してください。" />
				</div>
				<button type="button" class="btn btn-warning" id="btnOk">
					確認
				</button>
				
				<div class="form-group"> 
					<label for="to">
						メールアドレス
					</label>
					<input type="email" class="form-control" id="to" name="to" readonly />
				</div>
				
				<div class="form-group">
					<label for="contents">
					</label>
					<input type="hidden" class="form-control" id="contents" name="contents" />
				</div>
				
				<div class="form-group"> 
					<label for="subject">
					</label>
					<input type="hidden" class="form-control" id="subject" name="subject" value="パスワード確認メールです。" />
				</div>
				
				
				<button type="submit" class="btn btn-info" id="btnEmail" name="btnEmail">
					送る
				</button>
			</form>
		</div>
		<div class="col-md-3">
		</div>
	</div>
</div>










<%@ include file="../include/foot.jsp" %>
