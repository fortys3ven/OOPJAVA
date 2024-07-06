package model;

import java.time.LocalDate;

public abstract class Employee {
    protected int id;
    protected String name;
    protected LocalDate dob;
    protected int dayWork;

    public Employee(int id, String name, LocalDate dob, int dayWork) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.dayWork = dayWork;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public int getDayWork() {
        return dayWork;
    }

    public void setDayWork(int dayWork) {
        this.dayWork = dayWork;
    }

    public abstract int salaryWork();

    public abstract void showInfo();
}