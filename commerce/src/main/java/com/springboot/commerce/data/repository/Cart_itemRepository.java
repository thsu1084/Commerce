package com.springboot.commerce.data.repository;

import com.springboot.commerce.data.entity.Cart_item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Cart_itemRepository extends JpaRepository<Cart_item, Long> {
    List<Cart_item> findByCartId(Long cartId);
    Cart_item findByCartIdAndProductNumber(Long cartId, Long productId);
}