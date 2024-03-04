/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0003_doanthanhphuc_ce170580.pkg2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Doan Thanh Phuc - CE170580
 */
public class FruitManagement {

    Scanner sc = new Scanner(System.in);// Nhập dữ liệu từ bàn phím

    Validation ck = new Validation();//Khái báo đối tượng Validation để kiểm tra

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
     * Add new fruit to the shop
     *
     * declare variables corresponding to fruit information and add to ArrayList
     * to store fruit information, check the ID and name of the new fruit
     * information and check whether the old fruit is the same or not
     */
    public void addFruit() {
        do {
            showFruit();//Show ra trái cây trong show
            boolean checkID = true;//kiểm tra dữ liệu
            Fruit addf = new Fruit();//Khái báo một đối tượng trái cây mới

            Set<String> idSet = new HashSet<>();//Đưa vào HashSet để kiểm tra dữ liệu
            for (Fruit f : fruits) {//Duyêt qua từng phần tử để lấy dữ liệu
                idSet.add(f.getID().toLowerCase());//truyền ID vào set
            }

            String newID;//String chưa ID mới
            do {
                newID = addf.inputID();//Nhập ID mới
                if (idSet.contains(newID.toLowerCase())) {//Nếu ID tồn tại
                    System.out.println("This ID already exists!");
                    checkID = false;
                } else {
                    checkID = true;//nếu ID không tồn tại
                }
            } while (!checkID);

            //Iput name, price, quatity and origin of fruit
            addf.inputName();
            addf.inputPrice();
            addf.inputQuantity();
            addf.inputOrigin();
            fruits.add(addf);//thêm fruit vào danh sách
        } while (ck.checkYN());//Nếu chọn tiếp tục thêm trái cây thì tục tục 
        showFruit();
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
        System.out.println("+-----+-----+---------------+---------+---------+--------------+");
        System.out.println("|No.  | ID  |  Fruit Name   |  Price  | Quatity |    Origin    |");
        System.out.println("+-----+-----+---------------+---------+---------+--------------+");
        // Iterate over the fruits list and display information
        int no = 1;//thức tự của trái 
        for (Fruit f : this.fruits) {//Duyệt qua từng phần tử để lấy dữ liệu
            System.out.printf("| %-3d ", no++);
            f.disPlay();//in ra thông tin trái cây
            System.out.println();
        }
        // Print table footer
        System.out.println("+-----+-----+---------------+---------+---------+--------------+");
    }

    /**
     * Check the number of fruits
     *
     * This method checks the quantity of available fruits. It initializes a
     * variable 'availableFruitsCount' to 0. It then iterates over each fruit in
     * the 'fruits' list. If a fruit has a quantity greater than 0, it
     * increments the 'availableFruitsCount' and breaks out of the loop. After
     * the loop, if 'availableFruitsCount' is still 0, it means there are no
     * fruits with a quantity greater than 0, so it returns true. Otherwise, it
     * returns false.
     *
     * @return true if all fruit count is equal to = 0
     */
    public boolean checkQutity() {
        int availableFruitsCount = 0;//đếm số lượng trái cây cái số lượng lớn hơn 0
        for (Fruit fruit : fruits) {
            if (fruit.getQuantity() > 0) {
                availableFruitsCount++;//tăng khi gặp số lượng trái cây lớn hơn 0
                break;
            }
        }
        // Nếu không có trái cây nào có số lượng khác 0, in ra thông báo
        if (availableFruitsCount == 0) {
            return true;
        }
        return false;//Nếu còn có trái cây có số lượng lớn hơn 0
    }

}
