/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0003_doanthanhphuc_ce170580.pkg2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Doan Thanh Phuc - CE170580
 */
public class ShopManagement {

    FruitManagement fm = new FruitManagement();//Khai báo đối tượng FruitManagement
    
    CustomerManagement cm = new CustomerManagement();//Khai báo đối tượng CustomerManagement
    
    Scanner sc = new Scanner(System.in);//Nhập dữ liệu từ bàn phím
    
    Validation ck = new Validation();//Khái báo đối tượng validation 
    
    private int selectedItem = 0;//Iteam được order

    public void enterSelect() {
        boolean check = true;//kiểm tra dữ liệu nhập vào
        do {
            try {
                System.out.print("Enter your choice: ");
                selectedItem = Integer.parseInt(sc.nextLine());//chuyển sang số nguyên
                check = false;
                if (selectedItem < 1 || selectedItem > fm.fruits.size()) {//nếu lựa chọn không có trong bảng
                    System.out.println("Out of range!");
                    check = true;
                } else {
                    check = false;//nếu dữ liệu hợp lệ
                }
            } catch (NumberFormatException e) {//nếu không phải là số nguyên
                System.out.println("Please enter an integer number!");
            }
        } while (check);
    }

    /**
     * Make purchases and save order lists
     *
     * Clear the customer's order list. Check if there are enough fruits in
     * stock; if not, exit. Display available fruits for selection. Prompt the
     * user to choose a fruit and enter the desired quantity. Update fruit
     * quantities in stock and customer's order. If the fruit is already in the
     * customer's order, update the quantity; otherwise, add it as a new item.
     * Prompt the user to continue shopping. Display the details of the most
     * recent customer. Prompt the user to enter the customer's name. Add the
     * customer's orders to the customer management. In summary, the method
     * allows the user to select and order fruits, manages stock availability
     * and customer orders, and captures customer information.
     *
     */
    private void Shopping() {
        cm.orderFruit1.clear();//Tránh trùng lập dữ liệu
        // Shopping section
        System.out.println("------- [SHOPPING] -------");
        boolean found = false;//kiểm tra loại trái cây tồn tại
        boolean zeroQuantity = false;//kiểm tra số lượng order còn hay không
        if (fm.checkQutity() == true) {//Nếu tất cả mặc hàng trái cây đều bằng 0
            System.out.println("\nWe were out of stock\n");
            return;
        }
        do {
            zeroQuantity = false;
            fm.showFruit();//show sản phẩm

            enterSelect();//Nhập lựa chọn mặc hàng

            Fruit selectedFruit = fm.fruits.get(selectedItem - 1);//tạo đội tượng được lựa chọn

            Fruit d = new Fruit();//Khái báo một đội tượng Fruit để so sánh

            System.out.println("You selected: " + selectedFruit.getfName());

            int qualityOrder;
            qualityOrder = d.inputQuantity();//số trái cây cần order

            for (Fruit f : fm.fruits) {//Lập qua từng phần tử của Array để láy dữ liệu
                if (f.getID().equalsIgnoreCase(selectedFruit.getID())) {//Lấy trái cây đã order trong Array
                    if (qualityOrder > f.getQuantity()) {//nếu số lợn order lơn hơn số lượng có sẵn
                        System.out.println("Error: There are not enough fruits for you to buy!");
                        zeroQuantity = true;
                    } else {//Nếu số lượng cho phép
                        f.setQuantity(f.getQuantity() - qualityOrder);//cập nhập số lượng sản phẩm
                    }
                }
            }
            if (!zeroQuantity) {//Nếu số lượng order trong mức cho phép
                found = false; // Đặt lại found về false
                for (Fruit orderedFruit : cm.orderFruit1) {//Duyệt qua danh sách đã order
                    if (orderedFruit.getID().equalsIgnoreCase(selectedFruit.getID())) {//kiểm tra trái cây trùng
                        orderedFruit.setQuantity(orderedFruit.getQuantity() + qualityOrder);//Thêm số lượng order
                        found = true;//nếu có trái cây trùng
                        break;
                    }
                }
                if (found == false) {//nếu không có trái cây trùng
                    //Thêm trái cây mới vào danh sách order
                    cm.orderFruit1.add(new Fruit(selectedFruit.getID(), selectedFruit.getfName(),
                            selectedFruit.getPrice(), qualityOrder, selectedFruit.getOrigin()));
                }
            }
            if (fm.checkQutity() == true) {//Nếu tất cả mặc hàng trái cây đều bằng 0
                System.out.println("\nWe were out of stock\n");
            }
        } while (ck.checkYN() == true);//Nếu lựa chọn người dùng là 'y' thì tiếp tục lập
        if (cm.orderFruit1.size() > 0) {//Nếu có order trái cây
            cm.showRecentCustomer();//in ra thông tin trái cây đã được order
            String customerName = cm.enterCusName();//Nhập tên người mua
            ArrayList<Fruit> customerOrders = new ArrayList<>(cm.orderFruit1);//Array mới để tránh bị ghi đề dữ liệu
            cm.orders.put(customerName, customerOrders);//đưa lịch sử orde vào HashTable
        } else {
            System.out.println("No order!");//nếu không có mặc hàng được order
        }
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
                op = Integer.parseInt(sc.nextLine());//chuyẻn option sang số 
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
                        Shopping();
                        break;
                    }
                    case 4: {//nếu người dùng muốn thoát chương trình
                        System.out.println("Thank you for using the program!");//in thông báo cảm ơn
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

    }

}
