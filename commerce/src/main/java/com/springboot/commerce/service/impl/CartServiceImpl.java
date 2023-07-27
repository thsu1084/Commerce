package com.springboot.commerce.service.impl;

import com.springboot.commerce.data.entity.Cart;
import com.springboot.commerce.data.entity.Cart_item;
import com.springboot.commerce.data.entity.Product;
import com.springboot.commerce.data.entity.User;
import com.springboot.commerce.data.repository.CartRepository;
import com.springboot.commerce.data.repository.Cart_itemRepository;
import com.springboot.commerce.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final Cart_itemRepository cart_itemRepository;

    @Override
    public void createCart(User user) {
        Cart cart = Cart.createCart(user);
        cartRepository.save(cart);
    }

    @Override
    public void addCart(User user, Product product, int count) {
        Cart cart = cartRepository.findByUserId(user.getId());

        if (cart == null) {
            cart = Cart.createCart(user);
            cartRepository.save(cart);
        }

        Cart_item cart_item = cart_itemRepository.findByCartIdAndProductNumber(cart.getId(), product.getNumber());

        if (cart_item == null) {
            cart_item = Cart_item.createCartItem(cart, product, count);
            cart_itemRepository.save(cart_item);
            cart.setCount(cart.getCount() + 1);
        } else {
            cart_item.addCount(count);
        }
    }

    @Override
    public List<Cart_item> userCartView(Cart cart) {
        return cart_itemRepository.findByCartId(cart.getId());
    }

    @Override
    public void cartItemDelete(Long id) {
        cart_itemRepository.deleteById(id);
    }
}