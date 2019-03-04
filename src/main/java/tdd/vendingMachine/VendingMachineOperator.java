package tdd.vendingMachine;

import java.util.ArrayList;

public class VendingMachineOperator {

    private ArrayList<Shelve> shelves = new ArrayList<>();

    public void addProductToShelve(Product product, int shelveIndex) {
        try {
            ArrayList<Product> productsOnShelve = getShelve(shelveIndex);
            if (!productsOnShelve.isEmpty()) {
                compareProducts(product, productsOnShelve.get(0));
            }
            productsOnShelve.add(product);
            setShelve(productsOnShelve, shelveIndex);
        }
        catch (MixingProductsOnTheShelveException e) {
            e.printStackTrace();
            System.out.println("You cannot mix products on the shelve");
        }
    }

    private void compareProducts(Product product1, Product product2) throws MixingProductsOnTheShelveException {
        if (product1.getName().equals(product2.getName()) &&
            product1.getPrice().equals(product2.getPrice())) {
            return;
        }
        else {
            throw new MixingProductsOnTheShelveException();
        }
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
