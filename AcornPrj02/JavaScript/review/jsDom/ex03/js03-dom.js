
addEventListener("load", function () {

    var section = document.querySelector("#s1");

    var rangeInputSize = section.querySelector(".size");
    var rangeInputColor = section.querySelector(".color");

    var widthInput = section.querySelector(".width-input");
    var heightInput = section.querySelector(".height-input");
    var redInput = section.querySelector(".red-input");
    var greenInput = section.querySelector(".green-input");
    var blueInput = section.querySelector(".blue-input");

    var box = section.querySelector(".box");

    rangeInputSize.oninput = function () {

        // width & height
        if (widthInput.checked)
            box.style["width"] = `${rangeInputSize.value}px`;
        if (heightInput.checked)
            box.style["height"] = `${rangeInputSize.value}px`;

    }

    rangeInputColor.oninput = function () {

        var red = 0;
        var green = 0;
        var blue = 0;

        // RGB
        if (redInput.checked)
            red = rangeInputColor.value;
        if (greenInput.checked)
            green = rangeInputColor.value;
        if (blueInput.checked)
            blue = rangeInputColor.value;
        box.style["background-color"] = `rgb(${red},${green},${blue})`;

    }

});