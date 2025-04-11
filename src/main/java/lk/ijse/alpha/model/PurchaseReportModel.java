package lk.ijse.alpha.model;

import lk.ijse.alpha.db.DBConnection;
import lk.ijse.alpha.dto.PurchaseReportDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PurchaseReportModel {
    public String saveReport(PurchaseReportDto purchaseReportDto) throws ClassNotFoundException, SQLException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Purchase_Report VALUES(?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, purchaseReportDto.getReportId());
        statement.setString(2, purchaseReportDto.getOrderId());
        statement.setString(3, purchaseReportDto.getDescription());

        return statement.executeUpdate() > 0 ? "Successfully Saved" : "Fail";
    }

    public String updateReport(PurchaseReportDto purchaseReportDto) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE Purchase_Report SET order_id = ? , report_description = ? , report_id = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, purchaseReportDto.getOrderId());
        statement.setString(2, purchaseReportDto.getDescription());
        statement.setString(3, purchaseReportDto.getReportId());

        return statement.executeUpdate() > 0 ? "Successfully Updated" : "Fail";
    }

    public PurchaseReportDto deleteReport(String reportId) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM Purchase_Report WHERE report_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, reportId);

        ResultSet rst = statement.executeQuery();

        if (rst.next()) {
            PurchaseReportDto dto = new PurchaseReportDto(rst.getString("report_id"),
                    rst.getString("order_id"),
                    rst.getString("report_description")
            );
            return dto;
        }
        return null;
    }
    public ArrayList<PurchaseReportDto> getAll() throws ClassNotFoundException , SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Purchase_Report";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet rst = statement.executeQuery();
        ArrayList<PurchaseReportDto> purchaseReportDtos = new ArrayList<>();

        while (rst.next()){
            PurchaseReportDto dto = new PurchaseReportDto(rst.getString("report_id"),
                    rst.getString("order_id"),
                    rst.getString("report_description")
            );
            purchaseReportDtos.add(dto);
        }
        return purchaseReportDtos;
    }
}