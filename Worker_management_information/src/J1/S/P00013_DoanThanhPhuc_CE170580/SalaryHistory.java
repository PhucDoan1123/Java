package J1.S.P00013_DoanThanhPhuc_CE170580;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 *
 * @author Doan Thanh Phuc - CE170580
 */
public class SalaryHistory {

    private String ID;//ID of worker
    private String name;//name or worker
    private int age;// age of worker
    private double updatesalary;// salary after update
    private String status;// thông báo up or down
    private LocalDate date;//Ngày cập nhập

    Scanner sc = new Scanner(System.in);//Nhập dữ liệu từ bàn phím

    Validation ck = new Validation();//đối tượng kiểm tra dữ liệu

    /**
     *
     */
    public SalaryHistory() {
    }

    /**
     * Constructor with arguments to initialize values for properties.
     *
     * @param ID is worker's ID
     * @param name is worker's name
     * @param age is worker's age
     * @param updatesalary is worker's update salary
     * @param status is worker's status salary
     * @param date is date update salary
     */
    public SalaryHistory(String ID, String name, int age, double updatesalary, String status, LocalDate date) {
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.updatesalary = updatesalary;
        this.status = status;
        this.date = date;
    }

    /**
     * Getter method for the ID property in the Worker class.
     *
     * @return value of the ID
     */
    public String getID() {
        return ID;
    }

    /**
     * Setter method for the ID property in the Worker class.
     *
     * @param ID is worker's ID
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * Getter method for the name property in the Worker class.
     *
     * @return the value of the name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for the name property in the Worker class.
     *
     * @param name is worker's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for the age property in the Worker class.
     *
     * @return the value of the age
     */
    public int getAge() {
        return age;
    }

    /**
     * Setter method for the age property in the Worker class.
     *
     * @param age is worker's age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Getter method for the update salary property.
     *
     * @return value of the update salary
     */
    public double getUpdatesalary() {
        return updatesalary;
    }

    /**
     * Setter method for the update salary property.
     *
     * @param updatesalary is worker's update salary
     */
    public void setUpdatesalary(double updatesalary) {
        this.updatesalary = updatesalary;
    }

    /**
     * Getter method for the status property.
     *
     * @return value of the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Setter method for the status property.
     *
     * @param status is worker's status salary
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Getter method for the date property.
     *
     * @return the value of the date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Setter method for the date property.
     *
     * @param date update salary of worker
     */
    public void setDate(LocalDate date) {
        this.date = date;
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
        boolean check = true;//kiểm tra dữ liệu
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
     * Update Salary
     *
     * This function prompts the user to enter an updated salary. It performs
     * input validation by checking if the entered value is a positive number.
     * If the entered value is not valid, the user is prompted to re-enter it
     * until a valid salary is provided. The function stores the valid salary in
     * the 'updatesalary' variable.
     *
     */
    public void updateSa() {
        boolean check = true; // Flag to check data validity
        // Enter updated Salary
        do {
            System.out.print("Enter money: ");
            try {
                updatesalary = Double.parseDouble(sc.nextLine()); // Convert input to a floating-point number

                if (updatesalary < 1) {
                    System.out.println("Money must be a positive number!");
                    check = true; // If the salary is less than 1, set check to true to continue the loop
                } else {
                    check = false; // If the salary is valid, set check to false to exit the loop
                }
            } catch (NumberFormatException e) {
                // Catch any NumberFormatException that may occur if the input cannot be parsed as a double
                System.out.println("Error");
            }
        } while (check); // Continue looping as long as check is true (invalid salary entered)
    }

    /**
     * Display the information of a SalaryHistory object.
     */
    public void display() {
        //Sử dụng DateTimeFormatter để định dạng đối tượng ngày tháng
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        //Ngày được định dạng được lưu trữ trong biến formattedDate
        String formattedDate = date.format(formatter);
        System.out.printf("|%-8s|%-19s|%-12d|%-13.1f|%-14s|%-12s|\n", ID, name, age, updatesalary, status, formattedDate);
    }

}
