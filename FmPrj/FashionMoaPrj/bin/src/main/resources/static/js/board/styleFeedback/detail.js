'use strict';
let slideIndex = 1;
showSlides1(slideIndex);
showSlides2(slideIndex);
showSlides3(slideIndex);
showSlides4(slideIndex);
showSlides5(slideIndex);

function plusSlides1(n) {
  showSlides1((slideIndex += n));
}
function plusSlides2(n) {
  showSlides2((slideIndex += n));
}
function plusSlides3(n) {
  showSlides3((slideIndex += n));
}
function plusSlides4(n) {
  showSlides4((slideIndex += n));
}
function plusSlides5(n) {
  showSlides5((slideIndex += n));
}

function currentSlide1(n) {
  showSlides1((slideIndex = n));
}
function currentSlide2(n) {
  showSlides2((slideIndex = n));
}
function currentSlide3(n) {
  showSlides3((slideIndex = n));
}
function currentSlide4(n) {
  showSlides4((slideIndex = n));
}
function currentSlide5(n) {
  showSlides5((slideIndex = n));
}

function showSlides1(n) {
  let i;
  const slides = document.querySelectorAll('.mySlides1');

  if (n > slides.length) {
    slideIndex = 1;
  }
  if (n < 1) {
    slideIndex = slides.length;
  }
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = 'none';
  }
  slides[slideIndex - 1].style.display = 'block';
}

function showSlides2(n) {
  let i;
  const slides = document.querySelectorAll('.mySlides2');

  if (n > slides.length) {
    slideIndex = 1;
  }
  if (n < 1) {
    slideIndex = slides.length;
  }
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = 'none';
  }
  slides[slideIndex - 1].style.display = 'block';
}

function showSlides3(n) {
  let i;
  const slides = document.querySelectorAll('.mySlides3');

  if (n > slides.length) {
    slideIndex = 1;
  }
  if (n < 1) {
    slideIndex = slides.length;
  }
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = 'none';
  }
  slides[slideIndex - 1].style.display = 'block';
}

function showSlides4(n) {
  let i;
  const slides = document.querySelectorAll('.mySlides4');

  if (n > slides.length) {
    slideIndex = 1;
  }
  if (n < 1) {
    slideIndex = slides.length;
  }
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = 'none';
  }
  slides[slideIndex - 1].style.display = 'block';
}

function showSlides5(n) {
  let i;
  const slides = document.querySelectorAll('.mySlides5');

  if (n > slides.length) {
    slideIndex = 1;
  }
  if (n < 1) {
    slideIndex = slides.length;
  }
  for (i = 0; i < slides.length; i++) {
    slides[i].style.display = 'none';
  }
  slides[slideIndex - 1].style.display = 'block';
}

$(()=> {
	
	let button = $(".member__register__comment");	// ?????? ?????? ??????
	let cmtList = $(".comment-list");	// ?????? ?????????

	button.click((e)=>{
		e.preventDefault();
		
		let pathName = $(location).attr("pathname");	// /board/styleFeedback/73 
		console.log(pathName);	// /board/styleFeedback/73

		let id = pathName.substring(21, 23);
		console.log(id);
		
		let cmtReg = $(".feedback__member");
		console.log(cmtReg);
		let content = cmtReg.find("input[name=content]").val();	// ????????? ?????? content ???
		console.log(content);
		let writerId = cmtReg.find("input[name=writerId]").val();	// ????????? ?????? writerId ???
		console.log(writerId);
		let regdate = cmtReg.find("input[name=regdate]").val();	// ????????? ?????? regdate ???
		console.log(regdate);
		let cmtId = $(".comment").find("input[name=cmtId]").val();	// ????????? id ???
		console.log(cmtId);
		
		// ?????? ?????? ajax
		$.ajax({
			url : `/api/board/styleFeedback/${id}`,
			type : "POST",
			data : {
				"id" : id,
				"writerId" : writerId,
				"content" : content
			},
			datatype : "JSON",
			success : (cmt)=>{
				cmtReg.find("input[name=content]").val("");
			}
		});
		
		// ?????? ????????? ?????? ajax
		$.ajax({
			url : `/api/board/styleFeedback/${id}`,
			type : "GET",
			data : {
				"id" : id,
				"writerId" : writerId,
				"content" : content,
				"cmtId" : cmtId
			},
			datatype : "JSON",
			success : ()=>{
				// prepend ??? ?????? ???????????? ??????
				cmtList.prepend(`
					<form action="cmtDelete" method="get">
						<div class="comment">
							<div class="comment-info">
								<div class="icon"></div>
								<div class="writer">${writerId }</div>
								<div class="report"></div>
								<div class="content">${content }</div>
								<div class="regdate">${regdate}</div>
								<input type="hidden" name="boardId" value="${id}">
								<input type="hidden" name="cmtId" value="${cmtId }">
								<button type="submit" value="??????" class="delete"><i class="fas fa-trash"></i></button>
							</div>
						</div>
					</form>
				`);
			}
		});
		
	});
	
});