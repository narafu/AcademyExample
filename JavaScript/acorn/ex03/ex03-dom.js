
addEventListener("load", function () {

    var section = document.querySelector("#s1");
    var boxs = section.querySelectorAll(".box");

    var startButton = section.querySelector(".start-button");
    var rotateButton = section.querySelector(".rotate-button");
    // var startButton = section.querySelector("input[name=start-button]");
    // var rotateButton = section.querySelector("input[name=rotate-button]");
    var roatateIndex = 0;

    startButton.onclick = function () {

        for (var i = 0; i < boxs.length; i++) {
            boxs[i].classList.add(`pos${i}`);
        }

    };

    rotateButton.onclick = function () {

        for (var i = 0; i < boxs.length; i++) {
            var removeIndex = (i + roatateIndex) % 3;
            var addIndex = (i + roatateIndex + 1) % 3;
            boxs[i].classList.remove(`pos${removeIndex}`);
            boxs[i].classList.add(`pos${addIndex}`);
        }
        roatateIndex++;
    }

});