package composite;

import java.util.ArrayList;

public class Coupon implements Product {

    private float discount;
    private ArrayList<Product> pp = new ArrayList<>();
    private String couponName = "";
    private float price;


    public Coupon(int nBurger, int nFrenchFries, int nDrink, float d){ // for testing
        int size = 0;
        discount = d;
        for(int i = 0; i<nBurger; i++)
            pp.add(new Burger(size));
        for(int i = 0; i<nDrink; i++)
            pp.add(new Drink(size));
        for(int i = 0; i<nFrenchFries; i++)
            pp.add(new FrenchFries(size));
        setPrice();
        setName();
    }

    public Coupon() {
        discount = (float) (Math.random() * 0.46 + 0.05); //  discount compreso tra 50% e 5% (0.05 0.5)
        float pBurger = (float) (Math.random());
        float pDrink = (float) (Math.random());
        float pFrenchFries = (float) (Math.random());
        int nBurger;
        int nFrenchFries;
        int nDrink;
        if (pBurger < 0.33)
            nBurger = 1;
        else if (pBurger < 0.66) //1/3 di prob
            nBurger = 2;
        else nBurger = 3;
        if (pDrink < 0.33)
            nDrink = 1;
        else if (pDrink < 0.66) //1/3 di prob
            nDrink = 2;
        else nDrink= 3;
        if (pFrenchFries < 0.33)
            nFrenchFries = 1;
        else if (pFrenchFries < 0.66) //1/3 di prob
            nFrenchFries = 2;
        else nFrenchFries= 3;
        for(int i = 0; i<nBurger; i++)
            pp.add(new Burger());
        for(int i = 0; i<nDrink; i++)
            pp.add(new Drink());
        for(int i = 0; i<nFrenchFries; i++)
            pp.add(new FrenchFries());
        setPrice();
        setName();

    }


    public Coupon(Coupon coupon) { // costruttore di copia
        discount = coupon.discount;
        pp = coupon.pp;
    }


    public void setPrice() {
        for (Product p : pp) {
            price += p.getPrice();
        }
        price = price - (price * discount);

    }


    public void setName() {
        for (Product p : pp) {
            couponName += p.getName() + "-";

        }

    }


    @Override
    public String getName(){
        return couponName;
    }



    @Override
    public float getPrice() {
        return price;
    }

    @Override
    public Product getCopy() {
        return new Coupon(this);
    }
}
