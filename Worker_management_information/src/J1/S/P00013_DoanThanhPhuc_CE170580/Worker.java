package J1.S.P00013_DoanThanhPhuc_CE170580;

import java.util.Scanner;

/*
 * @Author  Doan Thanh Phuc - CE170580
 *
 */
public class Worker {

    private String ID;
    private String name;
    private int age;
    private double salary;
    private String worklocation;

    Scanner sc = new Scanner(System.in);

    Validation ck = new Validation();

    /**
     * Default constructor with no input parameters. Used to create a new Worker
     * object without providing values for the properties.
     */
    public Worker() {
    }

    /**
     * Constructor with input parameters. Used to create a new Worker object and
     * assign values to its properties.
     *
     * @param ID is the worker's ID
     * @param name is the worker's name
     * @param age is the worker's age
     * @param salary is the worker's salary
     * @param worklocation is the worker's work location
     */
    public Worker(String ID, String name, int age, double salary, String worklocation) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.worklocation = worklocation;
    }

    /**
     * Getter method for the ID property. Used to access and return the current
     * value of the ID property.
     *
     * @return the value of the ID property
     */
    public String getID() {
        return ID;
    }

    /**
     * Setter method for the ID property. Used to set the value of the ID
     * property.
     *
     * @param ID is the worker's ID
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * Getter method for the name property. Used to access and return the
     * current value of the name property.
     *
     * @return the value of the name property
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for the name property. Used to set the value of the name
     * property.
     *
     * @param name is the worker's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for the age property. Used to access and return the current
     * value of the age property.
     *
     * @return the value of the age property
     */
    public int getAge() {
        return age;
    }

    /**
     * Setter method for the age property. Used to set the value of the age
     * property.
     *
     * @param age is the worker's age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Getter method for the salary property. Used to access and return the
     * current value of the salary property.
     *
     * @return the value of the salary property
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Setter method for the salary property. Used to set the value of the
     * salary property.
     *
     * @param salary is the worker's salary
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * Getter method for the work location property. Used to access and return
     * the current value of the work location property.
     *
     * @return the value of the work location property
     */
    public String getWorklocation() {
        return worklocation;
    }

    /**
     * Setter method for the work location property. Used to set the value of
     * the work location property.
     *
     * @param worklocation is the worker's work location
     */
    public void setWorklocation(String worklocation) {
        this.worklocation = worklocation;
    }

    /**
     * Input ID worker
     *
     * This function prompts the user to enter a worker's ID. It performs input
     * validation by checking if the entered ID is valid using the checkID()
     * method. If the entered ID is not valid, the user is prompted to re-enter
     * it until a valid ID is provided. The function returns the valid worker's
     * ID.
     *
     */
    public void inputID() {
        boolean check = true;
        do {
            System.out.print("Enter worker's ID: ");
            ID = sc.nextLine().trim().replaceAll("\\s+", " ");//Cắt khoảng trắng dư thừa
            if (ck.checkID(ID) == false) {//Kiểm tra tính hợp lệ của chuỗi
                check = true;
            } else {
                check = false;//Nếu không có lỗi khi nhập
            }
        } while (check);//điều kiện thực hiện vòng lập
    }

    /**
     * Input Data
     *
     * This function prompts the user to enter various details of a worker,
     * including name, age, salary, and location. It performs input validation
     * for each field to ensure the entered data is valid.
     *
     */
    public void inputData() {
        boolean check1 = true; //check the validity of the name
        boolean check2 = true; //check the validity of the age
        boolean check3 = true; //check the validity of the salary
        boolean check4 = true; //check the validity of the location

        // Enter name of the worker
        do {
            System.out.print("Enter worker's name: ");
            name = sc.nextLine().trim().replaceAll("\\s+", " "); // Remove leading/trailing whitespace and replace multiple spaces with a single space

            if (ck.enterString(name) == false) {
                // Check if the entered name is valid using the ck.enterString() method
                check1 = true; // If the name is invalid, set check1 to true to continue the loop
            } else {
                check1 = false; // If the name is valid, set check1 to false to exit the loop
            }
        } while (check1); // Continue looping as long as check1 is true (invalid name entered)

        // Enter age of the worker
        do {
            System.out.print("Enter worker's age: ");
            try {
                age = Integer.parseInt(sc.nextLine()); // Convert input to an integer

                if (age < 18 || age > 50) {
                    System.out.println("Age must be from 18 to 50!");
                    check2 = false; // If the age is outside the valid range, set check2 to false to continue the loop
                } else {
                    check2 = true; // If the age is valid, set check2 to true to exit the loop
                }
            } catch (NumberFormatException e) {
                // Catch any NumberFormatException that may occur if the input cannot be parsed as an integer
                System.out.println("Error");
                check2 = false;
            }
        } while (!check2); // Continue looping as long as check2 is false (invalid age entered)

        // Enter salary of the worker
        do {
            System.out.print("Enter salary: ");
            try {
                salary = Double.parseDouble(sc.nextLine()); // Convert input to a floating-point number

                if (salary < 1) {
                    System.out.println("Salary must be a positive number!");
                    check3 = true; // If the salary is less than 1, set check3 to true to continue the loop
                } else {
                    check3 = false; // If the salary is valid, set check3 to false to exit the loop
                }
            } catch (NumberFormatException e) {
                // Catch any NumberFormatException that may occur if the input cannot be parsed as a double
                System.out.println("Error");
            }
        } while (check3); // Continue looping as long as check3 is true (invalid salary entered)

        // Enter location of the worker
        do {
            System.out.print("Enter worker's location: ");
            worklocation = sc.nextLine().trim().replaceAll("\\s+", " "); // Remove leading/trailing whitespace and replace multiple spaces with a single space

            if (ck.enterString(worklocation) == false) {
                // Check if the entered location is valid using the ck.enterString() method
                check4 = true; // If the location is invalid, set check4 to true to continue the loop
            } else {
                check4 = false; // If the location is valid, set check4 to false to exit the loop
            }
        } while (check4); // Continue looping as long as check4 is true (invalid location entered)
    }

    /**
     * The display() method prints the information of a Worker object to the
     * screen. It uses the printf() method to format and print the ID, name,
     * age, salary, and work location attributes.
     */
    public void display() {
        System.out.printf("|%-8s|%-19s|%-12d|%-13.1f|%-13s|\n", ID, name, age, salary, worklocation);
    }

}
