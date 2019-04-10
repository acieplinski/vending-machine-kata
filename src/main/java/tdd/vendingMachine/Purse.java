package tdd.vendingMachine;

import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.multiset.HashMultiSet;

import java.math.BigDecimal;

public class Purse {

    private MultiSet<Coin> coins;

    Purse() {
        coins = new HashMultiSet<>();
    }

    public MultiSet<Coin> getCoins() {
        return coins;
    }

    public BigDecimal getValue() {
        BigDecimal value = BigDecimal.ZERO;

        for (Coin coin : Coin.values()) {
            BigDecimal count = new BigDecimal(coins.getCount(coin));
            value = value.add(count.multiply(coin.value));
        }

        return value;
    }
}
