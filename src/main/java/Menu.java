import composite.*;

import java.util.ArrayList;

/* Menu è un Singleton quindi : costruttore privato
                                metodo pubblico e statico
                                unica istanza
                                visibilità globale
                                per il resto si comporta come una classe normale

  Menu è una lista di prodotti(nome) con relativo prezzo
*/

// n.b poteva essere una lista di stringhe volendo ma più complicato

public class Menu {

    private static Menu instance = null;  // riferimento all'istanza
    private ArrayList<Product> products = new ArrayList<>();


    private Menu() { // costruttore privato
        for (int i = 0; i < 10; i++) {       //creazione randomica del menu
            Product p;
            float random = (float) Math.random();
            if (random < 0.25)
                p = new Burger();
            else if (random < 0.5)
                p = new Drink();
            if (random < 0.75)
                p = new FrenchFries();
            else
                p = new Coupon();

            products.add(p);
        }

    }


    public static Menu getInstance() { // delega la costruzione dell'istanza ad un metodo statico
        if (instance == null)
            instance = new Menu();
        return instance;

    }


    public ArrayList<Product> getMenu() {
        return products;
    }

    public void viewMenu() { // stampa il menu: prodotti e relativo prezzo
        System.out.println("****************** MENU *********************");
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i).getName() + "(" + ( i ) + ")" + " " + products.get(i).getPrice()+"$");
        }
        System.out.println("*********************************************");

    }

}

