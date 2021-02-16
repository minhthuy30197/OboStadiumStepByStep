# Bước 3: Serve website tĩnh

> Sử dụng layout đã tạo ở bước 2, dựng trang Obo Stadium tĩnh (chưa yêu cầu vận dụng cú pháp Thymeleaf để render html với dữ liệu động). Mục đích của bước này nhằm giúp các bạn làm quen với fragment và layout. 


## Thực hành dựng trang chủ
#### Tạo template
- Tạo file **index.html** trong thư mục **/templates/shop**
- Tạo khung template: Thay thế bằng fragment "main-fragment" ở template /layout/layout.html. Copy/paste nội dung từ source code tĩnh, điền vào các phần tilte, header, css resources, js resource và main content  
```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"
      th:replace="~{/layout/layout :: main-fragment(
                                                ~{:: title},
                                                'full-header',     // tên của fragment header muốn chèn: full-header hoặc short-header
                                                ~{:: #css-resources},
                                                ~{:: #js-resources},
                                                ~{:: #main-content}
                                               )}">
    
    <head>
        <title>Nhập tên tiêu đề trang ở đây</title>
    
        <th:block id="css-resources">
            // Thêm link css riêng cho trang chủ vào đây
        </th:block>
    </head>
    <body>
        <main id="main-content">
            // Copy/paste code body của trang chủ vào đây
        </main>
        
        <th:block id="js-resources">
            // Thêm link js riêng cho trang chủ vào đây
        </th:block>
    </body>
</html>
```
- Thay thế các tham chiếu đến static resources (ảnh, link) bằng cú pháp Thymeleaf

Lưu ý: Nên gom nhóm các template cùng nhóm chức năng vào trong cùng thư mục để dễ quản lý
<br><br>
#### Tạo controller
Tạo class ShopController chứa method xử lý request **GET /**. Method trả ra đường dẫn đến template trang chủ để render.
```java
@Controller
public class ShopController {
    @GetMapping("/")
    public String getIndexPage(Model model) {
        return "shop/index";
    }
}

```
Lưu ý: Tạo class ShopController trong package /controller/anonymous ---> Nên gom nhóm các method xử lý request liên quan đến một đối tượng trong cùng controller. Phân chia cấp package để dễ quản lý. VD:
```aidl
├───controller
│   ├───admin                                     // Chứa các hàm xử lý request từ trang admin
│   │       DashboardController.java              
│   │       ManageBrandController.java           
│   │       ManageCategoryController.java
│   │       ManageImageController.java
│   │       ManageOrderController.java
│   │       ManagePostController.java
│   │       ManageProductController.java
│   │       ManagePromotionController.java
│   │
│   └───anonymous                                // Chứa các hàm xử lý request từ trang bên ngoài cho end user
│           BlogController.java                   
│           PromotionController.java              
│           ShopController.java          
│           UserController.java
```

## Bài tập: Dựng trang Tin tức
Request đến trang tin tức: GET /tin-tuc
