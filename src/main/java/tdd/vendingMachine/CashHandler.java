package tdd.vendingMachine;

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
}
