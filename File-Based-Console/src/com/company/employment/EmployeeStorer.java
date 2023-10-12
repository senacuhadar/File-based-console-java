package com.company.employment;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class EmployeeStorer extends EntityFiler{

    private String newLine= "\r\n";
 
    public EmployeeStorer(String filePath) {
        super(filePath);
    }
public void store(List<Employee> employeeList) throws IOException{
FileWriter fw = new FileWriter(filePath);
BufferedWriter bw = new BufferedWriter(fw);
for(Employee employee : employeeList){
String line = format(employee);
bw.write(line + newLine);
}
      bw.close();
}

public String format(Employee employee){
StringBuilder builder = new StringBuilder();
builder.append(employee.getEmployeeId()).append(fieldDelimiter);
         builder.append(employee.getEmployeeName()).append(fieldDelimiter);
         builder.append(employee.getMonthlySalary());
         return builder.toString();
}

    public String getNewLine() {
        return newLine;
    }

    public void setNewLine(String newLine) {
        this.newLine = newLine;
    }


}
