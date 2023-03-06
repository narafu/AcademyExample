
window.addEventListener("load", function () {

    var section = document.querySelector("#s1");
    var xInput = section.querySelector(".x-input");
    var yInput = section.querySelector(".y-input");

    var movButton = section.querySelector(".move-button");
    var colorInput = section.querySelector(".color-input");

    var boxs = section.querySelectorAll(".box");

    movButton.onclick = function () {

        boxs[0].style.left = xInput.value + "px";
        boxs[0].style.top = yInput.value + "px";
        boxs[0].style["background-color"] = colorInput.value;

    };

});

window.addEventListener("load", function () {

    var section = document.querySelector("#s2");
    var container = section.querySelector(".container");
    var box = container.querySelector(".box");
    var rangInput = section.querySelector(".range-input");
    var xInput = section.querySelector(".x-input");
    var widthInput = section.querySelector(".width-input");
    var rInput = section.querySelector(".r-input");
    var gInput = section.querySelector(".g-input");
    var bInput = section.querySelector(".b-input");

    rangInput.oninput = function () {

        if (xInput.checked)
            box.style["left"] = rangInput.value + "px";
        if (widthInput.checked) {
            box.style["width"] = (100 + parseInt(rangInput.value)) + "px";
        }

        var r = 0;
        var g = 0;
        var b = 0;

        if (rInput.checked)
            r = rangInput.value;
        else if (gInput.checked)
            g = rangInput.value;
        else if (bInput.checked)
            b = rangInput.value;

        box.style["background-color"] = `rgb(${r},${g},${b})`;


        // var radios = section.getElementsByClassName("color-input");
        // var selected = null;
        // for (var i in radios) {
        //     if (radios[i].checked)
        //         selected = radios[i].value;
        // }
        // console.log(selected);

        var selected = section.querySelector("input[type=radio]:checked");
        if (selected != null) {
            box.innerText = `${selected.value} : ${rangInput.value}`;
        }



    }

});
