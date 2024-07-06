
package controller;

import Controller.Utils;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import model.*;
import view.Menu;


public class ControllerCompany extends Menu {

    static String title = "Manage Employee";
    static String[] arr = {"Add a Empoyee", "Show information of emp by type", "Sort and show the staff list by descending salary", "Find and remove emp by name", "Calculate and show average salary of fulltime emp and parttime emp", "Exit"};
    static CompanyManager company;

    public ControllerCompany() throws ParseException {
        super(title, arr);
        company = new CompanyManager();
    }

    public static void main(String[] args) throws ParseException {
        ControllerCompany controller = new ControllerCompany();
        controller.run();
    }

    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1 -> {
                boolean check = Boolean.parseBoolean(Utils.getValueString("Enter staff type:\nFulltime(true), Partime(default): "));
                Employee emp = createNewStaff(check);
                company.addStaff(emp, check);
            }
            case 2 -> {
                printStaffListByType();
            }

            case 3 -> {
                sortAndExportStaffListBySalary();
            }

            case 4 -> {
                String key = Utils.normalizeName(Utils.getValueString("Enter staff name to remove: "));
                findAndRemoveStaffByName(key);
            }

            case 5 -> {
                calculateAverageSalaryByType();
            }

            default -> {
                System.out.println("Exit. See you again");
                System.exit(0);
            }
        }
    }

    private static Employee createNewStaff(boolean checkType) {
        try {
            int id;
            int checkID;
            do {
                id = Utils.getValueInt("Enter ID: ");

                // không cho phép cùng ID
                checkID = Utils.checkId(id, company.getEmpList());
            } while (id < 0 || checkID == 0);
            String name = Utils.normalizeName(Utils.getValueString("Enter Name: "));
            LocalDate birthday = Utils.getLocalDate();
            
            int dayWork;
            do {
                dayWork = Utils.getValueInt("Enter the number of working days in the month: ");
            } while (dayWork < 0 || dayWork > 31);
            if (checkType) {
                int OT = Utils.getValueInt("Enter number hour of Over Time: ");
                return new FulltimeEmployee(id, name, birthday, dayWork, OT);
            } else {
                return new ParttimeEmployee(id,name,birthday, dayWork);
            }
        } catch (NumberFormatException e) {
            System.err.println("Invalid input. Try again!");
            return null;
        }
    }

    private static void printStaffListByType() {
        ArrayList<FulltimeEmployee> fulltimeList = company.getFulltimeEmployees();
        ArrayList<ParttimeEmployee> parttimeList = company.getParttimeEmployees();
        if (fulltimeList.isEmpty()) {
            System.out.println("No main staff");
        } else {
            System.out.println("List of Main Staff: ");
            company.printListOfStaff();
        }

        if (parttimeList.isEmpty()) {
            System.out.println("No seasonal staff");
        } else {
            System.out.println("List of Seasonal Staff: ");
            company.printListOfStaff(parttimeList);
        }

    }

    private static void sortAndExportStaffListBySalary() {
        company.sortStaffBySalary(company.getEmpList());
        company.printListOfStaff(company.getEmpList());
    }

    private static void findAndRemoveStaffByName(String key) {
        Employee foundStaff = company.findStaffByName(company.getEmpList(), key);
        if (foundStaff != null) {
            System.out.println("Staff was found");
            System.out.println(foundStaff.toString());
            company.removeStaff(foundStaff);
            System.out.println("Staff was removed");
        } else {
            System.out.println("Not found");
        }
    }

    private static void calculateAverageSalaryByType() {
        System.out.println("Average Salary Of Main Staff: " + Utils.formatSalary(company.calculateAverageSalary(company.getFulltimeEmployees())));

        System.out.println("Average Salary Of Seasonal Staff: " + Utils.formatSalary(company.calculateAverageSalary(company.getParttimeEmployees())));

    }
}
