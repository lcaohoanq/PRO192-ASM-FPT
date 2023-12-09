package viewer;

import controller.*;
import tool.ConsoleColors;

public class Main {

    final String fileEmp = "src\\input\\ListOfEmployees.txt";
    final String filePL = "src\\input\\PLInfo.txt";
    final String fileWrite1 = "src\\output\\Req2.txt";
    final String fileWrite2 = "src\\output\\Req3.txt";

    int choice = 0;

    Menu menu = new Menu("Company Employee Management Program");

    CompanyManagement cm = new CompanyManagement();
    
//    App app = new App();

    public Main() throws Exception {
        
        
        initMenu();

        System.out.println(ConsoleColors.YELLOW + "Note: \nAll employee's salary based on the actual salary after multiply with the bonus and casted into integer!!!" + ConsoleColors.RESET);

        
        doManagement(); //nhận vào tham số từ GUI và chạy chức năng tương ứng

    }

    private void initMenu() {
        menu.addNewOption("Read all Employees and print to screen");
        menu.addNewOption("Show staff proficient in a Programming Language");
        menu.addNewOption("Show Tester has a height salary");
        menu.addNewOption("Show Employee’s higest salary");
        menu.addNewOption("Show Leader of the Team has most Employees");
        menu.addNewOption("Sort Employees as descending salary");
        menu.addNewOption("Show All Employees (optional)"); //mình muốn check lại dữ liệu mỗi khi được chỉnh sửa
        menu.addNewOption("Write file");
        menu.addNewOption("Exit");
    }

    private void doManagement() throws Exception {
        do {
            menu.print();
            choice = menu.getChoice();
            switch (choice) {
                case 1:
                    cm.getEmployeeFromFile(fileEmp, filePL);
                    break;
                case 2:
                    cm.getDeveloperByProgrammingLanguage(filePL);
                    break;
                case 3:
                    cm.getTestersHaveSalaryGreaterThan();
                    break;
                case 4:
                    cm.getEmployeeWithHighestSalary();
                    break;
                case 5:
                    cm.getLeaderWithMostEmployees();
                    break;
                case 6:
                    cm.sorted();
                    break;
                case 7:
                    cm.printEmpList();
                    break;
                case 8:
                    cm.writeFile(fileWrite1);
                    cm.writeFile(fileWrite2);
                    break;
                case 9: {
                    System.out.println("Good bye");
                }
            }
        } while (choice > 0 && choice < menu.getSize());
    }

    public static void main(String[] args) throws Exception {
        new Main();
    }
}
