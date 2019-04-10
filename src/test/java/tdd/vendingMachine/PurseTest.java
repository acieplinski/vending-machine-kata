package tdd.vendingMachine;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.MatcherAssert.assertThat;


public class PurseTest {

    private Purse purse;

    @Before
    public void before() {
        purse = new Purse();
    }

    @Test
    public void canCountMoney() {
        BigDecimal expected = new BigDecimal(9.0);

        // when
        purse.getCoins().add(Coin.COIN_OF_5);
        purse.getCoins().add(Coin.COIN_OF_2);
        purse.getCoins().add(Coin.COIN_OF_1,2);

        // then
        assertThat(purse.getValue(), Matchers.comparesEqualTo(expected));
    }
}
