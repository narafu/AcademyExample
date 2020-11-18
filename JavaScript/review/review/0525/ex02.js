addEventListener("load", function () {

    var section = document.querySelector("#s4");
    var returnBtn = section.querySelector(".return-btn");
    var turnBtn = section.querySelector(".turn-btn");
    var boxs = section.querySelectorAll(".box");
    var index = 0;

    var boxStyle = window.getComputedStyle(boxs[0]);
    boxs[0].style.left = boxStyle.getPropertyValue("left");
    boxs[0].style.top = boxStyle.getPropertyValue("top");

    addEventListener("transitionstart", function () {

        boxs[0].lastElementChild.remove(".d-none");

    });

    addEventListener("transitionend", function () {


    });


    turnBtn.onclick = function () {

        // for (var i = 0; i < boxs.length; i++) {
        //     boxs[i].classList.remove(`pos${(i + index) % 3}`);
        //     boxs[i].classList.add(`pos${(i + index + 1) % 3}`);
        // };
        // index++;

        var translate = Math.random() * 500 - 250;
        var scale = Math.random() * 0.5 + 1
        boxs[0].style.transform = `translate(${translate}px) scale(${scale})`;


        // boxs[1].style.transform = `traslate(${Math.random() * 500 - 250}px) scale(${Math.random() * 0.5 + 1})`;

    };

    returnBtn.onclick = function () {

        boxs[1].style.top = "200px";
        boxs[1].style.left = "0px";
        boxs[1].style.transform = "tranlate(0px) scale(1)";

    };
});

addEventListener("load", function () {

    var section = document.querySelector("#s3");
    var turnBtn = section.querySelector(".turn-btn");
    var returnBtn = section.querySelector(".return-btn");
    var boxs = section.querySelectorAll(".box");

    for (var i = 0; i < boxs.length; i++) {
        var boxStyle = window.getComputedStyle(boxs[i]);
        boxs[i].style.top = boxStyle.getPropertyValue("top");
        boxs[i].style.left = boxStyle.getPropertyValue("left");
    };

    turnBtn.onclick = function () {

        for (var i = 0; i < boxs.length; i++) {
            var translate = Math.random() * 500 - 250;
            var scale = Math.random() * 0.5 + 1
            boxs[i].style.transform = `translate(${translate}px) scale(${scale})`;
        }
    };

    returnBtn.onclick = function () {

        for (var i = 0; i < boxs.length; i++) {
            boxs[i].style.top = 0;
            boxs[i].style.left = 0;
        };

    };

});

addEventListener("load", function () {

    var section = document.querySelector("#s2");
    var turnBtn = section.querySelector(".turn-btn");
    var boxs = section.querySelectorAll(".box");
    var index = 0;


    turnBtn.onclick = function () {

        for (var i = 0; i < boxs.length; i++) {
            var translate = Math.random() * 500 - 250;
            var scale = Math.random() * 0.5 + 1
            boxs[i].style.transform = `translate(${translate}px) scale(${scale})`;
        }
    };

});

addEventListener("load", function () {

    var section = document.querySelector("#s1");
    var turnBtn = section.querySelector(".turn-btn");
    var boxs = section.querySelectorAll(".box");
    var index = 0;


    turnBtn.onclick = function () {
        for (var i = 0; i < boxs.length; i++) {
            boxs[i].classList.remove(`pos${(i + index) % 3}`);
            boxs[i].classList.add(`pos${(i + 1 + index) % 3}`);
        }
        index++;
    };

});