package com.springboot.commerce.controller;

import com.springboot.commerce.data.dto.ProductResponseDto;
import com.springboot.commerce.data.entity.Cart;
import com.springboot.commerce.data.entity.Product;
import com.springboot.commerce.data.entity.User;
import com.springboot.commerce.data.repository.CartRepository;
import com.springboot.commerce.service.CartService;
import com.springboot.commerce.service.ProductService;
import com.springboot.commerce.service.UserPageService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/cart")
public class CartController {

    private final ProductService productService;
    private final CartService cartService;
    private final UserPageService userPageService;
    private final CartRepository cartRepository;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-AUTH-TOKEN", value = "로그인 성공 후 발급 받은 access_token", required = true, dataType = "String", paramType = "header")
    })
    @PostMapping("/{id}/{productId}")
    public ResponseEntity<Product> myCartAdd(@PathVariable("id") Long id, @PathVariable("productId") Long productId, int count) {
        User user = userPageService.findUser(id);
        ProductResponseDto productResponseDto = productService.getProduct(productId);

        Product product = new Product();
        product.setName(productResponseDto.getName());
        product.setNumber(productResponseDto.getNumber());
        product.setPrice(productResponseDto.getPrice());
        product.setStock(productResponseDto.getStock());

        cartService.addCart(user, product, count);

        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-AUTH-TOKEN", value = "로그인 성공 후 발급 받은 access_token", required = true, dataType = "String", paramType = "header")
    })
    @GetMapping("/{id}/{cart_productId}/delete")
    public ResponseEntity<String> myCartDelete(@PathVariable("id") Long id, @PathVariable("cart_productId") Long cart_productId){
        User user = userPageService.findUser(id);
        Cart cart = cartRepository.findByUserId(user.getId());
        cartService.cartItemDelete(cart_productId);

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }
}
