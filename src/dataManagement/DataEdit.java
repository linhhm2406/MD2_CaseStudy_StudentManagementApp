package dataManagement;

import entity.*;
import java.sql.*;
import java.util.ArrayList;

public class DataEdit {
    public static final String SQL_DATABASE_NAME = "dbo.StudentManagement";

    ConnectionToSQLServer connectionToSqlServer = new ConnectionToSQLServer();
    private ResultSet result = null;

    private void getDataFromSQL(ArrayList<Student> list, String sql) {
        try {
            PreparedStatement preparedStatement = connectionToSqlServer.connection.prepareStatement(sql);
            result = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (result.next()) {
                int idSQL = result.getInt("ID");
                String firstNameSQL = result.getString("First Name").trim();
                String lastNameSQL = result.getString("Last Name").trim();
                String genderSQL = result.getString("Gender").trim();
                double gradeSQL = Double.parseDouble(result.getString("Grade"));
                String DOBSQL = result.getString("Date Of Birth").trim();
                String PhoneNumberSQL = result.getString("Phone Number").trim();

                list.add(new Student(idSQL, firstNameSQL, lastNameSQL, genderSQL, gradeSQL, DOBSQL, PhoneNumberSQL));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Student> importDataToMainArray(ArrayList<Student> list) {
        list.clear();
        String sql = "select * from " + SQL_DATABASE_NAME;
        getDataFromSQL(list, sql);
        return list;
    }

    public ArrayList<Student> importDataToSearchArray(String searchBy, String str, ArrayList<Student> list) {
        list.clear();
        String sql = "SELECT * FROM " + SQL_DATABASE_NAME + " WHERE " + searchBy + str;
        getDataFromSQL(list, sql);
        return list;
    }

    public void addStudentToSQL(Student student) {
        String sql = "INSERT INTO " + SQL_DATABASE_NAME + "\n VALUES (" +
                student.getId() + ",N'" +
                student.getFirstName() + "',N'" +
                student.getLastName() + "','" +
                student.getGender() + "'," +
                String.valueOf(student.getGrade()) + ",'" +
                student.getDateOfBirth() + "','" +
                student.getPhoneNumber() + "')";
        try {
            Statement statement = connectionToSqlServer.connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudentInSQL(int id) {
        String sql = "DELETE " + SQL_DATABASE_NAME + " WHERE ID = " + id;
        try {
            Statement statement = connectionToSqlServer.connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void changeInformationStudentInSQL(Student student) {
        String sql = "UPDATE " + SQL_DATABASE_NAME + " " +
                "SET [First Name] = N'" + student.getFirstName() + "'," +
                "[Last Name] = N'" + student.getLastName() + "'," +
                "Gender = '" + student.getGender() + "'," +
                "Grade =" + String.valueOf(student.getGrade()) + "," +
                "[Date Of Birth]='" + student.getDateOfBirth() + "'," +
                "[Phone Number] = '" + student.getPhoneNumber() + "' WHERE ID =" + student.getId();
        try {
            Statement statement = connectionToSqlServer.connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}