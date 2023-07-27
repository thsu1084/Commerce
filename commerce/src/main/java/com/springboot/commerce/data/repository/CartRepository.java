package com.springboot.commerce.data.repository;

import com.springboot.commerce.data.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springboot.commerce.data.repository.Cart_itemRepository;
@Repository
public interface CartRepository extends JpaRepository<Cart,Long> {
    Cart findByUserId(Long userId);
}