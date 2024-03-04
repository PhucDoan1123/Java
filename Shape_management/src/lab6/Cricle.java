package lab6;

/**
 *
 * @author Acer
 */
public class Cricle extends Shape {

    private double radius;

    public Cricle(String ID, double radius, String color, boolean isfilled) {
        super(ID, color, isfilled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return this.radius * this.radius * Math.PI;
    }

    @Override
    public double getPerimeter() {
        return (this.radius * 2) * Math.PI;
    }

    @Override
    public void showProfile() {
        System.out.printf("|Cricle:\t|%4s|%tD|%10s| "+isFilled()+"|%6.1f|      -|       -|%6.1f|%6.1f|\n", super.getID(), super.getDateCreated(),super.getColor(), this.radius, this.getArea(), this.getPerimeter());

    }

}
