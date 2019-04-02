package tdd.vendingMachine;

public class CashHandler {
    public void insertCoin(Coin coin) {
        if (coin.equals(Coin.OTHER_COIN)) {
            return;
        }

        coin.addOneCoin();
    }

    public int checkNumberOfCoins(Coin coin) {
        return coin.getCount();
    }

    public void giveCoinBack(Coin coin) {
        coin.getOneCoin();
    }
}
