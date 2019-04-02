package tdd.vendingMachine;

import java.math.BigDecimal;

public enum Coin {
    COIN_OF_5(new BigDecimal(5)),
    COIN_OF_2(new BigDecimal(2)),
    COIN_OF_1(new BigDecimal(1)),
    COIN_OF_05(new BigDecimal(0.5)),
    COIN_OF_02(new BigDecimal(0.2)),
    COIN_OF_01(new BigDecimal(0.1)),
    OTHER_COIN(new BigDecimal(0));

    BigDecimal value;

    Coin(BigDecimal value) {
        this.value = value;
    }
}
