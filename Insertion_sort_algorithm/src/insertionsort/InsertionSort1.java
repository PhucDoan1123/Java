/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package insertionsort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Doan Thanh Phuc - CE170580
 */
public class InsertionSort1 {

    private int arr[]; //array of integer numbers
    private int n; //size of array

    /**
     * Let user enter size of array
     *
     * Let random Element of array
     *
     * @return true if done
     */
    public boolean inputArray() {
        Scanner sc = new Scanner(System.in);
        n = 0;
        boolean valid = true;

        //A loop to enter array size until it's valid 
        do {
            try {
                System.out.println("Enter number of array: ");
                n = Integer.parseInt(sc.nextLine());
                if (n <= 0) {// if number is out of range
                    System.out.println("Error: N must be a positive integer.");
                    valid = false;
                } else {
                    valid = true;// kết thúc vòng lập
                }
            } catch (NumberFormatException e) {//if it's not an integer
                System.out.println("Error: N must be an integer.");
                valid = false;
            }
        } while (!valid);

        //gán độ dài của mãng là n
        arr = new int[n];
        Random random = new Random();
        //radom phần từ của mãng từ -10 đến 10;
        for (int i = 0; i < n; i++) {
            int randomNumber = random.nextInt(21) - 10;
            arr[i] = randomNumber;
        }
        return true;
    }

    /**
     * Sort the array by Insertion Sort
     * 
     * Let determine the key and compare the element
     */
    public void sortArray() {

        int length = arr.length;//length of array

        // Insertion sort method
        for (int i = 1; i < length; i++) {// duyệt qua từ phần tử
            int key = arr[i];
            int j = i - 1;

            // Move the elements of arr [0 ... i - 1], greater than key
            // to a position after their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];//dịch phải để tạo khoảng trống cho
                j = j - 1;//giảm giá trị j để duyệt qua phần tử tiếp theo
            }
            arr[j + 1] = key;// Cập nhật lại giá trị cho key
        }
    }

    /**
     * Let import Arrays class in Java library
     *
     * print array by toString method
     */
    public void printArr() {
        System.out.println(Arrays.toString(arr));
    }

}
