addEventListener("load", function () {

    var section = document.querySelector("#s1");
    var loadBtn = section.querySelector(".load-btn");
    var table = section.querySelector("table");
    var tbody = table.querySelector("tbody");
    var notices = [
        { no: "1", title: "오늘은..", content: "화요일입니다.", hit: "1241" },
        { no: "2", title: "어제는..", content: "월요일입니다.", hit: "365" },
        { no: "3", title: "내일은..", content: "수요일입니다.", hit: "5437" },
        { no: "4", title: "이번달은..", content: "5월입니다.", hit: "35" },
        { no: "5", title: "다음달은..", content: "6월입니다.", hit: "573" }
    ];

    loadBtn.onclick = function () {

        // for(var i=0; i<notices.length; i++){

        //     var trNode = document.createElement("tr");
        //     tbody.appendChild(trNode);

        //     trNode.innerHTML = `
        //     <td>${notices[i].no}</td>
        //     <td>${notices[i].title}</td>
        //     <td>${notices[i].content}</td>
        //     <td>${notices[i].hit}</td>
        //     `;
        // }

        /*
        var tr = document.createElement("tr");
        tbody.appendChild(tr);

        var tds = [
            document.createElement("td"),
            document.createElement("td"),
            document.createElement("td"),
            document.createElement("td")
        ];

        tr.appendChild(tds[0]);
        tr.appendChild(tds[1]);
        tr.appendChild(tds[2]);
        tr.appendChild(tds[3]);

        var td = table.querySelector("td");

        tds[0].innerText = 10;
        tds[1].innerText = "올해는";
        tds[2].innerText = "2020년입니다.";
        tds[3].innerText = 1239;
        */

        /* tr 만들고 */
        var trs = [
            document.createElement("tr"),
            document.createElement("tr"),
            document.createElement("tr"),
            document.createElement("tr")
        ];

        /* tr 붙이고 */
        for (var i = 0; i < trs.length; i++) {
            tbody.appendChild(trs[i]);
        };

        /* td 만들고 */
        /* tr마다 td 붙이고 */
        for (var i = 0; i < trs.length; i++) {
            var tds = [
                document.createElement("td"),
                document.createElement("td"),
                document.createElement("td"),
                document.createElement("td")
            ];
            for (var j = 0; j < tds.length; j++) {
                trs[i].appendChild(tds[j]);
            }
        }

        // trs[0].tds[0].innerText = notices[i].no;

        /* 텍스트 삽입 */
        for (var i = 0; i < trs.length; i++) {
            trs[i].tds[0].innerText = notices[i].no;
            trs[i].tds[1].innerText = notices[i].title;
            trs[i].tds[2].innerText = notices[i].content;
            trs[i].tds[3].innerText = notices[i].hit;
        }

    };
});