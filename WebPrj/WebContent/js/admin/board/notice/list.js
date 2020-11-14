
window.addEventListener("load", function () {

    var main = document.querySelector(".main");
    var aside = document.querySelector(".aside");
    var regButton = main.querySelector(".reg-button");
    var page = main.querySelector(".pager");
    var ul = page.querySelector("ul");

    regButton.onclick = function (e) {

        e.preventDefault();

        //부분 페이지 요청
        var xhr = new XMLHttpRequest();
        xhr.open('get', 'reg', true);

        xhr.onload = function () {
            main.remove();
            aside.insertAdjacentHTML("afterend", xhr.responseText.trim());
        };

        xhr.send(null);

    };

    var notices = [
        { id: 1, title: "hello", writerId: "newlec" },
        { id: 2, title: "hi~", writerId: "newlec" }
    ];

    ul.onclick = function (e) {

        e.preventDefault();
        if (e.target.nodeName != "A") return;

        var page = e.target.innerText;
        var shield = new Shield(".main");

        var xhr = new XMLHttpRequest();
        xhr.open('get', 'list-data?p=' + page, true);

        xhr.onload = function () {
            notices = JSON.parse(xhr.responseText);
            bind();
            shield.hide();
        };

        xhr.send(null);
        shield.show();

    };

    function bind() {
        var table = main.querySelector("table");
        var tbody = table.querySelector("tbody");
        var tbodyContent = "";
        for (var i in notices) {
            var n = notices[i];
            var template = `<tr>
                             <td>${n.id}</td>
                             <td class="title indent text-align-left"><a href="detail?id=${n.id}">${n.title}</a></td>
                             <td>${n.writerId}</td>
                             <td>
                             </td>
                             <td></td>
                        	</tr>`;
            tbodyContent = tbodyContent.concat(template);
        };
        tbody.innerHTML = tbodyContent;
    };


});