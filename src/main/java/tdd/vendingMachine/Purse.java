package tdd.vendingMachine;

import org.apache.commons.collections4.MultiSet;
import org.apache.commons.collections4.multiset.HashMultiSet;

public class Purse {

    MultiSet<Coin> coins;
    Purse () {
        coins = new HashMultiSet<>();
    }

}
