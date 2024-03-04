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
public class Rectangle extends Quadfrilateral {

    public Rectangle(String ID, double width, double height, String color, boolean isfilled) {
        super(ID, width, height, color, isfilled);
    }

    @Override
    public void showProfile() {
        System.out.printf("|Rectangle:\t|%4s|%tD|%10s| " + isFilled() + "|%6.1f|%7.1f|       -|%6.1f|%6.1f|\n", super.getID(), super.getDateCreated(),super.getColor(), getHeight(),getWidth(), this.getArea(), this.getPerimeter());

    }

    @Override
    public double getArea() {
        return super.getHeight() * super.getWidth();
    }

    @Override
    public double getPerimeter() {
        return (super.getHeight() + super.getWidth()) * 2;

    }

}
