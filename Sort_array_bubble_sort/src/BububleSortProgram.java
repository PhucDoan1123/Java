
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
public class BububleSortProgram {

    private int[] arr;//mãng số nguyên
    private int n;// size of array

    Scanner sc = new Scanner(System.in);//đọc dữ liệu từ bàn phím

    /**
     * Let user enter size and element of array
     *
     * Use the check Input function of the Validation object to check the length
     * and elements of the array
     *
     */
    public void inputArray() {
        boolean valid1 = true;//check zise of array
        boolean valid2 = true;//check element of array

        //Nhập và kiểm tra lỗi khi nhập size of array
        do {
            try {
                System.out.println("---- Input Element ----");
                System.out.print("Enter number of array: ");
                n = Integer.parseInt(sc.nextLine());//đổi số n được nhập vào thành số nguyên
                valid1 = true;
                if (n <= 0) {// if it out of range or not an integer
                    System.out.println("Please enter a valid number greater than zero.");
                    valid1 = false;
                }
            } catch (NumberFormatException e) {//nếu nó không phải là số nguyên
                System.out.println("Please enter integer number!");
                valid1 = false;
            }

        } while (!valid1);//điều kiện thực hiện vòng lập

        //input element of array
        arr = new int[n];// gán n cho kích cỡ của mãng arr

        //truyền từng phần tử vào mãng
        for (int i = 0; i < n; i++) {
            //check giá trị nhập vào có phải là số nguyên hay không
            do {
                System.out.print("Enter number " + (i + 1) + ": ");//số thứ tự của phần tử khi nhập
                try {
                    int number = Integer.parseInt(sc.nextLine());//khai báo 1 biến number để kiểm tra number đó có phải là số nguyên hay không
                    arr[i] = number;//nếu phải thì gán nó cho arr[i]
                    valid2 = true;
                } catch (NumberFormatException e) {//ném ra ngoại lệ khi không phải số nguyên
                    System.out.println("Please enter integer number!");//in ra thông báo lỗi
                    valid2 = false;
                }
            } while (!valid2);//điều kiện thực hiện vòng lập
        }
    }

    /**
     * Sort array in Ascending by Bubble sort
     *
     * use two overlapping loops to implement the algorithm, loop i to make sure
     * all elements are checked and loop j to compare and swap values, after
     * each iteration the limit of loop j will be updated because we already
     * know the last number is correct its position
     *
     * print sorted array in ascending
     */
    public void sortAscending() {
        if (arr == null) {//kiểm tra chuỗi có được nhập hay chưa
            System.out.println("Please enter element of array!");
        } else {
            int l = arr.length;// gán l là đỗ dài của mãng cần sort
            //i is for j to run until it met the already order index
            for (int i = 0; i < l - 1; i++) {
                // j for check and swap
                for (int j = 0; j < l - i - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
            //Đưa mãng vào một chuỗi để sử lí in theo format
            String result = "";
            System.out.println("----- Ascending -----");
            //truyền từng phần tử vào chuỗi
            for (int i = 0; i < l; i++) {
                result += "->" + "[" + arr[i] + "]";
            }
            System.out.println(result.substring(2));//bỏ dấu mũi tên đầu tiên
        }

    }

    /**
     * Sort array in Descending by bubble sort
     *
     * use two overlapping loops to implement the algorithm, loop i to make sure
     * all elements are checked and loop j to compare and swap values, after
     * each iteration the limit of loop j will be updated because we already
     * know the last number is correct its position
     *
     * print sorted array in descending
     */
    public void sortDescending() {
        if (arr == null) {//kiểm tra chuỗi có được nhập hay chưa
            System.out.println("Please enter element of array!");
        } else {
            int l = arr.length;// gán l là đỗ dài của mãng cần sort
            //i is for j to run until it met the already order index
            for (int i = 0; i < l - 1; i++) {
                // j for check and swap
                for (int j = 0; j < l - i - 1; j++) {
                    if (arr[j] < arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
            //Đưa mãng vào một chuỗi để sử lí in theo format
            String result = "";
            System.out.println("----- Descending -----");
            //truyền từng phần tử vào chuỗi
            for (int i = 0; i < l; i++) {
                result += "->" + "[" + arr[i] + "]";
            }
            System.out.println(result.substring(2));//bỏ dấu mũi tên đầu tiên
        }
    }

}
