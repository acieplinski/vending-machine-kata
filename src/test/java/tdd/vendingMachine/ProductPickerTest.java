package tdd.vendingMachine;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ProductPickerTest {

    private ProductPicker productPicker;
    private VendingMachineOperator operator;

    @Before
    public void before() {
        operator = new VendingMachineOperator();
        operator.initializeVendingMachine();

        productPicker = new ProductPicker(operator);
    }

    @Test
    public void canPickUpProductFromShelve() {
        operator.addProductToShelve(new Product("chocolate bar", new BigDecimal("3.50")), 1);
        System.out.println(operator.getShelve(1).size());

        // when
        productPicker.pickUpFromShelve(1);

        // then
        assertTrue(productPicker.getOperator().getShelve(1).isEmpty());
        System.out.println(operator.getShelve(1).size());
    }
}
