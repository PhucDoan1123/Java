package J1.S.P00013_DoanThanhPhuc_CE170580;

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

}
