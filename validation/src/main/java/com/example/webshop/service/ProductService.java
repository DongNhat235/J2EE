package com.example.webshop.service;

import com.example.webshop.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service
public class ProductService {
    private List<Product> listProduct = new ArrayList<>();
    private final CategoryService categoryService;
    private static final String UPLOAD_DIR = "src/main/resources/static/images/";

    public ProductService(CategoryService categoryService) {
        this.categoryService = categoryService;
        // Initialize with sample data
        listProduct.add(new Product(1, "laptop 1", 30000, "laptop_1.jpg", "Laptop 1", categoryService.get(2)));
        listProduct.add(new Product(2, "điện thoại 1", 20000, "phone_1.png", "Điện thoại 1", categoryService.get(1)));
    }

    public List<Product> getAll() {
        return listProduct;
    }

    public Product get(int id) {
        return listProduct.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void add(Product newProduct) {
        int maxId = listProduct.stream()
                .mapToInt(Product::getId)
                .max()
                .orElse(0);
        newProduct.setId(maxId + 1);
        listProduct.add(newProduct);
    }

    public void update(Product editProduct) {
        Product find = get(editProduct.getId());
        if (find != null) {
            find.setPrice(editProduct.getPrice());
            find.setName(editProduct.getName());
            find.setCategory(editProduct.getCategory());
            if (editProduct.getImage() != null) {
                find.setImage(editProduct.getImage());
            }
        }
    }

    public void delete(int id) {
        listProduct.removeIf(p -> p.getId() == id);
    }

    public void updateImage(Product newProduct, MultipartFile imageProduct) {
        String contenttype = imageProduct.getContentType();
        if (contenttype != null && contenttype.contains("image")) {
            try {
                Path dirImages = Paths.get(UPLOAD_DIR);
                if (!Files.exists(dirImages)) {
                    Files.createDirectories(dirImages);
                }

                String newFileName = UUID.randomUUID() + "." +
                        StringUtils.getFilenameExtension(imageProduct.getOriginalFilename());
                Path pathFileUpload = dirImages.resolve(newFileName);
                Files.copy(imageProduct.getInputStream(), pathFileUpload);
                newProduct.setImage(newFileName);
            } catch (IOException e) {
                e.printStackTrace(); // Handle the exception appropriately
            }
        }
    }
}
