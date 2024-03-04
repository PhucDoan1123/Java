/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0008_doanthanhphuc_ce170580;

import java.util.Scanner;

/**
 *
 * @author Doan Thanh Phuc - CE170580
 */
public class CoverNumber {

    private String inputValue;// Số cần đổi
    private String baseNumber;// kết quả sau khi đổi

    Scanner sc = new Scanner(System.in);// nhập dữ liệu từ bàn phím

    //Các phương thức getter và setter để truy xuất 
    //và đặt giá trị của hai biến inputValue và baseNumber
    //cho phép các oject khác có thể lấy giá trị cũng như thiết lập các giá trị mới cho chúng.
    
    /*
     * @return giá trị của biến inputValue
     */
    public String getInputValue() {
        return inputValue;
    }

    /*
     * để đặt giá trị cho biến inputValue
     *
     * @param inputValue giá trị đầu vào
     */
    public void setInputValue(String inputValue) {
        this.inputValue = inputValue;
    }

    /*
     *
     * @return giá trị của biến baseNumber
     */
    public String getBaseNumber() {
        return baseNumber;
    }

    /*
     * để đặt giá trị cho biến inputValue
     *
     * @param basenumber giá trị đầu vào
     */
    public void setBaseNumber(String baseNumber) {
        this.baseNumber = baseNumber;
    }

    /**
     * Let check inputValue
     *
     * Use the do-while loop to check the inputValue entered, if the inputValue
     * does not contain special characters, does not have too many spaces, is
     * not empty, the loop ends.
     *
     */
    public void inPutNumber() {
        boolean check = false;// kiểm tra giá trị nhập vào
        //Bắt lỗi những trường hợp người dùng nhập sai
        do {
            System.out.print("Enter your number: ");//Mời người dùng nhập lại
            inputValue = sc.nextLine();// nhập giá trị từ bàn phím
            if (inputValue.isEmpty()) {
                //Bắt lỗi chuỗi rỗng
                System.out.println("Please enter number is binary or decimal or is hexadecimal");
            } else if (inputValue.matches(".*[^a-zA-Z0-9 ]+.*")) {
                //Bắt lỗi chuỗi nhập vào là kí tự đăc biệt
                System.out.println("Input cannot contain Special characters");
            } else if (inputValue.matches(".*\\s{2,}.*")) {
                //bắt lỗi chuỗi nhập vào là toàn là khoảng trắng
                System.out.println("Please enter number is binary or decimal or is hexadecimal");
            } else {
                check = true;
            }
        } while (check == false);
    }

    /**
     * Let check inputValue is binary or not
     *
     * Use a for-each loop to check each character of the inputVale string
     * return false if it is not a 0 or 1 character.
     *
     * @return true if inputValue only contain 0 and 1
     */
    public boolean isBinary() {
        for (char c : inputValue.toCharArray()) {//Tách từng phần tử của inputVale và đưa vào mãng 
            if (c != '0' && c != '1') {//Nếu có ký tự không phải là 0 hoặc 1
                return false;
            }
        }
        return true;//Nếu các ký tự đều là 0 và 1
    }

    /**
     * Let check inputVale is decimal or not
     *
     * use try - catch to catch exception inputValue is not integer, use
     * Integer.parseInt() to convert inputValue to integer, if not an integer,
     * throw exception.
     *
     * @return false if it is not an decimal
     */
    public boolean isDecimal() {
        try {
            Integer.parseInt(inputValue);//Chuyển inputValue thành số nguyên
            return true;//nếu chuyển thành công
        } catch (NumberFormatException e) {
            return false;//nếu không chuyển thành số nguyên được
        }
    }

    /**
     * Let check inputVale is hexadecimal or not
     *
     * Create one named hexDigits to store the possible hexadecimal numeric
     * characters, use for-each to iterate through each element of inputValue
     * after entering the array in the toCharArray() method, if the hexDigits
     * string does not contain any characters that are similar to those in the
     * inputValue string, return false
     *
     *
     * @return true if is string inputValue only contains "0123456789ABCDEF"
     */
    public boolean isHexadecimal() {
        String hexDigits = "0123456789ABCDEF";//Khái báo chuỗi chưa những ký tự cho phép Hexadecimal có
        for (char c : inputValue.toCharArray()) {//Tách từng phần tử của inputVale và đưa vào mãng
            if (!hexDigits.contains(Character.toString(c))) {// điều kiênj kiểm tra
                return false;//Nếu có ký tự của mãng mà hexDigigits không chứa
            }
        }
        return true;//Nếu inputVale chỉ chưa những ký tự "0123456789ABCDEF"
    }

