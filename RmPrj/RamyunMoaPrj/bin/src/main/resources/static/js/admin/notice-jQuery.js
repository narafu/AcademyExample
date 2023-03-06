$(function () {
	
	var bottomHeader = $(".bottom-header");
	var adminMenu = bottomHeader.find(".admin-menu");
	var adminMenuLi = adminMenu.find("li");
	
	var menuTit = $(".menu-tit");
	
	adminMenuLi.eq(3).mouseover(function(){
		
//		menuTit.clone()
//		.appendTo(adminMenuLi.eq(3));
		
	})
	
	adminMenuLi.mouseout(function(){
		
	})


    var title = $(".title");

    title.mouseover(function () {

        title
        .clearQueue("fx")
        .animate({
            fontSize : "5em"
        });

    });

    title.mouseout(function () {

        title
        .clearQueue("fx")
        .animate({
            fontSize : "3em"
        });

    });

});