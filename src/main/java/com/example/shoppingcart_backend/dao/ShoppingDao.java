package com.example.shoppingcart_backend.dao;

import com.example.shoppingcart_backend.model.Shopping;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShoppingDao extends CrudRepository<Shopping,String> {

    @Query(value = "SELECT `id`, `category`, `description`, `image`, `name`, `price` FROM `shopping` WHERE `name`LIKE %:name%",nativeQuery = true)
    List<Shopping>SearchProduct(@Param("name")String name);

}