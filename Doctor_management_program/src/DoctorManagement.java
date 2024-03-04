
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Doan Thanh Phuc - CE170580
 */
public class DoctorManagement {

    private int sizeOfList;//kích cỡ của listDoctor

    ArrayList<Doctor> ListDoctor = new ArrayList<>();//khái báo một Arraylist để lưu dữ liệu

    Scanner sc = new Scanner(System.in);// nhập dữ liệu từ bàn phím

    Validation ck = new Validation();//Đối tượng kiểm tra dữ liệu

    Doctor am = new Doctor();//Khai báo  một đối tượng doctor mới

    /**
     * Constructor for the DoctorManagement class.
     */
    public DoctorManagement() {
    }

    /**
     * Constructor for the DoctorManagement class with a specified size of the
     * list.
     *
     * @param sizeOfList The size of the list of doctors.
     */
    public DoctorManagement(int sizeOfList) {
        this.sizeOfList = sizeOfList;
    }

    /**
     * Read doctor data
     *
     * Reads data from the "Doctor.txt" file and populates the ListDoctor with
     * Doctor objects. It opens the file, reads the data line by line, and
     * creates Doctor objects with the extracted information. The Doctor objects
     * are then added to the ListDoctor. If the file is not found, an error
     * message is displayed.
     */
    public void readFile() {
        File input = new File("Doctor.txt");//Khai báo đối tượng File và trên tên file sẽ đọc
        System.out.println("The data file doctor.txt is found. Data of doctors is loading...");
        try {//bắt lỗi nếu xảy ra trong quá trình đọc file
            Scanner sc = new Scanner(input);//nhập dữ liệu từ file
            sizeOfList = Integer.parseInt(sc.nextLine());//đọc số lượng doctor
            for (int i = 0; i < sizeOfList; i++) {//duyệt qua từng phần tử để đoc dữ liệu từ file
                //lấy từng thông tin của bác sĩ
                String ID = sc.nextLine();
                String Name = sc.nextLine();
                String Specialization = sc.nextLine();
                int Availability = Integer.parseInt(sc.nextLine());

                ListDoctor.add(new Doctor(ID, Name, Specialization, Availability));//đưa vào list
            }
        } catch (FileNotFoundException e) {//Nếu có lỗi xảy ra
            System.out.println("Error!");
        }
    }

    /**
     * Write doctor data
     *
     * Writes data from the ListDoctor to the "Doctor.txt" file. It creates a
     * FileWriter object to write data to the file. It iterates through the
     * ListDoctor and writes the code, name, specialization, and availability of
     * each Doctor to the file. After writing the data, it closes the
     * FileWriter. If an IOException occurs during the write operation, an error
     * message is displayed.
     */
    public void writeFile() {
        try {//bắt những lỗi có thể xảy ra trong qua trình đọc file
            FileWriter wr = new FileWriter("Doctor.txt");//Khai báo đối tượng  FileWriter và truyền tên file sẽ write into
            wr.write(sizeOfList + "\r\n");//write số lượng bác sĩ
            for (Doctor e : ListDoctor) {//duyệt qua từng phần tử trong list dotor để write dữ liệu
                //wrtie code, name, Specialization and getAvailability of doctor
                wr.write(e.getCode() + "\r\n");
                wr.write(e.getName() + "\r\n");
                wr.write(e.getSpecialization() + "\r\n");
                wr.write(e.getAvailability() + "\r\n");
            }
            wr.close();//đóng write file
        } catch (IOException e) {//bắt lỗi nếu có trong qua trình write
            System.out.println("Error!");
        }
    }

    /**
     * Displays the data stored in the ListDoctor.
     *
     * If the sizeOfList is 0, it displays a message indicating that the doctor
     * storage is empty. Otherwise, it prints a formatted table showing the
     * code, name, specialization, and availability of each doctor.
     *
     */
    public void printData() {
        if (sizeOfList == 0) {//nếu list of doctor is emty
            System.out.println("The doctor storage is empty!");
        } else {
            System.out.println("========= LIST OF DOCTOR ==========");
            System.out.println("+------+----------------+----------------+--------------+");
            System.out.println("|Code  |     Name       | Specialization | Availability |");
            System.out.println("+------+----------------+----------------+--------------+");
            for (Doctor doctor : ListDoctor) {//duyệt qua từng phần tử để in ra danh sách doctor
                doctor.disPlay();//in ra danh sách
            }
        }
        System.out.println("+------+----------------+----------------+--------------+");
    }

    /**
     * Search doctor by text in name
     *
     * Searches for doctors whose names contain a specified keyword. It displays
     * the current data using the printData() method. It prompts the user to
     * enter a name keyword to search for. It iterates through the ListDoctor
     * and checks if the name of each doctor contains the keyword
     * (case-insensitive). If a matching doctor is found, it displays a
     * formatted table with the code, name, specialization, and availability. If
     * no matching result is found, it displays a message indicating so.
     */
    public void searchDoc() {
        printData();//in table of doctor
        //input docter text
        String text;
        boolean check = true;//kiểm tra text 
        do {
            System.out.print("Enter text ");
            text = sc.nextLine().trim().replaceAll("\\s+", " ");//cắt khoảng trắng dư thừa
            if (ck.enterData(text) == false) {//nếu dữ liệu không hợp lệ
                check = true;
            } else {
                check = false;
            }
        } while (check);
        System.out.println("######## Result ########");
        System.out.println("+------+----------------+----------------+--------------+");
        System.out.println("|Code  |     Name       | Specialization | Availability |");
        System.out.println("+------+----------------+----------------+--------------+");

        for (int i = 0; i < ListDoctor.size(); i++) {//duyệt qua từng phần tử để kiểm tra và display
            if (ListDoctor.get(i).getName().toUpperCase().contains(text.toUpperCase())) {//tên có chữ text
                ListDoctor.get(i).disPlay();//in ra doctor có tên chứa text
                check = false;//cập nhập lại kiểm tra
            }
        }
        System.out.println("+------+----------------+----------------+--------------+");
        if (check == true) {//nếu không có bác sĩ có tên chứa text
            System.out.println("This code does not exist!");
        }
    }

