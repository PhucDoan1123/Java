package J1.S.P00013_DoanThanhPhuc_CE170580;

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

    ManagementWorker am = new ManagementWorker();//Khai báo đổi tượng ManagementWorker

    Scanner sc = new Scanner(System.in);//Nhập dư liệu từ bản phím

    //Thực hiện chương trình
    public void runProgram() {
        int op = 0;//Khái báo op để nhập lựa chọn 

        am.readFile();//Đọc file

        //Vòng lặp duy trì và hiển thị menu
        while (op != 5) {
            System.out.println("============ Worker Management ============");
            System.out.println("   1. Add Worker");
            System.out.println("   2. Up Salary");
            System.out.println("   3. Down Salary");
            System.out.println("   4. Display Information salary");
            System.out.println("   5. Exit");
            System.out.print("Enter your option: ");
            try {//Bắt ngoại lệ không phải là số nguyê
                op = Integer.parseInt(sc.nextLine());
                //Xử lí các tùy chọn
                switch (op) {
                    case 1: //add new worker
                        System.out.println("--------- Add Worker ---------");
                        //call addWorker
                        am.addWorker();
                        break;
                    case 2://increase worker salary
                        //call increaseSalary()
                        am.inSalary();
                        break;
                    case 3: //decrease worker salary
                        //call decreaseSalary()
                        am.deSalary();
                        break;
                    case 4: //display salary history
                        //call showSalary()
                        am.showSalary();
                        break;
                    case 5: //End the program
                        System.out.println("Thank for using program!");
                        am.writeFile();
                        break;
                    default://Nếu lựa chọn không hợp lệ
                        System.out.println("Please input integer from 1-5!");
                }
            } catch (NumberFormatException e) {//nếu không phải số nguyên
                System.out.println("Please input integer from 1-5!");
            }
        }
    }
}
