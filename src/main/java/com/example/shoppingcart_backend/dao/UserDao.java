package com.example.shoppingcart_backend.dao;

import com.example.shoppingcart_backend.model.UserRegistration;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<UserRegistration,Integer> {
}
