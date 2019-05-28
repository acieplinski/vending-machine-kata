package tdd.vendingMachine;

public class PurseBuilder {
    Purse purse;

    PurseBuilder() {
        purse = new Purse();
    }

    public PurseBuilder withCoin(Coin coin) {
        purse.getCoins().add(coin);
        return this;
    }

    public Purse build() {
        return purse;
    }
}
