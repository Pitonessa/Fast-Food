public class Simulator {
    public static void main(String args[]) throws InterruptedException {
        CustomerQueue cq = new CustomerQueue();
        OrderQueue oq = new OrderQueue();


        int N = 2; // più adattabile in caso di modifiche
        Cashier[] cc = new Cashier[N];
        for (int i = 0; i < N; i++) {
            cc[i] = new Cashier(cq, oq);
            cc[i].start();
        }

        int M = 3;
        Chef[] cf = new Chef[M];
        for (int i = 0; i < M; i++) {
            cf[i] = new Chef(oq);
            cf[i].start();
        }

        String name = "Cliente";
        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            Customer c = new Customer(name);
            cq.inLine(c);

        }
        Thread.sleep(2000);


    }
}

