# Hướng dẫn sử dụng AJAX 

AJAX - "Asynchronous JavaScript and XML" - là một bộ công cụ cho phép load dữ liệu từ server mà không yêu cầu tải lại trang.<br>
Đọc thêm

- https://viblo.asia/p/huong-dan-ve-cach-dung-ham-ajax-cua-jquery-Qbq5QJzGKD8
- https://www.w3schools.com/jquery/ajax_ajax.asp

## Thực hành
###Yêu cầu
Cho sẵn hàm xử lý request đăng ký tài khoản mới (Method register trong class UserController). Hãy sử dụng AJAX để gửi request đăng ký lên server. Thông tin API như sau:<br>
- POST /api/register<br>
- Body request
```json
{
    "fullName": string,
    "email": string,
    "password": string,
    "phone": string
}
```
- Response<br>
    
200
```
Thành công
```
400

```json

```


###Hướng dẫn
Ở các bước trước đã tách modal đăng nhập/đăng kí ra thành một fragment chung và nhúng vào layout. Code javascript để bắt sự kiện khi ấn vào nút đăng kí nằm ở file **/static/script/main.js**
```java
  // Validate sign up
  if (target.closest('.sign-up-btn')) {
    let isValid = true;
    $('.invalid-feedback').css('display', 'none');
    let phoneFormat = new RegExp(/((09|03|07|08|05)+([0-9]{8})\b)/g);
    let emailFormat = new RegExp(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/);
    ...
        
    // Validate name
    if (fullNameValue == "") {
      fullNameInvalid.css('display', 'block');
      fullNameInvalid.html('Vui lòng nhập họ tên');
      isValid = false;
    }

    ...

    if (isValid == true) {
        // Đã pass validate ở frontend, viết AJAX vào đây
    }
```
Cú pháp AJAX
```java
    $.ajax({
            url: '/api/register',                 // Endpoint của API
            type: 'POST',                         // Method: GET, POST, PUT, DELETE,...
            contentType: 'application/json',      
            data: tmp,                            // Body request (không bắt buộc, tùy vào API). Sử dụng JSON.Stringify để convert sang JSON string 
            success: function(data) {             // Hàm xử lý khi gọi thành công, data là response 
                console.log("ok");
            },
            error: function(data) {               // Hàm xử ký khi gọi lỗi 
                console.log("fail oi");
            }
    });
```
