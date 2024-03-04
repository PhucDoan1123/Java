/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce170580_lab7;

import io.IOCE170580;
import java.util.ArrayList;

/**
 *
 * @author Doan Thanh Phuc
 */
public class test {

    public static void menu() {
        System.out.println("----- EMPLOYEE MANAGEMENT -----");
        System.out.println("1. Adds new Management.");
        System.out.println("2. Adds new PartimeEmployee.");
        System.out.println("3. Adds new FulltimeEmployee.");
        System.out.println("4. Shows all Employee.");
        System.out.println("5. Sort ascending by Employee yob.");
        System.out.println("6. Search a Emplyee.");
        System.out.println("7. Quit.");
    }

    public static void main(String[] args) {
        int op;
        ArrayList<Person> listEmployee = new ArrayList<>();
        Manegement m1 = new Manegement("M1", "Giam Doc:", "Tom", 1980, "Can Tho");
        Manegement m2 = new Manegement("M2", "P.Giam Doc:", "Chaine", 1988, "Vinh Long");
        FullTimeEmployee f1 = new FullTimeEmployee("F1", "Nobita", 2001, "Soc Trang", 8);
        FullTimeEmployee f2 = new FullTimeEmployee("F2", "Susu", 2003, "An Giang", 6);
        PartTimePloyee p1 = new PartTimePloyee("P1", "Jerry", 2000, "Ca Mau", 5, 5);
        listEmployee.add(m1);
        listEmployee.add(m2);
        listEmployee.add(f1);
        listEmployee.add(f2);
        listEmployee.add(p1);

        do {
            menu();
            op = IOCE170580.getInteger("Please seletc a funtion: ", "Invailn");
            switch (op) {
                case 1: {
                    System.out.println("-----Add new Management-----");
                    String Id = IOCE170580.getString("Input ID: ", "Invailn!\n");
                    for (Person b : listEmployee) {
                        if(b.getID().equalsIgnoreCase(Id)) {
                            System.out.println("This " + Id + " is already exits");
                            Id = IOCE170580.getString("Input ID: ", "Invailn!\n");
                        }
                    }
                    String position = IOCE170580.getString("Input position: ", "Invailn!\n");
                    String name = IOCE170580.getString("Input name: ", "Invailn!\n");
                    int yob = IOCE170580.getInteger("Enter yob: ", "Invailn!\n");
                    String address = IOCE170580.getString("Input address: ", "Invailn!\n");
                    listEmployee.add(new Manegement(Id, position, name, yob, address));
                    System.out.println("Manegement created and added to list of Employee succesfull!");
                }
                break;

                case 2: {
                    System.out.println("-----Add new ParTimeEmployee-----");
                    String ID = IOCE170580.getString("Input ID: ", "Invailn!\n");
                    for (Person b : listEmployee) {
                        while (b.getID().equalsIgnoreCase(ID) == true) {
                            System.out.println("This " + ID + " is already exits");
                            ID = IOCE170580.getString("Input ID: ", "Invailn!\n");
                        }
                    }
                    String name = IOCE170580.getString("Input name: ", "Invailn!\n");
                    int yob = IOCE170580.getInteger("Enter yob: ", "Invailn!\n");
                    String address = IOCE170580.getString("Input address: ", "Invailn!\n");
                    int pamentPerHour = IOCE170580.getInteger("Input paymentPerHours: ", "Invailn!\n");
                    int wk = IOCE170580.getInteger("Input workingHours: ", "Invailn!");
                    listEmployee.add(new PartTimePloyee(ID, name, yob, address, pamentPerHour, wk));
                    System.out.println("ParTimeEmployee created and added to list of Employee succesfull!");
                }
                break;
                case 3: {
                    System.out.println("-----Add new FullTimeEmployee-----");
                    String Id = IOCE170580.getString("Input ID: ", "Invailn!\n");
                    for (Person b : listEmployee) {
                        while (b.getID().equalsIgnoreCase(Id) == true) {
                            System.out.println("This " + Id + " is already exits");
                            Id = IOCE170580.getString("Input ID: ", "Invailn!\n");
                        }
                    }
                    String name = IOCE170580.getString("Input name: ", "Invailn!\n");
                    int yob = IOCE170580.getInteger("Enter yob: ", "Invailn!\n");
                    String address = IOCE170580.getString("Input address: ", "Invailn!\n");
                    int pamentPerHour = IOCE170580.getInteger("Input paymentPerHours: ", "Invailn!\n");
                    listEmployee.add(new FullTimeEmployee(Id, name, yob, address, pamentPerHour));
                    System.out.println("FullTimeEmployee created and added to list of Employee succesfull!");
                }
                break;
                case 4: {
                    System.out.println("---- List of Employee -----");
                    System.out.println("|   Position|  ID|     Name|    Yob|   Address|W-Hours| P-Hours| Salary| Reward|");
                    for (Person s : listEmployee) {
                        s.showProfile();
                    }
                }
                break;
                case 5: {
                    for (int i = 0; i < listEmployee.size(); i++) {
                        for (int j = i + 1; j < listEmployee.size(); j++) {
                            if (listEmployee.get(i).getYob() > listEmployee.get(j).getYob()) {
                                Person b = listEmployee.get(i);
                                listEmployee.set(i, listEmployee.get(j));
                                listEmployee.set(j, b);
                            }
                        }
                    }
                    System.out.println("---- List of Employee -----");
                    System.out.println("|   Position|  ID|     Name|    Yob|   Address|W-Hours| P-Hours| Salary| Reward|");
                    for (Person s : listEmployee) {
                        s.showProfile();
                    }
                }
                break;
                case 6: {
                    System.out.println("Find Employee: ");
                    boolean ktid = false;
                    String id = IOCE170580.getString("Input ID to find: ", "Invailn!\n");
                    for (Person s : listEmployee) {
                        if (s.getID().equalsIgnoreCase(id)) {
                            ktid = true;
                            s.showProfile();
                        }
                    }
                    if (!ktid) {
                        System.out.println("Not found!");
                    }
                }
                break;

                case 7: {
                    break;
                }
                default: {
                    System.out.println("The function of application must be from 1 to 7!");
                }
                break;
            }
        } while (op != 7);
        System.out.println("THANK FOR USING MY APPLICATION!");
        System.out.println("SEE YOU AGAIN!");
    }

}
