package lk.ijse.alpha.model;

import lk.ijse.alpha.db.DBConnection;
import lk.ijse.alpha.dto.PurchaseOrderDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PurchaseOrderModel {

    public String saveOrder(PurchaseOrderDto purchaseOrderDto) throws ClassNotFoundException , SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO user VALUES(?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, purchaseOrderDto.getOrderId());
        statement.setString(2, purchaseOrderDto.getCustId());
        statement.setString(3, purchaseOrderDto.getOrderDate());
        statement.setDouble(4, purchaseOrderDto.getTotAmount());

        return statement.executeUpdate() > 0 ? "Successfully Saved" : "Fail";
    }
    public String updateOrder(PurchaseOrderDto purchaseOrderDto) throws ClassNotFoundException , SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE Purchase_Order SET customer_id = ? , order_date = ? , total_amount = ? WHERE order_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, purchaseOrderDto.getCustId());
        statement.setString(2, purchaseOrderDto.getOrderDate());
        statement.setDouble(3, purchaseOrderDto.getTotAmount());
        statement.setString(4, purchaseOrderDto.getOrderId());

        return statement.executeUpdate() > 0 ? "Successfully Updated" : "Fail";
    }
    public PurchaseOrderDto deleteOrder(String orderId) throws ClassNotFoundException , SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM Purchase_Order WHERE order_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, orderId);

        ResultSet rst = statement.executeQuery();

        if(rst.next()){
            PurchaseOrderDto dto = new PurchaseOrderDto(rst.getString("order_id"),
                    rst.getString("customer_id"),
                    rst.getString("order_date"),
                    rst.getDouble("total_amount")
                    );
            return dto;
        }
        return null;
    }
    public ArrayList<PurchaseOrderDto> getAll() throws ClassNotFoundException , SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Purchase_Order";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet rst = statement.executeQuery();
        ArrayList<PurchaseOrderDto> purchaseOrderDtos = new ArrayList<>();

        while (rst.next()){
            PurchaseOrderDto dto = new PurchaseOrderDto(rst.getString("order_id"),
                    rst.getString("customer_id"),
                    rst.getString("order_date"),
                    rst.getDouble("total_amount")
            );
            purchaseOrderDtos.add(dto);
        }
        return purchaseOrderDtos;
    }
}
