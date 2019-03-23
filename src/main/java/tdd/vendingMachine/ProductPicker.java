package tdd.vendingMachine;

import java.util.ArrayList;
import java.util.List;

public class ProductPicker {
    private VendingMachineOperator operator;

    ProductPicker (VendingMachineOperator operator) {
        this.operator = operator;
    }

    public void pickUpFromShelve(int i) {
        ArrayList<Product> products = operator.getShelve(i);
        if (!products.isEmpty()) {
            products.remove(0);
            operator.setShelve(products, i);
        }
    }

    public VendingMachineOperator getOperator() {
        return operator;
    }
}
