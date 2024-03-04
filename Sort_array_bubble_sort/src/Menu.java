
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
public class Menu {

    Scanner sc = new Scanner(System.in);//Nhận giá trị từ bàn phím
    BububleSortProgram am = new BububleSortProgram();//Khai báo đối tượng BububleSortProgram

    /**
     * Let print menu of Bububle Sort Program
     *
     * Let user enter option of menu
     *
     * Use the do-while loop to repeat the program until the user wants to exit,
     * declare array of integers to input value, use try-catch to catch the case
     * where the op is not an integer, use switch- case to execute the option
     * selected by the user.
     *
     * Stop the program if user input option is 4
     *
     */
    public void Program() {

        int op = 0;//lựa chọn của người dùng

        //Vòng lập để người dùng lựa chọn chưc năng của Bububle Sort Program
        do {
            //in menu mời người dùng nhập option của chương trình
            System.out.println("========= Bubble Sort program =========");//in ra menu sau mỗi lần lập
            System.out.println("1. Input Element");
            System.out.println("2. Sort Ascending");
            System.out.println("3. Sort Descending");
            System.out.println("4. Exit");
            System.out.print("Please choice one option: ");//mời người dùng nhập option
            try {
                op = Integer.parseInt(sc.nextLine());//Enter option 

                //Lựa chọn chức năng để thực thi
                switch (op) {
                    //Input elemnt and size of array
                    case 1: {
                        am.inputArray();//input value
                    }
                    break;
                    //Sort array in Ascending
                    case 2: {
                        am.sortAscending();// sort in Ascending
                    }
                    break;
                    //Sort array in Descending
                    case 3: {
                        am.sortDescending();// sort in Descending
                    }
                    break;
                    case 4: { //kết thức chương trình
                        break;
                    }
                    default: {
                        System.out.println("Please enter form 1 to 4!");//if optopn không phải là 1 đến 4
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter form 1 to 4!");//if optopn không phải là số nguyên
            }
        } while (op != 4);// điều kiện thực hiện lập
    }
}
