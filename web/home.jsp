
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta http-equiv="x-ua-compatible" content="ie=edge" />
        <title>Monica</title>
        <link rel="icon" type="image/png" href="https://saysach.com/wp-content/uploads/2020/05/saysach_favicon.png">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v6.0.0/css/all.css" />
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" />
        <link rel="stylesheet" href="css/mdb.min.css" />
        <link rel="stylesheet" href="css/home.css">
    </head>
    <body>
        <header>
            <style>
                #introCarousel,
                .carousel-inner,
                .carousel-item,
                .carousel-item.active {
                    height: 100vh;
                }
                .carousel-item:nth-child(1) {
                    background-image: url('images/tramdoc1.jpg');
                    background-repeat: no-repeat;
                    background-size: cover;
                    background-position: center center;
                }
                .carousel-item:nth-child(2) {
                    background-image: url('images/tramdoc2.jpg');
                    background-repeat: no-repeat;
                    background-size: cover;
                    background-position: center center;
                }
                .carousel-item:nth-child(3) {
                    background-image: url('images/tramdoc5.jpg');
                    background-repeat: no-repeat;
                    background-size: cover;
                    background-position: center center;
                }

                /* Height for devices larger than 576px */
                @media (min-width: 992px) {
                    #introCarousel {
                        margin-top: -58.59px;
                    }
                    #introCarousel,
                    .carousel-inner,
                    .carousel-item,
                    .carousel-item.active {
                        height: 60vh;
                    }
                }

                .navbar .nav-link {
                    color: #fff !important;
                }
                /* CSS để áp dụng chiều cao cố định cho các cột */
                .col-lg-4,.col-md-6 {
                    /*height: 400px;  Độ cao cố định */
                }
                .card-body {
                    height: 285px;
                    overflow: hidden; /* Đảm bảo nội dung không vượt ra khỏi phần tử */
                    margin: auto;
                    /*width: 80%;*/
                    /*border: 3px solid green;*/
                    padding: 10px;
                }
                /* Đảm bảo nút btn-primary được căn giữa theo chiều ngang */
                .card-body {
                    position: relative; /* Cho phép sử dụng position:absolute cho .btn-primary */
                    /*display: flex;*/
                    align-items: center; /* Căn theo chiều dọc */
                    justify-content: center;
                    /*Căn theo chiều ngang*/
                }

                .readmore {
                    position: absolute;
                    left: 50%;
                    transform: translateX(-50%);
                    bottom: 0;
                    margin-bottom: 10px;  /*Đảm bảo cách mép dưới card-body 1px*/
                }
                .card-text {
                    /*text-align: left;  Căn văn bản sang trái */
                }
                #searchBar {
                    display: none;
                }

            </style>
        </head>
        <header class="s-header">

            <div class="row s-header__inner width-sixteen-col">

                <div class="s-header__block">
                    <div class="s-header__logo">
                        <a class="logo" href="home.jsp">
                            <img src="images/logo.svg" alt="Homepage">
                        </a>
                    </div>

                    <a class="s-header__menu-toggle" href="#0"><span>Menu</span></a>
                </div> 

                <nav class="s-header__nav">

                    <ul class="s-header__menu-links">
                        <li><a href="home.jsp">Home</a></li>
                        <li><a href="review.jsp">Review</a></li>
                        <li>
                            <a href="#" id="searchLink">Tìm kiếm sách</a>
                            <div id="search-form" style="display: none;">
                                <form id="searchForm"> <!-- Thêm form tag -->
                                    <input type="text" id="searchInput" placeholder="Nhập từ khóa...">
                                    <button type="submit">Tìm kiếm</button> 
                                </form>
                            </div>
                        </li>
                       
                    </ul> 

                    <div class="s-header__contact">
                        <a href="login.jsp" class="btn btn--primary s-header__contact-btn">Log in</a>                        
                    </div> 
                </nav> 
            </div> 
        </header> 
        
        <div id="introCarousel" class="carousel slide carousel-fade shadow-2-strong" data-mdb-carousel-init>
            <!-- Indicators -->
            <div class="carousel-indicators">
                <li data-mdb-target="#introCarousel" data-mdb-slide-to="0" class="active"></li>
                <li data-mdb-target="#introCarousel" data-mdb-slide-to="1"></li>
                <li data-mdb-target="#introCarousel" data-mdb-slide-to="2"></li>
            </div>

            <!-- Inner -->
            <div class="carousel-inner">
                <!-- Single item -->
                <div class="carousel-item active">
                    <div class="mask" style="background-color: rgba(0, 0, 0, 0.6);">
                        <div class="d-flex justify-content-center align-items-center h-100">
                            <div class="text-white text-center" data-mdb-theme="dark">
                                <h1 class="mb-3" style="font-size: 45px;">TRẠM ĐỌC</h1>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Single item -->
                <div class="carousel-item">
                    <div class="mask" style="background-color: rgba(0, 0, 0, 0.3);">
                        <div class="d-flex justify-content-center align-items-center h-100">
                            <div class="text-white text-center">
                                <h2>You Are What You Read</h2>
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Single item -->
                <div class="carousel-item">
                    <div
                        class="mask"
                        style="
                        background: linear-gradient(
                        45deg,
                        rgba(29, 236, 197, 0.7),
                        rgba(91, 14, 214, 0.7) 100%
                        );
                        "
                        >
                        <div class="d-flex justify-content-center align-items-center h-100">
                            <div class="text-white text-center" data-mdb-theme="dark">
                                <h2>And cover it with any mask</h2>
                                <a
                                    class="btn btn-outline-light btn-lg m-2" data-mdb-ripple-init
                                    href="https://www.tiktok.com/@sach_hay777?_t=8kyKxH1mBuc&_r=1"
                                    target="_blank"
                                    role="button"
                                    >Read more</a
                                >
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Inner -->

            <!-- Controls -->
            <a class="carousel-control-prev" href="#introCarousel" role="button" data-mdb-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#introCarousel" role="button" data-mdb-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
        <!-- Carousel wrapper -->
    </header>

    <!--Main layout-->
    <main class="mt-5">
        <div class="container">
            <section>
                <div id="bookDetails">
                    <div class="row" id="bookDetails">
                        <div class="col-md-6 gx-5 mb-4">
                            <div class="bg-image hover-overlay shadow-2-strong" data-mdb-ripple-init data-mdb-ripple-color="light">
                                <center><img id="bookImage" src="" alt="Book Image" style="height: 500px;"></center>
                                <a href="#!">
                                    <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                                </a>
                            </div>
                        </div>

                        <div class="col-md-6 gx-5 mb-4">
                            <h4><strong><span id="bookTitle"></span></strong></h4>
                            <p class="text-muted">
                            <p><strong>Tác giả: </strong><span id="bookAuthor"></span></p>
                            </p>
                            <p><strong>Thể loại: </strong><span id="bookGenre"></span></p>
                            <p class="text-muted">
                            <p > <strong>Mô tả: </strong><span id="bookDescription"></span></p>
                            <!--<p id="bookContent"></p>-->
                            </p>
                        </div>
                    </div>
                </div>
            </section>

            <hr class="my-5" />
            <section class="text-center">
                <!--<h4 class="mb-5"><strong>Danh sách sách</strong></h4>-->
                <div id="book-list" class="row">
