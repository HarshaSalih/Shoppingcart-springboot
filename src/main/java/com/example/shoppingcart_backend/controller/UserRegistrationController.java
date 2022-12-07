package com.example.shoppingcart_backend.controller;

import com.example.shoppingcart_backend.dao.UserDao;
import com.example.shoppingcart_backend.model.UserRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController

public class UserRegistrationController {

    @Autowired
    private UserDao dao1;


    @CrossOrigin(origins = "*")

    @PostMapping(path = "/userregistration",consumes = "application/json",produces = "application/json")
    public Map<String,String> UserRegisteration(@RequestBody UserRegistration u)
    {
        System.out.println(u.getName().toString());
//        System.out.println(u.getAddress().toString());
//        System.out.println(u.getPhone().toString());
//        System.out.println(u.getEmail().toString());
//        System.out.println(u.getPassword().toString());
//        System.out.println(u.getConfirmpassword().toString());
        dao1.save(u);
        HashMap<String,String> map=new HashMap<>();
        map.put("status","success");
        return map;
    }
}
