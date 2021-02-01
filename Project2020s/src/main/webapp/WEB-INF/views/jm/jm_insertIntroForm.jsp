<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/head.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="/resources/js/jm_Script.js"></script>

<style>
.form-control{
	padding: 20px;
	width: 300px;
	border-radius: 5px;
	top: 50%;
	left: 50%;
}

#fileDrop{
	width: 40%;
	height: 12%;
	background-color: black;
	margin: auto;
	border: 1px dashed red;
	margin: 10px;
}
</style>

<script>
$(function(){
	$("#fileDrop").on("dragenter dragover",function(e){
		e.preventDefault();
	});
	$("#fileDrop").on("drop",function(e){
		e.preventDefault();
		var file = e.originalEvent.dataTransfer.files[0];
		var formData = new FormData();
		formData.append("file",file);
		var url ="/jm/jmUploadAjax";
		
		$.ajax({
			"processData" : false,
			"contentType" : false,
			"type" : "post",
			"url" : url,
			"data" : formData,
			"success" : function(rData){
				console.log(rData);
				
				var slashIndex = rData.lastIndexOf("-");
				var front = rData.substring(0,slashIndex+1);
				var rear = rData.substring(slashIndex+1);
				var thumbnailName = front +"jm"+rear;
				var originalName = rData.substring(rData.lastIndexOf("-")+1)
				var html = "<div data-filename='"+rData+"'>";
				var result = isImage(originalName);
				if(result ==true){
					html+="<img class ='img-tumbnail' src='/jm/displayFile?fileName="+thumbnailName+"'/>"
				}else{
					html+="<img class='img-tumbnail' src='/resources/images/noImage.jpg'/>"
				}
				html+="<spen>"+originalName+"<spen>"
				html+="<a href='"+rData+"'class='attach-del'><spen class=pull-right>[削除]<spen></a>"
				html+="</div>"
				$("#uploadList").append(html);								
			}
		});	
	});
	
	$("#uploadList").on("click",".attach-del",function(e){
		e.preventDefault();
		var that = $(this);
		var filename = $(this).attr("href");
		var url = "/jm/jmDeleteFile";
		var sendData = {"filename" : filename}
		$.get(url,sendData,function(){
			that.parent().parent().parent().remove();
		});
	});
	
	$("#insertIntroForm").submit(function(){
		var upDiv = $("#uploadList>div");
		if(upDiv.length == 0){
			alert("JPG or PNG or GIF の写真を添付してください。");
			return false;
		}
		upDiv.each(function(index){
			var filename = $(this).attr("data-filename");
			var slashIndex = filename.lastIndexOf("-");
			var front = filename.substring(0,slashIndex+1);
			var rear = filename.substring(slashIndex+1);
			var thumbnailName = front +"jm"+rear;
			var hiddenInput = "<input type='hidden' name='i_files["+index+"]' value='"+thumbnailName+"'/>";
			$("#insertIntroForm").prepend(hiddenInput);			
		});		
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
					<form role="form" id="insertIntroForm" action="/jm/jm_insertIntroRun" method="post">
					
						<div class="form-group">		 
							<label for="i_id">
							</label>
							<input type="hidden" class="form-control" id="i_id" name="i_id" value="${sessionScope.u_id}" readonly />
						</div>
						
						<div class="form-group">	 
							<label for="i_subject">
								タイトル
							</label>
							<input type="text" class="form-control" id="i_subject" name="i_subject" required/>
						</div>
						
							内容
						<div class="form-group">	 
							<label for="i_contents">		
							</label>
							<textarea rows="10" cols="50" id="i_contents" name="i_contents" required></textarea>
						</div>
						
						<div class="form-group">	 
							<label for="i_contry">
								種類
							</label>
							<select id="i_contry" name="i_contry">
								<option>国内版</option>
								<option>海外版</option>
							</select>
						</div>
						
						<div class="form-group">	 
							<label for="i_file">
								添付するファイルをドラッグしてください。
							</label>
							<div id="fileDrop"></div>
						</div>
						<div id="uploadList"></div>
						<div id="btnDiv"></div>
						
						<button type="submit" class="btn btn-info" id="btnbtn">
							作成完了	
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