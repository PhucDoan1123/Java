/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Selectionsort;

/**
 *
 * @author Doan Thanh Phuc - CE170580
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //Declare object SelectionSort1
        SelectionSort1 am = new SelectionSort1();

        //enter array
        am.inputArray();

        //print ra unsorted array
        System.out.printf("Unsorted array: ");
        am.printArr();

        //sorting the array
        am.sortArray();

        //in ra sorted array
        System.out.printf("Sorted array: ");
        am.printArr();

    }

}
