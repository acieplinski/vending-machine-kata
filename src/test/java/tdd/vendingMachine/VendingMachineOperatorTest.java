package tdd.vendingMachine;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class VendingMachineOperatorTest {

    VendingMachineOperator operator;

    @Before
    public void before() {
         operator = new VendingMachineOperator();
         operator.initializeVendingMachine();
    }

    @Test
    public void canAddProductToShelve() {
        // when
        operator.addProductToShelve(new Product("chocolate bar", new BigDecimal("3.50")), 1);

        // then
        assertNotNull(operator.getShelve(1));
        assertEquals(operator.getShelve(1).get(0).getName(), new Product("chocolate bar", new BigDecimal("3.50")).getName());
        assertEquals(operator.getShelve(1).get(0).getPrice(), new Product("chocolate bar", new BigDecimal("3.50")).getPrice());
    }

    @Test
    public void cannotMixProductsOnTheSameShelve() {
        // given
        operator.addProductToShelve(new Product("chocolate bar", new BigDecimal("3.50")), 1);

        // when
        operator.addProductToShelve(new Product("CocaCola", new BigDecimal("2.50")), 1);

        // then
        assertNotNull(operator.getShelve(1));
        assertEquals(1, operator.getShelve(1).size());
        assertEquals(operator.getShelve(1).get(0).getName(), new Product("chocolate bar", new BigDecimal("3.50")).getName());
        assertEquals(operator.getShelve(1).get(0).getPrice(), new Product("chocolate bar", new BigDecimal("3.50")).getPrice());
    }
}
