/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0003_doanthanhphuc_ce170580.pkg2;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

/**
 *
 * @author Doan Thanh Phuc - CE170580
 */
public class CustomerManagement {

    private String CustomerName;//Tên của khác hàng đã mua hàng

    Hashtable<String, ArrayList<Fruit>> orders = new Hashtable<>(); // Hashtable to store customer orders

    ArrayList<Fruit> orderFruit1 = new ArrayList<>(); // ArrayList to store order information

    Scanner sc = new Scanner(System.in);// Nhập dữ liệu từ bàn phím

    Validation ck = new Validation();//Khái báo đối tượng Validation để kiểm tra

    FruitManagement fm = new FruitManagement();

    /**
     * Default constructor for CustomerManagement class.
     */
    public CustomerManagement() {
    }

    /**
     * Prompt the user to enter their name.
     *
     * This method prompts the user to enter their name by displaying the
     * message "Enter your name: ". It reads the input from the user using the
     * 'sc' Scanner object and trims any leading/trailing whitespace. It then
     * replaces consecutive whitespace characters with a single space using the
     * regular expression "\\s+". The entered customer name is stored in the
     * 'CustomerName' field. The method continues to prompt for a name until a
     * valid name (as determined by the 'ck.enterString' method) is entered. The
     * 'ck.enterString' method checks if the entered name contains only letters
     * and spaces.
     *
     * @return The entered customer name.
     *
     */
    public String enterCusName() {
        boolean check = true;//kiểm tra dữ liệu nhập vào
        do {
            System.out.print("Enter your name: ");
            CustomerName = sc.nextLine().trim().replaceAll("\\s+", " ");//xóa những không trắng dư thừa
            if (ck.enterString(CustomerName) == false) {
                check = true;
            } else {
                check = false;//nếu dữ liệu hợp lệ
            }
        } while (check);
        return CustomerName;//tên khác hàng sau khi nhập
    }

    /**
     * Display the customer orders.
     *
     * This method displays the customer orders. It checks if the orders
     * Hashtable is empty and prints a message if there are no orders. If there
     * are orders, it iterates over each customer in the Hashtable. For each
     * customer, it prints their name and retrieves their list of ordered
     * fruits. It then calculates the total amount by iterating over each fruit,
     * multiplying the quantity by the price, and adding it to the total. It
     * displays a table with column names and prints the fruit details,
     * including the number and amount. Finally, it prints the total amount and
     * a table footer. This process is repeated for each customer in the
     * Hashtable.
     *
     */
    public void showCustomer() {
        if (orders.isEmpty()) {//Nếu chưa có khách hàng nào order 
            System.out.println("\nNo orders yet.\n");
            return;//kết thúc hàm 
        }
        System.out.println("Customer Orders:");
        for (String CustomerName : orders.keySet()) {//duyệt qua từng key của HashTable để lấy dữ liệu
            System.out.println("Customer: " + CustomerName);//in ra tên khách hàng
            ArrayList<Fruit> customerOrders = orders.get(CustomerName);//Láy từng dữ liệu từ key
            int no = 1;//thứ tự mặc hàng
            int total = 0;//tổng số tiền sau khi order
            //Bảng để in dữ liệu
            System.out.println("+-----+-----+---------------+---------+---------+--------------+--------+");
            System.out.println("|No.  | ID  |  Fruit Name   |  Price  | Quatity |    Origin    | Amount |");
            System.out.println("+-----+-----+---------------+---------+---------+--------------+--------+");
            for (Fruit f : customerOrders) {//duyệt qua Array để lấy dữ liệu ra
                int temp = f.getQuantity() * f.getPrice();//tính số tiền mỗi mặc hàng
                total += temp;//số tiền tổng 
                System.out.printf("| %-3d ", no++);
                f.disPlay();//in ra thông tin mặc hàng
                System.out.printf("%7d$|\n", temp);
            }
            System.out.println("+-----+-----+---------------+---------+---------+--------------+--------+");
            System.out.printf("|                                                         TOTAL:   %4d$|\n", total);
            System.out.println("+-----+-----+---------------+---------+---------+--------------+--------+");
        }
    }

    /**
     * Display the information of the recent customer.
     *
     * This method prints the information of the recent customer, including the
     * purchased fruits and the total amount. The customer's information is
     * retrieved from the 'orderFruit1' ArrayList. The customer's information is
     * displayed in a tabular format with columns for ID, Fruit Name, Price,
     * Quantity, Origin, and Amount. The total amount is calculated by
     * multiplying the quantity and price of each fruit and summing them up. The
     * table is printed to the console.
     */
    public void showRecentCustomer() {

        //Bảng để in thông tin order
        System.out.println("+-----+---------------+---------+---------+--------------+--------+");
        System.out.println("| ID  |  Fruit Name   |  Price  | Quatity |    Origin    | Amount |");
        System.out.println("+-----+---------------+---------+---------+--------------+--------+");

        int total = 0;//tổng số tiền mặc 

        for (Fruit f : orderFruit1) {//duyệt qua từng phần tử của Array để lấy dữ liệu
            total = f.getQuantity() * f.getPrice();//tính số tiền tỏng của từng mặc hàng
            f.disPlay();//in thông tin mặc hàng
            System.out.printf("%7d$|\n", total);
        }
        System.out.println("+-----+---------------+---------+---------+--------------+--------+");

    }

}
