$(function () {

    var section = $(".s1");
    var startBtn = section.find(".start-btn");
    var box1 = section.find(".box1");
    var goBtn = section.find(".go-btn");
    var btnSet = section.find(".btn-set");

    box1.css({
        width: "100px",
        height: "100px",
        textAlign: "center",
        "line-height": "100px",
        "font-weight": "bold"
    });

    startBtn.click(function () {

        goBtn.attr("type", "button");
        goBtn.attr("value", "Go");

    });

    goBtn.click(function () {

        box1.html("<b>Hello</b>");
        box1.css({ marginLeft: "100px", transition: "1s" });
        btnSet.width(300);
        $("<button class='new-btn'>new</button>").appendTo(".btn-set");

        var newBtn = section.find(".new-btn");

        newBtn.click(function () {

            box1.toggleClass("toggle");
            box1.css({marginLeft: "200px", padding: "25px"});

        });

    });

});