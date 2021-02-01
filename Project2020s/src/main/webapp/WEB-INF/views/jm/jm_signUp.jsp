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
	$("#btnUp").click(function(){
		console.log();
		var u_email = $("#u_email").val();
		$("#to").val(u_email);
		alert("会員登録中です");
	}); 
	
	$("#u_pwCheck").click(function(){
		console.log();
		var u_pw = $("#u_pw").val();
		var u_pwCheck = $("#u_pw2").val();
		
		if(u_pw != u_pwCheck){
			$("#checkPwSpan").text("パスワードが一致しません。 再確認してください。");
		}else{
			$("#checkPwSpan").text("パスワードが一致しています。");
		}
	});
	
	$("#u_idCheck").click(function(e){
		console.log(e);
		var u_id = $("#u_id").val();
		if(u_id ==""){
			$("#checkIdSpan").text("IDを入力してください。");
			return;
		}
		
		var sendData = {"u_id":u_id};
		var url ="/jm/jm_selectIdCheck"
		console.log(sendData);
		console.log(JSON.stringify(sendData));
		
		$.ajax({
			"type":"get",
			"url":url,
			"dataType":"text",
			"data":sendData,
			"headers":{
				"Content-Type": "application/json",
				"X-HTTP-Method-Override":"get"	
			},
			"success": function(rData){
				console.log(rData);
				
				if(rData=="success"){
					$("#checkIdSpan").text("重複しているIDです。");
					$("#btnUp").hide();
				}else{
					$("#checkIdSpan").text("使用可能なIDです。");
					$("#btnUp").show();
				}	
			},
		     error:function(request,status,error){
		     alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
		     }
		});	
	});	
});
</script>


<div class="container-fluid">
	<div class="row">
		<div class="col-md-3">
		</div>
		<div class="col-md-6">
			<form id="joinForm" role="form" action="/jm/jm_signUpRun" method="post">
				<div class="text-center">
					 <h3>会員登録</h3>
				</div>
				<div class="form-group">
					<label for="u_id">
						ID <span class="text-danger">*</span>
					</label>
					<input type="text" class="form-control" id="u_id" name="u_id"  required/>
				</div>
					<button type="button" class="btn btn-sm btn-info" id="u_idCheck">ID重複チェック</button>
						<span id="checkIdSpan"></span>
					
				<div class="form-group">
					 <label for="user_pw">
						パスワード<span class="text-danger">*</span>
					</label>
					<input type="password" class="form-control" id="u_pw" name="u_pw"  required/>
				</div>
				
				<div class="form-group">
					<label for ="u_pwCheck"> パスワードの再確認</label>	 
					<input type="password" class="form-control" id="u_pw2"   required/>
				</div>
					<button type="button" class="btn btn-sm btn-warning" id="u_pwCheck">パスワードの確認</button>
					 <span id="checkPwSpan"></span>
					 
				<div class="form-group">
					 <label for="u_name">
						名前<span class="text-danger">*</span>
					</label>
					<input type="text" class="form-control" id="u_name" name="u_name"  required/>
				</div>	 
				
				<div class="form-group">
					 <label for="u_gender">
						性別
					</label>
					<select id="u_gender" name="u_gender">
						<option>男</option>
						<option selected>女</option>
					</select>
				</div>
				
				<div class="form-group">
					 <label for="u_email">
						メールアドレス<span class="text-danger">*</span>
					</label>
					<input type="email" class="form-control" id="u_email" name="u_email"  required/>
				</div>
				
				<div class="form-group">
					 <label for="u_address">
						住所<span class="text-danger">*</span>
					</label>
					<input type="text" class="form-control" id="u_address" name="u_address"  required/>
				</div>	
				
				<div class="form-group">
					 <label for="u_phone">
						携帯番号<span class="text-danger">*</span>
					</label>
					<input type="text" class="form-control" id="u_phone" name="u_phone"  required/>
				</div>	  	 
					 
				 <div class="form-group">
					 <label for="to">
					 	<!--発信者メールアドレス-->
					</label>
					<input type="hidden" class="form-control" id="to" name="to"/>
				</div>
				
				<div class="form-group">
					 <label for="subject">
					 	<!--メールタイトル -->
					</label>
					<input type="hidden" class="form-control" id="subject" name="subject" value="会員登録おめでとうございます。"/>
				</div>	 	
				
				<div class="form-group">
					 <label for="contents">
					 	<!--メール内容 -->
					</label>
					<input type="hidden" class="form-control" id="contents" name="contents" value="会員登録おめでとうございます。 楽しくご利用して下さい。"/>
				</div>	 	  
				
				規約確認
				<select>
				<option>非同意</option>
				<option>同意</option>
				</select>
				
				<button type="button" class="btn btn-danger" id="btnOk" name="btnOk">
				規約確認
				</button><br>
					
				<button type="submit" class="btn btn-primary" id="btnUp">
					登録する
				</button>
			</form>
		</div>
		<div class="col-md-3">
		</div>
	</div>
</div>












<%@ include file="../include/foot.jsp" %>