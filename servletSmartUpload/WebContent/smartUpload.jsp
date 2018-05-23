<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传文件</title>
</head>
<body>
	<form action="servletSmartUpload" method="post" ENCTYPE="multipart/form-data">  
      <input type="file" name=file1" size="30"><Br>  
      <input type="file" name=file2" size="30"><Br>  
      <input type="file" name=file3" size="30"><Br>  
      <input type="file" name=file4" size="30"><Br>  
      <input type="submit" value="上传">  
    </form>  
</body>
</html>