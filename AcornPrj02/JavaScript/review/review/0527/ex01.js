addEventListener("load", function () {

    var section = document.querySelector("#ex");
    var mainImg = section.querySelector(".main-img img");
    var subImgDiv = section.querySelector(".sub-img");
    var save;

    subImgDiv.onclick = function (e) {

        if (e.target.nodeName != "IMG") return;
        save = mainImg.src;
        mainImg.src = e.target.src;
        e.target.src = save;

    };

    subImgDiv.onmouseon = function (e) {

        if (e.target.nodeName != "IMG") return;

        console.log(`${e.clientX}px`);
        console.log(`${e.clientY}px`);
        console.log(e.target.nodeName);
        e.target.nodeName.style.left = `${e.clientX}px`;
        e.target.nodeName.style.top = `${e.clientY}px`;

    };

});