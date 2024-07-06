package model;

import java.time.LocalDate;

public class FulltimeEmployee extends Employee {
    public static final int SALARYADAY = 1000000;
    private static final int CK = 100000;
    private final double OT;
    
    public FulltimeEmployee(int id, String name, LocalDate dob, int dayWork, double OT) {
        super(id, name, dob, dayWork);
        this.OT = OT;
    }

    @Override
    public int salaryWork() {
        int s = (int)(super.dayWork * SALARYADAY + OT * CK);
        return s;
    }

    @Override
    public void showInfo() {
        System.out.printf("|%4d|%20s|%10s|%2d|%2.1f|%12d|",id, name, dob, dayWork, OT, salaryWork());
    }
}