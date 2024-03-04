
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Đoàn Thanh Phúc - CE170580
 */
public class Calculate_BMI {

    private double weight;// weight of body
    private double height;// height of body

    Scanner sc = new Scanner(System.in);// Nhập giá trị từ bàn phím

    /**
     * Let calculate BMI number
     *
     * Convert height from centimeters to meters , calculate BMI_number,print
     * out the case message corresponding to BMI.
     */
    public void calculateBMI() {

        double h = height / 100; // Chuyển đổi chiều cao từ cm sang m

        double BMI_number = weight / (h * h); // Tính chỉ số BMI

        System.out.printf("BMI Number: %.2f \n", BMI_number);// print BMI number

        // Trả lại đối tượng tương ứng với điều kiện
        System.out.print("BMI status: ");
        if (BMI_number < 19) {
            System.out.println("UNDER-STANDARD");
        } else if (BMI_number < 25) {
            System.out.println("STANDARD");
        } else if (BMI_number < 30) {
            System.out.println("OVERWEIGHT");
        } else if (BMI_number < 40) {
            System.out.println("FAT");
        } else {
            System.out.println("VERYFAT");
        }
    }

    /**
     * Let input value weight and height
     *
     * Check if the entered height and weight are real numbers or not, perform
     * the calculate BMI function
     *
     * Print BMI status
     */
    public void inputCalculatorB() {
        boolean check1 = true;//check giá trị weight
        boolean check2 = true;//check giá trị height

        //Nhập và kiểm tra giá tị weight nhập vào
        do {
            try {
                System.out.print("Enter Weight(kg): ");
                weight = Double.parseDouble(sc.nextLine());
                check1 = true;
                if (weight < 1) {//if it is out of range
                    System.out.println("Weight must be geater than 0!");
                    check1 = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("BMI is digit");
                check1 = false;
            }
        } while (!check1);// điều kiện bắt người dùng nhập lại

        //Nhập và kiểm tra giá tị height nhập vào
        do {
            try {
                System.out.print("Enter Height(cm): ");
                height = Double.parseDouble(sc.nextLine());
                check2 = true;
                if (height < 1) {//if it is out of range
                    System.out.println("Weight must be geater than 0!");
                    check2 = false;
                }
            } catch (NumberFormatException e) {
                System.out.println("BMI is digit");
                check2 = false;
            }
        } while (!check2);// điều kiện bắt người dùng nhập lại
        calculateBMI();// tính chỉ số BMI và in ra thông báo tương ứng vơi chỉ số
    }
}
