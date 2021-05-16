import composite.Product;

import java.util.ArrayList;

// Chef è thread, subject e builder

public class Chef extends Thread {

    private OrderQueue orderQueue;
    private ArrayList<Product> menu = Menu.getInstance().getMenu();
    private Subject subject;  //  doppia estensione probb!! sol= estensione per composizione
    private Counter counter = Counter.getInstance();


    public Chef(OrderQueue qo) {
        this.subject = new Subject();
        this.orderQueue = qo;

    }


    private synchronized ArrayList<Product> prepareOrder() throws InterruptedException {
        Order id = orderQueue.removeOrder();
        subject.addObs(id.getCustomer());
        ArrayList<Product> p = new ArrayList<>();
        for (int i = 0; i < id.getSize(); i++)  {               // passaggio da interi  a prodotti
            p.add(menu.get(id.getOrder().get(i)).getCopy());   // costruttori di copia

        }
        System.out.println("Chef ha completato ordine di "+ id.getCustomer().getCustomerName());
        subject.notifyAllObs(id.getCustomer());
        Box b = new Box(p, id.getCustomer().getCostumerId());
        counter.putBox(b);
        return p;               // viene costruito un prodotto alla volta
    }

    public void run() {
        try {
            while (true) {
                ArrayList<Product> p = prepareOrder();
                Thread.sleep(3000);



            }
        } catch (InterruptedException ie) {

        }
    }

}
