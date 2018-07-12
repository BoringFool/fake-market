<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
	<!-- 该form用来上传文件-->
	<form action="<%=request.getContextPath()%>/user/upload"
		enctype="multipart/form-data" name="fileUploadForm" method="post">
		<input type="file" name="docFile" id="docFile" style="display: none;"
			onchange="document.fileUploadForm.filePath.value=this.value" /> <input
			type="text" name="filePath" id="filePath" /> <input type="button"
			value="Brows" onclick="document.fileUploadForm.docFile.click()" /><br>
		<input type="submit" value="提交" />
	</form>
</body>
</html>