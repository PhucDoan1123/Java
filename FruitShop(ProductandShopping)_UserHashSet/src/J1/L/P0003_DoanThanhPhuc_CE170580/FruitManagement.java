/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.L.P0003_DoanThanhPhuc_CE170580;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Doan Thanh Phuc - CE170580
 */
public class FruitManagement {

    private String orderFruitName;//Tên của trái cây được order
    private int orderFruitQuatity = 0;// số lượng được order

    Scanner sc = new Scanner(System.in);
    Validation ck = new Validation();

    /**
     * so that other classes can use the function in this class without passing
     * parameters
     */
    public FruitManagement() {
    }

    ArrayList<Fruit> fruits = new ArrayList<>();//ArrayList để lưu thông tin trái cây

    //generay sẵn các thông tin trái cây
    {
        fruits.add(new Fruit("f1", "Mango", 12, 9, "VietNam"));
        fruits.add(new Fruit("f2", "Durian", 60, 10, "ThaiLan"));
        fruits.add(new Fruit("f3", "Strawberry", 40, 20, "America"));
        fruits.add(new Fruit("f4", "Coconut", 10, 15, "Laos"));
        fruits.add(new Fruit("f5", "Grape", 55, 15, "Rusia"));
    }

    /**
     *
     * Function to get the name of the ordered fruit.
     *
     * @return The name of the ordered fruit.
     */
    public String getOrderFruitName() {
        return orderFruitName;
    }

    /**
     *
     * Function to set the name of the ordered fruit.
     *
     * @param orderFruitName The name of the ordered fruit.
     */
    public void setOrderFruitName(String orderFruitName) {
        this.orderFruitName = orderFruitName;
    }

    /**
     *
     * Function to get the quantity of the ordered fruit.
     *
     * @return The quantity of the ordered fruit.
     */
    public int getOrderFruitQuatity() {
        return orderFruitQuatity;
    }

    /**
     *
     * Function to set the quantity of the ordered fruit.
     *
     * @param orderFruitQuatity The quantity of the ordered fruit.
     */
    public void setOrderFruitQuatity(int orderFruitQuatity) {
        this.orderFruitQuatity = orderFruitQuatity;
    }

