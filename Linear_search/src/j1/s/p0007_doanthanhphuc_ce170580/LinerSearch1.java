/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0007_doanthanhphuc_ce170580;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Doan Thanh Phuc - CE170580
 */
public class LinerSearch1 {

    private int arr[]; //array of integer numbers
    private int n; //size of array
    private int k; // value to look for

    /**
     * Let user enter size of array
     *
     * @return true if done
     */
    public boolean InputArray() {
        Scanner sc = new Scanner(System.in);
        n = 0;
        boolean valid = true;

        //A loop to enter array size until it's valid 
        do {
            try {
                valid = true;
                System.out.println("Enter number of array: ");
                n = Integer.parseInt(sc.nextLine());
                if (n <= 0 || n > 999999) {// if number is out of range
                    System.out.println("Error: N must be a positive integer.");
                    valid = false;
                }
            } catch (NumberFormatException e) {//if it's not an integer
                System.out.println("Error: N must be an integer.");
                valid = false;
            }
        } while (valid == false);
        arr = new int[n];
        Random random = new Random();
        //Random elements of array từ - 10 đến 10
        for (int i = 0; i < n; i++) {
            int randomNumber = random.nextInt(21) - 10;
            arr[i] = randomNumber;
        }
        return true;
    }

    /**
     * Print the array formatted
     *
     * @return String of array elements
     */
    public void printArr() {
        String result = "";
        //truyền từng phần tử vào chuỗi để sử lý
        for (int i = 0; i < arr.length; i++) {
            result += ", " + arr[i];
        }
        result = result.substring(2); //cut commas and spaces at first
        System.out.println("The array: " + result);// print array
    }

    /**
     * Find the value in array by Liner Search
     *
     * @return the position of the search value
     */
    public void search() {
        Scanner sc1 = new Scanner(System.in);
        //Enter valid need to find
        boolean valid1 = true;
        do {
            try {
                System.out.println("Enter search value: ");
                k = Integer.parseInt(sc1.nextLine());
            } catch (NumberFormatException e) {//if it's not an integer
                System.out.println("Error: k must be an integer.");
                valid1 = false;
            }
        } while (valid1 == false);

        //Liner search method
        int position = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == k) {
                position = i;
                break;
            }
        }
        //In ra vị trí của số cần tìm nếu position >= 0
        if (position < 0) {
            System.out.println("The value " + k + " value does not exist in array");
        } else {
            System.out.println("Found " + k + " at index " + position);
        }
    }
}
