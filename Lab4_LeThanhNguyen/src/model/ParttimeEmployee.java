package model;

import java.time.LocalDate;

public class ParttimeEmployee extends Employee{
    private final double CKTV = 0.5;

    public ParttimeEmployee(int id, String name, LocalDate dob, int dayWork) {
        super(id, name, dob, dayWork);
    }

    @Override
    public int salaryWork() {
        int s = (int)(FulltimeEmployee.SALARYADAY * dayWork * CKTV);
        return s;
    }

    @Override
    public void showInfo() {
        System.out.printf("|%10s|%4d|%20s|%10s|%2d|%2s|%12d|","Fulltime",id, name, dob, dayWork,"--" , salaryWork());
    }
}