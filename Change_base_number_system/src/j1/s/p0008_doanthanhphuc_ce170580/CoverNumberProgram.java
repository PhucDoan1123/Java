/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0008_doanthanhphuc_ce170580;

import java.util.Scanner;

/**
 *
 * @author Doan Thanh Phuc - CE170580
 */
public class CoverNumberProgram {

    Scanner sc = new Scanner(System.in);// Nhập dữ liệu từ bàn phím
    CoverNumber am = new CoverNumber();// Khai báo đối tượng BaseNumber

    /**
     * Let's convert from binary to other bases
     *
     * Let enter the value from the keyboard and check if it is binary or not,
     * if not, then re-enter it, use try-catch to catch the error sub1 is not an
     * integer, switch - case for selection is user input, do - while for
     * re-entry if sub1 is not 1 or 2.
     *
     * print result number after base.
     *
     */
    public void binaryBase() {
        boolean check1 = true;//kiểm tra giá trị nhập vào có phải là số nguyên hay không
        am.inPutNumber();//Nhập số cần đổi
        while (!am.isBinary()) {// kiểm tra số nhập vào có phải nhị phân hay không
            System.out.println("This is not binary number!");//thông báo lỗi khi nó không phải nhị phân
            am.inPutNumber();//Nhập số cần đổi
        }
        //kiểm tra lựa chọn có phải là số nguyên hay không
        do {
            //In ra menu mỗi khi thực hiện vòng lập
            System.out.println("1.Decimal");// chuyển cơ số sang thập phân
            System.out.println("2.Hexadecimal");//Chuyển cở số sang thập lục phân
            System.out.print("Enter your choice: ");// mời người dùng nhập lựa chọn
            //Bắt ngoại lệ số nhập vào không phải là số nguyên
            try {
                int sub1 = Integer.parseInt(sc.nextLine());// nhập lựa chọn từ bàn phím

                //Thực hiện chuyển cơ số theo lựa chọn của người dùng
                switch (sub1) {
                    //Nếu người dùng muốn chuyển từ nhị phân sang thập phân
                    case 1: {
                        am.binaryToDe();//chuyển cơ số nhị phân sang thập phân
                        System.out.println("Number after cover based : " + am.getBaseNumber());// in kết quả
                        check1 = true;// điều kiện thoát vòng lập
                        break;
                    }
                    //Nếu người dùng muốn chuyển từ nhị phân sang thập nhị phân
                    case 2: {
                        //Chuyển cơ số từ nhị phân sang thập phân trược rồi chuyển thành thập lục phân
                        am.binaryToDe();// chuyển cơ số từ nhị phân sang thập phân
                        am.setInputValue(am.getBaseNumber());// gán kết quả sau khi đổi cho giá trị Inputvalue mới
                        am.decimalToHexadecimal();// chuyển cơ số từ thập phân sang thập lục phân
                        System.out.println("Number after cover based : " + am.getBaseNumber());// in kết quả
                        check1 = true;// điều kiện thoát vòng lập
                        break;
                    }
                    default: {
                        System.out.println("Please enter 1 or 2");//Nếu lựa chọn không phải là 1,2 or 3
                        check1 = false;// cho lập lại vòng lập
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter integer number!");// Nếu lựa chọn không phải là số nguyên
                check1 = false;// cho lập lại vòng lập
            }
        } while (!check1);//điều kiên thoát vòng lập

    }

    /**
     * Let's convert from decimal to other bases
     *
     * Let enter the value from the keyboard and check if it is decimal or not,
     * if not, then re-enter it, use try-catch to catch the error sub2 is not an
     * integer, switch - case for selection is user input, do - while for
     * re-entry if sub3 is not 1 or 2.
     *
     * print result number after base.
     *
     */
    public void decimalBase() {
        boolean check2 = true;//kiểm tra lựa chọn nhập vào có phải là số nguyên hay không
        am.inPutNumber();//Nhập số cần đổi
        while (!am.isDecimal()) {// kiểm tra số nhập vào có phải thập phân hay không
            System.out.println("This is not Decimal number!");//thông báo lỗi khi nó không phải thập phân
            am.inPutNumber();//Nhập số cần đổi
        }
        //kiểm tra lựa chọn có phải là số nguyên hay không
        do {
            //In ra menu mỗi khi thực hiện vòng lập
            System.out.println("1.Binary");//chuyển cơ số sang nhị phân
            System.out.println("2.Hexadecimal");//Chuyển cở số sang thập lục phân
            System.out.print("Enter your choice: ");// mời người dùng nhập lựa chọn
            //Bắt ngoại lệ số nhập vào không phải là số nguyên
            try {
                int sub2 = Integer.parseInt(sc.nextLine());// nhập lựa chọn từ bàn phím

                //Thực hiện chuyển cơ số theo lựa chọn của người dùng
                switch (sub2) {
                    //Nếu người dùng muốn chuyển cơ số từ decimal sang binary
                    case 1: {
                        am.decimalToBinary();//Chuyển cơ số từ decimal sang binary
                        System.out.println("Number after cover based : " + am.getBaseNumber());// in kết quả
                        check2 = true;// điều kiện thoát vòng lập
                        break;
                    }
                    //Nếu người dùng muốn chuyển cơ số từ decimal sang Hexadecimal
                    case 2: {
                        am.decimalToHexadecimal();//chuyển cơ số từ decimal sang Hexadecimal
                        System.out.println("Number after cover based : " + am.getBaseNumber());// in kết quả
                        check2 = true;// điều kiện thoát vòng lập
                        break;
                    }
                    default: {
                        System.out.println("Please enter 1 or 2");//Nếu lựa chọn không phải là 1,2 or 3
                        check2 = false;// cho lập lại vòng lập
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter integer number!");// Nếu lựa chọn không phải là số nguyên
                check2 = false;// cho lập lại vòng lập
            }
        } while (!check2);//điều kiên thoát vòng lập

    }

    /**
     * Let's convert from hexadecimal to other bases
     *
     * Let enter the value from the keyboard and check if it is hexadecimal or
     * not, if not, then re-enter it, use try-catch to catch the error sub3 is
     * not an integer, switch - case for selection is user input, do - while for
     * re-entry if sub3 is not 1 or 2.
     *
     * print result number after base.
     *
     */
    public void hexbase() {
        boolean check3 = true;//kiểm tra lựa chọn nhập vào có phải là số nguyên hay không
        am.inPutNumber();//Nhập số cần đổi
        while (!am.isHexadecimal()) {// kiểm tra số nhập vào có phải thập phân hay không
            System.out.println("This is not Hexadecimal number!");//thông báo lỗi khi nó không phải thập phân
            am.inPutNumber();//Nhập số cần đổi
        }
        //kiểm tra lựa chọn có phải là số nguyên hay không
        do {
            //In ra menu mỗi khi thực hiện vòng lập
            System.out.println("1.Binary");//chuyển cơ số sang nhị phân
            System.out.println("2.Decimal");// chuyển cơ số sang thập phân
            System.out.print("Enter your choice: ");// mời người dùng nhập lựa chọn
            //Bắt ngoại lệ số nhập vào không phải là số nguyên
            try {
                int sub3 = Integer.parseInt(sc.nextLine());// nhập lựa chọn từ bàn phím
                switch (sub3) {
                    //Nếu người dùng muốn đổi từ Hexadecimal sang binary
                    case 1: {
                        //Chuyển Hexadecimal sang decimal, sau đó chuyển từ decimal sang binary
                        am.hexToDe();//Chuyển Hexadecimal sang decimal
                        am.setInputValue(am.getBaseNumber());// gán kết quả sau khi Chuyển Hexadecimal sang decimal vào input mới
                        am.decimalToBinary();//Chuyển từ decimal sang binary
                        System.out.println("Number after cover based : " + am.getBaseNumber());// in kết quả
                        check3 = true;// điều kiện thoát vòng lập
                        break;
                    }
                    //Nếu người dùng muốn đổi từ Hexadecimal sang decimal
                    case 2: {
                        am.hexToDe();//đổi từ Hexadecimal sang decimal
                        System.out.println("Number after cover based : " + am.getBaseNumber());// in kết quả
                        check3 = true;// điều kiện thoát vòng lập
                        break;
                    }
                    default: {
                        System.out.println("Please enter 1 or 2");//Nếu lựa chọn không phải là 1,2 or 3
                        check3 = false;// cho lập lại vòng lập
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter integer number!");// Nếu lựa chọn không phải là số nguyên
                check3 = false;// cho lập lại vòng lập
            }
        } while (!check3);//điều kiên thoát vòng lập
    }

}
