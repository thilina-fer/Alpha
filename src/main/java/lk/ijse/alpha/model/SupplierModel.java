package lk.ijse.alpha.model;

import lk.ijse.alpha.db.DBConnection;
import lk.ijse.alpha.dto.SupplierDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierModel {
    public String saveSupplier(SupplierDto supplierDto) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Supplier VALUES(?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, supplierDto.getSupId());
        statement.setString(2, supplierDto.getSupName());
        statement.setString(3, supplierDto.getSupContact());

        return statement.executeUpdate() > 0 ? "Successfully Saved" : "Fail";
    }

    public String updateSupplier(SupplierDto supplierDto) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE Supplier SET suplier_name = ? , supplier_contact = ? WHERE suplier_id = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, supplierDto.getSupName());
        statement.setString(2, supplierDto.getSupContact());
        statement.setString(3, supplierDto.getSupId());

        return statement.executeUpdate() > 0 ? "Successfully Updated" : "Fail";

    }
    public SupplierDto deleteSupllier(String supId) throws ClassNotFoundException , SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM Supplier WHERE supplier_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, supId);

        ResultSet rst = statement.executeQuery();

        if(rst.next()){
            SupplierDto dto = new SupplierDto(rst.getString("supplier_id"),
                    rst.getString("supplier_name"),
                    rst.getString("supplier_contact")
                    );
            return dto;
        }
        return null;
    }
    public ArrayList<SupplierDto> getAll() throws ClassNotFoundException , SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Supplier";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet rst = statement.executeQuery();
        ArrayList<SupplierDto> supplierDtos = new ArrayList<>();

        while (rst.next()){
            SupplierDto dto = new SupplierDto(rst.getString("supplier_id"),
                    rst.getString("supplier_name"),
                    rst.getString("supplier_contact")
            );
            supplierDtos.add(dto);
        }
        return supplierDtos;
    }
}
