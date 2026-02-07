package com.example.webshop;

import com.example.webshop.service.CategoryService;
import com.example.webshop.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Bai4ApplicationTests {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @Test
    void contextLoads() {
        assertNotNull(productService);
        assertNotNull(categoryService);
    }

    @Test
    void testProductServiceGetAll() {
        assertNotNull(productService.getAll());
        assertTrue(productService.getAll().size() > 0);
    }

    @Test
    void testCategoryServiceGetAll() {
        assertNotNull(categoryService.getAll());
        assertEquals(3, categoryService.getAll().size());
    }

}
