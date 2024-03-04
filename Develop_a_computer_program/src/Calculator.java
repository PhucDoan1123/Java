
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Doan Thanh Phuc - CE180580
 */
public class Calculator {

    Scanner sc = new Scanner(System.in);//Nhập dữ liệu từ bàn phím

    Calculate_BMI bm = new Calculate_BMI();// khai báo đối tượng Calculate_BMI

    Calculator_Normal nl = new Calculator_Normal();// khai báo đối tượng Calculator_Normal

    /**
     * Let user chose option to run program
     *
     * Use a do-while loop to program until the user wants to exit, use
     * switch-case for the user to choose the option to perform, Error message
     * if user enters wrong option
     *
     * Choose 3 to Exit program
     */
    public void calculatorProgram() {
        int op = 0;// Lựa chọn của người dùng

        //Thực hiện chương trình
        do {
            //print menu những option để người dùng lựa chọn phép tính
            System.out.println("========= Calculator Program =========");// print menu mỗi khi lập
            System.out.println("1. Normal Calculator");
            System.out.println("2. BMI Calculator");
            System.out.println("3. Exit");
            System.out.print("Please choice one option: ");

            try {// bắt lỗi người dùng nhập option không phải là số nguyên
                op = Integer.parseInt(sc.nextLine());// enter option
                switch (op) {
                    case 1: {//Normal calculator
                        System.out.println("----- Normal Calculator -----");
                        nl.inputCalculatorN();// thực hiện phép toán Normal calculator
                        break;
                    }
                    case 2: {//Tính chỉ số BMI
                        System.out.println("----- BMI Calculator -----");
                        bm.inputCalculatorB();// thực hiện BMI calculator
                        break;
                    }
                    case 3: {
                        break;// kết thúc chương trình
                    }
                    default: {
                        System.out.println("Enter option from 1 to 3");//if it is not form 1 to 3
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Enter option from 1 to 3");// if it is not an integer
            }
        } while (op != 3);//nếu người dùng chọn option khác 3
    }
}
