<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="/opgg/css/reset.css" type="text/css">
<link rel="stylesheet" href="/opgg/css/opgg-layout.css" type="text/css">
<link rel="stylesheet" href="/opgg/css/opgg-componant.css" type="text/css">
<title>OPGG</title>
</head>

<body>

	<!-- header box -->
	<header id="header">
		<h1 class=hidden>헤더</h1>
		<nav class="top-header">
			<h1 class=hidden>top헤더</h1>
			<nav>
				<h1 class=hidden>로고</h1>
				<a href=""><img class=logo src="./image/logo-opgg.png" alt=""></a>
				<h1 class=hidden>로그인</h1>
				<a class=login href="" class="login">로그인</a>
			</nav>
		</nav>
		<section class="bottom-header">
			<h1 class=hidden>bottom헤더</h1>
			<nav>
				<h1 class=hidden>헤더 목록</h1>
				<ul>
					<li><a href="">Home</a></li>
					<li><a href="">분석</a></li>
					<li><a href="">통계</a></li>
					<li><a href="">랭킹</a></li>
					<li><a href="">커뮤니티</a></li>
				</ul>
			</nav>
			<section>
				<h1 class=hidden>전체검색</h1>
				<form action="">
					<select name="" id="">
						<option value="">옵션</option>
						<option value="">옵션</option>
					</select> <input type="text">
					<button>
						<img src="./image/00-icon-gg.svg" alt="">
					</button>
				</form>
			</section>
		</section>
	</header>

	<!-- body box -->
	<main id="main">
		<h1 class=hidden>메인</h1>
		<aside class="aside">
			<h1 class=hidden>설명</h1>
			<div>
				<p>챔피언 분석은 플래티넘 티어 이상의 랭크 게임만을 수집합니다.</p>
			</div>
		</aside>
		<div class="content-container">
			<section class="list">
				<h1 class=hidden>리스트 목록</h1>
				<div>
					<nav class="list-sort">
						<h1 class=hidden>분류</h1>
						<ul>
							<li><a href="/item">전체</a></li>
							<li><a href="/nongsim/nongsim.html">농심</a></li>
							<li><a href="/odduki/odduki.html">오뚜기</a></li>
							<li><a href="/samyang/samyang.html">삼양</a></li>
							<li><a href="/paldo/paldo.html">팔도</a></li>
							<!-- <li><a href="/item/list?mfg=pb">PB</a></li> -->
						</ul>
					</nav>
					<section class="find">
						<h1 class=hidden>라면검색</h1>
						<form action="">
							<input type="text" placeholder="검색">
						</form>
					</section>
				</div>
				<section>
					<h1 class=hidden>라면 리스트</h1>
					<span> <a href=""><img
							src="./image/paldo/bonghee_cup_off.jpg" alt=""></a>
					</span> <span> <a href=""><img
							src="./image/paldo/noodles_tab_009_off.jpg" alt=""></a></span> <span><a
						href=""><img src="./image/paldo/noodles_tab_040_off.jpg"
							alt=""></a></span> <span><a href=""><img
							src="./image/paldo/noodles_tab_041_off.jpg" alt=""></a></span> <span><a
						href=""><img
							src="./image/paldo/r_tab_big3_bokkimchimen_off.jpg" alt=""></a></span>
					<span><a href=""><img
							src="./image/paldo/r_tab_bokkimchimen_off.jpg" alt=""></a></span> <span><a
						href=""><img src="./image/paldo/r_tab_brand01_off.jpg" alt=""></a></span>
					<span><a href=""> <img
							src="./image/paldo/r_tab_brand03_off.jpg" alt=""></a></span> <span><a
						href=""><img src="./image/paldo/r_tab_brand04_off.jpg" alt=""></a></span>
					<span><a href=""><img
							src="./image/paldo/r_tab_brand05_off.jpg" alt=""></a></span> <span><a
						href=""><img src="./image/paldo/r_tab_brand07_off.jpg" alt=""></a></span>
					<span><a href=""><img
							src="./image/paldo/r_tab_brand08_off.jpg" alt=""></a></span> <span><a
						href=""><img src="./image/paldo/r_tab_brand14_off.jpg" alt=""></a></span>
					<span><a href=""><img
							src="./image/paldo/r_tab_brand18_off.jpg" alt=""></a></span> <span><a
						href=""><img src="./image/paldo/r_tab_brand20_off.jpg" alt=""></a></span>
					<span><a href=""><img
							src="./image/paldo/r_tab_brand21_off.jpg" alt=""></a></span> <span><a
						href=""><img src="./image/paldo/r_tab_brand35_off.jpg" alt=""></a></span>
					<span><a href=""><img
							src="./image/paldo/r_tab_brand38_off.jpg" alt=""></a></span> <span><a
						href=""><img src="./image/paldo/r_tab_brand39_off.jpg" alt=""></a></span>
					<span><a href=""><img
							src="./image/paldo/r_tab_cheeda_off.jpg" alt=""></a></span> <span><a
						href=""><img src="./image/paldo/r_tab_mepsimen_off.jpg" alt=""></a></span>
					<span><a href=""><img
							src="./image/paldo/tab_brand16_off.jpg" alt=""></a></span>
				</section>
			</section>

			<section class="ranking">
				<h1 class="hidden">순위</h1>
				<div>
					<h1>챔피언 순위</h1>
					<nav class="ranking-category">
						<ul>
							<li><a href="">티어</a></li>
							<li><a href="">승률</a></li>
							<li><a href="">픽롤</a></li>
							<li><a href="">밴롤</a></li>
						</ul>
					</nav>
				</div>
				<nav class="ranking-sort">
					<h1 class="hidden">분류</h1>
					<ul>
						<li><a href="">전체</a></li>
						<li><a href="">농심</a></li>
						<li><a href="">오뚜기</a></li>
						<li><a href="">삼양</a></li>
						<li><a href="">팔도</a></li>
						<li><a href="/item/list?mfg=pb">PB</a></li>
					</ul>
				</nav>
				<section>
					<h1 class=hidden>순위표</h1>
					<table border="1">
						<thead>
							<tr>
								<th colspan="2" width=60px>Rank</th>
								<th width=100px>품목</th>
								<th width=50px>판매량</th>
								<th width=80px>평점</th>
								<th width=60px>제조사</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="list" items="${list}">
								<tr>
									<td class="rank">${list.rank}</td>
									<td>+2</td>
									<td><a href="/item?code=${list.code}">${list.item}</a></td>
									<td>${list.sales}</td>
									<td>${list.grade}</td>
									<td>${list.mfg}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</section>
			</section>
		</div>

	</main>

	<!-- footer box -->
	<footer id="footer">
		<h1 class=hidden>풋터</h1>
		<div class="content-container">
			<nav>
				<h1 class=hidden>리스트</h1>
				<ul>
					<li><a href="">About</a></li>
					<li><a href="">History</a></li>
					<li><a href="">개인정보처리방핌</a></li>
					<li><a href="">도움말</a></li>
					<li><a href="">제휴</a></li>
					<li><a href="">문의/피드백</a></li>
					<li><a href="">채용</a></li>
				</ul>
			</nav>
			<section>
				<h1 class=hidden>??</h1>
				<p>© 2012-2020 OP.GG. OP.GG isn’t endorsed by Riot Games and
					doesn’t reflect the views or opinions of Riot Games or anyone
					officially involved in producing or managing League of Legends.
					League of Legends and Riot Games are trademarks or registered
					trademarks of Riot Games, Inc. League of Legends © Riot Games, Inc.
				</p>
			</section>
		</div>
	</footer>

</body>

</html>