/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.l.p0003_doanthanhphuc_ce170580.pkg2;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author Doan Thanh Phuc - CE170580
 */
public class Fruit {

    private String ID;//ID of fruit
    private String fName;//Name of fruit
    private int price;//Price of fruit
    private int quantity;//Quatity of fruit
    private String origin;//Origin of fruit
    Validation ck = new Validation();//Khai báo đối tượng kiểm tra dữ liệu
    Scanner sc = new Scanner(System.in);//Nhập dữ liệu từ bàn phím

    /**
     * Empty constructor
     */
    public Fruit() {
    }

    /**
     * Parameterized constructor
     *
     * @param ID the ID of the fruit
     * @param fName the name of the fruit
     * @param price the price of the fruit
     * @param quantity the quantity of the fruit
     * @param origin the origin of the fruit
     */
    public Fruit(String ID, String fName, int price, int quantity, String origin) {
        this.ID = ID;
        this.fName = fName;
        this.price = price;
        this.quantity = quantity;
        this.origin = origin;
    }

    /**
     * Get the ID of the fruit
     *
     * @return the ID
     */
    public String getID() {
        return ID;
    }

    /**
     * Set the ID of the fruit
     *
     * @param ID the ID to set
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * Get the name of the fruit
     *
     * @return the fName
     */
    public String getfName() {
        return fName;
    }

    /**
     * Set the name of the fruit
     *
     * @param fName the fName to set
     */
    public void setfName(String fName) {
        this.fName = fName;
    }

    /**
     * Get the price of the fruit
     *
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * Set the price of the fruit
     *
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Get the quantity of the fruit
     *
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Set the quantity of the fruit
     *
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Get the origin of the fruit
     *
     * @return the origin
     */
    public String getOrigin() {
        return origin;
    }

    /**
     * Set the origin of the fruit
     *
     * @param origin the origin to set
     */
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    /**
     * The function prompts the user to enter the ID of the fruit.
     *
     * It uses a do-while loop to repeatedly ask for input until a valid name is
     * entered. The user's input is stored in the `fName` field of the `Fruit`
     * class after trimming leading/trailing spaces and replacing consecutive
     * spaces with a single space. The input is validated using the
     * `enterString()` method from the `Validation` class (assuming it checks
     * for a non-empty string). If the input is valid, the check flag is set to
     * true, and the loop ends. If the input is invalid, an error message is
     * displayed, and the loop continues. Finally, the function returns the
     * entered name.
     *
     * @return ID of fruit after input
     */
    public String inputID() {
        boolean check = false;//kiểm tra dữ liệu nhập vào có đúng không
        do {
            System.out.print("Enter ID: ");
            ID = sc.nextLine().trim().replaceAll("\\s+", " ");//cắt khoảng trắng dư thừa
            if (ck.checkID(ID)) {
                check = true;//nếu dữ hợp lệ
            }
        } while (!check);
        return ID;//ID of fruit after input
    }

    /**
     * Prompt the user to enter the name of the fruit.
     *
     * It uses a do-while loop to repeat the entry request until a valid price
     * is entered. After the user enters, the price is converted to an integer
     * and stored in the price field of the Fruit object. The function returns
     * the entered price.
     *
     * @return the entered name
     */
    public String inputName() {
        boolean check = false;//kiểm tra dữ liệu nhập vào có đúng không
        do {
            System.out.print("Enter name: ");
            fName = sc.nextLine().trim().replaceAll("\\s+", " ");//Cắt khoảng trắng dư thừa
            if (ck.enterString(fName)) {
                check = true;//nếu dữ liệu hợp lệ
            }
        } while (!check);
        return fName;//return the entered name
    }

    /**
     * Prompt the user to enter the price of the fruit
     *
     * It uses a ring loop do-while to repeat the input request until there is a
     * matching number Rate is entered. After user input, the price is converted
     * to integer and stored in the quantity field of the Fruit object. Return
     * function on the amount entered.
     *
     * @return the amount entered.
     */
    public int inputPrice() {
        boolean check = false;
        do {
            try {
                System.out.print("Enter price: ");
                price = Integer.parseInt(sc.nextLine());//chuyển sang số nguyên
                if (price < 1) {//nếu không phải số nguyên dương
                    System.out.println("Please enter a positive number!");
                } else {
                    check = true;
                }
            } catch (NumberFormatException e) {//bắt lỗi không phải là số nguyên
                System.out.println("Please enter an integer number!");
            }
        } while (!check);
        return price;//the amount entered.
    }

    /**
     * Prompt the user to enter the quantity of the fruit
     *
     * It uses a do-while loop to repeatedly ask for input until a valid
     * quantity is entered. The user's input is parsed as an integer and stored
     * in the quantity variable. The input is validated to ensure it is a
     * positive number. If the input is less than 1, an error message is
     * displayed, and the loop continues. If the input is a valid positive
     * number, the check flag is set to true, and the loop ends. Finally, the
     * function returns the entered quantity.
     *
     * @return the entered quantity
     */
    public int inputQuantity() {
        boolean check = false;
        do {
            try {
                System.out.print("Enter quantity: ");
                quantity = Integer.parseInt(sc.nextLine());//chuyển sang số nguyên
                if (quantity < 1) {//nếu không phải sóo nguyên dương
                    System.out.println("Please enter a positive number!");
                } else {
                    check = true;
                }
            } catch (NumberFormatException e) {//bắt trường hợp không phải số nguyên
                System.out.println("Please enter an integer number!");
            }
        } while (!check);
        return quantity;//the entered quantity
    }

    /**
     * Prompt the user to enter the origin of the fruit
     *
     * It uses a do-while loop to repeatedly ask for input until a valid origin
     * is entered. The user's input is stored in the origin field of the Fruit
     * class after trimming leading/trailing spaces and replacing consecutive
     * spaces with a single space. The input is validated using the
     * enterString() method from the Validation class (assuming it checks for a
     * non-empty string). If the input is valid, the check flag is set to true,
     * and the loop ends. If the input is invalid, an error message is
     * displayed, and the loop continues. Finally, the function returns the
     * entered origin.
     *
     * @return the entered origin
     */
    public String inputOrigin() {
        boolean check = false;//kiểm tra dữ liệu nhập vào
        do {
            System.out.print("Enter origin: ");
            origin = sc.nextLine().trim().replaceAll("\\s+", " ");//xóa khoảng trắng dư thừa
            if (ck.enterString(origin)) {
                check = true;
            }
        } while (!check);
        return origin;//the entered origin
    }

    /**
     * Display the details of the fruit
     *
     * Format the value value to a string of the form "###,###,###$" using apply
     * Layer DecimalFormat and sample price2. Initialize an object DecimalFormat
     * with sample price2. Use DecimalFormat object for dedefine format value
     * value to string formatValue. Use System.out.printf() to in the screen of
     * the information about the left tree BY CATEGORIES FORMAT, BACK includes
     * ID, fName, formatValue (formatted value), quantity and origin.
     */
    public void disPlay() {
        String price2 = "###,###,###$";//tạo định dạng
        DecimalFormat df = new DecimalFormat(price2);//định dạng chuỗi theo format có sẵn
        String formatValue = df.format(price);//định dạng giá trị cần định dạng và trả về chuỗi String đã đc định dạng
        System.out.printf("|%-5s|%-15s|%-9s|%-9d|%-14s|", ID, fName, formatValue, quantity, origin);
    }

}
