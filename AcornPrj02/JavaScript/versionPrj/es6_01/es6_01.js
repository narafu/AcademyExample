$(() => {

    let section = $("#sec");
    let startBtn = section.find(".start-btn");
    let insertBtn = section.find(".insert-btn");
    let container = section.find(".container");
    let timer = section.find(".timer");
    let box = container.find(".box");

    let index = 0;
    let cloneBox;

    startBtn.click(() => {

        let direction;
        let distance;

        setInterval(() => {
            rotate(box);
            box.animate({ [direction]: distance });
            if (cloneBox != null) {
                rotate(cloneBox);
                cloneBox.each(() => cloneBox.animate({ [direction]: distance }));
            };
            timer.html(index++);
        }, 750);

        function rotate(object) {
            switch (index % 4) {
                case 0:
                    direction = "left";
                    distance = container.width() - object.position().left;
                    break;
                case 1:
                    direction = "top";
                    distance = container.width() - object.position().top;
                    break;
                case 2:
                    direction = "left";
                    distance = container.width() - object.position().left;;
                    break;
                case 3:
                    direction = "top";
                    distance = container.height() - object.position().top;
                    break;
            };
        };

    });

    insertBtn.click(() => {

        let tempBox;

        if (cloneBox == null) {
            cloneBox = box.clone();
            box.after(cloneBox);
            cloneBox.css({
                background: "yellowgreen",
                left: "100px",
                top: "100px"
            });
        }
        else if (tempBox == null) {
            tempBox = box.clone();
            box.after(tempBox);
            tempBox.css({
                background: "red",
                left: "200px",
                top: "200px"
            });
        }
        else {
            cloneBox = box.clone();
            box.after(cloneBox);
            cloneBox.css({
                background: "yellowgreen",
                left: "100px",
                top: "100px"
            });
        }
        // box = container.find(".box");
    });

});