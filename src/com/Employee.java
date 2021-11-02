package com;

public class Employee {

    String name;
    int empId;
    int deptId;
    int salary;
    boolean isActive;
    int age;

    public Employee(String name, int empId, int deptId, int salary, boolean isActive, int age) {
        this.name = name;
        this.empId = empId;
        this.deptId = deptId;
        this.salary = salary;
        this.isActive = isActive;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getEmpId() {
        return empId;
    }

    public int getDeptId() {
        return deptId;
    }

    public int getSalary() {
        return salary;
    }

    public boolean isActive() {
        return isActive;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", empId=" + empId +
                ", deptId=" + deptId +
                ", salary=" + salary +
                ", isActive=" + isActive +
                ", age=" + age +
                '}';
    }
}
