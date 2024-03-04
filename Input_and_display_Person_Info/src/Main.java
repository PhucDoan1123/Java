
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Doan Thanh Phuc - CE170580
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<PersonInfor> per = new ArrayList<>();//Array lưu dữ liệu
        
        System.out.println("=====Management Person programer=====");
        for (int i = 0; i < 3; i++) {//chỉ nhập dữ liệu cho 3 người
            PersonInfor bm = new PersonInfor();//Khai báo một đối tượng PersonInfor mới để input data
            bm.inputData();//nhập dữ liệu cho new person
            per.add(bm); // Thêm đối tượng bm vào danh sách per
        }
        //sort information by Salary
        for (int i = 0; i < per.size(); i++) {
            // Vòng lặp bên ngoài để duyệt qua từng phần tử trong danh sách per
            for (int j = i + 1; j < per.size(); j++) {
                // Vòng lặp bên trong để so sánh phần tử hiện tại (i) với các phần tử còn lại (j) trong danh sách per
                if (per.get(i).getSalary() > per.get(j).getSalary()) {
                    // Kiểm tra mức lương của phần tử i có lớn hơn mức lương của phần tử j hay không
                    PersonInfor b = per.get(i);
                    per.set(i, per.get(j));
                    // Gán phần tử j vào vị trí của phần tử i trong danh sách per
                    per.set(j, b);
                    // Gán giá trị của biến tạm b vào vị trí của phần tử j trong danh sách per
                }
            }
        }
        //display information
        for (PersonInfor p : per) {//duyệt qua ArrayList per để lấy dữ liệu
            p.disPlay();//in thông tin person
        }
    }

}
