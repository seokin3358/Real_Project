<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
        integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <title>글 상세 페이지</title>
    <style>
        header {
            border-top: 10px;
            margin: 10px 100px;
            width: 50%;
        }

        #serch {
            width: 80%;
        }

        p {
            border: 1px solid black;
        }
    </style>
</head>

<body>
    <header>
        <article>
            <form action="">
                <nav class="navbar navbar-light fixed-top bg-light">
                    <form class="form-inline">
                        <input id="serch" class="form-control mr-sm-2" type="search" placeholder="검색"
                            aria-label="Search">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">검색</button>

                        <fieldset id="icon">
                            <a href="#"><img src="exclamation-mark24.png"></a>
                            <a href="#"><img src="home.png"></a>
                            <a href="#"><img src="instagram.png" alt="..." class="rounded-circle"></a>
                        </fieldset>
                    </form>
                </nav>
            </form>
        </article>
    </header>
    <main>
        <br>
        <img src="" alt="">

        <div style="margin: 1cm 32%;">
            <p class="user"> 닉네임</p>
            <img id="userphoto" src="http://placehold.it/500x500" alr="게시사진">
            <p>글(컨텐츠)내용</p>
            <p><a href="#">해쉬태그</a></p>

            <p>댓글1</p>
            <p>댓글2</p>
            <p>댓글3</p>
            <p>댓글4</p>
            <p>댓글5<a href="#" style="float: right;">더보기</a></p>

            <div class="input-group mb-3">
                <input type="text" class="form-control" placeholder="댓글달기" aria-label="Recipient's username"
                    aria-describedby="button-addon2">
                <div class="input-group-append">
                    <button class="btn btn-outline-secondary" type="button" id="button-addon2">작성</button>
                </div>
            </div>
        </div>
    </main>
    <footer>
        <nav aria-label="Page navigation example">
            <ul class="pagination justify-content-center">
                <li class="page-item disabled">
                    <a class="page-link" href="#" tabindex="-1" aria-disabled="true">페이지</a>
                </li>
                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>

                </li>

                <div class="btn-group " style="float: right;" role="group" aria-label="Basic example">
                    <button type="button" class="btn btn-secondary">글쓰기</button>
                    <button type="button" class="btn btn-secondary">수정</button>
                    <button type="button" class="btn btn-secondary">삭제</button>
                </div>
            </ul>
        </nav>
        <br>

        <p style="text-align: center; border: 0;">Copyright 2020 blog Corp. All Rights Reserved.</p>
    </footer>
</body>

</html>