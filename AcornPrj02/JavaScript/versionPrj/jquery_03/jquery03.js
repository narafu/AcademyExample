$(function () {

    var section = $("#s1");

    var btnContainer = section.find(".btn-container");
    var btnInput = btnContainer.find(".btn-input");
    var timer = btnContainer.find(".timer");

    var boxContainer = section.find(".box-container");
    var box = boxContainer.find(".box");


    var index = 0;

    window.setInterval(function () {
        timer.html(index++);
    }, 800)

    btnInput.eq(0).click(function () {

        box.eq(0)
            .css({ color: "white" });

        box.eq(1).toggleClass("opacity");

        var boxWidth = box.eq(2).width();
        box.eq(2)
            .animate({ width: boxWidth += 100 });

        box.eq(3)
            .css({ background: `rgb(${255 - index * 10},${255 - index * 10},${255 - index * 10})` });

        box.eq(4)
            .css({
                position: "absolute",
                top: "400px"
            });

        box.eq(4)
            .animate({
                left: "400px"
            })
            .animate({
                left: "0px"
            });
    });

    btnInput.eq(1).click(function () {

        var addBox = box.eq(0).clone();

        addBox.css({
            background: "skyblue",
            position: "absolute",
            top: index % 5 + "00px",
            right: index % 5 + "00px"
        })
        box.eq(0).after(addBox);

        box.eq(0)
            .slideUp(500)
            .slideDown(500);


    });

    btnInput.eq(2).click(function () {

        section.after(section.clone());

    });

    btnInput.eq(3).click(function () {

        var addText = $("<div>안녕하세요</div>");
        boxContainer.after(addText);

        addText.css({
            position: "absolute"
        })
            .animate({ left: "750px" }, 2000, function () {
                addText.animate({ left: "500px" })
            });
        addText.animate({ fontSize: "2em" }, function () {
            addText.animate({ left: "1000px" }, function () {
                addText.animate({ top: index + "0px" })
            })
        });
    });

});