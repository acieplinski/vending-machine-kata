package tdd.vendingMachine;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CashHandlerTest {

    private CashHandler cashHandler;

    @Before
    public void before() {
        cashHandler = new CashHandler();

        Product product = new Product("Water", new BigDecimal(1.60));
    }

    @Test
    public void canInsertCoins() {
        cashHandler.insertCoin(Coin.COIN_OF_1);
    }

    @Test
    public void checkNumberOfCoins() {
        // when
        cashHandler.insertCoin(Coin.COIN_OF_1);

        // then
        assertEquals(1, cashHandler.checkNumberOfCoins(Coin.COIN_OF_1));
    }

    @Test
    public void canGiveTheChange() {
        // given
        cashHandler.insertCoin(Coin.COIN_OF_2);
        assertEquals(1, cashHandler.checkNumberOfCoins(Coin.COIN_OF_2));

        // when
        cashHandler.giveCoinBack(Coin.COIN_OF_2);

        // then
        assertThat(cashHandler.checkNumberOfCoins(Coin.COIN_OF_2)).isEqualTo(0);
    }

    @Test
    public void canPayWithProperAmountOfCoins() {

        //initialize = one product on shelf no 21 with cost 3_00

        //cashHandler.payForProduct(product);

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

        // jak zaimplementować płatność za produkt, by:
        // w runtime zapewnić opcję wyboru kolejnych monet np. z konsoli
        // w teście podać kolejne wrzucane monety

    }

    @Test
    public void canPayAndGiveTheChange() {

    }

    @Test
    public void cannotPayWhenNoWayToGiveTheChange() {

    }
}
