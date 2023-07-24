package com.springboot.commerce.data.repository;



import com.springboot.commerce.data.entity.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {

    /*
    아래 메소드는 책에서 소개하고 있는 Repository의 메소드 명명 규칙 예시입니다.

    StartingWith(=StartWith) , EndingWith(=EndWith),
    Containing(=Contains), Like
    SQL 쿼리문에서 값의 일부를 포함하는 값을 추출할 때 사용하는 '%' 키워드와 동일한 역할

    */
    List<Product> findByNameLike(String name);

    List<Product> findByNameContaining(String name);

    List<Product> findByNameStartingWith(String name);

    List<Product> findByNameStartsWith(String name);

    List<Product> findByNameEndsWith(String name);

    /*

     */

    List<Product> findByPriceGreaterThan(int price);

    List<Product> findByPriceLessThan(int price);

    List<Product> findByNameOrderByPriceAsc(String name);

}