    /**
     * Updates the information of a doctor.
     *
     * It displays the current data using the printData() method. It prompts the
     * user to enter the code of the doctor to be updated. It iterates through
     * the ListDoctor and checks if the code matches any doctor. If a matching
     * doctor is found, it prompts the user to update the doctor's name,
     * specialization, and availability. After the update, it displays a success
     * message and calls the printData() method to show the updated data. If no
     * matching doctor is found, it displays an error message.
     */
    public void updateDoc() {
        boolean foundDoctor = false;//kiểm tra ID tồn tại
        printData();//in table of doctor list
        System.out.println("--------- Update Doctor -------");
        am.inputDocCode();//Nhập doctor code cần update
        for (Doctor c : ListDoctor) {//Duyệt qua từng phần tử để kiểm tra và update
            if (c.getCode().equalsIgnoreCase(am.getCode())) {//nếu code tồn tại
                //Cận nhập naem, Specialization, Availability
                c.updateData();
                System.out.println("Doctor update successful!");
                foundDoctor = true;//thay đổi kiểm tra ID tồn tại 
                printData();//in table of doctor list after update
                break;
            }
        }
        if (!foundDoctor) {//Nếu code không tồn tại
            System.out.println("This code does not exist!");
        }
    }

    /**
     * Deletes a doctor from the ListDoctor.
     *
     * It displays the current data using the printData() method. It prompts the
     * user to enter the code of the doctor to be deleted. It iterates through
     * the ListDoctor and checks if the code matches any doctor. If a matching
     * doctor is found, it removes the doctor from the ListDoctor, updates the
     * sizeOfList, and displays a success message. After the deletion, it calls
     * the printData() method to show the updated data. If no matching doctor is
     * found, it displays an error message.
     */
    public void deleteDoc() {
        printData();//print table of doctor list
        System.out.println("--------- Delete Doctor -------");
        am.inputDocCode();//Nhập ID bác sĩ cần xóa
        boolean found = false;//kiểm tra ID tồn tại
        for (int i = 0; i < ListDoctor.size(); i++) {//Lập qua list doctor để kiểm tra dữ liệu và xóa
            Doctor d = ListDoctor.get(i);//lấy từng bác sĩ trong list
            if (d.getCode().equalsIgnoreCase(am.getCode())) {//Nếu ID cần xóa tồn tại
                ListDoctor.remove(i);//xóa bác sĩ 
                sizeOfList--;//cập nhập lại số lượng bác sĩ
                found = true;//cập nhập lại kiểm tra tồn tại ID
                System.out.println("Doctor deleted successfully!");
                printData();//print table of doctor list after delete
                break;
            }
        }
        if (!found) {//nếu ID không tồn tại
            System.out.println("This doctor does not exist!");
        }
    }

    /**
     * Adds a new doctor to the ListDoctor.
     *
     * It displays the current data using the printData() method. It creates a
     * new Doctor object. It checks if the entered doctor code already exists in
     * the ListDoctor. If the code already exists, it displays an error message.
     * If the code does not exist, it prompts the user to enter the doctor's
     * name, specialization, and availability. It adds the new doctor to the
     * ListDoctor, updates the sizeOfList, and displays a success message. After
     * adding the new doctor, it calls the printData() method to show the
     * updated data.
     */
    public void inputData() {
        printData();//print table of doctor list
        Doctor e = new Doctor();//Khai báo một dối tượng doctor mới
        boolean check = true;//Kiểm tra id nhập có tồn tại không
        boolean exitDoc = false;//Kiểm tra id có tồn tại không
        Set<String> idSet = new HashSet<>(); // Create a set to store the existing IDs in the ListDoctor
        for (Doctor d : ListDoctor) { // Iterate through each element in the ListDoctor
            idSet.add(d.getCode().toLowerCase()); // Add the ID to the set
        }
        //Kiểm tra ID nhập vào
        do {
            e.inputDocCode();//Nhập ID mới
            if (idSet.contains(e.getCode().toLowerCase())) {//nếu nó đã tồn tại rồi
                System.out.println("This code is already exist!");
                check = true;
            } else {//nếu ID chưa tồn tại
                exitDoc = true;//nhập lại kiểm tra
                check = false;
            }
        } while (check);
        if (exitDoc) {//nếu ID chưa tồn tại
            //input new name , Specialization,Availability
            e.inputData();
            ListDoctor.add(e);//thêm bác sĩ mới
            sizeOfList += ListDoctor.size() - sizeOfList;//cập nhập lại số lượng bác sĩ
            System.out.println("Added new doctor successfully!");
        }
        printData();//print table of doctor list after add new doctor
    }

}
