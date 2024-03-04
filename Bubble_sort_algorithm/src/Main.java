
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Doan Thanh Phuc - CE170580
 */
public class Main {

    public static void main(String[] args) {
        //Declare object BubbleSort1
        BubbleSort1 am = new BubbleSort1();

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
