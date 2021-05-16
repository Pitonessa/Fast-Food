
// sacchetto


import composite.Product;

import java.util.ArrayList;

public class Box {
    private ArrayList<Product> p;
    private int customerId;


    public Box( ArrayList<Product> p, int customerId) {
        this.p = p;
        this.customerId = customerId;


    }

    public ArrayList<Product> getP() {
        return p;
    }

    public int getId() {
        return customerId;
    }
}
