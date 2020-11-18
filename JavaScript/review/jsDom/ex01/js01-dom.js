
window.addEventListener("load", function () {

    var txtX = document.getElementById("txt-x");
    var txtY = document.getElementById("txt-y");
    var btnCal = document.getElementById("btn-cal");
    var txtResult = document.getElementById("txt-result");

    btnCal.onclick = function () {

        var x = parseInt(txtX.value);
        var y = parseInt(txtY.value);

        txtResult.value = x + y;

    };
});

function calMultiple() {
    var cal2 = document.querySelector(".cal-2");
    var index = cal2.querySelectorAll("input");
    index[3].value =
        parseInt(index[0].value) * parseInt(index[1].value);
};

window.addEventListener("load", function () {

    var section = document.querySelectorAll("section")[2];
    var index = section.querySelectorAll("input");

    index[3].onclick = function () {

        var x = index[0].value;
        var y = index[1].value;
        var z = index[2].value;

        index[4].value = (parseInt(x) + parseInt(y) + parseInt(z)) / 3
    }

});

window.addEventListener("load", function () {

    var colorChange = document.querySelector(".color-change");
    var input = colorChange.querySelectorAll("input");
    var div = colorChange.querySelector("div");

    input[0].onclick = function () {

        if (input[0].value = "C")
            input[0].value = "A";
    }
    input[1].onclick = function () {
        div.innerText = "Success";
    }
});

addEventListener("load", function () {

    var section = document.querySelector("#calculator");
    var x = section.querySelector("var-x");
    var y = section.querySelector("var-y");
    var result = section.querySelector(".result");
    var avg = section.querySelector(".avg");
    var plus = section.querySelector(".plus");

    plus.onclick = function () {
        result = parseInt(x.value) + parseInt(y.value);
    }
    avg.onclick = function () {
        result = parseInt(x.value) * parseInt(y.value) / 2;
    }

});
