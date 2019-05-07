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

    public Coin takeAvailableCoinOfTheHighestValue(BigDecimal changeToGive) throws UnavailableCoinException {
        for (Coin c: Coin.values()) {
            System.out.println("Checking coin: " + c.value);
            if (c.value.compareTo(changeToGive) <= 0
                && coins.contains(c)) {
                System.out.println("Bank returning coin: " + c.value);
                System.out.println("There were: " + coins.getCount(c) + " of that coin");
                coins.remove(c);
                return c;
            }
        }
        throw new UnavailableCoinException();
    }
}
