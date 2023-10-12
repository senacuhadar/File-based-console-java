package com.company.employment;

import java.util.ArrayList;
import java.util.List;

public class Department{
    
private long departmentId;
private String departmentName;
private List <Employee> employeeList= new ArrayList();

    public Department(long departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    public Department() {
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List <Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List <Employee> employeeList) {
        this.employeeList = employeeList;
    }
    
    
public Employee find(long employeeId) {
        for (Employee employee : employeeList) {
            if (employeeId == employee.getEmployeeId()) {
                return employee;
            }
        }
        return null;
    }


}