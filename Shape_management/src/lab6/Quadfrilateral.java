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
public abstract class Quadfrilateral extends Shape {
    private double width;
    private double height;

    public Quadfrilateral(String ID,double width, double height,  String color, boolean isfilled) {
        super(ID, color, isfilled);
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    @Override
    public abstract double getArea();
    @Override
    public abstract double getPerimeter();
    @Override
    public abstract void showProfile();    
}
