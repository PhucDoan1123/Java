/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p0005_countletter;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Doan Thanh Phuc - CE170580
 */
public class CountLetter1 {

    private String str;//khai bao chuoi nhap vao

    /**
     * Let user enter string
     *
     *
     * @return true if it done
     */
    public boolean enterString() {
        boolean check = false;
        //Bắt lỗi những trường hợp người dùng nhập sai
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your content: ");
            str = sc.nextLine();
            if (str.isEmpty()) {
                //Bắt lỗi chuỗi rỗng
                System.out.println("Error: You must enter a string!");
            } else if (str.matches(".*\\d.*")) {
                //Bắt lỗi chuỗi nhập vào là số
                System.out.println("Error: Input string cannot contain numbers!");
            } else if (str.matches(".*[^a-zA-Z0-9 ]+.*")) {
                //Bắt lỗi chuỗi nhập vào là kí tự đăc biệt
                System.out.println("Error: Input string cannot contain Special characters");
            } else if (str.matches(".*\\s{2,}.*")) {
                //bắt lỗi chuỗi nhập vào là toàn là khoảng trắng
                System.out.println("Error: You must enter a string!");
            } else {
                check = true;
            }
        } while (check == false);
        return true;
    }

    /**
     * Split string and count occurrences of words and characters
     *
     * Print the result after counting
     */
    public void count() {

        //Tách chuỗi bằng StringTokenizer
        StringTokenizer token = new StringTokenizer(str);
        //Lưu trữ số lượng character
        Map<String, Integer> CntWord = new LinkedHashMap<>();//LinkedHashMap để duy trì thứ tự ban đầu của mảng
        //Lưu trữ số lượng letter
        Map<Character, Integer> CntChar = new HashMap<>();

        //Lập qua các Token để đếm số lần xuất hiện của letter và character
        while (token.hasMoreTokens()) {
            String tk = token.nextToken();
            //Đếm số lần xuất hiện của letter
            for (int i = 0; i < tk.length(); i++) {
                char c = tk.charAt(i);
                if (CntChar.containsKey(c)) {
                    CntChar.put(c, CntChar.get(c) + 1);
                } else {
                    CntChar.put(c, 1);
                }
            }
            //Đếm số lượng character
            if (CntWord.containsKey(tk)) {
                CntWord.put(tk, CntWord.get(tk) + 1);
            } else {
                CntWord.put(tk, 1);
            }
        }

        //In ket qua dem character
        String result1 = "";
        for (String word : CntWord.keySet()) {
            result1 += ", " + word + "=" + CntWord.get(word);
        }
        result1 = result1.substring(1);
        System.out.println("[" + result1.substring(1) + "]");

        //In ket qua dem ky letter
        String result2 = "";
        for (Character c : CntChar.keySet()) {
            result2 += ", " + c + "=" + CntChar.get(c);
        }
        result2 = result2.substring(1);
        System.out.println("[" + result2.substring(1) + "]");
    }

}
