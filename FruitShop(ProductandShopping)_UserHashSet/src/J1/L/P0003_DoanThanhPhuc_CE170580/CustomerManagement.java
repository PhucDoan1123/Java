/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.L.P0003_DoanThanhPhuc_CE170580;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Doan Thanh Phuc - CE170580
 */
public class CustomerManagement {

    ArrayList<Customer> customer = new ArrayList<>();//Lưu thông tin khác hàng đã order
    ArrayList<OrderFruit> orderFruit = new ArrayList<>();//Lưu thông tin mặc hàng được order
    ArrayList<OrderFruit> orderFruit1 = new ArrayList<>();//Lưu thông tin mặc hàng được generay
    ArrayList<OrderFruit> orderFruit2 = new ArrayList<>();//Lưu thông tin mặc hàng được generay

    Scanner sc = new Scanner(System.in);//Nhập dữ liệu từ bàn phím
    Validation ck = new Validation();//Khái báo đổi tượng validation
    FruitManagement fm = new FruitManagement();//Khai báo đối tượng FruitManagement

    /**
     * so that other classes can use the function in this class without passing
     * parameters
     */
    public CustomerManagement() {
    }

    //generay thông tin mặc hàng
    {
        orderFruit1.add(new OrderFruit("Coconut", 2, 10));
        orderFruit1.add(new OrderFruit("Strawberry", 3, 40));
        orderFruit1.add(new OrderFruit("Durian", 5, 60));
    }

    //generay thông tin mặc hàng
    {
        orderFruit2.add(new OrderFruit("Coconut", 6, 10));
        orderFruit2.add(new OrderFruit("Durian", 1, 60));
    }

    //generay thông tin khác hàng đã order
    {
        customer.add(new Customer("Hung", orderFruit1.size(), orderFruit1));
        customer.add(new Customer("Tung", orderFruit2.size(), orderFruit2));
    }

    /**
     * Display customer information and products
     *
     * Browse through each element in the Array containing customer information
     * purchased, create ArrayList containing information of each customer,
     * retrieve all information and screen printing
     */
    public void showCustomer() {
        for (Customer cust : customer) {//Duyệt qua từng phần tử
            String cName = cust.getcName();//Lấy tên của từng khác hàng
            System.out.println("\n" + cName + ":");//In ra tên của khác hàng

            ArrayList<OrderFruit> items = cust.getItem();//Lưu từng mặc hang

            int no = 0;//Thứ tự của mặc hàng
            int total = 0;//tổng số tiền 

            // Hiển thị bảng thông tin sản phẩm dạng bản
            System.out.println("+-------+----------------------+----------+-------------------+-------------------+");
            System.out.println("|  No.  |        Product       | Quantity |       Price       |       Amount      |");
            System.out.println("+-------+----------------------+----------+-------------------+-------------------+");

            for (OrderFruit item : items) {//duyệt qua tương thông tin của Iteam
                no++;//Cập nhập thứ tự Item
                //Lấy từng thông tin của Item
                String fName = item.getoName();
                int quantity = item.getoQuality();
                int price = item.getoPrice();
                int temp = quantity * price;//Số tiền tường sản phẩm
                total += temp;//tổng số tiền đã mua
                System.out.printf("| %-5d | %-20s | %8d | %16d$ | %16d$ |\n", no, fName, quantity, price, temp);//in thông tin mặc hàng
            }

            // Hiển thị tổng cộng
            System.out.println("+-------+----------------------+----------+-------------------+-------------------+");
            System.out.printf("|                                                     TOTAL:  | %16d$ |\n", total);
            System.out.println("+-------+----------------------+----------+-------------------+-------------------+");
        }
    }

    /**
     * Display information about products in recent customer's cart
     *
     * Browse each item to get the item's information and calculate the total
     * amount purchased and print the customer's purchase information on the
     * screen
     */
    public void showRecentCustomer() {
        int no;//Thứ tự mặc hàng
        no = 0;
        // Hiển thị bảng thông tin sản phẩm
        System.out.println("+-------+----------------------+----------+-------------------+-------------------+");
        System.out.println("|  No.  |        Product       | Quantity |       Price       |       Amount      |");
        System.out.println("+-------+----------------------+----------+-------------------+-------------------+");

        int total = 0; // Tổng số tiền mà khách hàng phải trả
        for (int j = 0; j < orderFruit.size(); j++) {//Duyệt qua từng phần tử để lấy thông tin
            no++;//Cập nhập thứ tự của mặc hàng
            //Lấy từng thông tin ra
            String fName = orderFruit.get(j).getoName();
            int quantity = orderFruit.get(j).getoQuality();
            int price = orderFruit.get(j).getoPrice();

            total += quantity * price;//tinh số tiền đã mua các sản phẩm

            int temp = quantity * price;//tổng số tiền từng sản phẩm

            System.out.printf("| %-5d | %-20s | %8d | %17s | %17s |\n", no, fName, quantity, price, temp);//in thông tin tường sản phẩm
        }
        // Hiển thị tổng cộng
        System.out.println("+-------+----------------------+----------+-------------------+-------------------+");
        System.out.printf("|                                                     TOTAL:  | %16d$ |\n", total);
        System.out.println("+-------+----------------------+----------+-------------------+-------------------+");

    }

}
