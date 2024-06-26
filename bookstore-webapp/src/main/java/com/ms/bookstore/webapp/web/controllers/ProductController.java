package com.ms.bookstore.webapp.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController  {

    @GetMapping
    public String index()
    {
        return "redirect:/products";
    }

    @GetMapping("/products")
    public String productsPage(@RequestParam(name = "page", defaultValue = "1") int pageNo,
        Model model)
    {
        model.addAttribute("pageNo",pageNo);
        return "products";
    }
}
