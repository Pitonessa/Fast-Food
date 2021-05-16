package composite;

public class Drink implements Product {

    private int size;
    private float price;
    private boolean ice;
    private String drinkName;

    public Drink() {
        this.size = (int) (Math.random() * 3);
        ice = Math.random() > 0.5 ? true : false;
        setPrice();
        setName();
    }

    public Drink(Drink drink) { // costruttore di copia
        size = drink.size;
        price = drink.price;
        ice = drink.ice;
        drinkName = drink.drinkName;
    }

    public Drink(int s) { // testing
        size = s;
        ice = false;
        setPrice();
        setName();
    }

    private void setName() {
        if (size == 0)
            drinkName = "S";
        else if (size == 1)
            drinkName = "M";
        else
            drinkName = "L";

        if (ice)
            drinkName += "-coldDrink";
        else
            drinkName += "-hotDrink";
    }

    private void setPrice() {
        if (size == 0)
            price = 1.5f;
        else if (size == 1)
            price = 2.5f;
        else
            price = 3.0f;
    }

    @Override
    public float getPrice() {
        return price;
    }


    public int getSize() {
        return size;
    }

    @Override
    public String getName() {
        return drinkName;
    }

    @Override
    public Product getCopy() {
        return new Drink(this);
    }

}
