
import java.util.ArrayList;
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
public class StudentManament {

    ArrayList<Student> std = new ArrayList<>();//Khai báo ArrayList lưu dữ liệu student

    Scanner sc = new Scanner(System.in);//Nhập dữ liệu từ bàn phím

    Validation ck = new Validation();//Kiểm tra dữ liệu nhập vào

    /**
     * Input information of student * This method is used to input student data.
     * It prompts the user to enter data for each student, including their name,
     * class, and marks. It creates a new Student object, calls the inputData()
     * method of the Student class to input data for the student, and adds the
     * student to the std list. The method continues to prompt for input until
     * the user chooses to stop entering data. Note: The checkYN() method of the
     * ck object is used to check if the user wants to continue entering data
     * (returns true) or not (returns false).
     */
    public void inputStd() {
        System.out.println("====== Management Student Program ======");
        do {
            Student s = new Student();//Khai báo một đối tượng student mới
            s.inputData();//nhập dữ liệu
            std.add(s);//thêm student mới
        } while (ck.checkYN());//Lập đến khi người dùng chọn Y/y or N/n
    }

    /**
     * Print data student
     *
     * This method is used to print the student data. It iterates through the
     * std list and prints the information of each student. The information
     * includes the student number, followed by the student's details obtained
     * from the disPlay() method of the Student class.
     */
    public void printData() {
        System.out.println("");
        int no = 0;//thứ tự học sinh
        for (Student st : std) {//Duyệt qua từng phần tử để lấy dữ liệu
            no++;//cập nhật thứ tự học sinh
            System.out.println("------ Student" + no + " Info ------");
            st.disPlay();//in thông tin sinh viên
        }
    }

    /**
     * Calculate the percentage of students
     *
     * This method is used to evaluate the performance of the students. It
     * calculates the number of students in each performance category (A, B, C,
     * D) based on their average marks. It then calculates the ratio of students
     * in each category as a percentage. Finally, it displays the classification
     * information, including the percentage of students in each category.
     */
    public void evaluateSt() {
        int totalStu = std.size();//tổng số học sinh
        //Số lượng sinh viên của mỗi type of marks
        int Astudent = 0;
        int Bstudent = 0;
        int Cstudent = 0;
        int Dstudent = 0;

        for (Student stu : std) {
            stu.avgMark();//tính điểm trung bình mỗi học sinh
            if (stu.avgMark() > 7.5) {//Sinh viên loại A
                Astudent++;
            } else if (stu.avgMark() >= 6 && stu.avgMark() <= 7.5) {//Sinh viên loại B
                Bstudent++;
            } else if (stu.avgMark() >= 4 && stu.avgMark() < 6) {//Sinh viên loại C
                Cstudent++;
            } else {//Sinh viên loại D
                Dstudent++;
            }
        }

        //Tính tỷ lệ học sinh của các type of marks
        double ratioA = (double) Astudent / totalStu * 100;
        double ratioB = (double) Bstudent / totalStu * 100;
        double ratioC = (double) Cstudent / totalStu * 100;
        double ratioD = (double) Dstudent / totalStu * 100;

        //Print kết quả
        System.out.println("--------Classification Info -----");
        System.out.printf("A: %.1f%%\n", ratioA);
        System.out.printf("B: %.1f%%\n", ratioB);
        System.out.printf("C: %.1f%%\n", ratioC);
        System.out.printf("D: %.1f%%\n", ratioD);
    }

    /**
     * Run program
     *
     * This method is used to run the program. It calls the inputStd() method to
     * input student data, then calls the printData() method to print the
     * student information, and finally calls the evaluateSt() method to
     * evaluate and display the classification information.
     */
    public void runProgam() {
        inputStd();//input information
        printData();//print information of student
        evaluateSt();//Calculate the percentage of students
    }

}
