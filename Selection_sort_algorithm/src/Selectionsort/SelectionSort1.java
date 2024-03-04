/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Selectionsort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Doan Thanh Phuc - CE170580
 */
public class SelectionSort1 {

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

        // A loop to enter array size until it's valid 
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
            } catch (NumberFormatException e) {// if it's not an integer
                System.out.println("Error: N must be an integer.");
                valid = false;
            }
        } while (!valid);

        //gán độ dài của mãng là n
        arr = new int[n];
        Random random = new Random();
        // Randomize array elements from -10 to 10
        for (int i = 0; i < n; i++) {
            int randomNumber = random.nextInt(21) - 10;
            arr[i] = randomNumber;// thêm phần tử vào mãng
        }
        return true;
    }

    /**
     * Sort the array by Selection Sort
     *
     * Let find the minimum value in the array and compare with order
     */
    public void sortArray() {

        int legnth = arr.length;//lenght of array

        // Iterate over each element of the array
        for (int i = 0; i < legnth - 1; i++) {

            // Find smallest element in unsorted array
            int min_idx = i;
            for (int j = i + 1; j < legnth; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            // Swap the smallest and first element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
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
