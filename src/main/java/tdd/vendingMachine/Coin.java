package tdd.vendingMachine;

import java.math.BigDecimal;

public enum Coin {
    COIN_OF_5(new BigDecimal("5.00")),
    COIN_OF_2(new BigDecimal("2.00")),
    COIN_OF_1(new BigDecimal("1.00")),
    COIN_OF_05(new BigDecimal("0.50")),
    COIN_OF_02(new BigDecimal("0.20")),
    COIN_OF_01(new BigDecimal("0.10")),
    OTHER_COIN(new BigDecimal("0"));

    BigDecimal value;

    Coin(BigDecimal value) {
        this.value = value;
    }
}
