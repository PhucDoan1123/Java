/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.util.Scanner;

/**
 *
 * @author Acer
 */
public class IOCE170580 {

    static Scanner sc = new Scanner(System.in);

    public static int getInteger(String iMsg, String iError) {
        int res = 0;
        while (true) {
            try {
                System.out.print(iMsg);
                res = Integer.parseInt(sc.nextLine());
                return res;
            } catch (Exception e) {
                System.out.print(iError);
            }
        }
    }

    public static int getInteger(String iMsg, String iError, int start, int end) {
        if (start > end) {
            int temp = start;
            start = end;
            end = temp;
        }

        int res = 0;
        while (true) {
            try {
                System.out.print(iMsg);
                res = Integer.parseInt(sc.nextLine());
                if (res < start || res > end) {
                    throw new Exception();
                }
                return res;
            } catch (Exception e) {
                System.out.print(iError);
            }
        }
    }

    public static double getDouble(String iMsg, String iError) {

        double res;
        while (true) {
            try {
                System.out.print(iMsg);
                res = Double.parseDouble(sc.nextLine());
                return res;
            } catch (Exception e) {
                System.out.print(iError);
            }
        }
    }

    public static double getDouble(String iMsg, String iError, double start, double end) {
        if (start > end) {
            double temp = start;
            start = end;
            end = temp;
        }

        double res = 0;
        while (true) {
            try {
                System.out.print(iMsg);
                res = Double.parseDouble(sc.nextLine());
                if (res < start || res > end) {
                    throw new Exception();
                }
                return res;
            } catch (Exception e) {
                System.out.print(iError);
            }
        }
    }

    public static String getString(String iMsg, String iError) {
        while (true) {
            try {
                System.out.print(iMsg);
                String res = sc.nextLine();
                if (res.length() == 0) {
                    throw new Exception();
                }
                return res;
            } catch (Exception e) {
                System.out.println(iError);
            }
        }
    }

    public static int getInteger(String iMsg) {
        int res = 0;
        res = Integer.parseInt(sc.nextLine());
        return res;
    }
  
}
