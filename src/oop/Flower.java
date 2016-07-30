package oop;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * rose
 * clove
 * tulip
 *
 */
abstract class Flower {
    protected double price;
    void setPrice(double price){
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}

class Rose extends Flower{
    public Rose(double price) {
        setPrice(price);
    }
}

class Clove extends Flower {
    public Clove(double price) {
        setPrice(price);
    }
}

class Tulip extends Flower {
    public Tulip(double price) {
        setPrice(price);
    }
}

class Bouquet {
    public static void main(String[] args) {
        Flower r1 = new Rose(3.14);
        Flower r2 = new Rose(1.59);
        Flower c = new Clove(2.65);
        Flower t = new Tulip(3.50);
        List<Flower> bouquet = new LinkedList<Flower>();
        bouquet.add(r1);
        bouquet.add(r2);
        bouquet.add(c);
        bouquet.add(t);
        ListIterator<Flower> li = bouquet.listIterator();
        double sum = 0.0;
        while (li.hasNext()){
            sum+=li.next().price;
        }

        System.out.println("Price of bouquet is "+sum);
    }
}
