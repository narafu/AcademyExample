<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<section class="notice-review">
	<h1 class="hidden">신고 관리</h1>
	<div class="container">
		<div class="title">신고 관리</div>

		<div class="container-table">

			<table class="notice-table">
				<thead>
					<tr>
						<th>No.</th>
						<td>${n.reportId}</td>
					</tr>
					<tr>
						<th>작성일</th>
						<td>${n.reportRegdate}</td>
					</tr>
					<tr>
						<th>작성자</th>
						<td>${n.reportNickname}</td>
					</tr>
					<tr>
						<th>제 목</th>
						<td>${n.reportTitle}</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td colspan="6"><textarea name="" id="" cols="30" rows="10">${n.reportContent}</textarea>
						</td>
					</tr>
					<tr>
						<th>신고대상(제목)</th>
						<td>${n.title}</td>
					</tr>
					<tr>
						<th>신고대상(작성자)</th>
						<td>${n.nickname}</td>
					</tr>
					<tr>
						<th>신고대상(내용)</th>
						<td>${n.content}</td>
					</tr>
				</tbody>
			</table>

			<div class="bottom-btn">
				<a href="list">
					<button>확인</button>
				</a>
			</div>
		</div>

	</div>
</section>