    /**
     * Add new fruit to the shop
     *
     * declare variables corresponding to fruit information and add to ArrayList
     * to store fruit information, check the ID and name of the new fruit
     * information and check whether the old fruit is the same or not
     */
    public void addFruit() {
        String countinuAdd = "";
        boolean checkcountinu = true;
        do {
            String ID = "";//ID của trái cây mới
            String name = "";//Tên của trái cây mới
            int price = 0;//giá của trái cây mới
            int Quality = 0;// số lượng của trái cây mới
            String Origin;//nguồn gốc của trái cây mới

            //Cách check1 đến check5 để kiểm tra giá trị nhập vào có hợp lệ không 
            boolean check1 = false;
            boolean check2 = false;
            boolean check3 = true;
            boolean check4 = true;
            boolean check5 = true;

            Set<String> idSet = new HashSet<>();//Khai báo một Set để lưu ID của trái cây có sẵn
            Set<String> nameSet = new HashSet<>();//Khai báo một Set để lưu ID của trái cây có sẵn

            //Lấy tên trái cây và ID có sẵn trong ArrayList
            for (Fruit f : this.fruits) {
                idSet.add(f.getID().toLowerCase());//Thêm ID của trái cây vào set
                nameSet.add(f.getfName().toLowerCase());//thêm tên của trái cây vào set
            }

            //Enter ID 
            do {
                System.out.print("Enter fruit's ID: ");
                ID = sc.nextLine().trim().replaceAll("\\s+", " ");
                if (ck.checkID(ID) == false) {//Kiểm tra tính hợp lệ của chuỗi
                    check1 = true;
                } else if (idSet.contains(ID.toLowerCase())) {//Kiểm tra name trùng
                    System.out.println("This ID is ready exit!");
                    check1 = true;//Nếu không có lỗi khi nhập
                } else {
                    check1 = false;//Nếu không có lỗi khi nhập
                }
            } while (check1);//điều kiện thực hiện vòng lập

            // Enter name of fruit
            do {
                System.out.print("Enter fruit's name: ");
                name = sc.nextLine().trim().replaceAll("\\s+", " ");//cắt những khoảng trắng dư thừa
                if (ck.enterString(name) == false) {//Kiểm tra tính hợp lệ của chuỗi
                    check2 = true;
                } else if (nameSet.contains(name.toLowerCase())) {//Kiểm tra name trùng
                    System.out.println("This name is ready exit!");
                    check2 = true;//Nếu không có lỗi khi nhập
                } else {
                    check2 = false;//Nếu không có lỗi khi nhập

                }
            } while (check2);//điều kiện thực hiện vòng lập

            //Enter price of Fruit
            do {
                System.out.print("Enter fruit's price: ");
                try {
                    price = Integer.parseInt(sc.nextLine());//chuyển giá của trái cây thành số nguyên
                    check3 = true;
                    if (price < 1) {//nếu giá nhỏ hơn 1
                        System.out.println("Please enter positive number!");
                        check3 = false;
                    }
                } catch (NumberFormatException e) {//Bắt lỗi price không phải số nguyên
                    System.out.println("Error");
                    check3 = false;
                }
            } while (!check3);//điệu kiên thực hiện vòng lập

            //Enter quality of Fruit
            do {
                System.out.print("Enter fruit's quatity: ");
                try {
                    Quality = Integer.parseInt(sc.nextLine());//chuyển thành số nguyên
                    check4 = true;
                    if (Quality < 1) {//nếu nhỏ hơn 1
                        System.out.println("Please enter positive number!");
                        check4 = false;
                    }
                } catch (NumberFormatException e) {//bắt lỗi không phải số ngyên
                    System.out.println("Error");
                    check4 = false;
                }
            } while (!check4);//điều kiện thực hiện vòng lập

            //Enter orgin of fruit
            do {
                System.out.print("Enter fruit's origin: ");
                Origin = sc.nextLine().trim();//cắt những khoảng trắng dư 
                if (ck.enterString(Origin) == false) {//kiểm tra tính hợp lệ của chuỗi
                    check5 = false;
                } else {
                    check5 = true;//nếu nó hợp lệ
                }
            } while (!check5);
            Fruit newFruit = new Fruit(ID, name, price, Quality, Origin);//Tạo trái cây mới
            this.fruits.add(newFruit);//thêm đối tượng vào list
            //Hỏi người dùng có muốn tiếp tục thêm sản phẩm không
            do {
                // Enter for continuing add
                System.out.print("Do you want to continue create Item? (Y/N or y/n)");
                countinuAdd = sc.nextLine();
                if (ck.enterString(countinuAdd) == false) {//kiểm tra chuỗi nhập vào
                    checkcountinu = false;
                } else if (countinuAdd.equalsIgnoreCase("y") || countinuAdd.equalsIgnoreCase("n")) {
                    checkcountinu = true;
                } else {//nếu chuỗi không phải là (Y/N or y/n)
                    System.out.println("You can only enter (Y/N or y/n)!");
                    checkcountinu = false;
                }
            } while (!checkcountinu);//điều kiện thoát vòng lập
        } while (countinuAdd.equalsIgnoreCase("Y"));
    }

    /**
     * Show fruit's information
     *
     * Function to display the list of fruits. This function prints a table with
     * the ID, name, price, quantity, and origin of each fruit. It iterates over
     * the fruits list and retrieves the information for each fruit. The
     * information is then formatted and printed in a table-like format.
     * Important code: The for loop iterates over the fruits list to access each
     * fruit. The information of each fruit is retrieved using getter methods.
     * The System.out.printf statement formats and prints the fruit information
     * in a table format.
     *
     */
    public void showFruit() {
        // Print table header
        System.out.println("+-------+----------------------+---------+----------+----------------------+");
        System.out.println("| ID    |         Name         |  Price  | Quantity | Origin               |");
        System.out.println("+-------+----------------------+---------+----------+----------------------+");

        // Iterate over the fruits list and display information
        for (int j = 0; j < fruits.size(); j++) {
            // Retrieve information for each fruit
            String fName = fruits.get(j).getfName();
            int quantity = fruits.get(j).getQuantity();
            int price = fruits.get(j).getPrice();
            String origin = fruits.get(j).getOrigin();
            String ID = fruits.get(j).getID();

            // Print formatted fruit information
            System.out.printf("| %-5s | %-20s | %6d$ | %8d | %-20s |\n", ID, fName, price, quantity, origin);
        }

        // Print table footer
        System.out.println("+-------+----------------------+---------+----------+----------------------+");
    }

