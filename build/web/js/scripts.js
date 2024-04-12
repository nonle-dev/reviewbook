$(document).ready(function () {
    // Bắt sự kiện khi click vào thẻ a "Tìm kiếm sách"
    $('#searchLink').click(function (event) {
        event.preventDefault(); // Ngăn chặn hành vi mặc định của thẻ a

        // Hiển thị form tìm kiếm khi click vào thẻ a
        $('#search-form').show();
    });
    // Bắt sự kiện khi submit form tìm kiếm
    $('#searchForm').submit(function (event) {
        event.preventDefault(); // Ngăn chặn hành vi mặc định của form

        // Lấy giá trị từ ô input tìm kiếm
        var searchTerm = $('#searchInput').val();

        // Gửi yêu cầu AJAX đến Servlet
        $.ajax({
            type: 'GET',
            url: 'search', // Đường dẫn đến Servlet của bạn
            data: {searchTerm: searchTerm},
            success: function (response) {
                console.log('Dữ liệu sách đã được trả về từ Servlet:');
                console.log(response);

                // Xóa các mục sách hiện có trên trang
                $('#book-list').empty();

                // Hiển thị kết quả trả về trên trang
                response.forEach(function (book) {
                    var bookItem = '<div class="col-lg-4 col-md-6 mb-4">';
                    bookItem += '<div class="card">';
                    bookItem += '<div class="bg-image hover-overlay" data-mdb-ripple-init data-mdb-ripple-color="light">';
                    bookItem += '<img src="' + book.image + '" class="img-fluid" style="width: 336px; height: 336px;">'; // Thiết lập kích thước của hình ảnh
                    bookItem += '<a href="a.html?id=' + book.id + '">';
                    bookItem += '<div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>';
                    bookItem += '</a>';
                    bookItem += '</div>';
                    bookItem += '<div class="card-body">';
                    bookItem += '<h5 class="card-title">' + book.title + '</h5>';
                    bookItem += '<p class="card-text">' + book.description + '</p>';
//                    bookItem += '<a href="#!" class="btn btn-primary readmore" data-mdb-ripple-init >Read more</a>';
                    bookItem += '</div>';
                    bookItem += '</div>';
                    bookItem += '</div>';

                    $('#book-list').append(bookItem);
                });
            },
            error: function (xhr, status, error) {
                console.error('Lỗi khi gửi yêu cầu AJAX: ' + error);
            }
        });
    });
});

$(document).ready(function () {
    // Gửi yêu cầu AJAX khi trang được tải
    $.ajax({
        type: 'GET',
        url: 'bookservlet', // Đường dẫn đến Servlet của bạn
        success: function (response) {
            console.log('Dữ liệu sách đã được trả về từ Servlet:');
            console.log(response);

            // Xóa các mục sách hiện có trên trang
            $('#book-list').empty();

            // Hiển thị kết quả trả về trên trang
            response.forEach(function (book) {
                var bookItem = '<div class="col-lg-4 col-md-6 mb-4">';
                bookItem += '<div class="card">';
                bookItem += '<div class="bg-image hover-overlay" data-mdb-ripple-init data-mdb-ripple-color="light">';
                bookItem += '<img src="' + book.image + '" class="img-fluid" style="width: 336px; height: 336px;">'; // Thiết lập kích thước của hình ảnh
                bookItem += '<a href="a.html?id=' + book.id + '">';
                bookItem += '<div class="mask"></div>';
                bookItem += '</a>';
                bookItem += '</div>';
                
                bookItem += '<div class="card-body">';
                bookItem += '<a href="a.html?id=' + book.id + '">';
                bookItem += '<h5 class="card-title" style="color:black">' + book.title + '</h5>';
                
                bookItem += '</a>';
                bookItem += '<p class="card-text">' + book.description + '</p>';
//                bookItem += '<a href="#!" class="btn btn-primary " data-mdb-ripple-init >Read more</a>';
                bookItem += '</div>';
                bookItem += '</div>';
                bookItem += '</div>';

                $('#book-list').append(bookItem);
            });
        },
        error: function (xhr, status, error) {
            console.error('Lỗi khi gửi yêu cầu AJAX: ' + error);
        }
    });
});
