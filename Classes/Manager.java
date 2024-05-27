package model;

import java.util.List;

public class Manager extends Employee {
    private String department;
    private List<Employee> subordinates;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<Employee> subordinates) {
        this.subordinates = subordinates;
    }

    public void viewEmployeeInfo(Employee employee) {
        System.out.println("Employee Name: " + employee.getName());
        System.out.println("Department: " + employee.getDepartment());
        // Display other employee information
    }

    public void editEmployeeInfo(Employee employee, String name, String phoneNum, int age, String gender, String address, String nationalID) {
        employee.setName(name);
        employee.setPhoneNum(phoneNum);
        employee.setAge(age);
        employee.setGender(gender);
        employee.setAddress(address);
        employee.setNationalID(nationalID);
    }

    public void deleteEmployee(Employee employee) {
        subordinates.remove(employee);
        // Implement logic to delete employee from the system
    }

    public void manageSalary(Employee employee, float newSalary) {
        employee.setSalary(newSalary);
    }
}