<!--                    Danh sách sách sẽ được hiển thị ở đây -->
                </div>
            </section>
            <hr class="my-5" />

            <!--Section: Content-->
            <section class="mb-5">
                <h4 class="mb-5 text-center"><strong>Facilis consequatur eligendi</strong></h4>

                <div class="row d-flex justify-content-center">
                    <div class="col-md-6">
                        <form>
                            <!-- 2 column grid layout with text inputs for the first and last names -->
                            <div class="row mb-4">
                                <div class="col">
                                    <div class="form-outline" data-mdb-input-init>
                                        <input type="text" id="form3Example1" class="form-control" />
                                        <label class="form-label" for="form3Example1">First name</label>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-outline" data-mdb-input-init >
                                        <input type="text" id="form3Example2" class="form-control" />
                                        <label class="form-label" for="form3Example2">Last name</label>
                                    </div>
                                </div>
                            </div>

                            <!-- Email input -->
                            <div class="form-outline mb-4" data-mdb-input-init>
                                <input type="email" id="form3Example3" class="form-control" />
                                <label class="form-label" for="form3Example3">Email address</label>
                            </div>

                            <!-- Password input -->
                            <div class="form-outline mb-4" data-mdb-input-init>
                                <input type="password" id="form3Example4" class="form-control" />
                                <label class="form-label" for="form3Example4">Password</label>
                            </div>

                            <!-- Checkbox -->
                            <div class="form-check d-flex justify-content-center mb-4">
                                <input
                                    class="form-check-input me-2"
                                    type="checkbox"
                                    value=""
                                    id="form2Example3"
                                    checked
                                    />
                                <label class="form-check-label" for="form2Example3">
                                    Subscribe to our newsletter
                                </label>
                            </div>

                            <!-- Submit button -->
                            <button type="submit" class="btn btn-primary btn-block mb-4" data-mdb-ripple-init >
                                Sign up
                            </button>

                        </form>
                    </div>
                </div>
            </section>
            <!--Section: Content-->
        </div>
    </main>
    <!--Main layout-->

    <!--Footer-->
    <footer class="bg-light text-lg-start">
        <hr class="m-0" />

        <div class="text-center py-4 align-items-center">
            <a
                href="#"
                class="btn btn-primary m-1" data-mdb-ripple-init
                role="button"
                rel="nofollow"
                target="_blank"
                >
                <i class="fab fa-youtube"></i>
            </a>
            <a
                href="#"
                class="btn btn-primary m-1" data-mdb-ripple-init
                role="button"
                rel="nofollow"
                target="_blank"
                >
                <i class="fab fa-facebook-f"></i>
            </a>
            <a
                href="#"
                class="btn btn-primary m-1"
                role="button"
                rel="nofollow"
                target="_blank"
                >
                <i class="fab fa-twitter"></i>
            </a>
            <a
                href="https://www.tiktok.com/@sach_hay777?_t=8kyKxH1mBuc&_r=1"
                class="btn btn-primary m-1" data-mdb-ripple-init
                role="button"
                rel="nofollow"
                target="_blank"
                >
                <i class="fab fa-github"></i>
            </a>
        </div>

        <!-- Copyright -->
        <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
            !!2024!!
            <a class="text-dark" href="https://mdbootstrap.com/">nonle.dev@gmail.com</a>
        </div>
        <!-- Copyright -->
    </footer>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> 
    <script src="js/scripts.js"></script> 
    <script type="text/javascript" src="js/mdb.umd.min.js"></script>
    <script src="js/plugins.js"></script>
    <script src="js/main.js"></script>
    <script>
        // Sử dụng JavaScript để tải thông tin sách từ servlet và hiển thị trên trang
        function getNewestBookInfo() {
            var xhr = new XMLHttpRequest();
            xhr.open("GET", "/monica/newest", true);
            xhr.onreadystatechange = function () {
                if (xhr.readyState === 4 && xhr.status === 200) {
                    var bookInfo = JSON.parse(xhr.responseText);
                    document.getElementById("bookImage").src = bookInfo.image;
                    document.getElementById("bookTitle").innerText = bookInfo.title;
                    document.getElementById("bookAuthor").innerText  = bookInfo.author;
                    document.getElementById("bookGenre").innerText =  bookInfo.genre;
                    document.getElementById("bookDescription").innerText =  bookInfo.description;
//                    document.getElementById("bookContent").innerText = "Nội dung: " + bookInfo.content;
                }
            };
            xhr.send();
        }

        // Gọi hàm để lấy thông tin sách khi trang được tải
        window.onload = function () {
            getNewestBookInfo();
        };
    </script>


</body>
</html>

