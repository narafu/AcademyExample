window.addEventListener("load", function () {
    
    var section = document.querySelector("#s1");
    var box = section.querySelector(".box");
    var container = section.querySelector(".container");

    var isDragging = false;
    var offset = { x: 0, y: 0 };
    var left = container.offsetLeft;
    var top = container.offsetTop;
    var current = null;
    var placeHolder = document.createElement("div");

    container.onmousedown = function (e) {

        isDragging = true;
        current = e.target;
        offset.x = e.offsetX;
        offset.y = e.offsetY;

        var currentStyle = window.getComputedStyle(current);
        var width = currentStyle.getPropertyValue("width");
        var height = currentStyle.getPropertyValue("height");
        // current.style.position = "absolute";

        // placeHolder 추가
        placeHolder.style.width = width;
        placeHolder.style.height = height;
        placeHolder.style.background = "gray";
        current.parentElement.append(placeHolder);

    }

    container.onmouseup = function (e) {

        // placeHolder 제거 + current 박스의 원위치
        if (placeHolder != null) {
            current.style.position = "initial"; /* 원래 값 */
            current.style.top = "initial"; /* 원래 값 */
            current.style.left = "initial"; /* 원래 값 */
            placeHolder.remove();
        }

        isDragging = false;
        current = null;
    }

    container.onmousemove = function (e) {
        e.preventDefault();
        if (!isDragging) return;
        if (current == null) return;
        current.style.position = "absolute";
        current.style.left = e.x - offset.x - left + "px";
        current.style.top = e.y - offset.y - top + "px";

        // if(!e.target.classList.contains("box")) return;
        // 끊기는 방식
        // box.style.left= e.x-offset.x-left+"px";
        // box.style.top= e.y-offset.y-top+"px";
        // console.log(offset);
    };
});