package tdd.vendingMachine;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class VendingMachineTest {

    @Test
    public void just_a_stupid_passing_test_to_ensure_that_tests_are_run() {
        Assertions.assertThat(new VendingMachine()).isNotNull();
    }

    @Test
    public void canPayForProductWithProperAmountOfCoins() {

//        initialize = one product on shelf no 21 with cost 3_00
//
//        cashHandler.payForProduct(product);

//        machine.insertCoin(Coin.COIN_OF_1);
//        machine.insertCoin(Coin.COIN_OF_2);
//
//        product = machine.selectProduct(21); //cost is 3
//
//        //expect
//        product is not null
//        machine.getProductCount(21).is(0);
//
//        //machine.inset
    }
}
