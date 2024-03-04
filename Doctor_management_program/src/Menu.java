
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

    Scanner sc = new Scanner(System.in);//Nhập dữ liệu từ bàn phím

    DoctorManagement doc = new DoctorManagement();//Khai báo đối tượng DoctorManagement

    /**
     * Runs the doctor management program.
     *
     * Displays a menu of options to the user and performs the corresponding
     * actions based on the chosen option. Options include adding a doctor,
     * updating a doctor, deleting a doctor, searching for a doctor, and exiting
     * the program.
     *
     * The program keeps running until the user chooses to exit.
     */
    public void runProgram() {
        doc.readFile();//thực hiện đọc file
        int op = 0;//khái báo lựa chọn
        do {
            //menu của chương trình
            System.out.println("======= DOCTOR MANAGEMENT =======");
            System.out.println("1. Add Doctor.");
            System.out.println("2. Update Doctor.");
            System.out.println("3. Delete Doctor.");
            System.out.println("4. Search Doctor.");
            System.out.println("5. Exit.");
            System.out.print("Enter your option: ");
            try {
                op = Integer.parseInt(sc.nextLine());//chuyển sang số nguyên
                switch (op) {//trả lại trường hợp theo lựa chọn người dùng
                    case 1: {//nếu muốn thêm dữ liệu
                        doc.inputData();
                        break;
                    }
                    case 2: {//nếu muốn cập nhâp doctor
                        doc.updateDoc();
                        break;
                    }
                    case 3: {//nếu muốn xóa doctor
                        doc.deleteDoc();
                        break;
                    }
                    case 4: {//nếu muốn tìm doctor
                        doc.searchDoc();
                        break;
                    }
                    case 5: {//nếu muốn thoát chương trình
                        doc.writeFile();//ghi dữ liệu vào file
                        break;
                    }
                    default: {//nếu lựa không nằm trong menu
                        System.out.println("Enter from 1 to 5!");
                    }
                }
            } catch (NumberFormatException e) {//nếu lựa chọn không phải số nguyên
                System.out.println("Please enter an integer!");
            }
        } while (op != 5);//điều kiện thực hiện chương trình
        System.out.println("Thank you for using the program!");
    }

}
