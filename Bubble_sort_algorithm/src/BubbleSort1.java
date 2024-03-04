
import java.util.Arrays;
import java.util.Random;
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
public class BubbleSort1 {

    private int arr[]; //array of integer numbers
    private int n; //size of array

    /**
     * Let user enter size of array
     *
     *
     * use try - catch to catch the case that the number n entered is not a
     * number integer,let random Element of array
     *
     * @return true if done
     */
    public void inputArray() {
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
                    valid = true;
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
            arr[i] = randomNumber;
        }
    }

    /**
     * Sort the array by bubble sort
     *
     * use two overlapping loops to implement the algorithm, loop i to make sure
     * all elements are checked and loop j to compare and swap values, after
     * each iteration the limit of loop j will be updated because we already
     * know the last number is correct its position
     *
     * The array will be sorted from smallest to largest after performing the
     * algorithm
     */
    public void sortArray() {

        int legnth = arr.length;//lenght of array

        //i is for j to run until it met the already order index
        for (int i = 0; i < legnth - 1; i++) {
            // j for check and swap
            for (int j = 0; j < legnth - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
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
