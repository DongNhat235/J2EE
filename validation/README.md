# Product Management Web Shop - Spring Boot Application

Ứng dụng web bán hàng sử dụng Spring Boot với validation, Thymeleaf templates và xử lý upload hình ảnh.

## Tính năng

- **Quản lý Sản phẩm**: Thêm, sửa, xóa sản phẩm
- **Validation**: Kiểm tra dữ liệu đầu vào
  - Tên sản phẩm không được để trống
  - Tên hình ảnh không quá 200 ký tự
  - Giá sản phẩm từ 1 - 9999999
- **Upload Hình ảnh**: Tải lên hình ảnh sản phẩm
- **Danh mục**: Phân loại sản phẩm theo danh mục
- **UI với Bootstrap**: Giao diện thân thiện với người dùng

## Yêu cầu

- Java 17+
- Maven 3.6+
- Trình duyệt web

## Cấu trúc Dự án

```
webshop/
├── src/main/java/com/example/webshop/
│   ├── model/                 # Model classes
│   │   ├── Product.java
│   │   └── Category.java
│   ├── service/               # Service classes
│   │   ├── ProductService.java
│   │   └── CategoryService.java
│   ├── controller/            # Controller classes
│   │   └── ProductController.java
│   └── Bai4Application.java  # Main class
├── src/main/resources/
│   ├── templates/            # Thymeleaf templates
│   │   ├── _layout.html      # Layout chính
│   │   └── product/
│   │       ├── products.html # Danh sách sản phẩm
│   │       ├── create.html   # Tạo sản phẩm
│   │       └── edit.html     # Chỉnh sửa sản phẩm
│   ├── static/
│   │   └── images/           # Thư mục lưu hình ảnh upload
│   └── application.properties # Cấu hình ứng dụng
└── pom.xml                    # Maven configuration
```

## Các Dependencies

- **Spring Boot Starter Web**: Framework web
- **Spring Boot Starter Thymeleaf**: Template engine
- **Thymeleaf Layout Dialect**: Layout support
- **Spring Boot Starter Validation**: Validation framework
- **Lombok**: Reduce boilerplate code
- **Spring Boot DevTools**: Development tools

## Hướng dẫn Chạy

### 1. Cài đặt Dependencies
```bash
mvn clean install
```

### 2. Chạy Ứng dụng
```bash
mvn spring-boot:run
```

Hoặc chạy qua IDE (Eclipse, IntelliJ, VS Code)

### 3. Truy cập Ứng dụng
Mở trình duyệt và truy cập:
```
http://localhost:8080/products
```

## API Endpoints

- `GET /products` - Hiển thị danh sách sản phẩm
- `GET /products/create` - Form tạo sản phẩm mới
- `POST /products/create` - Lưu sản phẩm mới
- `GET /products/edit/{id}` - Form chỉnh sửa sản phẩm
- `POST /products/edit` - Lưu thay đổi sản phẩm
- `POST /products/delete/{id}` - Xóa sản phẩm

## Validation Rules

### Product (Sản phẩm)
- **name**: Không được để trống (Required)
- **price**: Giá trị từ 1 đến 9999999
- **imageName**: Không quá 200 ký tự
- **category**: Danh mục sản phẩm

### Category (Danh mục)
- **name**: Không được để trống (Required)

## Mẫu Dữ liệu Ban đầu

Ứng dụng được khởi tạo với 2 sản phẩm mẫu:
1. Laptop 1 - Giá: 30,000 - Category: Laptop
2. Điện thoại 1 - Giá: 20,000 - Category: Điện thoại

## Các Danh mục Mặc định
1. Điện thoại
2. Laptop
3. Tablet

## Xử lý Hình ảnh

- Hình ảnh được lưu trong: `src/main/resources/static/images/`
- Được đặt tên ngẫu nhiên bằng UUID để tránh trùng lặp
- Hỗ trợ các định dạng: PNG, JPEG, GIF, WebP

## Tác Giả

Phát triển ứng dụng với J2EE - 2025

## License

MIT License
