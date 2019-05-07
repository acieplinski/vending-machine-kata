package tdd.vendingMachine;

import java.math.BigDecimal;

public class CashHandler {

    private Purse insertedCoins;
    private Purse bank;
    private Purse change;


    CashHandler(Purse insertedCoins, Purse bank, Purse change) {
        this.insertedCoins = insertedCoins;
        this.bank = bank;
        this.change = change;
    }

    public void insertCoin(Coin coin) {
        if (coin.equals(Coin.OTHER_COIN)) {
            return;
        }
        insertedCoins.getCoins().add(coin);
    }

    public int checkNumberOfCoins(Coin coin) {
        return insertedCoins.getCoins().getCount(coin);
    }

    public void giveCoinBack(Coin coin) {
        insertedCoins.getCoins().remove(coin);
    }

    public boolean isInsertedCoinsEnoughToPay(BigDecimal amountToPay) {
        System.out.println("Inserted coins: " + insertedCoins.getValue());
        System.out.println("Amount to pay: " + amountToPay);
        return insertedCoins.getValue().compareTo(amountToPay) >= 0;
    }

    public boolean canGiveTheChangeBack(BigDecimal requiredCash) {
        System.out.println("Inserted coins: " + insertedCoins.getValue());
        System.out.println("Required cash: " + requiredCash);
        BigDecimal changeToGive = insertedCoins.getValue().subtract(requiredCash);
        Purse temp = new Purse();
        System.out.println("Change to give: " + changeToGive);
        if (bank.getValue().compareTo(changeToGive) >= 0) {
            while (changeToGive.compareTo(BigDecimal.ZERO) != 0) {
                try {
                    Coin coin = bank.takeAvailableCoinOfTheHighestValue(changeToGive);
                    temp.getCoins().add(coin);
                    changeToGive = changeToGive.subtract(coin.value);
                    System.out.println("Now the change to give equals: " + changeToGive);
                } catch (UnavailableCoinException e) {
                    e.printStackTrace();
                    System.out.println("Change cannot be given");
                    return false;
                }
            }
            if (changeToGive.compareTo(BigDecimal.ZERO) == 0) {
                System.out.println("Change can be given");
                return true;
            }
        }
        System.out.println("Change cannot be given");
        return false;
    }
}
