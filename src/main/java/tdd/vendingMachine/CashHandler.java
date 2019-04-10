package tdd.vendingMachine;

import java.math.BigDecimal;

public class CashHandler {

    private Purse purse;

    CashHandler(Purse purse) {
        this.purse = purse;
    }

    public void insertCoin(Coin coin) {
        if (coin.equals(Coin.OTHER_COIN)) {
            return;
        }
        purse.getCoins().add(coin);

    }

    public int checkNumberOfCoins(Coin coin) {
        return purse.getCoins().getCount(coin);
    }

    public void giveCoinBack(Coin coin) {
        purse.getCoins().remove(coin);
    }

    public boolean isInsertedCoinsEnoughToPay(BigDecimal amountToPay) {
        System.out.println(purse.getValue());
        System.out.println(amountToPay);
        return purse.getValue().compareTo(amountToPay) >= 0;
    }
}
