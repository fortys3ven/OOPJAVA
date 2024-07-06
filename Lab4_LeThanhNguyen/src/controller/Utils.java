
package Controller;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
import model.Employee;

public class Utils {
    private static Scanner sc = new Scanner(System.in);

    public static int getValueInt(String message) {
        int n;
        while (true) {
            try {
                System.out.print(message);
                n = Integer.parseInt(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println("ERROR! Please enter again");
            }
        }
    }

    public static String getValueString(String message) {
        String str;
        System.out.print(message);
        str = sc.nextLine();
        while (true) {
            if (str.isEmpty()) {
                System.out.println("ERROR! Please enter again");
            } else return str;
        }
    }

    public static String normalizeName(String name) {
        name = name.replaceAll("[^a-zA-Z ]", "").replaceAll("\\s+", " ");
        String[] words = name.split("\\s+");
        StringBuilder normalized = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                String capitalizedWord = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
                normalized.append(capitalizedWord).append(" ");
            }
        }
        return normalized.toString().trim();
    }

    public static double getValueDouble(String message) {
        double n;
        while (true) {
            try {
                System.out.print(message);
                n = Double.parseDouble(sc.nextLine());
                return n;
            } catch (Exception e) {
                System.out.println("ERROR! Please enter again");
            }
        }
    }


    public static LocalDate getLocalDate() {
        LocalDate birthDate = null;
        while (birthDate == null) {
            String birthDateStr = Utils.getValueString("Enter Birth Date (yyyy-MM-dd): ");
            try {
                birthDate = LocalDate.parse(birthDateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date format. Please enter the date in yyyy-MM-dd format.");
            }
        }
        return birthDate;
    }
    
    public static int checkId(int id, ArrayList<Employee> empList) {
        for (Employee emp : empList) {
            if (emp != null && id == emp.getId()) {
                return 0;
            }
        }
        return 1;
    }


    public static String formatSalary(double salary) {
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(salary);
    }
}






