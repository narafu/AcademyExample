
addEventListener("load", function () {

    var section = document.querySelector("#s1");
    var boxs = section.querySelectorAll(".box");
    var rotateButton = section.querySelector(".rotate-button");
    var gobackButton = section.querySelector(".goback-button");
    var description = section.querySelectorAll(".description");

    // 초기화
    var boxStyle = window.getComputedStyle(boxs[0]);
    boxs[0].style.left = boxStyle.getPropertyValue("left");
    boxs[0].style.top = boxStyle.getPropertyValue("top");

    boxs[0].addEventListener("transitionstart", function () {
        console.log("start");
        // description[0].classList.add("d-none");
        // boxs[0].lastElementChild.classList.add("d-none");
        boxs[0].lastElementChild.classList.add("slide-up");
        // boxs[0].lastElementChild.classList.remove("slide-up");
    })

    boxs[0].addEventListener("transitionend", function () {
        console.log("end");
        // description[0].classList.remove("d-none");
        // boxs[0].lastElementChild.classList.remove("d-none");
        // boxs[0].lastElementChild.classList.add("slide-up");
        // boxs[0].lastElementChild.classList.remove("slide-up");
    });

    rotateButton.onclick = function () {

        var transitionX = Math.random() * 500 - 250;
        /* -250~250; 범위값 곱하고 최소값 더한다. */
        var scale = Math.random() * 0.5 + 1;
        boxs[0].style.transform = `translate(${transitionX}px) scale(${scale})`;
    }

    gobackButton.onclick = function () {

        // 목적지 설정
        boxs[0].style.left = "0px";
        boxs[0].style.top = "0px";
        boxs[0].style.transform = 'translate(0px) scale(1)';
    }

});