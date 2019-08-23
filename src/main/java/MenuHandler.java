import java.sql.*;

public class MenuHandler {

    //STUNDENTS
    public static void displayTableStudents(Connection connection) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                Integer age = rs.getInt("age");

                System.out.println("Studentul cu id-ul " + id + " este " + first_name + " " + last_name
                        + " cu varsta de " + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void insertNewStudent(Connection connection) {
        try {
            Statement stmt = connection.createStatement();
            Integer result = stmt.executeUpdate("INSERT students(first_name,last_name,age)" +
                    "VALUES(\"Emilus\",\"Bobonete\",20)");

            if (result == 1) {
                System.out.println("S-a intregistrat cu succes");
            } else {
                System.out.println("Nu s-a inregistrat cu succes!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertNewStudentFromKeyboard(Connection connection, String first_name, String last_name,
                                                    int age) {
        String sql = "INSERT INTO students(first_name,last_name, age)VALUES(?,?,?)";
        int resultSet = 0;
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, first_name);
            stmt.setString(2, last_name);
            stmt.setInt(3, age);
            resultSet = stmt.executeUpdate();

            if (resultSet == 1) {
                System.out.println("S-a intregistrat cu succes");
            } else {
                System.out.println("Nu s-a inregistrat cu succes!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void searchForStudent(Connection connection, String first_name) {
        String sql = "SELECT * from students WHERE first_name = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, first_name);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                Integer age = resultSet.getInt(4);

                System.out.println("Display results: ");
                System.out.println("Id : " + id);
                System.out.println("First name search result: " + firstName);
                System.out.println("Last name search result: " + lastName);
                System.out.println("Age search result: " + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteFromKeyboardAStudent(Connection connection, Integer id) {
        String sql = "DELETE FROM students WHERE id = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            int resultSet = stmt.executeUpdate();

            if (resultSet == 1) {
                System.out.println("S-a sters cu succes");
            } else {
                System.out.println("Nu s-a sters cu succes!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //GROUPS

    public static void displayTableGroups(Connection connection) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM `groups`");

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String name = rs.getString("name");


                System.out.println("Grupa cu id-ul " + id + " este " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void insertNewGroup(Connection connection) {
        try {
            Statement stmt = connection.createStatement();
            Integer result = stmt.executeUpdate("INSERT INTO `groups`(name) VALUES(\"1305A\")");

            if (result == 1) {
                System.out.println("S-a intregistrat cu succes");
            } else {
                System.out.println("Nu s-a inregistrat cu succes!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertNewGroupFromKeyboard(Connection connection, String name) {
        String sql = ("INSERT INTO `groups`(name) VALUES(?)");
        int result = 0;

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, name);
            result = stmt.executeUpdate();

            if (result == 1) {
                System.out.println("S-a intregistrat cu succes");
            } else {
                System.out.println("Nu s-a inregistrat cu succes!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void searchForGroup(Connection connection, String name) {
        String sql = ("SELECT * from `groups` WHERE name=?");

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, name);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                String group_name = resultSet.getString(2);

                System.out.println("Display results: ");
                System.out.println("Id : " + id);
                System.out.println("Group name search result: " + group_name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteFromKeyboardAGroup(Connection connection, Integer id) {
        String sql = "DELETE FROM `groups` WHERE id = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            int resultSet = stmt.executeUpdate();

            if (resultSet == 1) {
                System.out.println("S-a sters cu succes");
            } else {
                System.out.println("Nu s-a sters cu succes!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //TEACHERS

    public static void displayTableTeachers(Connection connection) {
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM teachers");

            while (rs.next()) {
                Integer id = rs.getInt("id");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                Integer age = rs.getInt("age");
                String type = rs.getString("type");

                System.out.println("Profesorul cu id-ul " + id + " este " + first_name + " " + last_name
                        + " cu varsta de " + age + " si cu tipul: " + type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void insertNewTeacher(Connection connection) {
        try {
            Statement stmt = connection.createStatement();
            Integer result = stmt.executeUpdate("INSERT INTO teachers(first_name, last_name,age,type) " +
                    "VALUES(\"Elena\",\"Serban\",55,\"conf.\")");
            if (result == 1) {
                System.out.println("S-a intregistrat cu succes");
            } else {
                System.out.println("Nu s-a inregistrat cu succes!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertNewTeacherFromKeyboard(Connection connection, String first_name, String last_name,
                                                    Integer age, String type) {
        String sql = ("INSERT INTO teachers(first_name, last_name, age, `type`)VALUES(?,?,?,?)");
        int result = 0;

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, first_name);
            stmt.setString(2, last_name);
            stmt.setInt(3, age);
            stmt.setString(4, type);
            result = stmt.executeUpdate();

            if (result == 1) {
                System.out.println("S-a intregistrat cu succes");
            } else {
                System.out.println("Nu s-a inregistrat cu succes!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void searchForTeacher(Connection connection, String last_name) {
        String sql = ("SELECT * from teachers WHERE last_name=?");

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, last_name);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                Integer age = resultSet.getInt(4);
                String type = resultSet.getString(5);

                System.out.println("Display results: ");
                System.out.println("Id : " + id);
                System.out.println("First name search result: " + firstName);
                System.out.println("Last name search result: " + lastName);
                System.out.println("Age: " + age);
                System.out.println("Type: " + type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteFromKeyboardATeacher(Connection connection, Integer id) {
        String sql = "DELETE FROM teachers WHERE id = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            int resultSet = stmt.executeUpdate();

            if (resultSet == 1) {
                System.out.println("S-a sters cu succes");
            } else {
                System.out.println("Nu s-a sters cu succes!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
