package com.techelevator;

public class Employee {

    //Instance variables
    private int employeeId;
    private String firstName;
    private String lastName;
    private String department;
    private double annualSalary;

    //Derived instance variables
    public String getFullName () {
        return lastName + ", " + firstName;
    }

    //Constructor
    public Employee(int employeeId, String firstName, String lastName, double annualSalary) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.annualSalary = annualSalary;
    }

    //Getters
    public int getEmployeeId() {return employeeId;}
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public String getDepartment() {return department;}
    public double getAnnualSalary() {return annualSalary;}

    //Setter
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setDepartment(String department) {this.department = department;}

    //Method
    public void raiseSalary(double percent) {
        annualSalary = annualSalary + ((annualSalary * percent) / 100);
    }
}