    /**
     * Let convert binary to decimal
     *
     * Use a for loop to iterate through all the elements of a binary number,
     * assign each character to the variable digit , convert the variable digit
     * assigned to a positive integer, calculate each number using the bit
     * formula * Math.pow(2 , power) and the public together.
     *
     * Update the value of the variable baseNumber
     *
     */
    public void binaryToDe() {
        int power = 0;
        int decimal = 0;//giá trị lưu số thập phân
        for (int i = getInputValue().length() - 1; i >= 0; i--) {// vòng lập ngược các phần tử
            char digit = getInputValue().charAt(i);//gán tử phần tử của chuỗi binary vào một biến char
            int bit = Character.getNumericValue(digit);//chuyển phần tử từ biến char thành số nguyên dương
            decimal += bit * Math.pow(2, power);//tính số decimal sau mỗi lần lập
            power++;
        }
        setBaseNumber(decimal + "");// cập nhập giá trị cho biến setBaseNumher
    }

    /**
     * Let cover decimal to binary
     *
     * Let's cover inputValue to integer number and assign it to the decimal
     * variable, declare a stringBuilder to store the binary number, do the
     * while loop until decimal < 0 , assign the remainder of decimal divided 2
     * to remainder, put remainder in position First of the binary string each
     * time, update the decimal variable by dividing by 2 until decimal = 0.
     *
     * Update the value of the variable baseNumber
     */
    public void decimalToBinary() {

        int decimal = Integer.parseInt(getInputValue());//chuyển inputValue thành số nguyên
        StringBuilder binary = new StringBuilder();//khai báo chuỗi để lưu số binary
        while (decimal > 0) {//điều kiên thực hiện vòng lập
            int remainder = decimal % 2;// gán số dự của decimal chia 2 vào biến remainder
            binary.insert(0, remainder);// đưa số biến remainder vào vị trí thứ nhất của chuỗi binary
            decimal = decimal / 2;//cập nhật biến decimal cho đến khi nó = 0
        }
        setBaseNumber(binary.toString());// cập lại giá trì cho biến baseNumber

    }

    /**
     * Let cover decimal to Hexadecimal
     *
     * Create a StringBuilder to store the hexadecimal number, create a char
     * array to store the characters the hexadecimal number can have, convert
     * inputValue to integer, Assign the decimal part of decimal divided by 16
     * to remainder variable, insert element hexDigits at remainder position in
     * the hexDigits array to the first position of the hex String after each
     * iteration, updating the value of decimal until it = 0.
     *
     * Update the value of the variable baseNumber
     *
     */
    public void decimalToHexadecimal() {

        StringBuilder hex = new StringBuilder();//Khai báo chuỗi để lưu số Hexadecimal
        //Khai báo mãng chưa những kí tự có trong một số Hexadecimal
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        int decimal = Integer.parseInt(getInputValue());//chuyển inputValue thành thập phân

        while (decimal > 0) {//điều kiên thực hiện vòng lập
            int remainder = decimal % 16;//gán số dư vào remainder khi decimal chia cho 16
            hex.insert(0, hexDigits[remainder]);// thêm phần tử ở vị trí remainder vào chuỗi hex
            decimal = decimal / 16;// cập nhập giá trị đến khi decimal = 0
        }

        setBaseNumber(hex.toString());// cập nhật lại giá trị baseNumber

    }

    /**
     * Let cover Hexadecimal to decimal
     *
     * use a for loop to iterate over each element of the binary number, each
     * time assign the value of each element to the digit, if the digit is a
     * character from '0' to '9' then digit the value of the character '0' in
     * the ASCII and assign it to value, if the character is between 'A' and 'F'
     * then 10 + digit minus the value character 'A' in the ASCII version,
     * calculate decimal stars each time.
     *
     * Update the value of the variable baseNumber
     */
    public void hexToDe() {
        int decimal = 0;// khai bao giá trị để lưu số thập phân
        int power = 0;// khai báo giá trị để lưu số mũ
        int n = getInputValue().length();// gán độ dài của chuỗi inputValue vào n
        for (int i = n - 1; i >= 0; i--) {// thực hiện vòng lập ngược để lập qua từng phần tử
            char digit = getInputValue().charAt(i);// gán từ phàn tử của số hex cho digit
            int value = 0;// khai báo giá trị để tính số decimal
            if (digit >= '0' && digit <= '9') {//nếu nó ở từ giá trị '0' - '9'
                value = digit - '0';// tính giá trị thập lục phân trong tương đương với thập phân
            } else if (digit >= 'A' && digit <= 'F') {//nếu nó ở từ giá trị 'A' - 'F'
                value = 10 + digit - 'A';// tính giá trị thập lục phân trong tương đương với thập phân
            }
            decimal += value * Math.pow(16, power);//Tính giá trị thập phân sau mỗi lần lập
            power++;// thêm 1 sau mỗi lần lập
        }
        setBaseNumber(decimal + "");// cập nhật lại giá trị baseNumber
    }

}
