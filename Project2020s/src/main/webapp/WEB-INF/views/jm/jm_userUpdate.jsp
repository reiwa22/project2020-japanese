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

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-3">
				</div>
				<div class="col-md-6">
					<form id="jm_userUpdate" role="form" action="jm_userUpdateRun" method="post">
						<div class="form-group">
							<label for="u_id">
								ID
							</label>
							<input type="text" class="form-control" id="u_id" name="u_id" value="${jmMemberVo.u_id }"  readonly/>
						</div>
						
						<div class="form-group">
						 	<label for="u_name">
								お名前
							</label>
							<input type="text" class="form-control" id="u_name" name="u_name" value="${jmMemberVo.u_name}" required/>
						</div>
						
						<div class="form-group">
						 	<label for="u_gender">
								性別
							</label>
							<select name="u_gender" id="u_gender">
								<option>女</option>
								<option>男</option>
							</select>
						</div>
						
						<div class="form-group">
						 	<label for="u_email">
								電子メール
							</label>
							<input type="email" class="form-control" id="u_email" name="u_email" value="${jmMemberVo.u_email}" required/>
						</div>
						
						<div class="form-group">
						 	<label for="u_address">
								住所
							</label>
							<input type="text" class="form-control" id="u_address" name="u_address" value="${jmMemberVo.u_address}" required/>
						</div>
						
						<div class="form-group">
						 	<label for="u_phone">
								携帯番号
							</label>
							<input type="text" class="form-control" id="u_phone" name="u_phone" value="${jmMemberVo.u_phone}" required/>
						</div>
						
						<div class="form-group">
						 	<label for="u_grade">
								等級
							</label>
							<select name="u_grade" id="u_grade">
								<option>bronze</option>
								<option>silver</option>
								<option>gold</option>
							
							</select>
						</div>
						
						<button type="submit" class="btn btn-primary">
							修正完了
						</button>
					</form>
				</div>
				<div class="col-md-3">
				</div>
			</div>
		</div>
	</div>
</div>










<%@ include file="../include/foot.jsp"%>