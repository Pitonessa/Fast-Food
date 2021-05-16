import java.util.ArrayList;

/* OrderQueue : coda fifo dove vengono inseriti gli ordini
                è una lista di Ordini e un ordine è una lista di numeri
  metodi sincronizzati perchè usata da thread
*/


public class OrderQueue {
    private ArrayList<Order> orders;

    public OrderQueue() {
        this.orders = new ArrayList<>();
    } // un ordine è una lista di interi
    public synchronized void addOrder(Order order) { //mutua esclusione
        orders.add(order);
        notifyAll();
    }

    public synchronized Order removeOrder() throws InterruptedException {
        while (orders.isEmpty()) {
            System.err.println("Non ci sono nuovi ordini");
            wait(); // genera un exception
        }
        return orders.remove(orders.size() - 1);

    }

}
