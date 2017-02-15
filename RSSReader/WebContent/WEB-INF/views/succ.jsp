<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RSS Tree</title>
</head>
<body>
<div style="width:1000px; margin-left: 100px;">
	<c:forEach var="list" items="${rsslist }" varStatus="status">
			<div id="title${status.index }">
				索引: <a>${status.index }</a>　
				标题: <a href='${list.getLink()}'>${list.getTitle()}</a>
			</div>
			<div id="content${status.index }" style="width:800px; margin-left: 100px;">
				标题简介：<br/> 
				<p>${list.getDescription().getValue()}</p>
			</div> 
	</c:forEach>
	<hr/>
</div>
</body>
</html>