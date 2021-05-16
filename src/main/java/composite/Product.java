package composite;

public interface Product {

    float getPrice();   // si omette la visibilità dei metodi
    String getName();
    Product getCopy();
}
