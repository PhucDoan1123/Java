package J1.S.P00013_DoanThanhPhuc_CE170580;

import java.io.File;
import java.io.FileWriter;
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
public class ManagementWorker {

    private int numberOfWorker;//Số lượng worker 

    ArrayList<Worker> worker = new ArrayList<>();//Lưu danh sách worker

    ArrayList<SalaryHistory> salary = new ArrayList<>();//Lưu lịch sử thay đổi lương

    Validation ck = new Validation();//Đối tượng để check dữ liệu

    Scanner sc = new Scanner(System.in);//Nhập dữ liệu từ bàn phím

    SalaryHistory s = new SalaryHistory();//Khai báo đối tượn SalaryHistory

    /**
     * This is a no-argument constructor of the "ManagementWorker" class. It
     * does not contain any specific code in its body.
     */
    public ManagementWorker() {
    }

    /**
     * This is a constructor of the "ManagementWorker" class with an integer
     * parameter "numberOfWorker". It sets the value of the "numberOfWorker"
     * variable to 0 using the "this" keyword.
     *
     * @param numberOfWorker the number of workers
     */
    public ManagementWorker(int numberOfWorker) {
        this.numberOfWorker = 0;
    }

    /**
     * Read data of worker
     *
     * This method reads data from the "Worker.txt" file and creates Worker
     * objects based on the read data. It prints a message indicating the
     * presence of the data file and the loading process. If any error occurs
     * during the file reading, it prints an error message. Finally, it prints a
     * message indicating the completion of the process along with the number of
     * workers read.
     */
    public void readFile() {
        File input = new File("Worker.txt");//Tạo đối tượng file với tên file là Worker.txt
        System.out.println("The data file worker.txt is found."
                + " Data of worker is loading...");//in ra thông báo là đang thwucj hiện đọc file
        try {//Bắt ngoại lệ nếu trong quá trình đọc file có vấn đề
            Scanner in = new Scanner(input);//Nhập dữ liệu vào file
            numberOfWorker = Integer.parseInt(in.nextLine());//đọc số lượng của worker
            for (int i = 0; i < numberOfWorker; i++) {//Duyệt qua từng phần tử để lấy dữ liệu ra
                //Lấy thông tin của từng worker có trong file
                String ID = in.nextLine();
                String name = in.nextLine();
                int age = Integer.parseInt(in.nextLine());
                double salary = Double.parseDouble(in.nextLine());
                String worklocation = in.nextLine();
                worker.add(new Worker(ID, name, age, salary, worklocation));//đưa vào Array worker
            }
        } catch (Exception e) {//Nếu có ngoại lệ
            System.out.println("Error!");
        }
        System.out.println("Done! [" + this.numberOfWorker + " workers]");//thông báo số lượng worker hiện có

    }

    /**
     * Write information of worker
     *
     * This method writes the data of the workers to the "worker.txt" file. It
     * creates a FileWriter object to write data to the file. It writes the
     * number of workers in the "worker" list as the first line in the file.
     * Then, for each Worker object in the "worker" list, it writes the ID,
     * name, age, salary, and work location on separate lines in the file. After
     * writing the data, it closes the FileWriter. If any error occurs during
     * the file writing, it prints an error message. Finally, it prints a
     * message indicating the completion of the process along with the number of
     * workers.
     */
    public void writeFile() {

        try {//bắt ngoại lệ nếu có vấn đề gì xảy ra trong quá trình đọc file
            FileWriter out = new FileWriter("worker.txt");//Khái báo đối tượng FileWriter để ghi dự liệu vào file
            out.write(numberOfWorker + "\r\n");//Ghi số lượng worker hiện có
            for (Worker wo : worker) {//Lập và từ worker có trong Array để lấy dữ liệu
                //Ghi thông tin của từng Worker vào file
                out.write(wo.getID() + "\r\n");
                out.write(wo.getName() + "\r\n");
                out.write(wo.getAge() + "\r\n");
                out.write(wo.getSalary() + "\r\n");
                out.write(wo.getWorklocation() + "\r\n");
            }
            out.close();//Đóng quá trình ghi file
        } catch (Exception e) {//Bắt ngoại lệ và in thông báo
            System.out.println("Error!");
        }
        System.out.println("Done! [" + this.numberOfWorker + " workers]");//in số lượng worker hiện có
    }

