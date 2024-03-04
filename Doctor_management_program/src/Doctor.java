
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
public class Doctor {

    private String Code;//code of doctor
    private String Name;//name of doctor
    private String Specialization;//Specialization of doctor
    private int Availability;//Availability of doctor
    Scanner sc = new Scanner(System.in);//Nhập dữ liệu từ bàn phím
    Validation ck = new Validation();//Khái báo đối tượng kiểm tra dữ liệu

    /**
     * Default constructor for the Doctor class.
     */
    public Doctor() {
    }

    /**
     * Parameterized constructor for the Doctor class. Initializes the Doctor
     * object with the provided values for code, name, specialization, and
     * availability.
     *
     * @param Code the code of the doctor
     * @param Name the name of the doctor
     * @param Specialization the specialization of the doctor
     * @param Availability the availability of the doctor
     */
    public Doctor(String Code, String Name, String Specialization, int Availability) {
        this.Code = Code;
        this.Name = Name;
        this.Specialization = Specialization;
        this.Availability = Availability;
    }

    /**
     * Getter method for retrieving the code of the doctor.
     *
     * @return the code of the doctor
     */
    public String getCode() {
        return Code;
    }

    /**
     * Setter method for setting the code of the doctor.
     *
     * @param Code the code of the doctor
     */
    public void setCode(String Code) {
        this.Code = Code;
    }

    /**
     * Getter method for retrieving the name of the doctor.
     *
     * @return the name of the doctor
     */
    public String getName() {
        return Name;
    }

    /**
     * Setter method for setting the name of the doctor.
     *
     * @param Name the name of the doctor
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * Getter method for retrieving the specialization of the doctor.
     *
     * @return the specialization of the doctor
     */
    public String getSpecialization() {
        return Specialization;
    }

    /**
     * Setter method for setting the specialization of the doctor.
     *
     * @param Specialization the specialization of the doctor
     */
    public void setSpecialization(String Specialization) {
        this.Specialization = Specialization;
    }

    /**
     * Getter method for retrieving the availability of the doctor.
     *
     * @return the availability of the doctor
     */
    public int getAvailability() {
        return Availability;
    }

    /**
     * Setter method for setting the availability of the doctor.
     *
     * @param Availability the availability of the doctor
     */
    public void setAvailability(int Availability) {
        this.Availability = Availability;
    }

    /**
     * input doctor code
     *
     * Prompts the user to input the doctor's code and returns the entered
     * value. The input is validated using a checkID() method to check if the
     * code is valid or not, it will be re-entered
     *
     */
    public void inputDocCode() {
        boolean check = true;//kiểm tra dữ liệu
        do {
            System.out.print("Enter doctor's code: ");
            Code = sc.nextLine().trim().replaceAll("\\s+", " ");//nhập và cắt khoảng trắng dư thừa
            if (ck.checkID(Code) == false) {//nếu dữ liệu không hợp lệ
                check = true;
            } else {
                check = false;
            }
        } while (check);
    }

    /**
     * Input doctor's data
     *
     * This function allows the user to enter the doctor's name, specialty, and
     * availability. When entering, it will catch errors that the user enters
     * incorrectly and let the user enter again until correct data is entered.
     *
     */
    public void inputData() {
        boolean check1 = true; // Flag to check validity of name input
        boolean check2 = true; // Flag to check validity of specialization input
        boolean check3 = true; // Flag to check validity of availability input

        do {
            System.out.print("Enter doctor's name: ");
            Name = sc.nextLine().trim().replaceAll("\\s+", " "); // Remove extra whitespaces

            if (ck.enterData(Name) == false) { // Check if the input data is valid using the ck.enterData() method
                check1 = true;
            } else {
                check1 = false;
            }
        } while (check1); // Continue looping until a valid name is entered

        do {
            System.out.print("Enter doctor's specialization: ");
            Specialization = sc.nextLine().trim().replaceAll("\\s+", " "); // Remove extra whitespaces

            if (ck.enterData(Specialization) == false) { // Check if the input data is valid using the ck.enterData() method
                check2 = true;
            } else {
                check2 = false;
            }
        } while (check2); // Continue looping until a valid specialization is entered

        do {
            System.out.print("Enter doctor's availability: ");
            try {
                Availability = Integer.parseInt(sc.nextLine()); // Parse input as an integer

                if (Availability < 1) { // Check if the availability is less than 1
                    System.out.println("Availability cannot be less than 1!");
                } else {
                    check3 = false;
                }
            } catch (NumberFormatException e) { // Handle non-integer input
                System.out.println("Please enter a positive integer!");
            }
        } while (check3); // Continue looping until a valid availability is entered
    }

