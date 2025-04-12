package lk.ijse.alpha.model;

import lk.ijse.alpha.db.DBConnection;
import lk.ijse.alpha.dto.OrderPaymentDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderPaymentModel {
    public String saveOrderPayment(OrderPaymentDto orderPaymentDto) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Order_Payment VALUES (?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, orderPaymentDto.getOpId());
        statement.setString(2, orderPaymentDto.getSupId());
        statement.setString(3, orderPaymentDto.getSoId());
        statement.setDouble(4, orderPaymentDto.getAmount());
        statement.setString(5, orderPaymentDto.getPayType());

        return statement.executeUpdate() > 0 ? "Successfully Saved" : "Fail";

    }

    public String updateOrderPayment(OrderPaymentDto orderPaymentDto) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE Order_Payment SET supplier_id = ? , so_id = ? , amount = ? , op_pay_type = ? WHERE op_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, orderPaymentDto.getSupId());
        statement.setString(2, orderPaymentDto.getSoId());
        statement.setDouble(3, orderPaymentDto.getAmount());
        statement.setString(4, orderPaymentDto.getPayType());
        statement.setString(5, orderPaymentDto.getOpId());

        return statement.executeUpdate() > 0 ? "Successfully Updated" : "Fail";
    }
    public OrderPaymentDto deleteOrderPayment(String opId) throws ClassNotFoundException , SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM Order_Payment WHERE op_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, opId);

        ResultSet rst = statement.executeQuery();

        if(rst.next()){
            OrderPaymentDto dto = new OrderPaymentDto(rst.getString("op_id"),
                    rst.getString("supplier_id"),
                    rst.getString("so_id"),
                    rst.getDouble("amount"),
                    rst.getString("op_pay_type")
                    );
            return dto;
        }
        return null;
    }
    public ArrayList<OrderPaymentDto> getAll() throws ClassNotFoundException , SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Order_Payment";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet rst = statement.executeQuery();
        ArrayList<OrderPaymentDto> orderPaymentDtos = new ArrayList<>();

        while (rst.next()){
            OrderPaymentDto dto = new OrderPaymentDto(rst.getString("op_id"),
                    rst.getString("supplier_id"),
                    rst.getString("so_id"),
                    rst.getDouble("amount"),
                    rst.getString("op_pay_type")
            );
            orderPaymentDtos.add(dto);
        }
        return orderPaymentDtos;
    }
}
