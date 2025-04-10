package lk.ijse.alpha.model;

import lk.ijse.alpha.db.DBConnection;
import lk.ijse.alpha.dto.CustomerDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerModel {
    public String saveCustomer(CustomerDto customerDto) throws ClassNotFoundException , SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Customer VALUES(?,?,?,?) ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1 , customerDto.getCustId());
        statement.setString(2, customerDto.getCustName());
        statement.setString(3, customerDto.getCustContact());
        statement.setString(4, customerDto.getCustAddresss());

        return statement.executeUpdate() > 0 ? "Successfully Saved" : "Fail";
    }

    public String updateCustomer(CustomerDto customerDto) throws ClassNotFoundException , SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE Customer SET customer_name = ? , customer_contact = ? ,customer_address WHERE customer_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, customerDto.getCustName());
        statement.setString(2, customerDto.getCustContact());
        statement.setString(3, customerDto.getCustAddresss());
        statement.setString(4 , customerDto.getCustId());

        return statement.executeUpdate() > 0 ? "Successfully Updated" : "Fail";
    }
    public CustomerDto deleteCustomer(String custId) throws ClassNotFoundException , SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM Customer WHERE customer_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, custId);

        ResultSet rst = statement.executeQuery();

        if(rst.next()){
            CustomerDto dto = new CustomerDto(rst.getString("customer_id"),
                    rst.getString("customer_name"),
                    rst.getString("customer_contact"),
                    rst.getString("customer_address")
                    );
            return dto;
        }
        return null;
    }
    public ArrayList<CustomerDto> getAll() throws ClassNotFoundException , SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Customer";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet rst = statement.executeQuery();
        ArrayList<CustomerDto> customerDtos = new ArrayList<>();

        while (rst.next()){
            CustomerDto dto = new CustomerDto(rst.getString("customer_id"),
                    rst.getString("customer_name"),
                    rst.getString("customer_contact"),
                    rst.getString("customer_address")
            );
            customerDtos.add(dto);
        }
        return customerDtos;
    }

}
