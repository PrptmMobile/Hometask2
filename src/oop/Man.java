package oop;

import java.time.Year;
import java.util.Date;

/*
Создать класс Man (человек), с полями: имя, возраст, пол и вес.
Определить методы задания имени, возраста и веса.
Создать производный класс Student, имеющий поле года обучения.
Определить методы задания и увеличения года обучения.
 */
enum Sex{
    MALE, FEMALE;
}
public class Man {
    private String name;
    private byte age;
    private Sex sex;
    private short weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public short getWeight() {
        return weight;
    }

    public void setWeight(short weight) {
        this.weight = weight;
    }

    public Man (String name, byte age, Sex sex, short weight){
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.weight = weight;
    }
}

class Student extends Man {
    private Year yearOfGraduation;

    public Student(String name, byte age, Sex sex, short weight, Year year) {
        super(name, age, sex, weight);
        this.yearOfGraduation = year;
    }

    public void setYearOfGraduation(Year yearOfGraduation) {
        this.yearOfGraduation = yearOfGraduation;
    }

    public Year getYearOfGraduation() {
        return yearOfGraduation;
    }
}