    /**
     * Update the number of fruits after ordering
     *
     * Function to update the quantity of a fruit in the storage after an order
     * is placed. It searches for the fruit with a name matching the ordered
     * fruit's name. If a match is found, the function updates the fruit's
     * quantity in the fruits list. If the ordered quantity matches the
     * available quantity, the fruit is removed from the list. Important code:
     * The for loop iterates over the fruits list to find the matching fruit.
     * The getfName method is used to compare the fruit names. The setQuantity
     * method is used to update the quantity of the fruit. If the ordered
     * quantity matches the available quantity, the remove method is used to
     * remove the fruit.
     */
    public void setFruitStorageQuantity() {
        for (int i = 0; i < this.fruits.size(); i++) {
            // Compare fruit names
            if (this.fruits.get(i).getfName().equalsIgnoreCase(getOrderFruitName())) {
                Fruit f = this.fruits.get(i);
                // Update quantity or remove fruit
                if (f.getQuantity() == getOrderFruitQuatity()) {//Nếu khác hàng order hết số lượng hiện có
                    this.fruits.remove(f);
                } else {//nếu số lượng order nhỏ hơn số lượng hiên có
                    this.fruits.get(i).setQuantity(f.getQuantity() - getOrderFruitQuatity());
                }
            }
        }
    }

    /**
     * check if the number of names of fruit is in the store
     *
     * Function to check if a fruit name exists in the list of fruits. It
     * iterates over the fruits list and compares the name of each fruit with
     * the ordered fruit's name. If a match is found, the function returns true,
     * indicating that the fruit name exists in the list. If no match is found,
     * the function returns false. Important code: The for-each loop iterates
     * over the fruits list to access each fruit. The getfName method is used to
     * retrieve the name of each fruit. The equalsIgnoreCase method is used to
     * compare the fruit names.
     *
     * @returns true if a match is found
     *
     */
    public boolean exitName() {
        for (Fruit fruit : this.fruits) {//Lập qua các trái cây
            if (fruit.getfName().equalsIgnoreCase(getOrderFruitName().trim().replaceAll("\\s+", " "))) {//so sánh tên
                return true;
            }
        }
        return false;//Nếu không có tên trunhg
    }

    /**
     * Enter the name of the fruit you want to order
     *
     * Function to prompt the user to input the name of the fruit for ordering.
     * It reads the user's input using a scanner and validates the input using a
     * validation object. If the input is valid, it sets the order fruit name.
     * Important code: The do-while loop repeats until a valid input is entered.
     * The sc.nextLine() method reads the user's input. The ck.enterString
     * method is used to validate the input. If the input is valid, the order
     * fruit name is set using setOrderFruitName.
     */
    public void inputOrderFruitName() {
        boolean check1 = true;
        String enterName;
        do {
            System.out.print("You selected: ");
            enterName = sc.nextLine().trim().replaceAll("\\s+", " ");//cắt những khoảng trắng dư 
            if (ck.enterString(enterName.trim()) == false) {//Kiểm tra chuỗi nhập vào
                check1 = false;
            } else {
                setOrderFruitName(enterName);//cập nhập lại tên của trái cây được order
                check1 = true;
            }
        } while (!check1);//điều kiên thoát vòng lập
    }

    /**
     * Enter quantity of fruit ordered
     *
     * Function to prompt the user to input the quantity of the fruit for
     * ordering. It reads the user's input using a scanner and validates the
     * input using a validation object. If the input is valid, it sets the order
     * fruit quantity. Important code: The do-while loop repeats until a valid
     * input is entered. The sc.nextLine() method reads the user's input. The
     * Integer.parseInt method is used to convert the input to an integer. The
     * NumberFormatException is caught to handle invalid input. If the input is
     * valid, the order fruit quantity is set using setOrderFruitQuatity.
     */
    public void inputOrderFruitQuatity() {
        int findQuantity = 0;
        boolean check = true;
        do {
            System.out.print("Enter Fruit's quantity: ");
            try {
                findQuantity = Integer.parseInt(sc.nextLine());//chuyển thành số nguyên
                check = true;
                if (findQuantity < 1) {//nếu nó nhỏ hơn 1
                    check = false;
                } else {
                    setOrderFruitQuatity(findQuantity);//cập nhập lại số lượng được order
                    check = true;
                }
            } catch (NumberFormatException e) {//bắt lỗi không phải số nguyên
                System.out.println("Error!");
                check = false;
            }
        } while (!check);//điẹue kiện thoát vòng lập
    }
}
