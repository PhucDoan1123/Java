
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
public class Dictionary {

    private String VnWord;//Vietnamese word
    private String EnWord;//English word

    Validation ck = new Validation();//Nhập dữ liệu từ bàn phím

    Scanner sc = new Scanner(System.in);//Khai báo đối tượng kiểm tra dữ liệu

    /**
     * This is the default constructor of the Dictionary class. It does not take
     * any parameters and does not perform any operations.
     */
    public Dictionary() {
    }

    /**
     * This is the constructor of the Dictionary class. It takes two parameters:
     * VnWord (Vietnamese word) and EnWord (English word). It assigns the values
     * of the parameters to the corresponding member variables.
     *
     * @param VnWord The Vietnamese word.
     * @param EnWord The English word.
     */
    public Dictionary(String VnWord, String EnWord) {
        this.VnWord = VnWord;
        this.EnWord = EnWord;
    }

    /**
     * Getter method to retrieve the Vietnamese word (VnWord).
     *
     * @return The value of the VnWord variable.
     */
    public String getVnWord() {
        return VnWord;
    }

    /**
     * Setter method to set the value of the Vietnamese word (VnWord).
     *
     * @param VnWord The new value of the Vietnamese word.
     */
    public void setVnWord(String VnWord) {
        this.VnWord = VnWord;
    }

    /**
     * Getter method to retrieve the English word (EnWord).
     *
     * @return The value of the EnWord variable.
     */
    public String getEnWord() {
        return EnWord;
    }

    /**
     * Setter method to set the value of the English word (EnWord).
     *
     * @param EnWord The new value of the English word.
     */
    public void setEnWord(String EnWord) {
        this.EnWord = EnWord;
    }

    /**
     * Enter English word
     *
     * Method used to enter an English word from the user. It uses a do-while
     * loop to repeatedly ask the user for input until a valid word is entered.
     * Then it assigns the new English word value to the EnWord variable.
     */
    public void enterEnW() {
        boolean check = true;//kiểm tra dữ liệu 
        do {
            System.out.print("Enter English: ");
            EnWord = sc.nextLine().trim().replaceAll("\\s+", " ");//nhập và cắt khoảng trắng dư thừa
            if (ck.enterString(EnWord) == true) {//nếu dữ liệu hợp lệ
                check = false;
            }
        } while (check == true);//Lập cho đến khi dữ liệu nhập đúng format
    }

    /**
     * Enter Vietnamese word
     *
     * Method used to enter a Vietnamese word from the user. It uses a do-while
     * loop to repeatedly ask the user for input until a valid word is entered.
     * Then it assigns the new Vietnamese word value to the VnWord variable.
     */
    public void enterVnW() {
        boolean check = true;//Kiểm tra dữ liệu
        do {
            System.out.print("Enter Vietnamese: ");
            VnWord = sc.nextLine().trim().replaceAll("\\s+", " ");//nhập và cắt khoảng trắng dư thừa
            if (ck.enterString(VnWord) == true) {//nếu dữ liệu hợp lệ
                check = false;
            }
        } while (check == true);//Lập cho đến khi dữ liệu nhập đúng format
    }

    /**
     * Print Dictionary
     *
     * Method used to print the current English and Vietnamese words in a
     * tabular format.
     */
    public void printW() {
        System.out.printf("| %-30s| %-30s|\n", EnWord, VnWord);
    }

}
