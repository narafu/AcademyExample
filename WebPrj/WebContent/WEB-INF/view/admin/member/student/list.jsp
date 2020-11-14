<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<main class="main">
	<h2 class="main title">회원목록-[5]</h2>
	<div class="breadcrumb">
		<h3 class="hidden">breadlet</h3>
		<ul>
			<li>home</li>
			<li>회원관리</li>
			<li>학생회원</li>
		</ul>
	</div>
	<div class="search-form margin-top first align-right">
		<h3 class="hidden">회원 검색폼</h3>
		<form class="table-form">
			<fieldset>
				<legend class="hidden">회원 검색 필드</legend>
				<label class="hidden">검색분류</label> <select name="t">
					<option value="id">아이디</option>
					<option value="name">이름</option>
					<option value="phone">연락처</option>
				</select> <label class="hidden">검색어</label> <input type="text" name="q" /> <input
					class="btn btn-search" type="submit" value="검색" />
			</fieldset>
		</form>
	</div>
	<div class="margin-top">
		<h3 class="hidden">회원 목록</h3>
		<table id="member-table" class="table table-list">
			<thead>
				<tr>
					<th class="w100">이름(아이디)</th>
					<th class="">가입일</th>
					<th class="w100">연락처</th>
					<th class="w60">성별</th>
					<th class="w60">나이</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="list" items="${list}">
					<tr>
						<td>${list.name}(<a href="detail?id=24">${list.uid}</a>)
						</td>
						<td>${list.regDate}</td>
						<td>${list.phone}</td>
						<td>${list.gender}</td>
						<td>${list.age}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<c:set var="page" value="${empty param.p?1:param.p}" />
	<c:set var="startNum" value="${page-(page-1)%5}" />
	<c:set var="lastNum"
		value="${fn:substringBefore(Math.ceil(count/5),'.')}" />


	<div class="indexer text-align-right margin-top">
		<h3 class="hidden">현재 페이지</h3>
		<div>
			<span class="text-strong color-notice">${page}</span> / ${lastNum}
			pages
		</div>
	</div>

	<div class="text-align-right margin-top">
		<a class="btn-text btn-default" href="reg">학생추가</a>
	</div>

	<div class="text-align-center margin-top">
		<h3 class="hidden">페이저</h3>
		
		<div class="pager">

			<div>
				<c:if test="${startNum <= 1}">
					<span class="btn btn-prev" onclick="alert('이전 페이지가 없습니다.');">이전</span>
				</c:if>
				<c:if test="${1 < startNum}">
					<a class="btn btn-prev" href="?p=${startNum-5}&t=&q=">이전</a>
				</c:if>
			</div>

			<ul class="-list- center">
				<c:forEach var="i" begin="0" end="4">
					<c:if test="${startNum+i <= lastNum}">
						<li><a class="${startNum+i == page?'-text- orange bold':''}"
							href="?p=${startNum+i}&t=&q=">${startNum+i}</a></li>
					</c:if>
				</c:forEach>
			</ul>

			<div>
				<c:if test="${lastNum < startNum+5}">
					<span class="btn btn-next" onclick="alert('다음 페이지가 없습니다.');">다음</span>
				</c:if>
				<c:if test="${startNum+5 <= lastNum}">
					<a class="btn btn-next" href="?p=${startNum+5}&t=&q=">다음</a>
				</c:if>
			</div>

		</div>
	</div>

</main>