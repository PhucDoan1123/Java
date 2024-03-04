/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0007_doanthanhphuc_ce170580;

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

        //Declare object BinarySearch1
        LinerSearch1 b1 = new LinerSearch1();

        b1.InputArray();//enter array

        b1.printArr();//print array

        //Enter number need to search
        //return results after using Liner Search
        b1.search();
    }

}
