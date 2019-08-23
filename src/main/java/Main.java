import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Connection connection = null;
        Scanner scanner = new Scanner(System.in);


        //create connection
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://127.0.0.1:3306/sda-school?verifyServerCertificate=false&useSSL=true",
                    "root", "admin");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        while (!scanner.equals("0")) {
            System.out.println("Menu");
            System.out.println("\n---------STUDENTS---------");
            System.out.println("1.Display table Students");
            System.out.println("2.Insert student");
            System.out.println("3.Insert student manual");
            System.out.println("4.Search for student");
            System.out.println("5.Delete from keyboard a student");

            System.out.println("\n---------GROUPS---------");
            System.out.println("6.Display table Groups");
            System.out.println("7.Insert group");
            System.out.println("8.Insert group manual");
            System.out.println("9.Search for group");
            System.out.println("10.Delete from keyboard a group");

            System.out.println("\n---------TEACHERS---------");
            System.out.println("11.Display table Teachers");
            System.out.println("12.Insert teacher");
            System.out.println("13.Insert teacher manual");
            System.out.println("14.Search for teacher");
            System.out.println("15.Delete from keyboard a teacher");

            System.out.println("0.Exit");

            System.out.println("Please select one option:");
            String choice = scanner.nextLine();
            System.out.println("Your selection is: " + choice);

            if (choice.equals("1")) {
                MenuHandler.displayTableStudents(connection);
            } else if (choice.equals("2")) {
                MenuHandler.insertNewStudent(connection);
            } else if (choice.equals("3")) {
                System.out.println("Please enter first name: ");
                String first_name = scanner.nextLine();

                System.out.println("Please enter last name: ");
                String last_name = scanner.nextLine();

                System.out.println("Please enter age : ");
                Integer age = scanner.nextInt();

                MenuHandler.insertNewStudentFromKeyboard(connection, first_name, last_name, age);
            } else if (choice.equals("4")) {
                System.out.println("Please enter first name: ");
                String first_name = scanner.nextLine();

                MenuHandler.searchForStudent(connection, first_name);
            } else if (choice.equals("5")) {
                System.out.println("Please enter id for delete: ");
                Integer id = scanner.nextInt();

                MenuHandler.deleteFromKeyboardAStudent(connection, id);
            } else if (choice.equals("6")) {
                MenuHandler.displayTableGroups(connection);
            } else if (choice.equals("7")) {
                MenuHandler.insertNewGroup(connection);
            } else if (choice.equals("8")) {
                System.out.println("Please enter group name: ");
                String name = scanner.nextLine();

                MenuHandler.insertNewGroupFromKeyboard(connection, name);
            } else if (choice.equals("9")) {
                System.out.println("Please enter group name: ");
                String name = scanner.nextLine();

                MenuHandler.searchForGroup(connection, name);
            } else if (choice.equals("10")) {
                System.out.println("Please enter id for delete: ");
                Integer id = scanner.nextInt();

                MenuHandler.deleteFromKeyboardAGroup(connection, id);
            } else if (choice.equals("11")) {
                MenuHandler.displayTableTeachers(connection);
            } else if (choice.equals("12")) {
                MenuHandler.insertNewTeacher(connection);
            } else if (choice.equals("13")) {
                System.out.println("Please enter first name: ");
                String first_name = scanner.nextLine();

                System.out.println("Please enter last name: ");
                String last_name = scanner.nextLine();

                System.out.println("Please enter age : ");
                Integer age = scanner.nextInt();

                System.out.println("Please enter type: ");
                String type = scanner.nextLine();

                MenuHandler.insertNewTeacherFromKeyboard(connection, first_name, last_name, age, type);
            } else if (choice.equals("14")) {
                System.out.println("Please enter last name: ");
                String last_name = scanner.nextLine();

                MenuHandler.searchForTeacher(connection, last_name);
            } else if (choice.equals("15")) {
                System.out.println("Please enter id for delete: ");
                Integer id = scanner.nextInt();

                MenuHandler.deleteFromKeyboardATeacher(connection, id);
            } else if (choice.equals("0")) {
                System.exit(1);
            }
        }
    }
}
