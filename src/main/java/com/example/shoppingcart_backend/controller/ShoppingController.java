package com.example.shoppingcart_backend.controller;

import com.example.shoppingcart_backend.dao.ShoppingDao;
import com.example.shoppingcart_backend.model.Shopping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ShoppingController {

    @Autowired
    private ShoppingDao dao;

    @PostMapping("/add")
    public String AddProduct(@RequestBody Shopping s)
    {
        System.out.println(s.getName().toString());
        System.out.println(s.getCategory().toString());
        System.out.println(s.getDescription().toString());
        dao.save(s);
        return "Product added successfully";
    }

    @GetMapping("/view")
    public String ViewProduct()
    {
        return "Welcome to view product page";
    }

    @PostMapping("/search")
    public String SearchProduct()
    {
        return "Welcome to search product page";
    }

}
