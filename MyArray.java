package com.ex.multi_thread;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + ", age: " + age;
    }
}

public class MyArray {
    public static void main(String[] args) {
        Person[] people = new Person[3];
        people[0] = new Person("RAM", 25);
        people[1] = new Person("Seeta", 22);
        people[2] = new Person("Shiv", 30);

        System.out.println("Array of gods:");
        for (Person p : people) {
            System.out.println(p);
        }
    }
}
