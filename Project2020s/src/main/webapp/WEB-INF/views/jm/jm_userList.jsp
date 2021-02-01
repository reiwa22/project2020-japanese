<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/head.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<style>
.form-inline{
	padding: 20px;
	width: 300px;
	border-radius: 5px;
	top: 25%;
	left: 25%;
	margin: 25;
}

.btn-group{
	padding: -23px;
	width: 300px;
	border-radius: 5px;
	top: 25%;
	left: 25%;
	margin: -10;
}
</style>
<script>
$(function(){
	//数で照会
	$("select[name=perPage]").change(function(){
		console.log($(this).val());
		$("#frmPage > input[name=perPage]").val($(this).val());
	    $("#frmPage").submit();
	});

	//ページ番号
	$("a.page-link").click(function(e){
		e.preventDefault();
		var page = $(this).attr("href").trim();
		$("#frmPage >input[name=page]").val(page);
		$("#frmPage").submit();
	});
	
	//検索ボタン
	$("#btnSearch").click(function(){
		console.log("click");
		var searchType = $("#searchType").val();
		var keyword = $("#keyword").val();
		console.log(searchType);
		console.log(keyword);
		$("#frmPage >input[name=searchType]").val(searchType);
		$("#frmPage >input[name=keyword]").val(keyword);
		$("#frmPage").submit(); 
	});
	
	/* //現在ページアクティブ
	$("a.page-link").each(function(){
		var page = $(this).attr("href");
		if(page =="${jmPagingDto.page}"){
			$(this).parent().addclass("active");
			return;
		}
	});  */
});	
</script>


<form id ="frmPage" action="/jm/jm_userList" method="get">
	<input type="hidden" name="u_info" value="${jmMemberVo.u_info}">
	<input type="hidden" name="page" value="${jmPagingDto.page}">
	<input type="hidden" name="perPage" value="${jmPagingDto.perPage}">
	<input type="hidden" name="searchType" value="${jmPagingDto.searchType}">
	<input type="hidden" name="keyword" value="${jmPagingDto.keyword}"> 
</form>

<%-- <%@ include file="../include/jmManager.jsp"%> --%>

	<select name="perPage" class="form-inline">
		<c:forEach begin="5" end="15" step="5" var="i">
			<option value="${i}"
				<c:if test="${i==jmPagingDto.perPage}">selected</c:if>	
			>${i}行ずつ見る	
			</option>
		</c:forEach>
	</select>
	
	<select id="searchType" name="searchType" class="form-inline">
		<option value="u_id"	
		<c:if test="${jmPagingDto.searchType =='u_id'}">selected</c:if>
		>ID</option>
		<option value="u_grade"
		<c:if test="${jmPagingDto.searchType =='u_grade'}">selected</c:if>
		>等級</option>
	</select>
	
	<input type="text" id="keyword" name="keyword" class="form-inline"
		value="${jmPagingDto.keyword}"/>
	<button type="button" id="btnSearch" class="btn btn-info">検索</button>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-3">
				</div>
				<div class="col-md-6">
					<table class="table">
						<thead>
							<tr>
								<th>
									ID
								</th>
								<th>
									名前
								</th>
								<th>
									電子メール
								</th>
								<th>
									住所
								</th>
								<th>
									携帯番号
								</th>
								<th>
									性別
								</th>
								<th>
									等級
								</th>
								<th>
									修整
								</th>
								<th>
									削除
								</th>		
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${list}" var="jmMemberVo">
							<tr>
								<td>
									${jmMemberVo.u_id}
								</td>
								<td>
									${jmMemberVo.u_name}
								</td>
								<td>
									${jmMemberVo.u_email}
								</td>
								<td>
									${jmMemberVo.u_address}
								</td>
								<td>
									${jmMemberVo.u_phone}
								</td>
								<td>
									${jmMemberVo.u_gender}
								</td>
								<td>
									${jmMemberVo.u_grade}
								</td>
								<td>
									<a type="button" class="btn btn-sm btn-warning" href="/jm/jm_userUpdate?u_id=${jmMemberVo.u_id}">会員修正</a>
								</td>
								<td>
									<a type="button" class="btn btn-sm btn-danger" href="/jm/jm_userDelete?u_id=${jmMemberVo.u_id}">会員削除</a>
								</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="col-md-3">
				</div>
			</div>
		</div>
	</div>
</div>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-2">
				</div>
				<div class="col-md-8">
					<nav>
						<ul class="pagination">
						<c:if test="${jmPagingDto.startPage !=1}">
							<li class="page-item">
								<a class="page-link" href="${jmPagingDto.startPage-1}">«</a>
							</li>
							</c:if>
							<c:forEach begin="${jmPagingDto.startPage}" end="${jmPagingDto.endPage }" var="s">
							<li class="page-item">
								<a class="page-link" href="${s}">${s}</a>
							</li>
							</c:forEach>
							<c:if test="${jmPagingDto.endPage < jmPagingDto.totalPage}">
							<li class="page-item">
								<a class="page-link" href="${jmPagingDto.endPage+1}">»</a>
							</li>
							</c:if>
						</ul>
					</nav>
				</div>
				<div class="col-md-2">
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="../include/foot.jsp" %>