    /**
     * Add number of worker
     *
     * This method allows the user to add a new worker to the existing list of
     * workers. It prompts the user to enter the ID, name, age, salary, and
     * location of the worker. It performs input validation to ensure the
     * entered values are valid. It checks for the uniqueness of the worker's ID
     * and prevents duplicate entries. The method updates the list of workers
     * with the newly added worker and updates the count of workers. It also
     * displays the updated list of workers after adding the new worker.
     */
    public void addWorker() {
        showWorker();//in danh sách worker hiện có
        Worker newW = new Worker();
        boolean checkID = true;//kiểm tra dữ liệu

        Set<String> idSet = new HashSet<>();//Đưa vào HashSet để kiểm tra dữ liệu
        for (Worker w : worker) {//thêm tên vào của worker vào set
            idSet.add(w.getID().toLowerCase());
        }
        do {
            newW.inputID();//Nhập ID mới
            if (idSet.contains(newW.getID().toLowerCase())) {//Nếu ID tồn tại
                System.out.println("This ID already exists!");
                checkID = false;
            } else {
                checkID = true;//nếu ID không tồn tại
            }
        } while (!checkID);
        //Nhập tên , tuổi , lương và vị trí làm việc
        newW.inputData();
        worker.add(newW);//Thêm thông tin của bác sĩ mưới vào list
        numberOfWorker += worker.size() - numberOfWorker;//cập nhập lại số lượng worker
        System.out.println("Worker is created!");
        showWorker();//in thông tin sau khi thêm worker
    }

    /**
     * Displays the list of workers.
     *
     * Checks and displays the information of workers in the list. If the list
     * is empty, it prints "Database is empty!". If the list is not empty, it
     * displays the data columns and information of each worker.
     */
    public void showWorker() {
        //Nếu size của list bang 0
        if (numberOfWorker == 0) {
            System.out.println("Database is empty!");
        } else {//Nếu size lớn hơn 0
            //Tạo bản chưa thông tin worker
            System.out.println("######## LIST OF WORKERS ########");
            System.out.println("+--------+-------------------+------------+-------------+-------------+");
            System.out.println("| ID     |      Name         | Age        | Salary      |Work Location|");
            System.out.println("+--------+-------------------+------------+-------------+-------------+");
            //Vòng lặp đi qua từng công nhân trong list
            for (int i = 0; i < worker.size(); i++) {
                Worker o = worker.get(i);
                o.display();//in thông tin khác hàng
            }
            System.out.println("+--------+-------------------+------------+-------------+-------------+");
        }

    }

    /**
     * Increase salary of worker
     *
     * Increases the salary of a worker. Requests the worker's ID and the amount
     * to increase the salary. If the ID is valid and exists in the worker list,
     * it increases the salary and displays the worker list. If the ID is
     * invalid or does not exist in the list, it prints "This ID is not exit!".
     */
    public void inSalary() {
        showWorker();
        //Khai báo một set để thực hiện kiểm tra ID
        Set<String> idSet = new HashSet<>();
        for (Worker w : worker) {//Duyệt qua tựng phần tử của Array
            idSet.add(w.getID().toLowerCase());//thêm ID vào Array
        }
        s.inputID();//Nhập ID đề xóa
        if (idSet.contains(s.getID().toLowerCase())) {//Nếu ID có trong Array
            for (Worker w : worker) {//Duyệt qua từng phần tử của Array
                if (w.getID().equalsIgnoreCase(s.getID())) {//Lấy ID được nhập 
                    s.updateSa();//Nhập số tiền tăng
                    Worker worker = w;//Lấy dữ liệu worker được thay đổi
                    double newSalary = worker.getSalary() + s.getUpdatesalary();//số lương sau khi thay đổi
                    worker.setSalary(newSalary);//cập nhập số lương
                    //Thêm thông dữ liệu worker được thay đổi lương
                    salary.add(new SalaryHistory(worker.getID(), worker.getName(),//Thêm lịch sử update Salary
                            worker.getAge(), worker.getSalary(), "Up", java.time.LocalDate.now()));
                    System.out.println("---- Salary Updated Successfully ----");
                    showWorker();//in ra số list of worker
                }
            }
        } else {//Nếu không có ID trong Array
            System.out.println("This id is not exit!");
        }
    }

