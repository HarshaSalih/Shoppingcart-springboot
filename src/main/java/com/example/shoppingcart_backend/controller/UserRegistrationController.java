package com.example.shoppingcart_backend.controller;

import com.example.shoppingcart_backend.dao.UserDao;
import com.example.shoppingcart_backend.model.UserRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

public class UserRegistrationController {

    @Autowired
    private UserDao dao1;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/userlogin",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> UserLogin(@RequestBody UserRegistration u)
    {
        System.out.println(u.getEmail());
        List<UserRegistration> result=(List<UserRegistration>) dao1.FindUserLogin(u.getEmail(),u.getPassword());
        HashMap<String,String> s=new HashMap<>();
        if(result.size()==0)
        {
            s.put("status","failed");
            s.put("message","user doesn't exist");
        }
        else {
            int id=result.get(0).getId();
            s.put("userid",String.valueOf(id));
            s.put("status","success");
            s.put("message","user login success");
        }
        return s;
    }


    @CrossOrigin(origins = "*")

    @PostMapping(path = "/userregistration",consumes = "application/json",produces = "application/json")
    public Map<String,String> UserRegisteration(@RequestBody UserRegistration u)
    {
        System.out.println(u);
        List<UserRegistration> result=(List<UserRegistration>) dao1.FindUserLogin(u.getEmail(),u.getPassword());
        System.out.println(result);
        HashMap<String,String> s=new HashMap<>();
        if(result.size()!=0)
        {
            s.put("status","success");
            s.put("message","user already exist");
        }
        else {
            dao1.save(u);
            s.put("status","success");
            s.put("message","user added successfully");
        }
        return s;


//        System.out.println(u.getAddress().toString());
//        System.out.println(u.getPhone().toString());
//        System.out.println(u.getEmail().toString());
//        System.out.println(u.getPassword().toString());
//        System.out.println(u.getConfirmpassword().toString());
//        dao1.save(u);
//        HashMap<String,String> map=new HashMap<>();
//        map.put("status","success");
//        return map;
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path="/viewprofile",consumes = "application/json",produces = "application/json")
    public List<UserRegistration>viewProfile(@RequestBody UserRegistration u)
    {
        return dao1.viewProfile(u.getId());
    }
}
