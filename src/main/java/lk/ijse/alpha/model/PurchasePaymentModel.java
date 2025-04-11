package lk.ijse.alpha.model;

import lk.ijse.alpha.db.DBConnection;
import lk.ijse.alpha.dto.PurchasePaymentDto;
import lk.ijse.alpha.dto.PurchaseReportDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PurchasePaymentModel {
    public String savePurchasePPayment(PurchasePaymentDto purchasePaymentDto) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Purchase_Report VALUES(?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, purchasePaymentDto.getPaymentId());
        statement.setString(2, purchasePaymentDto.getOrderId());
        statement.setString(3, purchasePaymentDto.getPaymentType());
        statement.setString(4, purchasePaymentDto.getPayDayTime());

        return statement.executeUpdate() > 0 ? "Successfully Saved" : "Fail";

    }

    public String updatePurchasePPayment(PurchasePaymentDto purchasePaymentDto) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE Purchase_Payment SET order_id = ? , payment_type = ? , pay_day_time WHERE payment_id = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, purchasePaymentDto.getOrderId());
        statement.setString(2, purchasePaymentDto.getPaymentType());
        statement.setString(3, purchasePaymentDto.getPayDayTime());
        statement.setString(4, purchasePaymentDto.getPaymentId());

        return statement.executeUpdate() > 0 ? "Successfully Updated" : "Fail";

    }

    public PurchasePaymentDto deletePurchasePayment(String paymentId) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM Purchase_Payment WHERE payment_id  = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, paymentId);

        ResultSet rst = statement.executeQuery();

        if (rst.next()) {
            PurchasePaymentDto dto = new PurchasePaymentDto(rst.getString("payment_id"),
                    rst.getString("orderId"),
                    rst.getString("payment_type"),
                    rst.getString("pay_day_time")
            );
            return dto;
        }
        return null;
    }

    public ArrayList<PurchasePaymentDto> getAll() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Purchase_Payment";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet rst = statement.executeQuery();
        ArrayList<PurchasePaymentDto> purchasePaymentDtos = new ArrayList<>();

        while (rst.next()) {
            PurchasePaymentDto dto = new PurchasePaymentDto(rst.getString("payment_id"),
                    rst.getString("orderId"),
                    rst.getString("payment_type"),
                    rst.getString("pay_day_time")
            );
            purchasePaymentDtos.add(dto);
        }
        return purchasePaymentDtos;
    }
}
