package com.example.shoppingcart_backend.controller;

import com.example.shoppingcart_backend.dao.ShoppingDao;
import com.example.shoppingcart_backend.model.Shopping;
import com.example.shoppingcart_backend.model.UserRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

public class ShoppingController {

    @Autowired
    private ShoppingDao dao;

    @CrossOrigin(origins = "*")

    @PostMapping(path = "/add",consumes = "application/json",produces = "application/json")
    public Map<String,String> AddProduct(@RequestBody Shopping s)
    {
        System.out.println(s.getName().toString());
        System.out.println(s.getCategory().toString());
        System.out.println(s.getDescription().toString());
        dao.save(s);
        HashMap<String,String>map=new HashMap<>();
        map.put("status","success");
        return map;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/view")
    public List<Shopping> ViewProduct()
    {
        return (List<Shopping>)dao.findAll();
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/search",consumes = "application/json",produces = "application/json")
    public List<Shopping> SearchProduct(@RequestBody Shopping s)
    {
        String name=s.getName();
        System.out.println(name);
        return (List<Shopping>) dao.SearchProduct(s.getName());
    }







}
