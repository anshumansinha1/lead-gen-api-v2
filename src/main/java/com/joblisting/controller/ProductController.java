package com.joblisting.controller;

import com.joblisting.entities.Product;
import com.joblisting.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

//@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        System.out.println(product);
        return productService.addProduct(product);
    }

    @GetMapping
    public Page<Product> getProducts(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size,
            //@RequestParam(name = "sort", defaultValue = "id,asc") String[] sort
            @RequestParam(name = "sortField", defaultValue = "name") String sortField,
            @RequestParam(name = "sortOrder", defaultValue = "asc") String sortOrder) {
        Sort.Order order = Sort.Order.by(sortField).with(Sort.Direction.fromString(sortOrder));
        Pageable pageable = PageRequest.of(page, size, Sort.by(order));
        return productService.getProducts(pageable);
    }
}