<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<section class="notice-review">
	<h1 class="hidden">공지사항</h1>
	<div class="container">
		<div class="title">공지사항</div>

		<div class="container-table">

			<form action="update" method="post">
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
							<td>${n.writerId}</td>
						</tr>
						<tr>
							<th>제 목</th>
							<td><input type="text" name="title" value="${n.title}"></td>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td colspan="6"><textarea name="content" id="" cols="30"
									rows="10">${n.content}</textarea></td>
						</tr>
					</tbody>
				</table>

				<div class="bottom-btn">
					<input type="hidden" name="id" value="${n.id}">
					<button class="update-btn">수정</button>
					<button>취소</button>
				</div>
			</form>
		</div>

	</div>
</section>

<script>
	window.addEventListener("load", function() {

		var UpdateBtn = document.querySelector(".update-btn");

		UpdateBtn.onclick = function(e) {

			if (confirm("수정하시겠습니까?") == false) {
				e.preventDefault();
			} else {
				alert("수정하였습니다.");
			}
		}

	})
</script>