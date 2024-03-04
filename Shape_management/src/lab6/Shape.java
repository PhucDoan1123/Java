
package lab6;

import java.util.Date;

/**
 *
 * @author Đoàn Thanh Phúc
 */
public abstract class Shape {
    String ID;
    private String color;
    private boolean filled;
    private java.util.Date dateCreated;

    public Shape() {
    }

    public Shape(String ID, String color, boolean isfilled) {
        this.ID = ID;
        this.color = color;
        this.filled = isfilled;
        this.dateCreated = new java.util.Date();
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
    

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }
    public abstract double getArea();
    public abstract double getPerimeter();
    public abstract void showProfile();
}
