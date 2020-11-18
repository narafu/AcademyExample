$(function () {

    var section = $("#s1");
    var container = section.find(".container");
    var btnInput = section.find(".btn-input")
    var box1 = container.find(".box1");

    // var test1 =  box1.css("background-color");
    // alert(test1);

    // var test2 = btnInput.attr("type");
    // alert(test2);

    btnInput.click(function () {

        btnInput.attr("type", "text");
        box1.css("color", "blue");
        box1.css(
            {
                "background-color": "white",
                "width": "160px"
            }
        )
        box1.html("BOX1");
        alert(box1Width);
        console.log(box1.css("background-color"));

    });

    var box1Width = box1.width();
    box1.width(500);

    var offsetTop = box1.offset().top;
    console.log("offsetTop: " + offsetTop);
    var offsetLeft = box1.offset().left;
    console.log("offsetLeft " + offsetLeft);

    var posTop = box1.position().top;
    console.log("posTop: " + posTop);
    var posLeft = box1.position().left;
    console.log("posLeft: " + posLeft);


});