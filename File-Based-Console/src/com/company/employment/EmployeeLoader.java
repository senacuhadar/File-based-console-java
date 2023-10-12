package com.company.employment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class EmployeeLoader extends EntityFiler {

    public EmployeeLoader(String filePath) {
        super(filePath);
    }

    public List<Employee> load() throws IOException {
        List<Employee> employeeList = new ArrayList<>();
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null) {
            Employee employee = parse(line);
            employeeList.add(employee);
        }
        return employeeList;
    }

    public Employee parse(String line) {
        StringTokenizer tokenizer = new StringTokenizer(line, ";");
        long employeeId = Long.parseLong(tokenizer.nextToken());
        String employeeName = tokenizer.nextToken();
        double monthlySalary = Double.parseDouble(tokenizer.nextToken());
        return new Employee(employeeId, employeeName, monthlySalary);
    }

}
