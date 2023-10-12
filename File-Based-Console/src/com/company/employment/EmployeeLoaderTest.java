package com.company.employment;

import java.io.IOException;
import java.util.List;

public class EmployeeLoaderTest{
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Directory\\Student.txt";
        EmployeeLoader loader = new EmployeeLoader(filePath);
        
        
        List<Employee> employeeList = loader.load();
        
        for(Employee employee : employeeList){
            System.out.println("Çalışan No: " + employee.getEmployeeId() + " "+
                               "Çalışan Adı: " + employee.getEmployeeName() + " "+
                               "Çalışan Maaşı: " + employee.getMonthlySalary());
        }
        
    }
}