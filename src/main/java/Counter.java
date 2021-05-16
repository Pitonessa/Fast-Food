
// bancone è una coda fifo singleton visibilità globale

import java.util.ArrayList;

public class Counter {
    private static Counter instance = null;
    private ArrayList<Box> b = new ArrayList<>();

    private Counter() {
    }

    public static Counter getInstance() {
        if (instance == null)
            instance = new Counter();
        return instance;
    }

    public void putBox(Box box) {
        b.add(box);
    }

    public Box getBox(int id) {
        Box bb = null;
        for (int i = 0; i < b.size(); i++) {
            if (b.get(i).getId() == id) {
                bb = b.remove(i);

            }

        }
        return bb;
    }


}
