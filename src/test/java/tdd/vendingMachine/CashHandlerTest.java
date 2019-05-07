package tdd.vendingMachine;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class CashHandlerTest {

    private Purse insertedCoins;
    private Purse bank;
    private Purse change;
    private CashHandler cashHandler;

    @Before
    public void before() {
        insertedCoins = new Purse();
        bank = new Purse();
        change = new Purse();
        cashHandler = new CashHandler(insertedCoins, bank, change);

        Product product = new Product("Water", new BigDecimal(1.60));
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
        BigDecimal requiredCash = new BigDecimal("1.80");

        // when
        cashHandler.insertCoin(Coin.COIN_OF_1);
        cashHandler.insertCoin(Coin.COIN_OF_05);
        cashHandler.insertCoin(Coin.COIN_OF_02);
        cashHandler.insertCoin(Coin.COIN_OF_01);

        // then
        assertThat(cashHandler.isInsertedCoinsEnoughToPay(requiredCash)).isTrue();
    }

    @Test
    public void canPayAndGiveTheChangeByOneCoin() {
        // given
        BigDecimal requiredCash = new BigDecimal("1.80");
        bank.getCoins().add(Coin.COIN_OF_01);

        // when
        cashHandler.insertCoin(Coin.COIN_OF_1);
        cashHandler.insertCoin(Coin.COIN_OF_05);
        cashHandler.insertCoin(Coin.COIN_OF_02);
        cashHandler.insertCoin(Coin.COIN_OF_02);

        // then
        assertThat(cashHandler.isInsertedCoinsEnoughToPay(requiredCash)).isTrue();
        assertThat(cashHandler.canGiveTheChangeBack(requiredCash)).isTrue();
    }

    @Test
    public void canPayAndGiveTheChangeByThreeCoins() {
        // given
        BigDecimal requiredCash = new BigDecimal("3.20");
        bank.getCoins().add(Coin.COIN_OF_05);
        bank.getCoins().add(Coin.COIN_OF_02);
        bank.getCoins().add(Coin.COIN_OF_01);

        // when
        cashHandler.insertCoin(Coin.COIN_OF_2);
        cashHandler.insertCoin(Coin.COIN_OF_2);

        // then
        assertThat(cashHandler.isInsertedCoinsEnoughToPay(requiredCash)).isTrue();
        assertThat(cashHandler.canGiveTheChangeBack(requiredCash)).isTrue();
    }

    @Test
    public void cannotPayWhenNoWayToGiveTheChange() {
        // given
        BigDecimal requiredCash = new BigDecimal("1.80");
        bank.getCoins().add(Coin.COIN_OF_1);

        // when
        cashHandler.insertCoin(Coin.COIN_OF_1);
        cashHandler.insertCoin(Coin.COIN_OF_05);
        cashHandler.insertCoin(Coin.COIN_OF_02);
        cashHandler.insertCoin(Coin.COIN_OF_02);

        // then
        assertThat(cashHandler.isInsertedCoinsEnoughToPay(requiredCash)).isTrue();
        assertThat(cashHandler.canGiveTheChangeBack(requiredCash)).isFalse();
    }
}
