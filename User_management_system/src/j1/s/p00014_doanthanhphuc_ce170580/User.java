package j1.s.p00014_doanthanhphuc_ce170580;

import java.util.Scanner;

/**
 * User class represents a user with a username and password.
 */
/**
 *
 * @author Doan Thanh Phuc - CE170580
 */
public class User {

    private String UserName; // Name of user
    private String Password; // Password of user

    Scanner sc = new Scanner(System.in);

    /**
     * Constructs an empty User object.
     */
    public User() {
    }

    /**
     * Constructs a User object with the given username and password.
     *
     * @param UserName the username of the user
     * @param Password the password of the user
     */
    public User(String UserName, String Password) {
        this.UserName = UserName;
        this.Password = Password;
    }

    /**
     * Returns the username of the user.
     *
     * @return the username
     */
    public String getUserName() {
        return UserName;
    }

    /**
     * Sets the username of the user.
     *
     * @param UserName the username to set
     */
    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    /**
     * Returns the password of the user.
     *
     * @return the password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * Sets the password of the user.
     *
     * @param Password the password to set
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    /**
     * Input data of account
     *
     * The inputData() function allows the user to enter a username and password
     * from the keyboard. It uses a do-while loop to ask the user to re-enter if
     * the username and password do not respond to the following requests:
     * Username must be at least 5 characters and have no spaces. Password must
     * be at least 6 characters and have no spaces. The function will continue
     * to ask the user for input until both the username and password have
     * answered the above requests.
     *
     */
    public void inputData() {
        boolean check1 = true;//Kiểm tra userName
        boolean check2 = true;//kiểm tra password
        String checkName = "^[^\\s]{5,}$";//điều kiện cho phép nhập username
        String checkPass = "^[^\\s]{6,}$";//điều kiện cho phép nhập password
        //enter UserName
        do {
            System.out.print("Enter Username: ");
            UserName = sc.nextLine().trim();//Nhập username và cắt khoảng trắng dư thừa
            if (!UserName.matches(checkName)) {//Nếu không đúng đều kiện cho phép
                System.out.println("You must enter least at 5 character, and no space!");
            } else {
                check1 = false;
            }
        } while (check1);//Lập đế khi nhập sai điều kiện nhập username

        //enter Password
        do {
            System.out.print("Enter Password: ");
            Password = sc.nextLine().trim();//Nhập password và cắt khoảng trắng dư thừa
            if (!Password.matches(checkPass)) {//Nếu nhập không đúng điều kiện cho phép
                System.out.println("You must enter least at 6 character, and no space!");
            } else {
                check2 = false;
            }
        } while (check2);//Lập đế khi nhập sai điều kiện nhập password
    }
}
