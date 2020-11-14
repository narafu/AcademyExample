addEventListener("load", function () {

    var addListButton = document.querySelector(".add-list-button");
    var cancelListButton = document.querySelector(".cancle-list-button");
    var listAddForm = document.querySelector(".list-add-form");
    var listTitleInput = document.querySelector(".list-title-input");
    var contentBox = document.querySelector(".content-box");

    listAddForm.onsubmit = function (e) {

        e.preventDefault();

        var title = listTitleInput.value;
        if (title == "") {
            alert("제목을 입력하세요.");
            return;
        }

        var xhr = new XMLHttpRequest();
        xhr.open('post', 'reg', true);
        // xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhr.setRequestHeader("Content-type", "application/json");
        // 내가보내는 데이터 형식이 무엇인지 알려주는 것 - 이것이 없다면 데이터가 전송되어도 null로 받는다.
        // 전송할 데이터를 보내는 문자열 ex) urlencoding : t=?& ..

        var json = { "title": title, "regMemberId": "dino" };
        // var data = `t=${title}`;
        var data = JSON.stringify(json); /* 값을 JSON으로 변환 */
        xhr.send(data);

        xhr.onload = function () { /*XMLHttpRequest 처리 과정이 성공적으로 완료되면 발생한다.*/
            var result = JSON.parse(xhr.responseText);
            var formDiv = contentBox.lastElementChild;
            // 노드추가: appedchild / append
            // 노드삽입 : insertBefore / insertAdjacentElement / insertAdjacentHTML
            var template = `<div>
                                <section class="todo-list-box">
                                    <header>
                                        <h1>${result.title}</h1>
                                        <div>숨김버튼</div>
                                    </header>
                                        <div></div>
                                </section>
                            </div>`;
            formDiv.insertAdjacentHTML("beforebegin", template);
        };

    };

    addListButton.onclick = function (e) {

        e.preventDefault();
        // 1. 숨겨진 입력 박스를 띄우고, 라벨은 숨긴다.
        var spans = document.querySelectorAll(".list-add-form span");

        spans[0].classList.add("d-none");
        spans[1].classList.remove("d-none");

        // 2. 입력된 값을 등록하는 이벤트가 발생하면 서버로 전송한다.

        // 3. 새로 입력된 리스트 데이터를 받아서 화면을 갱신한다. 

    };

    cancelListButton.onclick = function (e) {

        var spans = document.querySelectorAll(".list-add-form span");

        spans[0].classList.remove("d-none");
        spans[1].classList.add("d-none");

    };

});