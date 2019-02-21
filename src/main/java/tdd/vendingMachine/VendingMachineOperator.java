package tdd.vendingMachine;

import java.util.ArrayList;

public class VendingMachineOperator {

    private ArrayList<Shelve> shelves = new ArrayList<>();

    public void addProductToShelve(Product product, int shelveIndex) {
        ArrayList<Product> productsOnShelve = new ArrayList<>();
        productsOnShelve = getShelve(shelveIndex);
        System.out.println(productsOnShelve);
        productsOnShelve.add(product);
        setShelve(productsOnShelve, shelveIndex);
    }

    private void setShelve(ArrayList<Product> productsOnShelve, int shelveIndex) {
        shelves.get(shelveIndex).setProductsOnShelve(productsOnShelve);
    }

    public ArrayList<Product> getShelve(int shelveIndex) {
        return shelves.get(shelveIndex).getProductsOnShelve();
    }

    public void initializeVendingMachine() {
        for (int i = 0; i < 10; i++) {
            shelves.add(new Shelve());
        }
    }
}
