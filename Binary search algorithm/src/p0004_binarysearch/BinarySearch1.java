/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p0004_binarysearch;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Doan Thanh Phuc - CE170580
 */
public class BinarySearch1 {

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
     * Sort the array by bubble sort
     *
     * @return the sorted array
     */
    public void Sort() {
        //i is for j to run until it met the already order index
        for (int i = 0; i < n - 1; i++) {
            // j for check and swap
            for (int j = 0; j < n - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Print the array formatted
     *
     * @return String of array elements
     */
    public void printArr() {
        String result = "";
        for (int i = 0; i < arr.length; i++) {
            result += ", " + arr[i];
        }
        result = result.substring(2); ////cut commas and spaces at first
        System.out.println("Array: " + result);
    }

    /**
     * Find the value in array by Binary Search
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

        //Binary Search Method
        int position = -1;
        int left = 0;
        int right = n - 1;
        int mid = 0;
        while (left <= right) {

            mid = (left + right) / 2;//lay phan nguyen

            if (arr[mid] == k) { //check if k is in the middle
                position = mid;
                right = mid - 1; // take the number in the previous position
            } else if (arr[mid] < k) {// If k is larger, skip the left half
                left = mid + 1;
            } else { // If k is larger, skip the right half
                right = mid - 1;
            }
        }
        //in ra vị trí cần tìm nếu position > -1
        if (position == -1) {
            System.out.println("The value " + k + " value does not exist in array");
        } else {
            System.out.println("Found " + k + " at index " + position);
        }
    }

}