    /**
     * Updating data
     *
     * This function allows the user to update the information of an object,
     * including name, major and availability. It performs input check for each
     * field to ensure updated data is valid.
     *
     */
    public void updateData() {
        boolean check1 = true; // Cờ kiểm tra tính hợp lệ của tên
        boolean check2 = true; // Cờ kiểm tra tính hợp lệ của chuyên ngành
        boolean check3 = true; // Cờ kiểm tra tính hợp lệ của tính sẵn có

        // Cập nhật tên
        do {
            System.out.print("Enter doctor's name: ");
            String input = sc.nextLine().trim().replaceAll("\\s+", " "); // Loại bỏ khoảng trắng dư thừa

            if (!input.isEmpty()) { // Nếu tên không rỗng
                if (ck.enterData(input)) { // Kiểm tra xem dữ liệu nhập vào có hợp lệ hay không 
                    setName(input); // Cập nhật dữ liệu tên
                    check1 = false;
                } else { // Nếu dữ liệu không hợp lệ
                    check1 = true;
                }
            } else { // Nếu không muốn thay đổi tên
                check1 = false;
            }
        } while (check1); // Tiếp tục lặp cho đến khi check1 là false (dữ liệu tên không hợp lệ được nhập)

        // Cập nhật chuyên ngành
        do {
            System.out.print("Enter doctor's specialization: ");
            String input = sc.nextLine().trim().replaceAll("\\s+", " "); // Nhập và loại bỏ khoảng trắng dư thừa

            if (!input.isEmpty()) { // Nếu muốn thay đổi dữ liệu
                if (ck.enterData(input)) { // Kiểm tra xem dữ liệu nhập vào có hợp lệ hay không 
                    setSpecialization(input); // Cập nhật lại dữ liệu
                    check2 = false;
                } else {
                    check2 = true;
                }
            } else { // Nếu không muốn thay đổi dữ liệu
                check2 = false;
            }
        } while (check2); // Tiếp tục lặp cho đến khi check2 là false (dữ liệu chuyên ngành không hợp lệ được nhập)

        // Cập nhật tính sẵn có
        Integer availability = null; // Tính sẵn có cần cập nhật
        String checkAvai; // Kiểm tra tính sẵn có nhập vào
        do {
            System.out.print("Enter doctor's availability: ");
            checkAvai = sc.nextLine().trim().replaceAll("\\s+", " "); // Nhập và loại bỏ khoảng trắng dư thừa

            if (checkAvai.isEmpty()) { // Nếu không muốn cập nhật dữ liệu
                check3 = false;
            } else {
                try {
                    availability = Integer.parseInt(checkAvai); // Chuyển đổi thành số nguyên

                    if (availability < 1) { // Nếu nhỏ hơn 1
                        System.out.println("Availability cannot be less than 1!");
                    } else {
                        setAvailability(availability); // Cập nhật dữ liệu
                        check3 = false;
                    }
                } catch (NumberFormatException e) { // Nếu không phải là số nguyên
                    System.out.println("Please enter a positive integer!");
                    check3 = true;
                }
            }
        } while (check3); // Vòng lặp bắt nhập lại dữ liệu nếu nhập sai
    }

    /**
     * Displays the doctor's information by printing the code, name,
     * specialization, and availability.
     */
    public void disPlay() {
        //in thông tin bác sĩ theo format 
        System.out.printf("|%-6s|%-16s|%-16s|%-14d|\n", Code, Name, Specialization, Availability);
    }

}
