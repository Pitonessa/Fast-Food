import java.util.ArrayList;

public class Order {
    private ArrayList<Integer> order = new ArrayList<>();
    private Customer cc;

    public Order(Customer cc) {
        this.cc = cc;
    }

    public ArrayList<Integer> getOrder() {
        return order;
    }

    public int getSize() {
        return order.size();
    }

    public Customer getCustomer() {
        return cc;
    }
}