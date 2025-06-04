package com.praveen.e_com;

import com.praveen.e_com.Product;
import com.praveen.e_com.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductViewController {

    @Autowired
    private ProductService productService;

    // Display list of products
    @GetMapping("/products")
    public String viewProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "products"; // returns templates/products.html
    }

    // Show form to add product (only for admin)
    @GetMapping("/products/new")
    public String showNewProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "new_product"; // templates/new_product.html
    }

    // Handle form submit to save product
    @PostMapping("/products")
    public String saveProduct(@ModelAttribute("product") Product product) {
        productService.addProduct(product);
        return "redirect:/products";
    }
}
