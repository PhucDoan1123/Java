
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Đoan Thanh Phúc - CE170580
 */
public class Calculator_Normal {

    private double a;// số được nhập trước
    private double b;// số được nhập sau
    private Operator op;// toán hạng của phép toán

    Scanner sc = new Scanner(System.in);// nhập giá trị từ bàn phím 

    enum Operator {//Liệt kê những trường hợp toán hạn cho phép
        ADD, SUBTRACT, MULTIPLY, DIVIDE, EXPONENTIATE, EQUALS // hằng số của enum Operator
    }

    /**
     * Let check Operator allows input
     *
     * use switch statement to check the value of operator string and returns
     * enum constant Corresponding operator, in switch-case.
     *
     * @return the constant corresponding to the case of Operator entered
     */
    public Operator checkOperator() {
        //trả lại hằng số enum tương ứng với chuỗi operator nhập vào
        String operator = sc.nextLine();
        switch (operator) {
            case "+":
                return Operator.ADD;
            case "-":
                return Operator.SUBTRACT;
            case "*":
                return Operator.MULTIPLY;
            case "/":
                return Operator.DIVIDE;
            case "^":
                return Operator.EXPONENTIATE;
            case "=":
                return Operator.EQUALS;
            default: {
                return null;// return null nếu không có trường hợp tương ứng
            }
        }
    }

    /**
     * Let check constant of Operator
     *
     * Use Switch - case to check case of Operator is entered
     *
     * @return the constant corresponding to the case of Operator entered
     */
    public double calculate() {
        // trả lại trường hợp tương ứng với hằng số Operator
        switch (op) {
            case ADD:
                return a + b;
            case SUBTRACT:
                return a - b;
            case MULTIPLY:
                return a * b;
            case DIVIDE:
                return a / b;
            case EXPONENTIATE:
                return Math.pow(a, b);
            default:
                throw new ArithmeticException("Invalid operator: " + op);//không có trường hợp nào tương ứng
        }
    }

    /**
     * Let check input value
     *
     * Let use the checkInput function to check the input value, Perform
     * calculation according to user input operand, save the result in memory
     * and print it to the screen.
     *
     * Print result if operator is '='
     */
    public void inputCalculatorN() {
        double result = 0;// kết quả sau khi thưc hiện phép toán
        boolean checkInput1 = true;// kiểm tra trường hợp nhập số a
        boolean checkInput2 = true;// kiểm tra trường hợp nhập số b ( lân đầu)
        boolean checkInput3 = true;// kiểm tra trường hợp nhập số b ( những lần kế tiếp)

        //Nhập và kiểm tra số được nhập trước
        do {
            try {
                System.out.print("Enter number: ");
                a = Double.parseDouble(sc.nextLine());//chuyển số nhập vào thành số thực
                checkInput1 = true;
            } catch (NumberFormatException e) {//ném ra ngoại lệ nếu nó không chuyển được thành số thực
                System.out.println("Invaled");//in ra thông báo lỗi
                checkInput1 = false;
            }
        } while (!checkInput1);//điều kiện thực hiện lập

        //Nhập và kiểm tra toán hạng
        do {
            System.out.print("Enter Operator: ");
            op = checkOperator();//gán hàm checkOperator để kiểm tra op nhập vào
            if (op == null) {// nếu nó không phải là toán hạng cho phép
                System.out.println("Please input (+, -, *, /, ^)");
            } else if (op == op.EQUALS) {//nếu chưa thực hiện phép tính nào mà người dùng đã nhập toán hạn là '='
                System.out.println("Please input (+, -, *, /, ^)");
                op = null;//gán toán hạn về null
            }
        } while (op == null);// điều kiện bắt người dùng nhập lại

        //Nhập và kiểm tra số được nhập sau
        do {
            try {
                System.out.print("Enter number: ");
                b = Double.parseDouble(sc.nextLine());//chuyển số b thành số thực
                checkInput2 = true;//thoát vòng lập
                if (op == Operator.DIVIDE && b == 0) {//nếu toán hạng là '/' và b = 0
                    System.out.println("Cannot divide by zero!");//in thông báo lỗi
                    checkInput2 = false;
                }
            } catch (NumberFormatException e) {//nẻm ra ngoại lệ
                System.out.println("Invalid!");//in ra thông báo nếu số nhập vào không phải là số thực
                checkInput2 = false;
            }
        } while (!checkInput2);// điều kiện bắt người dùng nhập lại

        //thực hiện phép tính khi toán hạng khác '='
        do {
            result = calculate();//thực hiện phép tính
            System.out.printf("Memory: %.1f\n", result);// in ra thông báo số memory
            a = result;//gán giá trị kết quả cho a để thực hiện phép tính mới

            // Nhập và kiểm tra toán hạng
            do {
                System.out.print("Enter Operator: ");
                op = checkOperator();//gán hàm checkOperator cho op để kiểm tra op nhập vào
                if (op == null) {// nếu nó không phải là toán hạng cho phép
                    System.out.println("Please input (+, -, *, /, ^)");
                }
            } while (op == null);// điều kiện bắt người dùng nhập lại

            //Nhập và kiểm tra số được nhập sau
            if (op != op.EQUALS) {
                do {
                    try {
                        System.out.print("Enter number: ");
                        b = Double.parseDouble(sc.nextLine());//chuyển số b thành số thực
                        checkInput3 = true;//thoát vòng lập
                        if (op == Operator.DIVIDE && b == 0) {//nếu toán hạng là '/' và b = 0
                            System.out.println("Cannot divide by zero!");//in thông báo lỗi
                            checkInput3 = false;
                        }
                    } catch (NumberFormatException e) {//ném ra ngoại lệ
                        System.out.println("Invalid!");//in ra thông báo nếu số nhập vào không phải là số thực
                        checkInput3 = false;
                    }
                } while (!checkInput3);// điều kiện bắt người dùng nhập lại
            }
        } while (op != Operator.EQUALS);//Nếu op khác'='
        System.out.printf("Result: %.1f\n", result);//print kết quả sau khi nhập Operator là '='
    }
}
