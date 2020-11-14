<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<section class="notice-review">
	<h1 class="hidden">게시판 관리</h1>
	<div class="container">
		<div class="title">게시판 관리</div>

		<div class="container-table">

			<table class="notice-table">
				<thead>
					<tr>
						<th>No.</th>
						<td>${n.id}</td>
					</tr>
					<tr>
						<th>작성일</th>
						<td>${n.regdate}</td>
					</tr>
					<tr>
						<th>작성자</th>
						<td>${n.nickname}</td>
					</tr>
					<tr>
						<th>제 목</th>
						<td>${n.title}</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="6"><textarea name="" id="" cols="30" rows="10" readonly="readonly">${n.content}</textarea>
						</td>
					</tr>
				</tbody>
			</table>

			<div class="bottom-btn">
				<a href="list"><input type="button" value="확인"></a>
			</div>
		</div>

	</div>
</section>