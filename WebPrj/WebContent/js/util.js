/*
	저작자:
	생성일:
	저작권:
	설명:
	참고 url:
*/

function Shield(selector) { // 속성관련 설정
	this.parent = document.querySelector(selector);
	this.dom = document.createElement("div");
}

Shield.prototype = { // 기능관련 설정
	show: function () {
		this.parent.append(this.dom);
		this.dom.style.position = "absolute";
		this.dom.style.top = "0px";
		this.dom.style.left = "0px";
		this.dom.style.width = "100%";
		this.dom.style.height = "100%";
		this.dom.style.display = "flex";
		this.dom.style.justifyContent = "center";
		this.dom.style.alignItems = "center";
		this.dom.innerHTML = `<img src="/images/ajax-loader.gif">`;
	},
	hide: function () {
		if (this.dom == null) return;
		this.dom.remove();
	}
}
