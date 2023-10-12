package com.company.employment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeStorerTest{
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Directory\\Employee.txt";
        EmployeeStorer storer = new EmployeeStorer(filePath);
        
        List<Employee> employeeList = new ArrayList();  
        
        Employee employee0 = new Employee(890, "Behiye Aksoy", 3500);
        employeeList.add(employee0);
        
        Employee employee1 = new Employee(891, "Emel Sayın", 2300);
        employeeList.add(employee1);
        
        Employee employee2 = new Employee(892, "Muazzez Ersoy", 3350);
        employeeList.add(employee2);
       
        storer.store(employeeList);
    }


}