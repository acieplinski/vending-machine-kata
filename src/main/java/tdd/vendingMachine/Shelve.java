package tdd.vendingMachine;

import java.util.ArrayList;

public class Shelve {

    ArrayList<Product> products;

    public ArrayList<Product> getProductsOnShelve() {
        return products;
    }

    public void setProductsOnShelve(ArrayList<Product> productsOnShelve) {
        products = productsOnShelve;
    }
}
