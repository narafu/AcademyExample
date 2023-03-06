addEventListener("load", function () {

    var section = document.querySelector("#maker");
    var menu = section.querySelectorAll("#menu");

    var mainSelect = section.querySelector("select[name=main]");

    var borderSelect = section.querySelector("select[name=border]");
    var wRange = section.querySelector(".border-menu .w-range");
    var rRange = section.querySelector(".border-menu .r-range");
    var cBtn = section.querySelector(".border-menu .c-btn");

    var rotateRange = section.querySelector(".transform-menu .rotate-range");
    var scaleRange = section.querySelector(".transform-menu .scale-range");
    var skewRange = section.querySelector(".transform-menu .skew-range");
    var transRange = section.querySelector(".transform-menu .translate-range");

    var hRange = section.querySelector(".boxshadow-menu .h-range");
    var vRange = section.querySelector(".boxshadow-menu .v-range");
    var blurRange = section.querySelector(".boxshadow-menu .blur-range");
    var color = section.querySelector(".boxshadow-menu .color");

    var redRange = section.querySelector(".rgba-menu .red-range");
    var greenRange = section.querySelector(".rgba-menu .green-range");
    var blueRange = section.querySelector(".rgba-menu .blue-range");
    var opacityRange = section.querySelector(".rgba-menu .opacity-range");

    var view = section.querySelector(".content-preview");

    mainSelect.onclick = function () {

        for (var i = 0; i < menu.length; i++) {
            if (mainSelect.value == menu[i].className) {
                menu[i].style["display"] = "block";
            }
        };

        for (var i = 0; i < menu.length; i++) {
            if (mainSelect.value != menu[i].className) {
                menu[i].style["display"] = "none";
            }
        };

    };

    borderSelect.onchange = function () {
        view.style.border = borderSelect.value;
    };

    wRange.oninput = function () {
        view.style["border-width"] = `${wRange.value}px`;
    };

    rRange.oninput = function () {
        view.style["border-radius"] = `${rRange.value}px`;
    };

    cBtn.onchange = function () {
        view.style["border-color"] = cBtn.value;
    }


    rotateRange.oninput = function () {
        view.style["transform"] = `rotate(${rotateRange.value}deg)`;
    }
    scaleRange.oninput = function () {
        view.style["transform"] = `scale(${scaleRange.value})`;
    }
    skewRange.oninput = function () {
        view.style["transform"] = `skew(${skewRange.value}deg)`;
    }
    transRange.oninput = function () {
        view.style["transform"] = `translate(${transRange.value}px)`;
    }


    redRange.oninput = function () {
        view.style["background-color"] = `rgba(${redRange.value}, ${greenRange.value}, ${blueRange.value}, ${opacityRange.value})`;
    }
    greenRange.oninput = function () {
        view.style["background-color"] = `rgba(${redRange.value}, ${greenRange.value}, ${blueRange.value}, ${opacityRange.value})`;
    }
    blueRange.oninput = function () {
        view.style["background-color"] = `rgba(${redRange.value}, ${greenRange.value}, ${blueRange.value}, ${opacityRange.value})`;
    }
    opacityRange.oninput = function () {
        view.style["background-color"] = `rgba(${redRange.value}, ${greenRange.value}, ${blueRange.value}, ${opacityRange.value})`;
    }

});