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
//        assertThat(operator.getShelve(1)).isNotNull();
//        assertThat(operator.getShelve(1).size());

        assertNotNull(operator.getShelve(1));
    }

    @Test(expected = MixingProductsOnTheShelveException.class)
    public void cannotMixProductsOnTheSameShelve() {
        // given
        operator.addProductToShelve(new Product("chocolate bar", new BigDecimal("3.50")), 1);

        // when
        operator.addProductToShelve(new Product("CocaCola", new BigDecimal("2.50")), 1);
    }

}
