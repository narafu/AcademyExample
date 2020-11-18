
window.addEventListener("load", function () {

    var section = document.querySelector("#s1");
    var container = section.querySelector(".container");
    var box = section.querySelector(".box");

    var isdragging = false;
    var offset = { x: 0, y: 0 };
    var left = container.offsetLeft;
    var top = container.offsetTop;
    var current;

    container.onmousedown = function (e) {
        isdragging = true;
        current = e.target;
        offset.x = e.offsetX;
        offset.y = e.offsetY;
    }

    container.onmouseup = function (e) {
        isdragging = false;
        current = null;
    }

    container.onmousemove = function (e) {

        e.preventDefault();
        if (!isdragging) return;

        if (current == null) return;
        current.style.left = `${e.x - (offset.x + left)}px`;
        current.style.top = `${e.y - (offset.y + top)}px`;

        // if (!e.target.classList.contains("box")) return;
        // box.style.left = `${e.x - (offset.x + left)}px`;
        // box.style.top = `${e.y - (offset.y + top)}px`;
    }

})