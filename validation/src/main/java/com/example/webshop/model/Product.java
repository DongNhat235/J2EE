package com.example.webshop.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private int id;

    @NotBlank(message = "Tên sản phẩm không được để trống")
    private String name;

    @Min(value = 1, message = "Giá sản phẩm không được để trống và cho phép nhập từ 1 - 9999999")
    @Max(value = 9999999, message = "Giá sản phẩm không được để trống và cho phép nhập từ 1 - 9999999")
    private long price;

    private String image;

    @Size(max = 200, message = "Tên hình ảnh không quá 200 kí tự")
    private String imageName;

    private Category category;
}
