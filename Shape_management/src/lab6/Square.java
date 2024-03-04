/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6;

/**
 *
 * @author Acer
 */
public class Square extends Rectangle{
    public Square(String ID, double edge, String color, boolean isfilled) {
        super(ID, edge, edge, color, isfilled);
    }
    @Override
    public void showProfile() {
        System.out.printf("|Square: \t|%4s|%tD|%10s| "+isFilled()+"|%6.1f|      -|       -|%6.1f|%6.1f|\n",super.getID(),super.getDateCreated(),super.getColor(),super.getHeight(),this.getArea(),this.getPerimeter());
    }
}
