<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title>Shop Homepage - Start Bootstrap Template</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="../assets/favicon.ico"/>
    <!-- Bootstrap icons-->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet"/>
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="../css/styles.css" rel="stylesheet"/>
</head>
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container px-4 px-lg-5">
        <a class="navbar-brand" href="/">INDUK 영화</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span
                class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                <li class="nav-item"><a class="nav-link active" aria-current="page" href="/">홈</a></li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">순위</a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="/">일일 순위</a></li>
                        <li><a class="dropdown-item" href="/week1">주간 순위</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">상영관</a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="https://www.cgv.co.kr/" target="_blank">CGV</a></li>
                        <li><a class="dropdown-item" href="https://www.lottecinema.co.kr/NLCHS"
                               target="_blank">롯데시네마</a></li>
                        <li><a class="dropdown-item" href="https://www.megabox.co.kr/" target="_blank">MegaBox</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">드라마</a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="https://www.netflix.com/kr/browse/genre/1191605"
                               target="_blank">Netflix</a></li>
                        <li><a class="dropdown-item"
                               href="https://www.wavve.com/list/VN500?api=apis.wavve.com%252Fes%252Fvod%252Fhotepisodes%253Forderby%253Dviewtime%2526contenttype%253Dvod%2526genre%253Dall%2526WeekDay%253Dall%2526uitype%253DVN500%2526uiparent%253DGN51-VN500%2526uirank%253D12%2526broadcastid%253D144530%2526offset%253D0%2526limit%253D20%2526uicode%253DVN500&came=home"
                               target="_blank">Wavve</a></li>
                        <li><a class="dropdown-item" href="https://watcha.com/staffmades/409" target="_blank">Watcha</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <form class="d-flex">
                <button class="btn btn-outline-dark" type="submit">
                    about
                </button>
            </form>
        </div>
    </div>
</nav>
<!-- Main Content -->
<form action="/commentUpdate" method="get">
    <div class="container px-4 px-lg-5 my-5">
        <div style="margin-bottom: 4px;">
            <input type="hidden" name="title" value="${title}">
            <input type="hidden" name="name" value="${name}">
            <input type="hidden" name="no" value="${no}">
        </div>
        <textarea name="comment" rows="3" style="width: 100%" placeholder="내용"></textarea>
        <button type="submit" class="btn btn-primary">등록</button>
    </div>
</form>
<hr>
<footer class="py-5">
    <div class="container"><p class="m-0 text-center text-black fw-bolder">인덕대학교 컴퓨터소프트웨어학과 일사천리팀</p></div>
</footer>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="../Downloads/team/src/main/webapp/js/scripts.js"></script>
</body>
</html>