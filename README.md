# product-maintain

Các bước thực hiện:

1.Tạo Entity,Dto,Repository cho project(package model,dto,repository): Ngọc
2.Viết các Controller
2.1. HomeController: Ngọc
2.2. ProductController:
2.2.1. create(): truyền object rỗng cho product.html để có thể nhập sản phẩm: Ngọc
2.2.2. list(): lấy tất cả sản phẩm trong CSDL để truyền vào list.html: Ngọc
2.2.3. saveOrUpdate(): nhận dữ liệu nhập của người dùng, kiểm tra tính hợp lệ, tránh sản phẩm trùng để thêm vào CSDL rồi sau đó chuyển hướng về trang hiển thị danh sách sản phẩm: Thái
2.2.4. edit(): lấy dữ liệu trong CSDL theo productCode mà người dùng click vào rồi truyền vào file product.html để người dùng chỉnh sửa: Thái
2.2.5. confirmDelete(): lấy dữ liệu từ CSDL theo productCode để hiển thị trên trang xác nhận xóa sản phẩm confirmDelete.html: Thái
2.2.6. delete(): xóa sản phẩm trong CSDL theo productCode rồi chuyển hướng về trang hiển thị danh sách sản phẩm: Ngọc
3. Viết file HTML theo định dạng thymeleaf theo yêu cầu của controller và thêm CSS vào file HTML: Sơn Anh
