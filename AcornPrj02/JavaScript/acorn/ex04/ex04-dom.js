
addEventListener("load", function () {

    var section = document.querySelector("#s1");
    var boxs = section.querySelectorAll(".box");
    var rotateButton = section.querySelector(".rotate-button");
    var roatateIndex = 0;

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