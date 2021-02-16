# Bước 1: Dựng khung project + cấu hình

#### Cấu trúc project
- **config**: chứa các lớp cấu hình 
- **controller**: chứa các lớp controller
- **model**: chứa các lớp trung gian được sử dụng làm cấu trúc request, response, dto
- **entity**: chứa các lớp đại diện cho các bảng
- **repository**: chứa các interface tương tác với database 
- **service**: chứa các lớp xử lý business logic
- **exception**: chứa các lớp định nghĩa và xử lý ngoại lệ
- **security**: chứa các lớp liên quan đến bảo mật
- **util**: chứa các lớp có các hàm hữu ích có thể tái sử dụng
- **resources**:
    - **static**: chứa các file tĩnh (css, js, ảnh,...)
    - **templates**: chứa file HTML template
    - **application.properties**: file cấu hình
- **pom.xml**: file khai báo thông tin project (dependency, version, tên, ...) được cấu hình qua Maven 
```
 ├───java
 │   └───com
 │       └───example
 │           └───demo
 │               ├───config
 │               ├───controller
 │               │   ├───admin
 │               │   └───anonymous
 │               ├───entity
 │               ├───exception
 │               ├───model
 │               ├───repository
 │               ├───security
 │               ├───service
 │               │   └───impl
 │               └───util
 └───resources
     ├───static
     └───templates
```
 
#### Danh sách dependency cần thiết
1. **spring-boot-starter-web**
2. **spring-boot-starter-thymeleaf**
3. **spring-boot-starter-data-jpa**
4. **mysql-connector-java**
5. **hibernate-types-52**: cung cấp các kiểu dữ liệu (JSON,...) không được hỗ trợ bởi Hibernate ORM core
6. **gson**
7. **spring-boot-starter-security**
8. **jjwt**: thư viện xử lý JWT token 
9. **spring-boot-devtools**
10. **slugify**: dùng để tạo slug từ tiêu đề bài viết, tối ưu SEO 
11. **lombok**
12. **spring-boot-starter-test**

#### Cấu hình application.properties 
```xml
#Cấu hình port 
server.port=8081

# Xử lý ngày / tháng về đúng định dạng 
spring.jackson.serialization.write-dates-as-timestamps=false

# Cấu hình DATABASE
spring.datasource.url=jdbc:mysql://localhost:3306/obo?useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=123

# HIBERNATE
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=none
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect
spring.jpa.hibernate.use-new-id-generator-mappings=false

# Hot reload template
spring.thymeleaf.cache=false
spring.thymeleaf.prefix=file:src/main/resources/templates/
```

#### Tham khảo
https://codeboje.de/jackson-java-8-datetime-handling/
