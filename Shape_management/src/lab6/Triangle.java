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
public class Triangle extends Shape{
    private double side_1;
    public double side_2;
    public double side_3;

    public Triangle( String ID,double side_1, double side_2, double side_3, String color, boolean isfilled) {
        super(ID, color, isfilled);
        this.side_1 = side_1;
        this.side_2 = side_2;
        this.side_3 = side_3;
    }

    public double getSide_1() {
        return side_1;
    }

    public void setSide_1(double side_1) {
        this.side_1 = side_1;
    }

    public double getSide_2() {
        return side_2;
    }

    public void setSide_2(double side_2) {
        this.side_2 = side_2;
    }

    public double getSide_3() {
        return side_3;
    }

    public void setSide_3(double side_3) {
        this.side_3 = side_3;
    }
         
    
    @Override
    public double getArea() {
      double s = getPerimeter() / 2;
      return Math.sqrt(s * (s - side_1) * (s - side_2) * (s - side_3));
    }

    @Override
    public double getPerimeter() {
         return side_1 + side_2 + side_3;
    }

    @Override
    public void showProfile() {
        System.out.printf("|Triangle:\t|%4s|%tD|%10s| "+isFilled()+"|%6.1f|%7.1f|%8.1f|%6.1f|%6.1f|\n",super.getID(),super.getDateCreated(),super.getColor(),side_1,side_2,side_3,this.getArea(),this.getPerimeter());
    }
   
   
}
