package com.springboot.commerce.data.entity;

import lombok.*;

import javax.persistence.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Cart_item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="CartId")
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ProductNumber") // Product 엔티티와 매핑되는 속성명을 적절히 변경해주세요.
    private Product product;

    private int count; // 카트에 담긴 상품 개수




    public static Cart_item createCartItem(Cart cart,Product product,int count){
        Cart_item cartItem = new Cart_item();
        cartItem.setCart(cart);
        cartItem.setProduct(product);
        cartItem.setCount(count);

        return cartItem;
    }

    public void addCount(int count){
        this.count += count;
    }
}