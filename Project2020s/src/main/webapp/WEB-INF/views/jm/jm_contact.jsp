<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/head.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
.form-inline{
	padding: 20px;
	width: 300px;
	border-radius: 5px;
	top: 25%;
	left: 25%;
	margin: 25;
}
</style>

<script>
$(function(){
	
	//表示数
	$("select[name=perPage]").change(function(){
		$("#frmPage >input[name=perPage]").val($(this).val());
		$("#frmPage").submit();
	});
	
	//ページ番号
	$("a.page-link").click(function(e){
		e.preventDefault();
		var page = $(this).attr("href").trim();
		$("#frmPage>input[name=page]").val(page);
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
});
</script>

<!-- ページリンク -->
	<form id="frmPage" action="/jm/jm_contact" method="get">
		<input type="hidden" name="c_info" value="${jmContactVo.c_info}">
		<input type="hidden" name="page" value="${jmPagingDto.page}">
		<input type="hidden" name="perPage" value="${jmPagingDto.perPage}">
		<input type="hidden" name="searchType" value="${jmPagingDto.searchType}">
		<input type="hidden" name="keyword" value="${jmPagingDto.keyword}">  
	</form>
	
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-2">
				</div>
				<div class="col-md-8">
					<c:choose>
						<c:when test="${not empty sessionScope.u_id}">
							<a href="/jm/jm_insertContactForm" class="btn btn-info">問い合わせる</a>
						</c:when>
						<c:otherwise>
							<a href="/jm/jm_login" class="btn btn-danger">商品に関するお問い合わせはログイン時に可能</a>
						</c:otherwise>
					</c:choose>
				
				<select class="form-inline" name="perPage">
					<c:forEach begin="5" end="15" step="5" var="i">
						<option value="${i}"
							<c:if test="${i==jmPagingDto.perPage}">selected</c:if>
						>${i}行ずつ見る</option>	
					</c:forEach>
				</select>
				
				<select id="searchType" name="searchType" class="form-inline">
				<option value="c_subject"
					<c:if test="${jmPagingDto.searchType =='c_subject'}">selected</c:if>
				>タイトル</option>
				<option value="c_id"
					<c:if test="${jmPagingDto.searchType =='c_id'}">selected</c:if>
				>ID</option>
				</select>
				
				<input type="text" id="keyword" name="keyword" class="form-inline" />
				<button type="button" id="btnSearch" class="btn btn-danger">検索</button>
				
					<table class="table">
						<thead>
							<tr>
								<th>
									問い合わせ番号[内容を見る]
								</th>
								<th>
									ID
								</th>
								<th>
									タイトル
								</th>
								<th>
									時間
								</th>
								<th>
									アクサス数
								</th>
								<th>
									等級
								</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${list}" var="jmContactVo">
							<tr class="table">
								<td>
									<a href="/jm/jm_contactInfo/${jmContactVo.c_info}" class="contact_rirle btn btn-sm btn-danger">${jmContactVo.c_info}</a>
								</td>
								<td>
									${jmContactVo.c_id}
								</td>
								<td>
									${jmContactVo.c_subject}
								</td>
								<td>
									${jmContactVo.c_time}
								</td>
								<td>
									${jmContactVo.c_viewcnt}
								</td>
								<td>
									<c:choose>
										<c:when test="${sessionScope.u_grade !='gold'}">
											一般会員
										</c:when>
										<c:otherwise>
											<a href="/jm/jm_contactManagerInsert/${jmContactVo.c_info}" type="button" class="btn btn-sm btn-info">管理者-コメントを書き込む</a>
											<a href="/jm/jm_deleteContact/${jmContactVo.c_info}" type="button" class="btn btn-sm btn-info">管理者-書き込み削除</a>
										</c:otherwise>
									</c:choose>
								</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="col-md-2">
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
							<!-- ページナンバリング -->
							<c:forEach begin="${jmPagingDto.startPage}" end="${jmPagingDto.endPage}" var="g">
							<li class="page-item">
								<a class="page-link" href="${g}">${g}</a>
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