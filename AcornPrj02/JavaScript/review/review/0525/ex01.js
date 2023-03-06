addEventListener("load", function () {

    var section = document.querySelector("#s1");
    var rotateBtn1 = section.querySelector("input[name=rotate-btn-1]");
    var rotateBtn2 = section.querySelector("input[name=rotate-btn-2]");
    var centerBtn = section.querySelector("input[name=center-btn]");
    var returnBtn = section.querySelector("input[name=return-btn]");
    var changeBtn = section.querySelector("input[name=change-btn]");
    var boxs = section.querySelectorAll(".box");
    var Boxs = section.querySelectorAll(".Box");
    var index1 = 0;
    var index2 = 0;
    var index3 = 0;

    rotateBtn1.onclick = function () {

        for (var i = 0; i < boxs.length; i++) {
            boxs[i].classList.remove(`pos${(i + index1) % 4}`);
            boxs[i].classList.add(`pos${(i + 1 + index1) % 4}`);
        };
        index1++;
    };

    rotateBtn2.onclick = function () {

        for (var i = 0; i < Boxs.length; i++) {
            Boxs[i].classList.remove(`Pos${(i + index2) % 4}`);
            Boxs[i].classList.add(`Pos${(i + 1 + index2) % 4}`);
        }
        index2++;
    };

    centerBtn.onclick = function () {

        for (var i = 0; i < boxs.length; i++) {
            boxs[i].classList.remove(`pos${i})`);
            boxs[i].classList.add("center");
        };

        for (var i = 0; i < Boxs.length; i++) {
            Boxs[i].classList.remove(`pos${i}`);
            Boxs[i].classList.add("center");
        };

    };

    returnBtn.onclick = function () {

        for (var i = 0; i < boxs.length; i++) {
            boxs[i].classList.remove("center");
            boxs[i].classList.add(`pos${i + 1})`);
        };

        for (var i = 0; i < Boxs.length; i++) {
            Boxs[i].classList.remove("center");
            Boxs[i].classList.add(`pos${i + 1}`);
        };

    };

    changeBtn.onclick = function () {

        for (var i = 0; i < boxs.length; i++) {
            boxs[i].classList.remove(`pos${(i + index3) % 4}`);
            boxs[i].classList.add(`Pos${(i + index3) % 4}`);
        };

        for (var i = 0; i < Boxs.length; i++) {
            Boxs[i].classList.remove(`Pos${(i + index3) % 4}`);
            Boxs[i].classList.add(`pos${(i + 1 + index3) % 4}`);
        };
        index3++;
    }

});