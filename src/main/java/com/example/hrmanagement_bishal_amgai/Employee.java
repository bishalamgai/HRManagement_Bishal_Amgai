package com.example.hrmanagement_bishal_amgai;

import javafx.fxml.FXML;

public class Employee {
    @FXML
        private int id;
    @FXML
        private String Name;
    @FXML
        private int Salary;
    @FXML
        private String Department;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int salary) {
        Salary = salary;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }
    public Employee(int id, String name, int salary, String department) {
        this.id = id;
        Name = name;
        Salary = salary;
        Department = department;
    }
}