    /**
     * Decrease salary of worker
     *
     * Decreases the salary of a worker. Requests the worker's ID and the amount
     * to decrease the salary. If the ID is valid and exists in the worker list,
     * it decreases the salary and displays the worker list. If the ID is
     * invalid or does not exist in the list, it prints "This ID is not exit!".
     */
    public void deSalary() {
        showWorker();
        boolean check = true;
        //Khai báo một set để thực hiện kiểm tra ID
        Set<String> idSet = new HashSet<>();
        for (Worker w : worker) {//Duyệt qua tựng phần tử của Array
            idSet.add(w.getID().toLowerCase());//thêm ID vào Array
        }
        s.inputID();//Nhập ID đề tìm worker cần xóa
        if (idSet.contains(s.getID().toLowerCase())) {//Nếu ID có trong Array
            for (Worker w : worker) {//Duyệt qua từng phần tử của Array
                if (w.getID().equalsIgnoreCase(s.getID())) {//Lấy ID được nhập 
                    do {
                        s.updateSa();//nhập số lương cần giảm
                        if (w.getSalary() < s.getUpdatesalary()) {//Nếu số tiền cần giảm lớn hơn số tiền hiện tại
                            System.out.println("The reduced amount cannot"
                                    + " be greater than the current amount");
                        } else {
                            check = false;
                        }
                    } while (check);//điều kiện thực hiện vòng lập
                    Worker worker = w;//Lấy dữ liệu worker được thay đổi
                    double newSalary = worker.getSalary() - s.getUpdatesalary();//số lương sau khi thay đổi
                    worker.setSalary(newSalary);//cập nhập số lương
                    //Thêm thông dữ liệu worker được thay đổi lương
                    salary.add(new SalaryHistory(worker.getID(), worker.getName(),//Thêm lịch sử update Salary
                            worker.getAge(), worker.getSalary(), "Down", java.time.LocalDate.now()));
                    System.out.println("---- Salary Updated Successfully ----");
                    showWorker();//in ra số list of worker
                }
            }
        } else {//Nếu không có ID trong Array
            System.out.println("This id is not exit!");
        }
    }

    /**
     * Displays the salary information.
     *
     * Checks and displays the salary information of workers in the list. If the
     * salary list is empty, it prints "The list is empty!". If the salary list
     * is not empty, it displays the data columns and information of each salary
     * history.
     */
    public void showSalary() {
        //Nếu size danh sách lịch sử lương bằng 0
        if (salary.size() == 0) {
            System.out.println("The list is empty!");
        } else { //Ngược lại lớn hơn 0
            //Tạo bản đeer in thông tin 
            System.out.println("######## Display Information Salary ########");
            System.out.println("+--------+-------------------+------------+-------------+--------------+------------+");
            System.out.println("| ID     |      Name         | Age        | Salary      |  Status      | Date       |");
            System.out.println("+--------+-------------------+------------+-------------+--------------+------------+");
            //Lặp qua danh sách các mục lịch sử lương
            for (int i = 0; i < salary.size(); i++) {
                SalaryHistory o = salary.get(i);
                o.display();//in thông tin worker được thay đổi
            }
            System.out.println("+--------+-------------------+------------+-------------+--------------+------------+");
        }
    }

}
