package com.example.shoppingcart_backend.dao;

import com.example.shoppingcart_backend.model.Shopping;
import com.example.shoppingcart_backend.model.UserRegistration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends CrudRepository<UserRegistration,Integer> {
//  @Query(value = "SELECT `id`, `address`, `confirmpassword`, `email`, `name`, `password`, `phone` FROM `user_registration` WHERE `email` && `password`")
}
