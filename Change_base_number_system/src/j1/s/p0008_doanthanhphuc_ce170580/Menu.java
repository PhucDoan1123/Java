package j1.s.p0008_doanthanhphuc_ce170580;

import java.util.Scanner;

/**
 *
 * @author Acer
 */
public class Menu {

    Scanner sc = new Scanner(System.in);//Nhập dữ liệu từ bàn phím
    CoverNumberProgram bs = new CoverNumberProgram();//Khai báo đối tượng BaseProgram

    /**
     * Let execute the program according to user requirements
     *
     * declare an op variable for the user to make selections, use do-while to
     * execute the program until the user wants to stop the program, print the
     * selection menu every time the loop is executed, try-catch catches the
     * user's input error must be an integer, swith - case to execute the
     * program according to the user's choice
     *
     * Choose 4 to exit program
     */
    public void baseNumberProgram() {
        int op = 0;// khai báo biến op để người dùng nhập lựa chọn

        //vòng lập để thực hiện chương trình đến khi người dùng muôn thoát
        do {
            //print menu những option cho người dùng chọn để đổi cơ số
            System.out.println("----- BASE NUMBER PROGRAM -----");// in menu sau mỗi lần lập
            System.out.println("1.Binary");
            System.out.println("2.Decimal");
            System.out.println("3.Hexadecimal");
            System.out.println("4.Exit");
            System.out.print("Enter your choice: ");
            try {// bắt lỗi op nếu không phải là số nguyên
                op = Integer.parseInt(sc.nextLine());// nhập lựa chọn từ bàn phím

                //thực hiện chương trình theo lựa chọn người dùng
                switch (op) {
                    case 1: {//Nếu người dùng muốn đổi cơ số binary sang cơ số khác
                        bs.binaryBase();
                        break;
                    }
                    case 2: {//Nếu người dùng muốn đổi cơ số dicemal sang cơ số khác
                        bs.decimalBase();
                        break;
                    }
                    case 3: {//Nếu người dùng muốn đổi cơ số hexdicemal sang cơ số khác
                        bs.hexbase();
                        break;
                    }
                    case 4: {// nếu người dùng muốn thoát chương trình
                        break;
                    }
                    default: {// nếu lựa chọn không phải là 1,2,3 or 4
                        System.out.println("Please enter from 1 to 4!");// print thông báo khi nhập sai
                        break;
                    }
                }
            } catch (NumberFormatException e) {//Bắt ngoại lệ
                System.out.println("Please enter integer number!");// print thông báo khi có ngoại lệ
            }
        } while (op != 4);// điều kiện thực hiện vòng lập

    }

}
