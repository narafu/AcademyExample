addEventListener("load", function () {

    var notices = [

        { id: 2, title: "사자", regDate: "2020-05-21", writerId: "lion", hit: "83" },
        { id: 1, title: "호랑이", regDate: "2020-05-20", writerId: "tiger", hit: "123" }
    ];


    var section = document.querySelector("#s3");
    var cloneButton = section.querySelector(".clone-button");
    var templateButton = section.querySelector(".template-button");
    var noticeList = section.querySelector(".notice-list");
    var tbodyNode = noticeList.querySelector("tbody");
    var trNode = tbodyNode.querySelector("tr");

    cloneButton.onclick = function () {

        var cloneNode = trNode.cloneNode(true);
        var tds = cloneNode.querySelectorAll("td");
        tds[0].textContent = notices[0].id;
        tds[1].innerHTML = '<a href="">' + notices[0].title + '</a>';
        tds[2].textContent = notices[0].regDate;
        tds[3].textContent = notices[0].writerId;
        tds[4].textContent = notices[0].hit;

        tbodyNode.append(cloneNode);

    }

    templateButton.onclick = function () {

        var template = section.querySelector("template");

        var cloneNode = document.importNode(template.content, true);
        var tds = cloneNode.querySelectorAll("td");
        tds[0].textContent = notices[0].id;
        tds[1].innerHTML = '<a href="">' + notices[0].title + '</a>';
        tds[2].textContent = notices[0].regDate;
        tds[3].textContent = notices[0].writerId;
        tds[4].textContent = notices[0].hit;

        tbodyNode.append(cloneNode);

    }

});

addEventListener("load", function () {

    var section = document.querySelector("#s2");
    var titleInput = section.querySelector(".title-input");
    var menuListUl = section.querySelector(".menu-list");
    var addButton = section.querySelector(".add-button");
    var delButton = section.querySelector(".del-button");

    addButton.onclick = function () {

        /* [1]
        var txtNode = document.createTextNode(titleInput.value);
        menuListUl.appendChild(txtNode);
        */

        /* [2]
        var txtNode = document.createTextNode(titleInput.value);
        var liNode = document.createElement("li");
        var aNode = document.createElement("a");
        menuListUl.appendChild(liNode);
        liNode.appendChild(aNode);
        aNode.href="";
        aNode.appendChild(txtNode);
        */

        /* [3] 
        // menuListUl.innerHTML += '<li><a href="">' + titleInput.value + '</a></li>';
        

        /* [4] */
        var li = document.createElement("li");
        li.innerHTML = '<a href="">' + titleInput.value + '</a>';
        menuListUl.appendChild(li);


    }

    delButton.onclick = function () {

        /*
        var txtNode = menuListUl.childNodes[0];
        */

        /*
        var liNode = menuListUl.children[0];
        menuListUl.removeChild(liNode);
        */

        menuListUl.children[0].remove();

    }
});


addEventListener("load", function () {

    var section = document.querySelector("#s1");
    var colorInput = section.querySelector(".color-input");
    var btnInput = section.querySelector(".btn-input");
    var img = section.querySelector("img");
    var select = section.querySelector("select");

    btnInput.onclick = function () {

        img.style["border-color"] = colorInput.value;
        img.src = `../../../poster/${select.value}`;

    }

});


