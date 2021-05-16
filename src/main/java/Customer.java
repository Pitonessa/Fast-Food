public class Customer implements Observer {

    private static int count = 0;   //con static ne esiste una sola istanza evita sovrapposizioni
    private int costumerId;
    private String customerName;
    private float money;
    private Counter counter = Counter.getInstance();
    private Box box;


    public Customer(String customerName) {
        setCostumerId();
        this.customerName = customerName + "{" + getCostumerId() + "}";
        this.money = (float) (Math.random() * 100 + 1); // soldi casuali fino a 100$

    }

    public void setCostumerId() { //id è un contatore a incremento
        this.costumerId = ++count;
    }

    public String getCustomerName() {
        return customerName;
    }

    public float getMoney() {
        return money;
    }

    public  int getCostumerId() {
        return costumerId;
    }

    public Boolean paid(float cost) { // serve per pagare
        this.money -= cost;
        boolean paid = true;
        if (money < 0) {
            paid = false;
        }
        return paid;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public Order askRequest() { // serve per ordinare invocata dal cassiere
        System.out.println(getCustomerName() + " sta guardando il Menu:");
        Menu.getInstance().viewMenu();
        System.out.println();

        Order order = new Order(this);
        int c = (int) (Math.random() * 10+1); // randomizzazione dell'ordine
        for (int i = 0; i < c; i++) {
            int random = (int) (Math.random() * 10);
            order.getOrder().add(random);
        }
        System.out.println(getCustomerName() + " sta ordinando:" + order.getOrder());
        System.out.println();

        return order;
    }

    // perchè  Observer //
    /* se un oggetto cambia il suo stato interno,
    ciascuno degli oggetti dipendenti da esso viene notificato e aggiornato automaticamente.
     */
    @Override
    public void update() {
        box = counter.getBox(costumerId);
        System.out.println( getCustomerName() +" può ritirare il suo ordine");

    }

}
