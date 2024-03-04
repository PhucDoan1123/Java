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
public class Menu {

    FruitManagement fm = new FruitManagement();// khai báo đối tượng FruitManagement
    CustomerManagement cm = new CustomerManagement();// khai báo đối tượng CustomerManagement
    Scanner sc = new Scanner(System.in);//Nhập dữ liệu từ bàn phím
    Validation ck = new Validation();//Khái báo đối tượng validation 
    private String customerName;//Tên của khách hàng

    /**
     * Retrieves the customer name.
     *
     * @return the customer name
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Sets the customer name.
     *
     * @param customerName the customer name to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * Runs the main program for the fruit shop system.
     *
     * the runProgram() function is used to execute the program according to the
     * customer's choice, declare an op variable to enter the selection for
     * swith - case , use the do -while loop to repeat the program until the
     * user wants to stop then exit the loop, functions from other classes are
     * passed into swith - case to fulfill the user's request.
     *
     * choose 4 to exit program
     */
    public void runProgram() {
        // Initialize variables
        int op = 0;

        // Start the main program loop
        do {
            // Display menu options
            System.out.println("   FRUIT SHOP SYSTEM");
            System.out.println("1. Create Fruit");
            System.out.println("2. View orders");
            System.out.println("3. Shopping (for buyer)");
            System.out.println("4. Exit");
            System.out.print("   Please choose: ");

            try {
                // Read user input
                op = Integer.parseInt(sc.nextLine());

                // Perform actions based on user input
                switch (op) {
                    case 1: {//nếu người dùng muốn thêm trái cây
                        fm.addFruit();
                        break;
                    }
                    case 2: {//nếu người dùng muốn show thông tin khác hàng đã order
                        cm.showCustomer();
                        break;
                    }
                    case 3: {//Nếu người dùng muốn mua trái câyu
                        // Shopping section
                        cm.orderFruit.clear();//Cập nhập Array rỗng để lưu thông tin mới
                        System.out.println("------- [SHOPPING] -------");

                        //Các biến để kiểm tra dữ liệu 
                        boolean check1 = true;
                        boolean check2 = true;
                        boolean check3 = true;
                        boolean check4 = true;
                        boolean check5 = true;
                        String order = "";//Nhập lựa chọn order hay không
                        String continueB = "";//Nhập lựa chọn tiếp tục hay không

                        //Nhập tên khác hàng
                        do {
                            System.out.print("Please enter your name: ");
                            customerName = sc.nextLine().trim().replaceAll("\\s+", " ");
                            if (ck.enterString(customerName) == false) {//Kiểm tra chuỗi nhập vào
                                check1 = false;
                            } else {
                                check1 = true;//nếu chuỗi hợp lệ
                            }
                        } while (!check1);
                        setCustomerName(customerName);// cập nhập lại tên khác hàng

                        // Start shopping loop
                        do {
                            // Display available fruits
                            int numberOfFruit = fm.fruits.size();//số lượng loại trái cây có trong của hàng

                            System.out.println("\nList of fruits: ");
                            if (numberOfFruit < 1) {//Nếu không có trái cây trong cửa hàng
                                System.out.println("\nWe have no fruit in store");
                                break;
                            } else {//nếu có trái cây trong cửa hàng
                                //in danh sách trái cây
                                fm.showFruit();

                                // Nhập tên của loại trái cây cần mua
                                do {
                                    fm.inputOrderFruitName();
                                    if (fm.exitName() == false) {//nếu tên trái cây không có tồn tại trong cửa hàng
                                        check2 = false;
                                        System.out.println("There is no such fruit");
                                    } else {
                                        check2 = true;
                                    }
                                } while (!check2);//điều kiện thoát vòng lập

                                fm.inputOrderFruitQuatity();//Nhập số lượng cần order

                                // Process selected fruit
                                for (Fruit f : fm.fruits) {
                                    if (f.getfName().equalsIgnoreCase(fm.getOrderFruitName().trim())) {
                                        do {
                                            // Check quantity availability
                                            if (fm.getOrderFruitQuatity() > f.getQuantity()) {//nếu nhiều hơn số lượng có trong shop
                                                System.out.println("Error: There are not enough fruit for you to buy!");
                                                fm.inputOrderFruitQuatity();
                                            } else {//nếu có đủ số lượng trái cây cần order
                                                check3 = false;
                                            }
                                        } while (check3);//điều kiện lập vòng lập

                                        System.out.println("\n    You chose: " + f.getfName());//in ra tên trái cây đã chọn
                                        System.out.println("    The quantity is: " + fm.getOrderFruitQuatity() + "\n");//in ra số lượng order

                                        //hỏi người dùng có muốn order trái cây đã chọn không
                                        do {
                                            // Prompt for order confirmation
                                            System.out.print("Do you want to order this item? (Y/N or y/n) ");
                                            order = sc.nextLine();//Nhập lựa chọn
                                            if (ck.enterString(order) == false) {//Kiểm tra chuỗi nhập vào
                                                check4 = false;
                                            } else if (order.equalsIgnoreCase("y") || order.equalsIgnoreCase("n")) {//Kiểm tra có phải chon y or n
                                                check4 = true;
                                            } else {//nếu enter không phải là (Y/N or y/n)
                                                System.out.println("You can only enter (Y/N or y/n)!");
                                                check4 = false;
                                            }
                                        } while (!check4);//điều kiện thoát vòng lập

                                        if (order.equalsIgnoreCase("y")) {//Nếu người dùng chọn order trái cây
                                            // Add ordered fruit to customer's order
                                            fm.setFruitStorageQuantity();//cập nhập lại số lượng trái cây trong shop

                                            OrderFruit of = new OrderFruit(f.getfName(), fm.getOrderFruitQuatity(), f.getPrice());
                                            cm.orderFruit.add(of);//thêm vào Array
                                        }
                                    }
                                }
                                //tránh lỗi thay đổi cấu trúc của ArrayList khi lập qua nó
//                                if (order.equalsIgnoreCase("y")) {
//                                    fm.setFruitStorageQuantity();//cập nhập lại số lượng trái cây trong shop
//                                }

                                //Hỏi người dùng có muốn tiếp tục mua hàng hay không
                                do {
                                    // Enter for continuing shopping
                                    System.out.print("Do you want to continue shopping? (Y/N or y/n)");
                                    continueB = sc.nextLine();
                                    if (ck.enterString(continueB) == false) {//kiểm tra chuỗi nhập vào
                                        check5 = false;
                                    } else if (continueB.equalsIgnoreCase("y") || continueB.equalsIgnoreCase("n")) {
                                        check5 = true;
                                    } else {//nếu chuỗi không phải là (Y/N or y/n)
                                        System.out.println("You can only enter (Y/N or y/n)!");
                                        check5 = false;
                                    }
                                } while (!check5);//điều kiện thoát vòng lập
                            }
                        } while (continueB.equalsIgnoreCase("y"));//if continueB là "n" thì thoát vòng lập

                        if (cm.orderFruit.size() > 0) {//Nếu có trái cây được order
                            // Add customer order to the list of customers
                            ArrayList<OrderFruit> list = new ArrayList<>();
                            list.addAll(cm.orderFruit);//Thêm tất cả các thông tin trái cây đã được mua
                            //Lưu thông tin người mua hàng
                            cm.customer.add(new Customer(getCustomerName(), cm.orderFruit.size(), cm.orderFruit));
                            System.out.println("\nCustomer name: " + getCustomerName());//in ra tên người vừa mua
                            cm.showRecentCustomer();//show thông tin người vừa mua
                        }
                        System.out.println("\nThank [ " + getCustomerName() + " ] for your ordering!\n");//thông báo cảm ơn khi mua hàng
                        break;
                    }
                    case 4: {//nếu người dùng muốn thoát chương trình
                        break;
                    }
                    default: {//nếu người dùng nhập không phải là lựa chon của chương trình
                        System.out.println("Please enter from 1 to 4!");
                    }
                }
            } catch (NumberFormatException e) {//bắt lỗi nhập lựa chọn không phải số nguyê
                System.out.println("Error!");
            }
        } while (op != 4);//điều kiện thực hiện vòng lập

        System.out.println("Thank you for using the program!");//in thông báo cảm ơn
    }

}
