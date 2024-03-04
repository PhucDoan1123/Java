package j1.l.p0003_doanthanhphuc_ce170580.pkg2;

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
public class Validation {

    Scanner sc = new Scanner(System.in);

    /**
     * The enterString function is responsible for validating and processing an
     * input string. It takes a string parameter s as input and returns a
     * boolean value indicating whether the input string is valid or not.
     *
     * @param s is the enter string to check
     *
     * @return true if the input string has no error
     */
    public boolean enterString(String s) {
        //Bắt lỗi những trường hợp người dùng nhập sai
        if (s.replaceAll("\\s+", " ").isEmpty()) {
            //Bắt lỗi chuỗi rỗng
            System.out.println("Error: You must enter a string!");
            return false;
        } else if (s.trim().replaceAll("\\s+", " ").matches(".*\\d.*")) {
            //Bắt lỗi chuỗi nhập vào là số
            System.out.println("Error: Input string cannot contain numbers!");
            return false;
        } else if (s.trim().replaceAll("\\s+", " ").matches(".*[^a-zA-Z ]+.*")) {
            //Bắt lỗi chuỗi nhập vào là kí tự đăc biệt
            System.out.println("Error: Input string cannot contain Special characters");
            return false;
        }
        return true;
    }

    /**
     * The CheckID function is responsible for validating and processing an
     * input string. It takes a string parameter s as input and returns a
     * boolean value indicating whether the input string is valid or not.
     *
     * @param s is the enter string to check
     *
     * @return true if the input string has no error
     */
    public boolean checkID(String s) {
        //Bắt lỗi những trường hợp người dùng nhập sai
        if (s.replaceAll("\\s+", " ").isEmpty()) {
            //Bắt lỗi chuỗi rỗng
            System.out.println("Error: You must enter a string!");
            return false;
        } else if (s.trim().replaceAll("\\s+", " ").matches(".*[^a-zA-Z0-9\\s]+.*")) {
            //Bắt lỗi chuỗi nhập vào là kí tự đặc biệt
            System.out.println("Error: Input string cannot contain Special characters");
            return false;
        }
        return true;
    }

    /**
     * The checkYN() method validates user input for continuing shopping. It
     * checks if the entered string is "Y" or "N" (case-insensitive), and
     * returns true if it is "Y" and false otherwise. It handles empty input and
     * displays an error message for invalid input.
     *
     * @return true if choose Yes
     */
    public boolean checkYN() {
        boolean check = true;
        String choose;
        do {
            System.out.print("Do you want to continue? (Y/N or y/n)");
            // Enter for continuing shopping
            choose = sc.nextLine();
            if (enterString(choose) == false) {//kiểm tra chuỗi nhập vào
                check = false;
            } else if (choose.equalsIgnoreCase("y") || choose.equalsIgnoreCase("n")) {
                check = true;
            } else {//nếu chuỗi không phải là (Y/N or y/n)
                System.out.println("You can only enter (Y/N or y/n)!");
                check = false;
            }
        } while (!check);//điều kiện thoát vòng lập
        if (choose.equalsIgnoreCase("y")) {//return true if chosse is "y" or "Y"
            return true;
        } else {
            return false;
        }
    }

}
