package oop1;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

abstract class Stationery {
    public String brand;
    public double price;
}
abstract class Writing extends Stationery{
    public String color;
    public double width;
}
class Pencil extends Writing{
    public Pencil(String br, double pr, String col, double wid) {
        brand = br;
        price = pr;
        color = col;
        width = wid;
    }
}

class Pen extends Writing{
    public Pen(String br, double pr, String col, double wid) {
        brand = br;
        price = pr;
        color = col;
        width = wid;
    }
}

class Cutter extends Stationery{
    public Cutter(String br, double pr) {
        brand = br;
        price = pr;
    }
}

class Scissors extends Stationery{
    public Scissors(String br, double pr) {
        brand = br;
        price = pr;
    }
}

class Ruler extends Stationery{
    public Ruler(String br, double pr) {
        brand = br;
        price = pr;
    }
}

class Notebook extends Stationery{
    public Notebook(String br, double pr) {
        brand = br;
        price = pr;
    }
}

///=======

class Desktop{
    private LinkedList<Stationery> itemsList;
    public double fullPrice(){
        ListIterator<Stationery> li =itemsList.listIterator();
        double sum = 0.0;
        while (li.hasNext()){
            sum+=li.next().price;
        }
        return sum;
    }
    public void add(Stationery st){
        itemsList.add(st);
    }

    public Desktop() {
        this.itemsList = new LinkedList<Stationery>();
    }
}

class Employee{
    public Desktop desktop;

    public Employee() {
        this.desktop = new Desktop();
    }
}

class Test{
    public static void main(String[] args) {
        Employee artemka = new Employee();
        artemka.desktop.add(new Pen("Parker",3.1,"Yellow",0.8));
        artemka.desktop.add(new Pencil("Carioca",2.5,"Red",0.6));
        artemka.desktop.add(new Scissors("111",10.5));

        System.out.println(artemka.desktop.fullPrice());
    }
}
