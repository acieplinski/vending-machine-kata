package tdd.vendingMachine;

public class CashHandler {
    public void insertCoin(Coins coin) {
        if (coin.equals(Coins.OTHER_COIN)) {
            return;
        }

        coin.addOneCoin();
    }

    public int checkNumberOfCoins(Coins coin) {
        return coin.getCount();
    }

    public void giveCoinBack(Coins coin) {
        coin.getOneCoin();
    }
}
