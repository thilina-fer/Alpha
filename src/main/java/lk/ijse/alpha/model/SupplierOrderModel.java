package lk.ijse.alpha.model;

import lk.ijse.alpha.db.DBConnection;
import lk.ijse.alpha.dto.SupplierDto;
import lk.ijse.alpha.dto.SupplierOrderDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierOrderModel {
    public String saveSupplierOrde(SupplierOrderDto supplierOrderDto) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Supplier_Order VALUES(?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, supplierOrderDto.getSoId());
        statement.setString(2, supplierOrderDto.getSupId());
        statement.setString(3, supplierOrderDto.getUserId());
        statement.setString(4, supplierOrderDto.getDate());
        statement.setString(5, supplierOrderDto.getItemId());

        return statement.executeUpdate() > 0 ? "Successfully Saved" : "Fail";
    }

    public String updateSupplierOrde(SupplierOrderDto supplierOrderDto) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE Supplier_Order SET supplier_id = ? , user_id = ? , date = ? , item_id = ? WHERE so_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, supplierOrderDto.getSupId());
        statement.setString(2, supplierOrderDto.getUserId());
        statement.setString(3, supplierOrderDto.getDate());
        statement.setString(4, supplierOrderDto.getItemId());
        statement.setString(5, supplierOrderDto.getSoId());

        return statement.executeUpdate() > 0 ? "Successfully Updated" : "Fail";
    }
    public SupplierOrderDto deleteSupplierOrder(String soId) throws ClassNotFoundException , SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM Supplier_Order WHERE so_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, soId);

        ResultSet rst = statement.executeQuery();

        if(rst.next()){
            SupplierOrderDto dto = new SupplierOrderDto(rst.getString("so_id"),
                    rst.getString("supplier_id"),
                    rst.getString("user_id"),
                    rst.getString("date"),
                    rst.getString("item_id")
                    );
            return dto;
        }
        return null;
    }
    public ArrayList<SupplierOrderDto> getAll() throws ClassNotFoundException , SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Supplier_Order";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet rst = statement.executeQuery();
        ArrayList<SupplierOrderDto> supplierOrderDtos = new ArrayList<>();

        while (rst.next()){
            SupplierOrderDto dto = new SupplierOrderDto(rst.getString("so_id"),
                    rst.getString("supplier_id"),
                    rst.getString("user_id"),
                    rst.getString("date"),
                    rst.getString("item_id")
            );
            supplierOrderDtos.add(dto);
        }
        return supplierOrderDtos;

    }
}
