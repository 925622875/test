package com.zhu.test;

import java.util.*;

/**
 * @author shkstart
 * @create 2023-05-10 11:07
 */
public class Single {

    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        
    }



}

class Person{

    int year;
    String name;

    public Person(int year, String name) {
        this.year = year;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return year == person.year &&
                Objects.equals(name, person.name);
    }
    public void setYear(int year){
        this.year = year;
    }
    public void setName(String name){
        this.name = name;
    }
}