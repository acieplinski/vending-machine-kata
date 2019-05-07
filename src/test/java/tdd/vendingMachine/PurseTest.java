package tdd.vendingMachine;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;


public class PurseTest {

    private Purse purse;

    @Before
    public void before() {
        purse = new Purse();
    }

    @Test
    public void canCountMoney() {
        // when
        purse.getCoins().add(Coin.COIN_OF_5);
        purse.getCoins().add(Coin.COIN_OF_2);
        purse.getCoins().add(Coin.COIN_OF_1,2);

        // then
        assertThat(purse.getValue()).isEqualTo("9.00");

        //testy:
        //załóż stan początkowy wrzutnika
        //sprawdzaj, jakimi monetami wydasz resztę dla zadanej kwoty; albo rzuć exception
    }
}
