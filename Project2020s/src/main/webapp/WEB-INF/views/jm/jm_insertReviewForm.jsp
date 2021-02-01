<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/head.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="/resources/js/jm_Script.js"></script>

<style>
.form-control{
padding: 20px;
width: 300px;
boarder-radius: 5px;
top: 50%;
left: 50%;
}

#fileDrop{
	width: 40%;
	height: 7%;
	background-color: pink;
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
		console.log(file);
		var formData = new FormData();
		formData.append("file",file);
		var url = "/jm/jmUploadAjax";
		
		 $.ajax({
			"processData" : false,
			"contentType" : false,
			"type" : "post",
			"url" : url,
			"data" : formData,
			"success" : function(rData){
				console.log(rData)

			     var slashIndex = rData.lastIndexOf("-");
				var front = rData.substring(0,slashIndex+1);
				var rear = rData.substring(slashIndex+1);
				var thumbnailName = front+"jm"+rear;
				var originalName = rData.substring(rData.lastIndexOf("-")+1);
				var html = "<div data-filename='"+rData+"'>";
				var result = isImage(originalName);
				
				if(result ==true){
					console.log(html);
					html+="<img class ='img-tumbnail' src='/jm/displayFile?fileName="+thumbnailName+"'/>"	
				}else{
					html+="<img class ='img-tumbnail' src='/resources/images/noImage.jpg'/>"
				}
				html+="<spen>"+originalName+"<spen>"
				html+="<a href='"+rData+"' class='attach-del'><spen class=pull-right>[削除]<spen></a>"
				html+="</div>"
				console.log(html);
				$("#uploadList").append(html); 
				  
			}	 
		});
	});
	
	$("#uploadList").on("click",".attach-del",function(e){
			e.preventDefault();
			var that = $(this);
			console.log("クリック");
		    var filename =$(this).attr("href");
			var url = "/jm/jmDeleteFile";
			var sendData = {"filename":filename}
			$.get(url,sendData,function(rData){
				console.log(rData);
				console.log(that);
				that.parent().parent().parent().remove(); 
				
			
			}); 
	});
	$("#insertReviewForm").submit(function(){
		var upDiv = $("#uploadList>div");
		if(upDiv.length ==0){
			alert("JPG or PNG or GIF のレビュー写真を添付してください。")
			return false;
		}
		upDiv.each(function(index){
			var filename = $(this).attr("data-filename");
			console.log("filename:"+filename);
			
			var slashIndex = filename.lastIndexOf("-");
			var front = filename.substring(0,slashIndex+1);
			var rear = filename.substring(slashIndex+1);
			var thumbnailName = front +"jm"+rear;
			var hiddenInput = "<input type='hidden' name='r_files["+index+"]' value='"+thumbnailName+"'/>";
			$("#insertReviewForm").prepend(hiddenInput);
		});
	});
});
</script>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="row">
				<div class="col-md-3">
				</div>
				<div class="col-md-6">
					<form id="insertReviewForm" role="form" action="/jm/jm_insertReviewRun" method="post">
						<div class="form-group">
							<label for="r_id">
							</label>
							<input type="hidden" class="form-control" id="r_id" name="r_id" value="${sessionScope.u_id}" readonly />
						</div>
						
						<div class="form-group">	 
							<label for="r_subject">
								タイトル<span class="text-danger">*</span>
							</label>
							<input type="text" class="form-control" id="r_subject" name="r_subject" required />
						</div>
						
						内容<span class="text-danger">*</span> 
						<div class="form-group">
							<label for="r_contents">	
							</label>
							<textarea rows="10" cols="50" id="r_contents" name="r_contents" required></textarea>
						</div>
						
						<div class="form-group">	 
							<label for="r_star">
								評点<span class="text-danger">*</span>
							</label>
							<input type="number" class="form-control" id="r_star" name="r_star" min="0" max="100" required />
						</div>
							
						<div class="form-group">	 
							<label for="r_file">
								添付するファイルをドラッグしてください。<span class="text-danger">*</span></label>
								<div id="fileDrop"></div>
						</div>	
						<div id="uploadList"></div>
						<div id="btnDiv"></div>
							
						<button id="btnbtn"  type="submit" class="btn btn-primary">
							作成完了
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