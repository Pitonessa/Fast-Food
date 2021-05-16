import java.util.ArrayList;

/*
Subject : classe base pattern Observer
         ha una lista di osservatori ai quali notifica il suo stato una volta compiuto
         deprecate quella di java.util
 */

public class Subject {
    private ArrayList<Observer> observers = new ArrayList<>();

    protected void addObs(Observer o) {
        observers.add(o);
    }

    protected void notifyAllObs(Customer c) {
        c.update();
        removeObs(c);

    }


    protected Observer removeObs(Customer c) {
        Observer o = null;
        for(int i =0; i<observers.size(); i++){
            if(observers.get(i) == c){
                o = observers.remove(i);
            }
        }
        return o;

    }
}
