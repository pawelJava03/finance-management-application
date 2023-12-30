package pl.apap.budget_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseService {


    private static final String JDBC_URL = "jdbc:sqlite:/Users/apap/IdeaProjects/budget_management/moneydb.db";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL);
    }

    public void newUser(String name, String surname, String email, String password) {
        if (userExists(email)) {
            System.out.println("User with that email already exists");
            return;
        }

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO finanse (name, surname, email, password) VALUES (?, ?, ?, ?)")) {

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, surname);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, password);
            preparedStatement.executeUpdate();

            System.out.println("Account created");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean userExists(String email) {
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement("SELECT * FROM finanse WHERE email = ?")) {
            stmt.setString(1, email);

            try (ResultSet resultSet = stmt.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Błąd podczas sprawdzania użytkownika", e);
        }
    }


    public boolean checkUser(String email, String password) {
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement("SELECT * FROM finanse WHERE email = ? AND password = ?")) {
            stmt.setString(1, email);
            stmt.setString(2, password);

            try (ResultSet resultSet = stmt.executeQuery()) {
                return resultSet.next();
            }
        } catch (SQLException e) {
            throw new RuntimeException("Błąd podczas sprawdzania użytkownika", e);
        }
    }

    private Long id;
    private String name, surname, email;

    private Double yoursMoney, yoursInvestment, totalEarned, totalLoses;
    public void loggedUserInfo(String email) {
        try (Connection connection = getConnection();
             PreparedStatement stmt = connection.prepareStatement("SELECT * FROM finanse WHERE email = ?;")) {
            stmt.setString(1, email);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    name = resultSet.getString("name");
                    surname = resultSet.getString("surname");
                    email = resultSet.getString("email");
                    yoursMoney = resultSet.getDouble("yours_money");
                    yoursInvestment = resultSet.getDouble("yours_investment");
                    totalEarned = resultSet.getDouble("total_earned");
                    totalLoses = resultSet.getDouble("total_loses");
                    System.out.println(name + " " + surname + " " + email);
                } else {
                    System.out.println("Blad podczas zapisywania do zmiennych");
                }
            } catch (SQLException e) {
                throw new RuntimeException("Blad podczas sprawdzania");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
