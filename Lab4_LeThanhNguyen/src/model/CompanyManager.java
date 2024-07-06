
package model;

import java.util.ArrayList;


public class CompanyManager {

    private final ArrayList<Employee> empList = new ArrayList();
    private final ArrayList<FulltimeEmployee> fulltimeEmpList = new ArrayList();
    private final ArrayList<ParttimeEmployee> parttimeEmpList = new ArrayList();

    public void printListOfStaff(ArrayList<Employee> empList) {
        for (Employee emp : empList) {
            System.out.println(emp.toString());
        }
    }

    public void addStaff(Employee emp, boolean staffType) {
        if (emp != null) {
            empList.add(emp);
            if (staffType) {
                fulltimeEmpList.add((FulltimeEmployee) emp);
                System.out.println("Add Fulltime Employee Successful");
            } else {
                parttimeEmpList.add((ParttimeEmployee) emp);
                System.out.println("Add Seasonal Staff Successful");
            }
        } else {
            System.out.println("Add Failed");
        }

    }

    public ArrayList<Employee> getEmpList() {
        return empList;
    }

    public ArrayList<FulltimeEmployee> getFulltimeEmployees() {
        return fulltimeEmpList;
    }

    public ArrayList<ParttimeEmployee> getParttimeEmployees() {
        return parttimeEmpList;
    }

    public void sortStaffBySalary(ArrayList<Employee> list) {
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (list.get(j).salaryWork() < list.get(j + 1).salaryWork()) {
                    Employee temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

    public Employee findStaffByName(ArrayList<Employee> list, String key) {
        for (Employee emp : list) {
            if (key.equals(emp.getName())) {
                return emp;
            }
        }
        return null;
    }

    public void removeStaff(Employee key) {
        empList.remove(key);
        for (Employee staff : fulltimeEmpList) {
            if (staff == key) {
                fulltimeEmpList.remove(staff);
                break;
            }
        }

        for (Employee staff : parttimeEmpList) {
            if (staff == key) {
                parttimeEmpList.remove(staff);
                break;
            }
        }
    }

    public double calculateAverageSalary(ArrayList<Employee> list) {
        double sum = 0;
        if (list.isEmpty()) return 0;
        for (Employee emp : list) {
            sum += emp.salaryWork();
        }
        return sum / list.size();
    }

}
