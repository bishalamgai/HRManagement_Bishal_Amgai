package com.example.hrmanagement_bishal_amgai;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import java.sql.*;

import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class EmployeeController implements Initializable {
    public TableColumn id;
    public TableColumn Name;
    public TableColumn Salary;
    public TableColumn Department;
    public TableView tableView;
    public TextField employeeNameTextField;
    public TextField salaryTextField;
    public TextField departmentTextField;
    ObservableList<Employee> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new
                PropertyValueFactory<Employee,Integer>("id"));
        Name.setCellValueFactory(new
                PropertyValueFactory<Employee,String>("Name"));
        Salary.setCellValueFactory(new
                PropertyValueFactory<Employee,Integer>("Salary"));
        Department.setCellValueFactory(new
                PropertyValueFactory<Employee,String>("Department"));
        tableView.setItems(list);
    }

    public void Viewdata(ActionEvent actionEvent) {
        // Establish a database connection
        String jdbcUrl = "jdbc:mysql://localhost:3306/hr_department";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
// Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM `employeetb`";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            tableView.getItems().clear();

// Populate the table with data from the database
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String Name = resultSet.getString("Name");
                int Salary = resultSet.getInt("Salary");
                String Department = resultSet.getString("Department");
                tableView.getItems().add(new Employee(id, Name, Salary,
                        Department));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void Insert(ActionEvent actionEvent) {
        String name = employeeNameTextField.getText();
        int salary = Integer.parseInt(salaryTextField.getText());
        String department = departmentTextField.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/hr_department";
        String dbUser = "root";
        String dbPassword = "";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            String query = "INSERT INTO employeetb (name, salary, department) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, salary);
            preparedStatement.setString(3, department);
            preparedStatement.executeUpdate();
            Viewdata(null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Update(ActionEvent actionEvent) {
        Employee selectedEmployee = (Employee) tableView.getSelectionModel().getSelectedItem();
        if (selectedEmployee == null) {
            // Handle the case where no employee is selected
            return;
        }

        String name = employeeNameTextField.getText();
        int salary = Integer.parseInt(salaryTextField.getText());
        String department = departmentTextField.getText();

        String jdbcUrl = "jdbc:mysql://localhost:3306/hr_department";
        String dbUser = "root";
        String dbPassword = "";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            String query = "UPDATE employeetb SET name=?, salary=?, department=? WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, salary);
            preparedStatement.setString(3, department);
            preparedStatement.setInt(4, selectedEmployee.getId());
            preparedStatement.executeUpdate();
            Viewdata(null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Delete(ActionEvent actionEvent) {
        Employee selectedEmployee = (Employee) tableView.getSelectionModel().getSelectedItem();
        if (selectedEmployee == null) {
            // Handle the case where no employee is selected
            return;
        }

        String jdbcUrl = "jdbc:mysql://localhost:3306/hr_department";
        String dbUser = "root";
        String dbPassword = "";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
            String query = "DELETE FROM employeetb WHERE id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, selectedEmployee.getId());
            preparedStatement.executeUpdate();
            Viewdata(null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

