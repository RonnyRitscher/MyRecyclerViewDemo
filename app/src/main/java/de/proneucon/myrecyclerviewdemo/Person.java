package de.proneucon.myrecyclerviewdemo;

/**
 * Klasse Person für die erstellung des Inhaltes der RecyclerView
 */
public class Person {

    //MEMBER
    private String name;
    private String city;

    //CONSTRUCTOR`s
    public Person() {
    }

    public Person(String name, String city) {
        this.name = name;
        this.city = city;
    }

    //GETTER und SETTER
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
