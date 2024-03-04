/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce170580_lab7;

/**
 *
 * @author Doan Thanh Phuc
 */
public abstract class Person {
    private String ID;
    private String name;
    private int yob;
    private String address;

    public Person(String ID, String name, int yob, String address) {
        this.ID = ID;
        this.name = name;
        this.yob = yob;
        this.address = address;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public abstract void showProfile();
}
