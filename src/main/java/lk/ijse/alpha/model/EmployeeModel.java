package lk.ijse.alpha.model;

import lk.ijse.alpha.db.DBConnection;
import lk.ijse.alpha.dto.EmployeeDto;

import java.lang.reflect.AnnotatedArrayType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeModel {
    public String saveEmployee(EmployeeDto employeeDto) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Employee VALUES(?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, employeeDto.getEmpId());
        statement.setString(2, employeeDto.getEmpName());
        statement.setString(3, employeeDto.getEmpContact());
        statement.setString(3, employeeDto.getEmpAddress());
        statement.setInt(5 , employeeDto.getEmpAge());
        statement.setDouble(6, employeeDto.getSalary());

        return statement.executeUpdate()  > 0 ? "Successfullufy Saved " : "Fail";
    }
    public String updateEmployee(EmployeeDto employeeDto) throws ClassNotFoundException , SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE Employee SET emp_name = ? , empp_contact = ? , emp_address = ? , emp_age = ? , salary = ? , WHERE employee_id  = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, employeeDto.getEmpName());
        statement.setString(2, employeeDto.getEmpContact());
        statement.setString(3, employeeDto.getEmpAddress());
        statement.setInt(4 , employeeDto.getEmpAge());
        statement.setDouble(5, employeeDto.getSalary());
        statement.setString(6, employeeDto.getEmpId());

        return statement.executeUpdate()  > 0 ? "Successfullufy Updated " : "Fail";
    }
    public EmployeeDto deleteEmployee (String empId) throws ClassNotFoundException , SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM Employee WHERE employee_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet rst = statement.executeQuery();

        if(rst.next()){
            EmployeeDto dto = new EmployeeDto(rst.getString("employee_id"),
                    rst.getString("emp_name"),
                    rst.getString("emp_contact"),
                    rst.getString("emp_address"),
                    rst.getInt("age"),
                    rst.getDouble("salary")
                    );
            return dto;
        }
        return null;
    }
    public ArrayList<EmployeeDto> getAll() throws ClassNotFoundException , SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Employee";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet rst = statement.executeQuery();
        ArrayList<EmployeeDto> employeeDtos = new ArrayList<>();

        while (rst.next()){
            EmployeeDto dto = new EmployeeDto(rst.getString("employee_id"),
                    rst.getString("emp_name"),
                    rst.getString("emp_contact"),
                    rst.getString("emp_address"),
                    rst.getInt("age"),
                    rst.getDouble("salary")
            );
            employeeDtos.add(dto);
        }
        return employeeDtos;
    }
}
