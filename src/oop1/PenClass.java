package oop1;

import java.awt.*;

/**
 * Created by Artemka on 31.07.2016.
 */

public class PenClass {
    private String brand;
    private Color color;
    private double length;
    private double width;

    public PenClass(String brand, Color col, double len, double wid){
        this.brand = brand;
        color = col;
        length = len;
        width = wid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PenClass PenClass = (PenClass) o;

        if (Double.compare(PenClass.length, length) != 0) return false;
        if (Double.compare(PenClass.width, width) != 0) return false;
        if (brand != null ? !brand.equals(PenClass.brand) : PenClass.brand != null) return false;
        return color.equals(PenClass.color);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = brand != null ? brand.hashCode() : 0;
        result = 31 * result + color.hashCode();
        temp = Double.doubleToLongBits(length);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(width);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "PenClass{" +
                "brand='" + brand + '\'' +
                ", color=" + color +
                ", length=" + length +
                ", width=" + width +
                '}';
    }
}
