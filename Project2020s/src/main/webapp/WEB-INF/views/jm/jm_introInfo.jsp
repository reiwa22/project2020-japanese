<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/head.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
					<form role="form">
					
						<div class="form-group">	 
							<label for="i_info">
								文章番号
							</label>
							<input type="text" class="form-control" id="i_info" name="i_info" value="${jmIntroVo.i_info}" readonly />
						</div>
						
						<div class="form-group"> 
							<label for="i_id">
								ID
							</label>
							<input type="text" class="form-control" id="i_id" name="i_id" value="${jmIntroVo.i_id}" readonly/>
						</div>
						
						<div class="form-group"> 
							<label for="i_subject">
								タイトル
							</label>
							<input type="text" class="form-control" id="i_subject" name="i_subject" value="${jmIntroVo.i_subject}" readonly/>
						</div>
						
							内容
						<div class="form-group"> 
							<label for="i_contents">	
							</label>
							<textarea rows="10" cols="50" id="i_contents" name="i_contents" readonly>${jmIntroVo.i_contents}</textarea>
						</div>
						
						<div class="form-group"> 
							<label for="i_contry">
								種類
							</label>
							<input type="text" class="form-control" id="i_contry" name="i_contry" value="${jmIntroVo.i_contry}" readonly/>
						</div>
						
						<div class="form-group"> 
							<label for="r_files">
								紹介写真
							</label><br>
								<c:forEach items="${image}" var="fileName">
									<img src="/jm/displayFile?fileName=${fileName}"/>
								</c:forEach>
						</div>
						
						<a href="/jm/jm_introForm" class="btn btn-info">目録へ行く</a>
						<c:if test="${sessionScope.u_grade =='gold'}">
							<a href="/jm/jm_updateIntro/?i_info=${jmIntroVo.i_info}" class="btn btn-danger">修正する</a>
							<a href="/jm/jm_deleteIntro/${jmIntroVo.i_info}" class="btn btn-warning">削除する</a>
						</c:if>
					</form>
				</div>
				<div class="col-md-2">
				</div>
			</div>
		</div>
	</div>
</div>









<%@ include file="../include/foot.jsp"%>