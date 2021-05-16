package composite;

public class FrenchFries implements Product {
    private int size;
    private float price;
    private String friesName;
    private boolean sauce;

    public FrenchFries() {
        this.size = (int) (Math.random() * 3);
        sauce = Math.random() > 0.5 ? true : false;
        setPrice();
        setName();
    }

    public FrenchFries(FrenchFries frenchFries) { // costruttore di copia
        size = frenchFries.size;
        price = frenchFries.price;
        friesName = frenchFries.friesName;
        sauce = frenchFries.sauce;
    }

    public FrenchFries(int s) { // testing
        size = s;
        sauce = false;
        setPrice();
        setName();
    }

    private void setName() {
        if (size == 0)
            friesName = "S";
        else if (size == 1)
            friesName = "M";
        else
            friesName = "L";

        if (sauce)
            friesName += "-sauceFries";
        else
            friesName += "-NOsauceFries";

    }

    private void setPrice() {
        if (size == 0)
            price = 1;
        else if (size == 1)
            price = 2;
        else
            price = 3;
        if (sauce)
            price += 0.5f;

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
        return friesName;
    }

    @Override
    public Product getCopy() {
        return new FrenchFries(this);
    }
}
