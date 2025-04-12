package lk.ijse.alpha.model;

import lk.ijse.alpha.db.DBConnection;
import lk.ijse.alpha.dto.PreOrderDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PreOrderModel {
    public String savePreOrder(PreOrderDto preOrderDto) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Pre_Order_Manage VALUES (?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, preOrderDto.getPreOrderId());
        statement.setString(2, preOrderDto.getUserId());
        statement.setString(3, preOrderDto.getItemId());
        statement.setDouble(4, preOrderDto.getAdvance());

        return statement.executeUpdate() > 0 ? "Successfully Saved" : "Fail";
    }

    public String updatePreOrder(PreOrderDto preOrderDto) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE Pre_Order_Manage SET user_id = ? , item_id = ? , addvance = ?  WHERE pre_order_id = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, preOrderDto.getUserId());
        statement.setString(2, preOrderDto.getItemId());
        statement.setDouble(3, preOrderDto.getAdvance());
        statement.setString(4, preOrderDto.getPreOrderId());

        return statement.executeUpdate() > 0 ? "Successfully Updated" : "Fail";

    }
    public PreOrderDto deletePreOrder(String preOrderId) throws ClassNotFoundException , SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM Pre_Order_Manage WHERE pre_order_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, preOrderId);

        ResultSet rst = statement.executeQuery();
        ArrayList<PreOrderDto> preOrderDtos = new ArrayList<>();

        while (rst.next()){
            PreOrderDto dto = new PreOrderDto(rst.getString("pre_order_id"),
                    rst.getString("user_id"),
                    rst.getString("item_id"),
                    rst.getDouble("advane_payment")
                    );
            return dto;
        }
        return null;
    }
    public ArrayList<PreOrderDto> getAll() throws ClassNotFoundException , SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Pre_Order_Manage";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet rst = statement.executeQuery();
        ArrayList<PreOrderDto> preOrderDtos = new ArrayList<>();

        while (rst.next()){
            PreOrderDto dto = new PreOrderDto(rst.getString("pre_order_id"),
                    rst.getString("user_id"),
                    rst.getString("item_id"),
                    rst.getDouble("advance_payment")
            );
            preOrderDtos.add(dto);
        }
        return preOrderDtos;
    }
}
