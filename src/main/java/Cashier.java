import composite.Product;

import java.util.ArrayList;

// customer deve ordinare dove l' ordine è un array di interi
// i clienti si mettono in fila e vengono serviti dai cassieri in ordine di arrivo

public class Cashier extends Thread {

    private int cashierId;
    private static int count = 0; // n.b static serve per evitare sovrapposizioni unica istanza
    private CustomerQueue cQueue;
    private OrderQueue oQueue;


    public Cashier(CustomerQueue customer, OrderQueue qo) {
        this.cQueue = customer;
        this.oQueue = qo;
        setCashierId();

    }


    public int getCashierId() {
        return cashierId;
    }

    public void setCashierId() { // id è un contatore a incremento
        cashierId = ++count;
    }


    public void run() {
        try {
            while (true) {
                Customer c = cQueue.service();
                System.out.println("Cashier(" + getCashierId() + ") sta servendo " + c.getCustomerName());
                System.out.println();

                Order order = c.askRequest();
                Thread.sleep(200);
                oQueue.addOrder(order);
                float bill = payment(order);
                System.out.println("Il conto di " + c.getCustomerName() + " è: " + bill + "$");
                Thread.sleep(500);

                if (c.paid(bill))
                    System.out.println(c.getCustomerName() + " ha pagato");
                else
                    System.err.println(c.getCustomerName() + " NON può pagare!!");


            }
        } catch (InterruptedException ie) {


        }
    }



    private float payment(Order order) { // passaggio da intero a prodotto!!
        Menu menu = Menu.getInstance();
        ArrayList<Product> p = menu.getMenu();
        float tot = 0;
        for (int i = 0; i < order.getSize(); i++) {
            tot += p.get(order.getOrder().get(i)).getPrice();
        }
        return tot;

    }


}


