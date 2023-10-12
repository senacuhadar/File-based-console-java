package com.company.employment;

import java.util.Scanner;

public class EmploymentConsole{
    
    public final static String EMPLOYEE_FILE = "C:\\Directory\\Employee.txt";
    public static Scanner scanner = new Scanner(System.in);
    public static Department department = new Department(540, "Muhasebe");
    public static EmployeeStorer storer = new EmployeeStorer(EMPLOYEE_FILE);
    public static EmployeeLoader loader = new EmployeeLoader(EMPLOYEE_FILE);


 public static void printMenu() {
        System.out.println("1. Listele");
        System.out.println("2. Ekle");
        System.out.println("3. Guncelle");
        System.out.println("4. Sil");
        System.out.println("5. Sec");
        System.out.println("6. Yukle");
        System.out.println("7. Sakla");
        System.out.println("8. Cik");
    }

 public static int scanChoice() {
        System.out.println("Lutfen seciniz: ");
        int choice = scanner.nextInt();
        System.out.println("Seciminiz: " + choice);
        return choice;
    }
 public static void handleCommand(int choice) {
        System.out.println("Islenen Secim = " + choice);
        switch (choice) {
            case 1 ->
                listEmployees();
            case 2 ->
                insertEmployee();
            case 3 ->
                updateEmployee();
            case 4 ->
                deleteEmployee();
            case 5 ->
                selectEmployee();
            case 6 ->
                loadEmployees();
            case 7 ->
                storeEmployees();
            case 8 ->
                exitConsole();
            default ->
                System.out.println("Gecersiz Secim!");
        }
    }
 public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = scanChoice();
            handleCommand(choice);
        }
    }



    private static void listEmployees() {
        System.out.println("Listeleniyor...");
        for(Employee employee : department.getEmployeeList()){
            System.out.println("Çalışan No: " + employee.getEmployeeId() + " " +
                               "Çalışan Adı: " + employee.getEmployeeName() + " " +
                               "Çalışan Maaşı: " + employee.getMonthlySalary());
        
        }
        System.out.println("Çalışan Sayısı: " + department.getEmployeeList().size());
    }

    private static void insertEmployee() {
       System.out.println("Ekleniyor...");
       System.out.println("Çalışan No: "); 
       long employeeId = scanner.nextLong();
        System.out.println("Çalışan Adi: ");
        String employeeName = scanner.next();
        System.out.println("Çalışan Maaşı: ");
        double monthlySalary = scanner.nextDouble();
        Employee employee = new Employee(employeeId, employeeName, monthlySalary);
        department.getEmployeeList().add(employee);
        employee.setDepartment(department);
        System.out.println("Çalışan basariyla eklenmistir");
    }

    private static void updateEmployee() {
        System.out.println("Güncelleniyor...");
        System.out.println("Guncellemek istediginiz calisan numarasi: ");
        long employeeId = scanner.nextLong();
        Employee employee = department.find(employeeId);
        if (employee != null) {
            System.out.println("Calisanin adini giriniz: ");
            String employeeName = scanner.next();
            employee.setEmployeeName(employeeName);
            System.out.println("Calisanin maasini giriniz: ");
            double monthlySalary = scanner.nextDouble();
            employee.setMonthlySalary(monthlySalary);
            System.out.println("Calisan basariyla guncellenmistir");
        } else {
            System.out.println("Boyle bir calisan no yok");
        }
    }

    private static void deleteEmployee() {
        System.out.println("Siliniyor...");
        System.out.println("Calisan no: ");
        long employeeId = scanner.nextLong();
        Employee employee = department.find(employeeId);
        if (employee != null) {
            department.getEmployeeList().remove(employee);
            System.out.println("Calisan basariyla silinnmistir");
        } else {
            System.out.println("Boyle bir calisan no yok");
        }
    }

    private static void selectEmployee() {
        System.out.println("Seciliyor...");
        System.out.println("Calisan numarasini giriniz: ");
        long employeeId = scanner.nextLong();
        Employee employee = department.find(employeeId);
        if (employee != null) {
            System.out.println("Calisan No: " + employee.getEmployeeId());
            System.out.println("Calisan Adi: " + employee.getEmployeeName());
            System.out.println("Calisan Maasi: " + employee.getMonthlySalary());

        } else {
            System.out.println("Boyle bir calisan no yok");
        }
    }

    private static void loadEmployees() {
         System.out.println("Yukleniyor...");
        try {
            department.setEmployeeList(loader.load());
            System.out.println("Calisanlar yuklenmistir");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void storeEmployees() {
        System.out.println("Saklanıyor...");
        Runnable runnable = () -> {
            try {
                storer.store(department.getEmployeeList());
                System.out.println("Calisanlar saklanmistir");
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    private static void exitConsole() {
       System.out.println("Cikis Yapiliyor...");
        System.exit(0); 
    }


}