<%@ page import="com.newlecture.web.entity.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%--
	<h1 style="font-size: 50px; color: black; font-weight: bold;">${list[1]}</h1>
	<h1 style="font-size: 50px; color: red; font-weight: bold;">${n.title}</h1>
	<h1 style="font-size: 50px; color: blue; font-weight: bold;">${n["title"]}</h1>
	--%>
<%-- n 배열에서 title을 꺼낼 때, ${n.title} 또는 ${n["title"]} --%>

<!-- --------------------------- main --------------------------------------- -->

<main>

	<h2 class="main title">공지사항</h2>

	<div class="breadcrumb">
		<h3 class="hidden">breadlet</h3>
		<ul>
			<li>home</li>
			<li>고객센터</li>
			<li>공지사항</li>
		</ul>
	</div>

	<div class="margin-top first">
		<h3 class="hidden">공지사항 내용</h3>
		<table class="table">
			<tbody>
				<tr>
					<th>제목</th>
					<td class="text-align-left text-indent text-strong text-orange"
						colspan="3">${n["title"]}</td>

					<%-- <%=((Notice)request.getAttribute("n")).getTitle()%> --%>
					<!-- %{n.title} -> jasper -> n을 저장소에서 꺼내어 .title -> .getTitle() -->
					<!-- 속성처럼 사용하지만 getter 메소드 사용 -->

					<!-- 배열로 받아서 0번째 꺼낼 경우 -->
					<%-- <%=((Notice)request.getAttribute("n")).getTitle().get(0)%> --%>
					<%-- ${list[0]} --%>
				</tr>
				<tr>
					<th>작성일</th>
					<td class="text-align-left text-indent" colspan="3"><fmt:formatDate
							value="${n.regdate}" pattern="yyyy-MM-dd HH:mm:ss" /> <%-- <fmt:formatNumber value = "123456789" type = "currency" /> --%>
					</td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${n.writerId}</td>
					<th>조회수</th>
					<td>${n.hit}</td>
				</tr>
				<tr>
					<th>첨부파일</th>
					<td colspan="3"><c:forTokens var="fname"
							items="file1.zip, file2.gif" delims=",">
							<a href="">${fname}</a>
						</c:forTokens></td>
				</tr>
				<tr class="content">
					<td colspan="4">${n.content}</td>
				</tr>
			</tbody>
		</table>
	</div>

	<div class="margin-top text-align-center">
		<a class="btn btn-list" href="list">목록</a>
	</div>

	<div class="margin-top">
		<table class="table border-top-default">
			<tbody>

				<tr>
					<th>다음글</th>
					<td colspan="3" class="text-align-left text-indent">다음글이 없습니다.</td>
				</tr>

				<tr>
					<th>이전글</th>
					<td colspan="3" class="text-align-left text-indent"><a
						class="text-blue text-strong" href="">스프링 DI 예제 코드</a></td>
				</tr>

			</tbody>
		</table>
	</div>

</main>
