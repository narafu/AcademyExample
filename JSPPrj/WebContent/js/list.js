window.addEventListener("load", function () {

	var section = document.querySelector(".main");
	var pagerUl = section.querySelector(".pager ul");

	pagerUl.onclick = function (e) {

		e.preventDefault();
		if (e.target.nodeName != "A") return;

		var xhr = new XMLHttpRequest();
		xhr.open('get', 'notice/list-data?p=' + e.target.innerText, true);
		xhr.send();
		xhr.onload = function () {
			var notices = JSON.parse(xhr.responseText);
			bind();
		}

	}

	function bind() {

		var tbody = table.querySelector("tbody");
		tbody.innerHTML = "";

		for (var i in notices) {

			var tr = document.createElement("tr");
			tbody.append(tr);

			var template =
				`<td>${notices[i].id}</td>
				<td class="title indent text-align-left"><a
					href="detail?id=${notices[i].id}">${notices[i].title}</a> <span>[${n.cmtCount}]</span>
				</td>
				<td>${notices[i].writerId}</td>
				<td><fmt: formatDate pattern="yyyy-MM-dd"
											value="${notices[i].regdate}" /></td>
				<td>${notices[i].hit}</td>`;

			tr.innerHTML = template;

		}
	}
})