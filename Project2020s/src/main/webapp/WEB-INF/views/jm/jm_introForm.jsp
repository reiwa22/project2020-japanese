<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/head.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
.form-inline{
	padding: 20px;
	width: 300px;
	border-radius: 5px;
	top: 25%;
	left: 25%;
}

</style>

<script>
$(function(){
	
	//表示数
	$("select[name=perPage]").change(function(){
		$("#frmPage>input[name=perPage]").val($(this).val());
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
		var searchType = $("select[name=searchType]").val();
		var keyword = $("#keyword").val();
		$("#frmPage>input[name=searchType]").val(searchType);
		$("#frmPage>input[name=keyword]").val(keyword);
		$("#frmPage").submit();
	});
	
	//現在ページアクティブ
	$("a.page-link").each(function(){
		var page = $(this).attr("href");
		if(page =="${jmPagingDto.page}"){
			$(this).parent().addClass("active");
			return;
		}
	});
});
</script>

<!-- ページリンク -->
<form id="frmPage" action="/jm/jm_introForm" method="get">
	<input type="hidden" name="i_info" value="${jmIntroVo.i_info}"/>
	<input type="hidden" name="page" value="${jmPagingDto.page}"/>
	<input type="hidden" name="perPage" value="${jmPagingDto.perPage}">
	<input type="hidden" name="searchType" value="${jmPagingDto.searchType}"/>
	<input type="hidden" name="keyword" value="${jmPagingDto.keyword}"/>
</form>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
		<c:if test="${sessionScope.u_grade=='gold'}">
			<a href="/jm/jm_insertIntroForm" class="btn btn-danger">文章作成</a>
		</c:if>
		
		<select class="form-inline" name="perPage">
			<c:forEach begin="5" end="20" step="5" var="j">
				<option value="${j}"
					<c:if test="${j==jmPagingDto.perPage}">selected</c:if>
				>${j}行ずつ見る</option>
			</c:forEach>
		</select>
		
		<select name="searchType" class="form-inline">
			<option value="i_subject"
				<c:if test="${jmPagingDto.searchType =='i_subject'}">selected</c:if>
			>タイトル</option>
			<option value="i_contry"
				<c:if test="${jmPagingDto.searchType =='i_contry'}">selected</c:if>
			>種類</option>
		</select>
		
		<input type="text" id="keyword" name="keyword" class="form-inline"
			value="${jmPagingDto.keyword}"/>
		<button type="button" id="btnSearch" class="btn btn-warning">検索</button>
		 
		
			<div class="row">
				<div class="col-md-2">
				</div>
				<div class="col-md-8">
					<table class="table">
						<thead>
							<tr>
								<th>
									番号
								</th>
								<th>
									掲示者
								</th>
								<th>
									タイトル
								</th>
								<th>
									作成時間
								</th>
								<th>
									種類
								</th>
								<th>
									イメージ
								</th>
								<th>
									アクセス数
								</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach items="${list}" var="jmIntroVo">
							<tr>
								<td>
									<a href="/jm/jm_introInfo/${jmIntroVo.i_info}" class="btn btn-sm btn-warning">
									${jmIntroVo.i_info}</a>
								</td>
								<td>
									${jmIntroVo.i_id}
								</td>
								<td>
									${jmIntroVo.i_subject}
								</td>
								<td>
									${jmIntroVo.i_time}
								</td>
								<td>
									${jmIntroVo.i_contry}
								</td>
								<td>
									<c:choose>
										<c:when test="${not empty jmIntroVo.i_file}">
											<img src="/jm/displayFile?fileName=${jmIntroVo.i_file}" >
										</c:when>
										<c:otherwise>
											<img src="/../../resources/images/noImage.jpg">
										</c:otherwise>
									</c:choose>
								</td>
								<td>
									${jmIntroVo.i_viewcnt}
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
						<c:forEach begin="${jmPagingDto.startPage}" end="${jmPagingDto.endPage}" var="s">
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





<%@ include file="../include/foot.jsp"%>