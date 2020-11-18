addEventListener("load", function() {

    var section = document.querySelector("#s1");
    var startBtn = section.querySelector(".start-btn");
    var returnBtn = section.querySelector(".return-btn");
    var boxs = section.querySelectorAll(".box");

    var boxStyle = window.getComputedStyle(boxs[0]);
    boxs[0].style.top = boxStyle.getPropertyValue("top");
    boxs[0].style.left = boxStyle.getPropertyValue("left");

    startBtn.onclick = function() {


    };

    returnBtn.onclick = function() {


    };


});