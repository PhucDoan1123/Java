
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
public class Student {

    private String name;//Name of student
    private String classes;//classe of student
    private double maths;//maths mark of student
    private double chemistry;//chemistry mark of student
    private double physics;//physics mark of student

    Scanner sc = new Scanner(System.in);//Nhập dữ liệu từ bàn phím

    Validation ck = new Validation();//Kiểm tra dữ liệu nhập vào

    /**
     *
     * Empty constructor for the Student class.
     */
    public Student() {
    }

    /**
     *
     * Constructor for the Student class with parameters.
     *
     * @param name The name of the student.
     * @param classes The class of the student.
     * @param maths The marks in Mathematics.
     * @param chemistry The marks in Chemistry.
     * @param physics The marks in Physics.
     */
    public Student(String name, String classes, double maths, double chemistry, double physics) {
        this.name = name;
        this.classes = classes;
        this.maths = maths;
        this.chemistry = chemistry;
        this.physics = physics;
    }

    /**
     *
     * Returns the name of the student.
     *
     * @return The name of the student.
     */
    public String getName() {
        return name;
    }

    /**
     *
     * Sets the name of the student.
     *
     * @param name The name of the student.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * Returns the class of the student.
     *
     * @return The class of the student.
     */
    public String getClasses() {
        return classes;
    }

    /**
     *
     * Sets the class of the student.
     *
     * @param classes The class of the student.
     */
    public void setClasses(String classes) {
        this.classes = classes;
    }

    /**
     *
     * Returns the marks in Mathematics of the student.
     *
     * @return The marks in Mathematics.
     */
    public double getMaths() {
        return maths;
    }

    /**
     *
     * Sets the marks in Mathematics of the student.
     *
     * @param maths The marks in Mathematics.
     */
    public void setMaths(double maths) {
        this.maths = maths;
    }

    /**
     *
     * Returns the marks in Chemistry of the student.
     *
     * @return The marks in Chemistry.
     */
    public double getChemistry() {
        return chemistry;
    }

    /**
     *
     * Sets the marks in Chemistry of the student.
     *
     * @param chemistry The marks in Chemistry.
     */
    public void setChemistry(double chemistry) {
        this.chemistry = chemistry;
    }

    /**
     *
     * Returns the marks in Physics of the student.
     *
     * @return The marks in Physics.
     */
    public double getPhysics() {
        return physics;
    }

    /**
     *
     * Sets the marks in Physics of the student.
     *
     * @param physics The marks in Physics.
     */
    public void setPhysics(double physics) {
        this.physics = physics;
    }

    /**
     * Input data student
     *
     * This method prompts the user to enter data for a student, including their
     * name, class, and marks in Mathematics, Chemistry, and Physics. It
     * performs input validation for each field and follows a step-by-step
     * process. It initializes boolean variables, validates the name and class
     * inputs, and checks the validity of marks entered for each subject. The
     * method continues looping until valid data is provided. Once all input
     * fields are validated and data is stored, the method execution concludes.
     * Note that specific validation checks and error messages may vary, and the
     * assumption is made that certain methods perform the necessary
     * validations.
     *
     */
    public void inputData() {
        boolean check1 = true;//kiểm tra Name
        boolean check2 = true;//Kiểm tra class
        boolean check3 = true;//Kiểm tra maths
        boolean check4 = true;//kiển tra chemistry
        boolean check5 = true;//kiểm tra Physics

        // Enter name
        do {
            System.out.print("Name: ");
            name = sc.nextLine().trim().replaceAll("\\s+", " ");//cắt khoảng trắng dư thừa

            if (ck.enterString(name) == false) {//nếu dữ liệu nhập vào không hợp lệ
                check1 = true;
            } else {
                check1 = false;
            }
        } while (check1);//lập cho đến khi dữ liệu hợp lệ
        //Enter classes
        do {
            System.out.print("Classese: ");
            classes = sc.nextLine().trim().replaceAll("\\s+", " ");//cắt khoảng trắng dư thừa

            if (ck.checkClasses(classes) == false) {//nếu dữ liệu nhập vào không hợp lệ
                check2 = true;
            } else {
                check2 = false;
            }
        } while (check2);//lập cho đến khi dữ liệu hợp lệ

        //Enter maths
        do {
            System.out.print("Maths: ");
            try {
                maths = Double.parseDouble(sc.nextLine());//chuyển sang số nguyên
                if (maths < 0) {//nếu điểm nhỏ hơn 0
                    System.out.println("Maths is greater than equal zero");
                } else if (maths > 10) {//nếu điểm vượt quá 10
                    System.out.println("Maths is less than equal ten");
                } else {
                    check3 = false;
                }
            } catch (NumberFormatException e) {//Nếu nhập vào không phải số nguyên
                System.out.println("Maths is digit");
            }

        } while (check3);

        //Enter chemistry
        do {
            System.out.print("Chemistry: ");
            try {
                chemistry = Double.parseDouble(sc.nextLine());//chuyển sang số thực
                if (chemistry < 0) {//nếu điểm nhỏ hơn 0
                    System.out.println("Chemistry is greater than equal zero");
                } else if (chemistry > 10) {//nếu điểm vượt quá 10
                    System.out.println("Chemistry is less than equal ten");
                } else {
                    check4 = false;
                }
            } catch (NumberFormatException e) {//Nếu số nhập vào không phải số thực
                System.out.println("Chemistry is digit");
            }

        } while (check4);

        //Enter physics
        do {
            System.out.print("Physics: ");
            try {
                physics = Double.parseDouble(sc.nextLine());//chuyển sang số thực
                if (physics < 0) {//nếu điểm nhỏ hơn 0
                    System.out.println("Physics is greater than equal zero");
                } else if (physics > 10) {//nếu điểm vượt quá 10
                    System.out.println("Physics is less than equal ten");
                } else {
                    check5 = false;
                }
            } catch (NumberFormatException e) {//Nếu số nhập vào không phải số thực
                System.out.println("Physics is digit");
            }

        } while (check5);
    }

    /**
     * Calculate average marks
     *
     * This method calculates the average marks of a student. It adds up the
     * marks in Mathematics, Physics, and Chemistry, and divides the sum by 3 to
     * get the average. The average marks are then returned.
     *
     * @return The average marks of the student.
     */
    public double avgMark() {
        double AVG = 0;//Điểm trung bình
        AVG = (maths + physics + chemistry) / 3;//tính điểm trung bình
        return AVG;
    }

    /**
     * Display information
     *
     * This method displays the information of a student. It prints the
     * student's name, class, average marks, and type based on the average
     * marks. The type is determined as follows: - If the average marks are
     * greater than 7.5, the type is A. - If the average marks are between 6 and
     * 7.5 (inclusive), the type is B. - If the average marks are between 4 and
     * 6 (inclusive), the type is C. - Otherwise, the type is D.
     */
    public void disPlay() {
        //In thông tin học sinh
        System.out.println("Name: " + name);
        System.out.println("Classese: " + classes);
        System.out.printf("AVG: %.1f\n", avgMark());
        if (avgMark() > 7.5) {//sinh viên loại A
            System.out.println("Type: A");
        } else if (6 <= avgMark() && avgMark() <= 7.5) {//sinh viên loại B
            System.out.println("Type: B");
        } else if (4 <= avgMark() && avgMark() < 6) {//sinh viên loại C
            System.out.println("Type: C");
        } else {//sinh viên loại D
            System.out.println("Type: D");
        }
    }
}
