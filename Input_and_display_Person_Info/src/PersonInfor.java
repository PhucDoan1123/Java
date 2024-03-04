
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Doan Thanh Phuc - CE170580
 */
public class PersonInfor {

    private String Name;//Name of person
    private String Address;//Address of person
    private double Salary;//Salary of person

    Scanner sc = new Scanner(System.in);//Nhập dữ liệu từ bàn phím

    Validation ck = new Validation();//khai báo đối tượng validation để kiểm tra dữ liệu

    /**
     * Constructs an empty PersonInfor object.
     */
    public PersonInfor() {
    }

    /**
     * Constructs a PersonInfor object with the specified name, address, and
     * salary.
     *
     * @param Name the name of the person
     * @param Address the address of the person
     * @param Salary the salary of the person
     */
    public PersonInfor(String Name, String Address, double Salary) {
        this.Name = Name;
        this.Address = Address;
        this.Salary = Salary;
    }

    /**
     * Returns the name of the person.
     *
     * @return the name of the person
     */
    public String getName() {
        return Name;
    }

    /**
     * Sets the name of the person.
     *
     * @param Name the name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * Returns the address of the person.
     *
     * @return the address of the person
     */
    public String getAddress() {
        return Address;
    }

    /**
     * Sets the address of the person.
     *
     * @param Address the address to set
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     * Returns the salary of the person.
     *
     * @return the salary of the person
     */
    public double getSalary() {
        return Salary;
    }

    /**
     * Sets the salary of the person.
     *
     * @param Salary the salary to set
     */
    public void setSalary(double Salary) {
        this.Salary = Salary;
    }

    /**
     * Input information of person
     *
     * The inputData() function allows the user to enter a person's information
     * including name, address and salary. It uses loops and checks for validity
     * of the input data. During import, extra spaces in names and addresses are
     * removed. If the data is invalid, the message The corresponding * will be
     * displayed.
     */
    public void inputData() {
        boolean check1 = true;//kiểm ta name
        boolean check2 = true;//kiểm tra address
        boolean check3 = true;//kiểm tra salary

        // Enter name
        System.out.println("Input Information of Person");
        do {
            System.out.print("Name: ");
            Name = sc.nextLine().trim().replaceAll("\\s+", " ");//cắt khoảng trắng dư thừa

            if (ck.enterString(Name) == false) {//nếu dữ liệu nhập vào không hợp lệ
                check1 = true;
            } else {
                check1 = false;
            }
        } while (check1);//lập cho đến khi dữ liệu hợp lệ

        // Enter address
        do {
            System.out.print("Address: ");
            Address = sc.nextLine().trim().replaceAll("\\s+", " ");//cắt khoảng trắng dư thừa

            if (ck.enterString(Address) == false) {//nếu dữ liệu nhập vào không hợp lệ
                check2 = true;
            } else {
                check2 = false;
            }
        } while (check2);//lập cho đến khi dữ liệu hợp lệ

        // Enter salary
        do {
            System.out.print("Salary: ");
            try {
                Salary = Double.parseDouble(sc.nextLine());//chuyển sang số thực
                if (Salary < 1) {//nếu Salary bé hơn 1
                    System.out.println("Please enter a positive number!");
                } else {
                    check3 = false;
                }
            } catch (NumberFormatException e) {//bắt trường hợp không phải là số thực
                System.out.println("You must input a digit");
            }
        } while (check3);//lập cho đến khi dữ liệu hợp lệ
    }

    /**
     * Displays the information of the person.
     *
     * The disPlay() function is used to display the person's information.
     * First, print issue the message "Information of Person you have entered:"
     * to make a bookmark information will be displayed. Next, print out the
     * person's name using use the variable Name. Then print out the address of
     * the person using the variable Address. Finally, print out the person's
     * salary in a number format decimal has one digit after the decimal point,
     * using the variable Salary.
     */
    public void disPlay() {
        System.out.println("\nInformation of Person you have entered:");
        System.out.println("Name: " + Name);
        System.out.println("Address: " + Address);
        System.out.printf("Salary: %.1f\n", Salary);
    }

}
