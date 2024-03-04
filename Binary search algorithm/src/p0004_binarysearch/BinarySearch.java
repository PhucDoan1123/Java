/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p0004_binarysearch;

/**
 *
 * @author Doan Thanh Phuc - CE170580
 */
public class BinarySearch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //Declare object BinarySearch1
        BinarySearch1 b1 = new BinarySearch1();

        b1.InputArray();//enter array

        b1.Sort();//sort array

        b1.printArr();// print sorted array

        //Enter number need to search
        //return results after using Binary Search
        b1.search();

    }

}
