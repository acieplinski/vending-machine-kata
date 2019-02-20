package tdd.vendingMachine;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ProductTest {

    @Test
    public void productShouldHaveNameAndPrice() {
        // when
        Product product = new Product("CocaCola", new BigDecimal("2.50"));

        // then
        Assertions.assertThat(product.getName()).isNotNull();
        Assertions.assertThat(product.getPrice()).isNotNull();
    }

}
