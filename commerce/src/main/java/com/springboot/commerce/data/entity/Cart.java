package com.springboot.commerce.data.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int count; // 카트에 담긴 상품 개수

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    User user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cart")
    private List<Cart_item> cart_items = new ArrayList<>();

    public static Cart createCart(User user) {
        Cart cart = new Cart();
        cart.user = user;
        cart.count = 0;

        return cart;
    }
}