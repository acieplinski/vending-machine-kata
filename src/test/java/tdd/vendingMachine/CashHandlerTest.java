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
        cashHandler.insertCoin(Coins.COIN_OF_1);
    }

    @Test
    public void checkNumberOfCoins() {
        // when
        cashHandler.insertCoin(Coins.COIN_OF_1);

        // then
        assertEquals(1, cashHandler.checkNumberOfCoins(Coins.COIN_OF_1));
    }

    @Test
    public void canGiveTheChange() {
        // given
        cashHandler.insertCoin(Coins.COIN_OF_2);
        assertEquals(1, cashHandler.checkNumberOfCoins(Coins.COIN_OF_2));

        // when
        cashHandler.giveCoinBack(Coins.COIN_OF_2);

        // then
        assertEquals(0, cashHandler.checkNumberOfCoins(Coins.COIN_OF_2));
    }

    @Test
    public void canPayWithProperAmountOfCoins() {

        cashHandler.payForProduct(product);
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
