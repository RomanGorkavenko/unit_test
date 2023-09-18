package ru.gb.seminars.sem1.shop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ShopTest {

    /*
   1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов (правильное количество продуктов, верное содержимое корзины).
   2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
   3. Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).
   */

    private Shop shop;
    private List<Product> products;
    private Product product;
    private Product product2;
    private Product product3;

    @BeforeEach
    void setUp() {
        shop = new Shop();
        products = new ArrayList<>();

        product = new Product();
        product.setTitle("Orange");
        product.setCost(50);
        products.add(product);

        product2 = new Product();
        product2.setTitle("Apple");
        product2.setCost(30);
        products.add(product2);

        product3 = new Product();
        product3.setTitle("Water");
        product3.setCost(10);
        products.add(product3);


        shop.setProducts(products);

    }

    @Test
    public void getProducts_checkingTheQuantityOfProducts_successfully() {
        assertThat(shop.getProducts()).hasSize(3);
    }

    @Test
    public void getProducts_checkingTheContent_successfully() {
        assertThat(shop.getProducts()).contains(product);
        assertThat(shop.getProducts()).contains(product2);
        assertThat(shop.getProducts()).contains(product3);
    }

    @Test
    public void sortProductsByPrice_checkingTheCorrectnessOfSorting_sortedCollection() {
        List<Product> actual = shop.sortProductsByPrice();

        List<Product> expected = new ArrayList<>(List.of(product3, product2, product));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void getMostExpensiveProduct_gettingTheProductWithTheMaximumCost_productWithCostOf50() {

        int actual = shop.getMostExpensiveProduct().getCost();

        int expected = 50;

        assertThat(actual).isEqualTo(expected);
    }
}