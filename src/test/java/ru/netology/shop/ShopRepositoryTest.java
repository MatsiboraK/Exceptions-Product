package ru.netology.shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    ShopRepository repo = new ShopRepository();
    Product product1 = new Product(1, "Диплом", 30_000);
    Product product2 = new Product(2, "Курсовая работа", 15_000);
    Product product3 = new Product(3, "Дипломный проект", 80_000);
    Product product4 = new Product(4, "Итоговый проект", 150_000);

    @Test
    public void shouldRemoveTheExistingElement() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);
        repo.removeById(4);

        Product[] expected = {product1, product2, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowAnException() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.add(product4);


        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(5);
        });
    }

}
