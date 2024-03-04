/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p00014_doanthanhphuc_ce170580;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Doan Thanh Phuc - CE170580
 */
public class UserMangament {

    private int numberofUser = 0;//Number of account

    User us = new User();//khai báo đối tượng User

    Scanner am = new Scanner(System.in);

    ArrayList<User> user = new ArrayList<>();//Khái báo một arraylist để lưu account

    /**
     * Reads user information from a file
     *
     * It reads data from the "User.txt" file using a Scanner. The first line of
     * the file contains the number of users in the file. For each user, it
     * reads the username and password from consecutive lines and creates a new
     * User object. The User object is then added to the user list. If an
     * exception occurs during the process, it prints an error message.
     */
    public void readFile() {
        File in = new File("User.txt");  // Create a File object to represent the "User.txt" file
        try {
            Scanner sc = new Scanner(in);  // Create a Scanner to read data from the file
            numberofUser = Integer.parseInt(sc.nextLine());  // Read the number of users from the first line
            for (int i = 0; i < numberofUser; i++) {
                String userName = sc.nextLine();  // Read the username from the next line
                String passWord = sc.nextLine();  // Read the password from the next line
                user.add(new User(userName, passWord));  // Create a new User object and add it to the user list
            }
        } catch (Exception e) {
            System.out.println("Error!");  // Print an error message if an exception occurs
        }
    }

    /**
     * Writes the user list to a file.
     *
     * It creates a FileWriter to write data to the "User.txt" file. It writes
     * the number of users in the user list as the first line of the file. Then,
     * for each user in the user list, it writes the username and password on
     * separate lines. Finally, it closes the FileWriter. If an exception occurs
     * during the process, it prints an error message.
     */
    public void writeFile() {
        try {
            FileWriter out = new FileWriter("User.txt");  // Create a FileWriter to write data to "User.txt"
            out.write(user.size() + "\r\n");  // Write the number of users as the first line
            for (User u : user) {
                out.write(u.getUserName() + "\r\n");  // Write the username on a separate line
                out.write(u.getPassword() + "\r\n");  // Write the password on a separate line
            }
            out.close();  // Close the FileWriter
        } catch (Exception e) {
            System.out.println("Error!");  // Print an error message if an exception occurs
        }
    }

    /**
     * Adds a new user to the user list. Prompts the user to input data for the
     * new user. Displays a success message after creating the account.
     */
    public void enterUser() {
        User newUs = new User();//Tạo đối tượng user mới 
        newUs.inputData();//nhập dữ liệu account
        user.add(newUs);//thêm account mới
        numberofUser += user.size() - numberofUser;//cập nhập số lượng user
        System.out.println("Create account successful!");
    }

    /**
     * Check login account
     *
     * Checks the user's credentials against the existing user list. Prompts the
     * user to input their credentials. Displays a success message if the
     * credentials are valid, otherwise displays an error message. Displays a
     * message if no accounts have been created yet.
     */
    public void checkAcc() {
        //Tạo 2 Set để lưu trữ tên và password có sẵn trong ArrayList
        Set<String> checkName = new HashSet<>();
        Set<String> checkPass = new HashSet<>();
        for (User u : user) {//duyệt qua ArrayList để lấy dữ liệu 
            checkName.add(u.getUserName());
            checkPass.add(u.getPassword());
        }
        us.inputData();//Đăng nhập account
        if (checkName.contains(us.getUserName()) && checkPass.contains(us.getPassword())) {//Nếu tên đăng nhập và password có tồn tại
            System.out.println("Login successful!");
        } else {
            System.out.println("Username or password is wrong");
        }
    }

    /**
     * Program implementation
     *
     * The runProgram() method executes the main program loop, displaying a menu
     * for the user to choose from. It reads user information from a file,
     * prompts the user for input, and performs the corresponding actions based
     * on their choice. The loop continues until the user chooses to exit the
     * program.
     */
    public void runProgram() {
        readFile(); // Read user information from a file
        int op = 0; // Initialize the user's choice variable

        do {
            // Display the menu options
            System.out.println("====== USER MANAGEMENT SYSTEM ======");
            System.out.println("1. Create a new account");
            System.out.println("2. Login system");
            System.out.println("3. Exit");
            System.out.print("> Choose: ");

            try {
                op = Integer.parseInt(am.nextLine()); // Read the user's choice

                // Perform actions based on the user's choice
                switch (op) {
                    case 1:
                        enterUser(); // Create a new account
                        break;
                    case 2:
                        checkAcc(); // Login system
                        break;
                    case 3:
                        writeFile(); // Exit and save user information to a file
                        break;
                    default:
                        System.out.println("Enter form 1 to 3"); // Display an error message for invalid choices
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter an integer number!"); // Display an error message for non-integer input
            }
        } while (op != 3); // Continue the loop until the user chooses to exit
    }

}
