/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6;

import io.IOCE170580;
import java.util.ArrayList;

/**
 *
 * @author Acer
 */
public class ShapeManagement {

    public static void menu() {
        System.out.println("-----------SHAPE MANAGEMENT-----------");
        System.out.println("1. Adds new Circle.");
        System.out.println("2. Adds new Triangle.");
        System.out.println("3. Adds new Rectangle.");
        System.out.println("4. Adds new Square.");
        System.out.println("5. Shows all Shapes.");
        System.out.println("6. The biggest area shape.");
        System.out.println("7. Sort ascending by shape area.");
        System.out.println("8. Search a shape.");
        System.out.println("9. Quit.");
    }

    public static void main(String[] args) {
        int op;
        ArrayList<Shape> listShape = new ArrayList<>();
        Cricle C1 = new Cricle("C1", 8.0, "white", true);
        Cricle C3 = new Cricle("C3", 3, "White", true);
        Cricle C2 = new Cricle("C2", 2, "White", true);
        Rectangle r1 = new Rectangle("R1", 2, 3, "White", true);
        Rectangle r2 = new Rectangle("R2", 3, 4, "White", true);
        Triangle t1 = new Triangle("T1", 2, 3, 4, "White", true);
        Triangle t2 = new Triangle("T2", 3, 4, 5, "White", true);
        Square s2 = new Square("S2", 5, "White", true);
        Square s3 = new Square("S2", 5, "White", true);
        listShape.add(C1);
        listShape.add(C3);
        listShape.add(C2);
        listShape.add(r1);
        listShape.add(r2);
        listShape.add(t1);
        listShape.add(t2);
        listShape.add(s2);
        listShape.add(s3);
        do {
            menu();
            op = IOCE170580.getInteger("Please select a function: ", "Invail!!");
            switch (op) {
                case 1: {
                    System.out.println("-----Add new Cricle-----");
                    String ID = IOCE170580.getString("Input ID: ", "Invailn!");
                    for (Shape b : listShape) {
                        while (b.getID().equalsIgnoreCase(ID) == true) {
                            System.out.println("This " + ID + " is already exits");
                            ID = IOCE170580.getString("Input ID: ", "Invaile!");
                        }
                    }
                    String color = IOCE170580.getString("Input color: ", "Invailn");
                    double radius = IOCE170580.getDouble("Input radius: ", "Invailn");
                    listShape.add(new Cricle(ID, radius, color, true));
                    System.out.println("Cricle created and added to list of shapes succesfull!");
                }
                break;
                case 2: {
                    System.out.println("-----Add new Triangle-----");
                    String ID = IOCE170580.getString("Input ID: ", "Invailn!");
                    for (Shape b : listShape) {
                        while (b.getID().equalsIgnoreCase(ID) == true) {
                            System.out.println("This " + ID + " is already exits");
                            ID = IOCE170580.getString("Input ID: ", "Invaile!");
                        }
                    }
                    String color = IOCE170580.getString("Input color: ", "Invailn");
                    double side_1 = IOCE170580.getDouble("Input side_1: ", "Invailn");
                    double side_2 = IOCE170580.getDouble("Input side_2: ", "Invailn");
                    double side_3 = IOCE170580.getDouble("Input side_3: ", "Invailn");
                    System.out.println("Triangle created and added to list of shapes succesfull!");
                    listShape.add(new Triangle(ID, side_1, side_2, side_3, color, true));
                }
                break;
                case 3: {
                    System.out.println("-----Add new Rectangle-----");
                    String ID = IOCE170580.getString("Input ID: ", "Invailn!");
                    for (Shape b : listShape) {
                        while (b.getID().equalsIgnoreCase(ID) == true) {
                            System.out.println("This " + ID + " is already exits");
                            ID = IOCE170580.getString("Input ID: ", "Invaile!");
                        }
                    }
                    String color = IOCE170580.getString("Input color: ", "Invailn");
                    double height = IOCE170580.getDouble("Input height: ", "Invailn");
                    double witch = IOCE170580.getDouble("Input witch: ", "Invailn");
                    listShape.add(new Rectangle(ID, witch, height, color, true));
                    System.out.println("Rectangle created and added to list of shapes succesfull!");
                }
                break;
                case 4: {
                    System.out.println("-----Add new Square-----");
                    String ID = IOCE170580.getString("Input ID: ", "Invailn!");
                    for (Shape b : listShape) {
                        while (b.getID().equalsIgnoreCase(ID) == true) {
                            System.out.println("This " + ID + " is already exits");
                            ID = IOCE170580.getString("Input ID: ", "Invaile!");
                        }
                    }
                    String color = IOCE170580.getString("Input color: ", "Invailn");
                    double egde = IOCE170580.getDouble("Input square ", "Invailn");
                    listShape.add(new Square(ID, egde, color, true));
                    System.out.println("Cricle created and added to list of shapes succesfull!");
                }
                break;
                case 5: {
                    System.out.println("---- List of Shapes -----");
                    for (Shape s : listShape) {
                        s.showProfile();
                    }
                }
                break;
                case 6: {
                    double maxArea = 0;
                    Shape highest = null;
                    for (Shape b : listShape) {
                        if (b.getArea() > maxArea) {
                            maxArea = b.getArea();
                            highest = b;
                        }
                    }
                    System.out.println("The book has the biggest size is/are: ");
                    for (Shape b : listShape) {
                        if (b.getArea() == maxArea) {
                            b.showProfile();
                        }
                    }
                }
                break;
                case 7: {
                    for (int i = 0; i < listShape.size(); i++) {
                        for (int j = i + 1; j < listShape.size(); j++) {
                            if (listShape.get(i).getArea() > listShape.get(j).getArea()) {
                                Shape b = listShape.get(i);
                                listShape.set(i, listShape.get(j));
                                listShape.set(j, b);
                            }
                        }
                    }
                    System.out.println("---- List of Shapes -----");
                    for (Shape s : listShape) {
                        s.showProfile();
                    }
                }
                break;
                case 8: {
                    System.out.println("Find Shape: ");
                    String ID = IOCE170580.getString("Input ID to find: ", "Invailn");
                    for(Shape t : listShape) {
                        if(t.getID().equalsIgnoreCase(ID) == true) {
                            t.showProfile();
                        }else{
                            System.out.println("Not found!");
                            break;
                        }
                    }
                }break;
                case 9: 
                {
                    break;
                }
                default: {
                    System.out.println("The function of application must be from 1 to 8!");
                }break;
            }
        } while (op!= 9);
        System.out.println("THANK FOR USING MY APPLICATION!");
        System.out.println("SEE YOU AGAIN!");
    }
}
