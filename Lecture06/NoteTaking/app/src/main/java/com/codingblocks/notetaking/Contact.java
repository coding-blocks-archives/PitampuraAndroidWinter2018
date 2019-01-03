package com.codingblocks.notetaking;

public class Contact {

    private String name, number, surname;

    public Contact(String name, String surname, String number) {
        this.name = name;
        this.number = number;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getSurname() {
        return surname;
    }

}
