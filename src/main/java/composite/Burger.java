package composite;
// size = 0,1,2 (small, medium, large)
// price: dipende dalla grandezza etc...
// chicken true: pollo
// chicken false: burger


public class Burger implements Product {

    private int size;
    private float price;
    private String burgerName;
    private boolean chicken;

    public Burger() {
        this.size = (int) (Math.random() * 3);
        chicken = Math.random() > 0.5 ? true : false;
        setPrice();
        setName();
    }

    // testing
    public Burger(int s) {
        size = s;
        chicken = false;
        setPrice();
        setName();

    }

    //costruttore di copia
    public Burger(Burger burger) {
        size = burger.size;
        chicken = burger.chicken;
        price = burger.price;
        burgerName = burger.burgerName;

    }



    public void setName() {
        if (size == 0)
            burgerName = "S";
        else if (size == 1)
            burgerName = "M";
        else
            burgerName = "L";
        if (chicken)
            burgerName += "-chicken";
        else
            burgerName += "-burger";
    }

    @Override
    public float getPrice() {
        return price;
    }

    public void setPrice() {
        float multiply;
        if (chicken)
            multiply = 2;
        else
            multiply = 1.5f;
        if (size == 0)
            price = multiply;
        else if (size == 1)
            price = multiply * 2;
        else
            price = multiply * 3;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String getName() {
        return burgerName;
    }

    @Override
    public Product getCopy() {
        return new Burger(this);
    }
}

