package com.codingblocks.notetaking;

public class Contact {

    private String name, number, surname;
    private Boolean isDone = false;

    public Contact(String name, String surname, String number) {
        this.name = name;
        this.number = number;
        this.surname = surname;
    }

    public Boolean getDone() {
        return isDone;
    }

    public void setDone(Boolean done) {
        isDone = done;
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
