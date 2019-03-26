package tdd.vendingMachine;

public enum Coins {
    COIN_OF_5(5,    0),
    COIN_OF_2(2,    0),
    COIN_OF_1(1,    0),
    COIN_OF_05(0.5, 0),
    COIN_OF_02(0.2, 0),
    COIN_OF_01(0.1, 0),
    OTHER_COIN(0,   0);

    double value;
    int count;

    Coins (double value, int count) {
        this.value = value;
        this.count = count;
    }

    public void addOneCoin() {
        this.count++;
    }

    public void getOneCoin() {
        if (this.count > 0) {
            this.count--;
        }
    }

    public int getCount() {
        return count;
    }
}
