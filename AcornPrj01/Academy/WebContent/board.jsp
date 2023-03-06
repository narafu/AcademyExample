<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/board.css" type="text/css">
    <script src="js/board.js"></script>
</head>

<body>

    <header class="header">
        <h1>Trello</h1>
        <nav>
            <h1 class="d-none">메뉴</h1>
            <ul>
                <li>홈</li>
                <li>검색</li>
            </ul>
        </nav>
        <nav>
            <h1 class="d-none">메뉴</h1>
            <ul>
                <li>추가</li>
                <li>알람</li>
            </ul>
        </nav>
    </header>

    <main class="main">
        <section>
            <h1>도구바</h1>
            <ul>
                <li></li>
            </ul>
        </section>
        <section class="content-box">
            <h1 class="d-none">To do List</h1>
            <div>
                <section class="todo-list-box">
                    <header>
                        <h1>Things To do</h1>
                        <div>숨김버튼</div>
                    </header>
                    <div></div>
                </section>
            </div>
            <div>
                <section class="todo-list-box">
                    <header>
                        <h1>Things To do</h1>
                        <div>숨김버튼</div>
                    </header>
                    <div></div>
                </section>
            </div>
            <div>
                <form method="post" class="list-add-form" enctype="application/x-www-form-urlencoded">
                    <span>
                        <a class="add-list-button" href="">Add another list</a>
                    </span>
                    <span class="d-none">
                        <input class="list-title-input" type="text">
                        <input class="reg-list-button" type="submit" value="Add List">
                        <span class="cancle-list-button">X</span>
                    </span>
                </form>
            </div>
        </section>
    </main>

</body>

</html>