package org.example.database.jdbc;

import org.example.domain.employee.Access;
import org.example.domain.employee.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class JdbcRunner {
    public static void main(String[] args) throws SQLException {
        Class<Driver> driverClass = Driver.class;
        Employee employee = new Employee(1,"Maxim","Nekrasov","example@org",1250.15,"root123",Access.SECOND);

        try(Connection connection = ConnectionManager.open()) {

            createDatabase(connection);
            System.out.println("database created.");

            useDatabase(connection);
            System.out.println("database use.");

            createTable(connection);
            System.out.println("table create.");

            insertData(connection, employee);
            System.out.println("insert employee.");

            readData(connection);
            System.out.println("reading data.");
        }


    }
    
     private static void createDatabase(Connection connection) throws SQLException {
        String createDatabaseSQL = """
                CREATE DATABASE IF NOT EXISTS EmployeeDB;
                """;
        try (PreparedStatement statement = connection.prepareStatement(createDatabaseSQL)) {
            statement.execute();
        }
    }

    private static void useDatabase(Connection connection) throws SQLException {
        String useDatabaseSQL = """
                USE EmployeeDB;
                """;
        try (PreparedStatement statement = connection.prepareStatement(useDatabaseSQL)) {
            statement.execute();
        }
    }

    private static void createTable(Connection connection) throws SQLException {
        String createTableSQL = """
                CREATE TABLE IF NOT EXISTS employees (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255), surname VARCHAR(255), mail VARCHAR(255), salary VARCHAR(255),password DOUBLE, access VARCHAR(255));
                """;
        try (PreparedStatement statement = connection.prepareStatement(createTableSQL)) {
            statement.execute();
        }
    }

    /**
     * Добавление данных в таблицу employees
     * @param connection Соединение с БД
     * @param employee employee
     * @throws SQLException Исключение при выполнении запроса
     */
    private static void insertData(Connection connection, Employee employee) throws SQLException {
        String insertDataSQL = """
                INSERT INTO employees (id, name, surname, mail, salary, password, acces) VALUES (?, ?, ?, ?, ?, ?, ?);
                """;
        try (PreparedStatement statement = connection.prepareStatement(insertDataSQL)) {
            statement.setInt(1, employee.getId());
            statement.setString(2, employee.getName());
            statement.setString(3, employee.getSurname());
            statement.setString(4, employee.getMail());
            statement.setDouble(5, employee.getSalary());
            statement.setString(6, employee.getPassword());
            statement.setString(7, String.valueOf(employee.getAccess()));
            statement.executeUpdate();
        }
    }

    /**
     * Чтение данных из таблицы employees
     * @param connection Соединение с БД
     * @return Коллекция employees
     * @throws SQLException Исключение при выполнении запроса
     */
    private static Collection<Employee> readData(Connection connection) throws SQLException {
        ArrayList<Employee> studentsList = new ArrayList<>();
        String readDataSQL = """
                SELECT * FROM employees;
                """;
        try (PreparedStatement statement = connection.prepareStatement(readDataSQL)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String mail = resultSet.getString("mail");
                double salary = resultSet.getDouble("salary");
                String password = resultSet.getString("password");
                Access access = Access.valueOf(resultSet.getString("access"));
                studentsList.add(new Employee(id, name, surname, mail, salary, password,access));
            }
            return studentsList;
        }
    }

    /**
     * Обновление данных в таблице employees по идентификатору
     * @param connection Соединение с БД
     * @param employee Студент
     * @throws SQLException Исключение при выполнении запроса
     */
    private static void updateData(Connection connection, Employee employee) throws SQLException {
        String updateDataSQL = """
                UPDATE students SET name=?, surname=?, mail=?, sallary=?, password=?, acces=? WHERE id=?;
                """;
        try (PreparedStatement statement = connection.prepareStatement(updateDataSQL)) {
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getSurname());
            statement.setString(3, employee.getMail());
            statement.setDouble(4, employee.getSalary());
            statement.setString(5, employee.getPassword());
            statement.setString(6, String.valueOf(employee.getAccess()));
            statement.executeUpdate();
        }
    }

    /**
     * Удаление записи из таблицы employees по идентификатору
     * @param connection Соединение с БД
     * @param id Идентификатор записи
     * @throws SQLException Исключение при выполнении запроса
     */
    private static void deleteData(Connection connection, int id) throws SQLException {
        String deleteDataSQL = """
                DELETE FROM students WHERE id=?;
                """;
        try (PreparedStatement statement = connection.prepareStatement(deleteDataSQL)) {
            statement.setLong(1, id);
            statement.executeUpdate();
        }
    }
}
