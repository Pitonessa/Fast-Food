import java.util.ArrayList;

/* CustomerQueue : coda fifo di clienti
   metodi sincronizzati per tread
   ogni volta che arriva un cliente si mette in fila
   il primo che arriva è il primo ad essere servito
*/

public class CustomerQueue {
    private ArrayList<Customer> customers;

    public CustomerQueue() {
        this.customers = new ArrayList<>();
    }

    public synchronized void inLine(Customer c){ // quando arriva un cliente si add alla coda
        customers.add(c);
        System.out.println(c.getCustomerName() + " si è messo in fila");
        System.out.println();
        notifyAll();

    }

    public synchronized Customer service() throws InterruptedException {
        while(customers.isEmpty()){
            System.err.println("Non ci sono clienti da servire");
            wait();
        }
        return customers.remove(customers.size()-1);





    }
}
