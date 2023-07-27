package com.springboot.commerce.service;

import com.springboot.commerce.data.entity.Cart;
import com.springboot.commerce.data.entity.Cart_item;
import com.springboot.commerce.data.entity.Product;
import com.springboot.commerce.data.entity.User;

import java.util.List;

public interface CartService {

    public void createCart(User user);

    public void addCart(User user, Product product, int count);

    public List<Cart_item> userCartView(Cart cart);


    public void cartItemDelete(Long id);
}
