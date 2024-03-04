

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Doan Thanh Phuc - CE170580
 */
public class Fibonacci1 {

    private int n;// limit of Fibonacci sequence

    /**
     * Find the first 45 numbers of the Fibonacci sequence
     *
     * @return Fibonacci sequence from first position to 45
     */
    public void fibonacii() {
        n = 45;// gán giới hạn = 45
        int F[] = new int[n];

        F[0] = 0;//giá trị của F0
        F[1] = 1;//giá trị của F1

        System.out.printf("The %d sequence Fibonacci: \n", n);
        //Tìm dãy Fibonacci từ F3 đến F45
        for (int i = 2; i < n; i++) {
            F[i] = F[i - 1] + F[i - 2];
        }

        //In ra màng hình dãy Fibonacci từ 1st đến 45th
        System.out.print(F[0] + ", " + F[1] + ", ");
        for (int i = 2; i < n; i++) {
            System.out.print(F[i] + ", ");

        }
    }

}
