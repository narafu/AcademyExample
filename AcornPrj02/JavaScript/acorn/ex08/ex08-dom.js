addEventListener("load", function () {

    var section = document.querySelector("#s1");
    var addButton = section.querySelector(".add-button");
    var delButton = section.querySelector(".del-button");
    var changeButton = section.querySelector(".change-button");
    var loadButton = section.querySelector(".load-button");
    var notices = [
        { id: 1, title: "hello", writerId: "good" },
        { id: 2, title: "hi~", writerId: "aaaa" },
        { id: 3, title: "good mor...", writerId: "..." }
    ];
    var table = section.querySelector("table");
    // var td = table.lastElementChild.lastElementChild.firstElementChild;

    loadButton.onclick = function () {

        var tbody = table.querySelector("tbody");

        // 1-3 복잡한 엘리먼트 노드 생성 

        for (var i = 0; i < notices.length; i++) {
            var tr = document.createElement("tr");
            tbody.appendChild(tr);
            var trContent =
                `
            <td>${notices[i].id}</td>
            <td>${notices[i].title}</td>
            <td>${notices[i].writerId}</td>
            `;
            tr.innerHTML = trContent;
        }
        //

        // var trString =
        //     `<tr>
        //     <td>${notices[0].id}</td>
        //     <td>${notices[0].title}</td>
        //     <td>${notices[0].writerId}</td>
        //     </tr>`;
        // tbody.innerHTML += trContent;

        /*
        var tr = document.createElement("tr");
        tbody.appendChild(tr);

        var tds = [
            document.createElement("td"),
            document.createElement("td"),
            document.createElement("td")
        ];
        tr.appendChild(tds[0]);
        tr.appendChild(tds[1]);
        tr.appendChild(tds[2]);

        tds[0].innerText = notices[0].id;
        tds[1].innerText = notices[0].title;
        tds[2].innerText = notices[0].writerId;
        */


        // 1-2 엘리먼트 노드 생성

        // var td = document.createElement("td");
        // tr.appendChild(td);

        /*
        tr.innerHTML +=  `<td>${notices[0].title}</td>`; 이처럼, innerHTML 사용하지 말 것
        tr.innerHTML =  `<td>${notices[0].title}</td>`; 이건 괜찮음
        */

        // 1-1. 텍스트 노드 생성

        /*
        var textNode = document.createTextNode(notices[0].title); // 메모리 상에 node 생성
        td.appendChild(textNode); // 기존 구조(관계)로 연결 - 부모에게
        */

        /*
        td.innerText = notices[0].title;  이처럼, innerText 사용하는 것 양호
        */

    };

    addButton.onclick = function () {
        alert(1);
    };

    delButton.onclick = function () {
        alert(2);
    };

    changeButton.onclick = function () {
        alert(3);
    };

})