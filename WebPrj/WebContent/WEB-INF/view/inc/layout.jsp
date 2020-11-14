<%@page import="java.util.List"%>
<%@page import="com.newlecture.web.entity.NoticeView"%>
<%@page import="com.newlecture.web.service.NoticeService"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!DOCTYPE html>
<html>

<head>
<title>코딩 전문가를 만들기 위한 온라인 강의 시스템</title>
<meta charset="UTF-8">
<title>공지사항목록</title>

<link href="/css/customer/layout.css" type="text/css" rel="stylesheet" />
<link href='<tiles:getAsString name="css"/>' type="text/css"
	rel="stylesheet" />

<style>
#visual .content-container {
	height: inherit;
	display: flex;
	align-items: center;
	background: url("../../images/customer/visual.png") no-repeat center;
}
</style>
</head>

<body>

	<!-- header 부분 -->
	<tiles:insertAttribute name="header" />
	<%-- <jsp:include page="../inc/header.jsp" /> --%>

	<!-- --------------------------- <visual> --------------------------------------- -->
	<div id="visual">
		<div class="content-container"></div>
	</div>

	<!-- --------------------------- <body> --------------------------------------- -->
	<div id="body">
		<div class="content-container clearfix">
			<!-- --------------------------- aside --------------------------------------- -->
			<tiles:insertAttribute name="aside" />
			<!-- --------------------------- main --------------------------------------- -->
			<tiles:insertAttribute name="main" />
		</div>
	</div>

	<!-- ------------------- <footer> --------------------------------------- -->
	<tiles:insertAttribute name="footer" />
	<%-- <jsp:include page="../inc/footer.jsp" /> --%>

</body>

</html>