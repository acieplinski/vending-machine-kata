package tdd.vendingMachine;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class CashHandlerTest {

    private Purse purse;
    private CashHandler cashHandler;

    @Before
    public void before() {
        purse = new Purse();
        cashHandler = new CashHandler(purse);

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
        assertThat(cashHandler.checkNumberOfCoins(Coin.COIN_OF_1)).isEqualTo(1);
    }

    @Test
    public void canGiveTheChange() {
        // given
        cashHandler.insertCoin(Coin.COIN_OF_2);
        assertThat(cashHandler.checkNumberOfCoins(Coin.COIN_OF_2)).isEqualTo(1);

        // when
        cashHandler.giveCoinBack(Coin.COIN_OF_2);

        // then
        assertThat(cashHandler.checkNumberOfCoins(Coin.COIN_OF_2)).isEqualTo(0);
    }

    @Test
    public void canPayWithProperAmountOfCoins() {
        // given
        BigDecimal requiredCash = new BigDecimal(1.80);

        // when
        cashHandler.insertCoin(Coin.COIN_OF_1);
        cashHandler.insertCoin(Coin.COIN_OF_05);
        cashHandler.insertCoin(Coin.COIN_OF_02);
        cashHandler.insertCoin(Coin.COIN_OF_01);

        // then
        Assertions.assertThat(cashHandler.isInsertedCoinsEnoughToPay(requiredCash)).isTrue();
    }

    @Test
    public void canPayAndGiveTheChange() {

    }

    @Test
    public void cannotPayWhenNoWayToGiveTheChange() {

    }
}
