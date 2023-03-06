
window.addEventListener("load", function () {

    // url : json String -> /notice/list-data, /api/notice/list

    var notices =
        [
            { id: 1, title: "hello", writerId: "newlec" },
            { id: 2, title: "hi~", writerId: "newlec" }
        ];

    var section = document.querySelector(".notice");
    var table = section.querySelector(".table");
    var pager = document.querySelector(".pager");
    var ul = pager.querySelector("ul");
    var nums = ul.querySelectorAll("a");
    var shield = new Shield(".main");

    ul.onclick = function (e) {

        e.preventDefault();
        if (e.target.nodeName != "A") return;

        var xhr = new XMLHttpRequest(); // xmlHttpRequest : callback 개념의 라이브러리
        var page = e.target.innerText;
        xhr.open('GET', 'list-data?p=' + page, true);
        // 비동기 옵션 : false(동기형) // 기다리면 동기, 다른데로 가면 비동기
        // 동기화된디는 것은 종속, 비동화된다는 것은 독립된다는 의미인듯.. 무전기(동기), 전화기(비동기)

        xhr.onload = function () {
            notices = JSON.parse(xhr.responseText);
            // bind();
            shield.hide();  // shield 수거
        };

        xhr.send(null);
        // xhr.send('string');
        // xhr.send(new Blob());
        // xhr.send(new Int8Array());
        // xhr.send(document);
        shield.show();

    };

    // for (var i = 0; i < nums.length; i++) {
    //     nums[i].onclick = function () {
    //         alert("clicked");
    //     };
    // };

    /* 데이터를 dom으로 출력하는 작업 */
    function bind() {
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

    // function bind() {
    //     tbody.innerHTML = "";
    //     for (var i in notices) {
    //         var tr = document.createElement("tr");
    //         tbody.appendChild(tr);
    //         var n = notices[i];
    //         var template = 
    //         `<td>${n.id}</td>
    //         <td class="title indent text-align-left"><a href="detail?id=${n.id}">${n.title}</a></td>
    //         <td>${n.writerId}</td>
    //         <td></td>
    //         <td></td>`;
    //         tr.innerHTML = template;
    //     };
    // };

});