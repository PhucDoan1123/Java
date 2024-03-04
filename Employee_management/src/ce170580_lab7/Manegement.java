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
public class Manegement extends Person{
    private String position;

    public Manegement(String ID,String position, String name, int yob, String address) {
        super(ID, name, yob, address);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
    @Override
    public void showProfile() {
        System.out.printf("|%11s|%4s|%9s|%7d|%10s|\n",this.position,super.getID(),super.getName(),super.getYob(),super.getAddress());
    }
    
}
