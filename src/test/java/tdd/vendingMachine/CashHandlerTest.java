package tdd.vendingMachine;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CashHandlerTest {

    private CashHandler cashHandler;

    @Before
    public void before() {
        cashHandler = new CashHandler();
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

}
