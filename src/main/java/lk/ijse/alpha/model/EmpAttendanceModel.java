package lk.ijse.alpha.model;

import lk.ijse.alpha.db.DBConnection;
import lk.ijse.alpha.dto.EmpAttendanceDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpAttendanceModel {
    public String saveAttendance(EmpAttendanceDto empAttendanceDto) throws ClassNotFoundException , SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Employee_Attendance VALUES(?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, empAttendanceDto.getAttId());
        statement.setString(2, empAttendanceDto.getEmpId());
        statement.setString(3, empAttendanceDto.getDateTime());
        statement.setString(4, empAttendanceDto.getDuration());

        return statement.executeUpdate() > 0 ? "Successfully Saved" : "Fail";
    }
    public String updateAttendance(EmpAttendanceDto empAttendanceDto) throws ClassNotFoundException , SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE Employee_Attendance SET employee_id = ? , date_time = ? , duration = ? WHERE attendance_id = ? , ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, empAttendanceDto.getEmpId());
        statement.setString(2, empAttendanceDto.getDateTime());
        statement.setString(3, empAttendanceDto.getDuration());
        statement.setString(4, empAttendanceDto.getAttId());

        return statement.executeUpdate() > 0 ? "Successfully Updated" : "Fail";
    }
    public EmpAttendanceDto deleteAttendance(String attId) throws ClassNotFoundException , SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM Employee_Attendance WHERE attendance_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, attId);

        ResultSet rst = statement.executeQuery();

        if(rst.next()){
            EmpAttendanceDto dto = new EmpAttendanceDto(rst.getString("attendance_id"),
                    rst.getString("employee_id"),
                    rst.getString("date_time"),
                    rst.getString("duration")
                    );
            return dto;
        }
        return null;
    }
    public ArrayList<EmpAttendanceDto> getAll() throws ClassNotFoundException , SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Employee_Attendance";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet rst = statement.executeQuery();
        ArrayList<EmpAttendanceDto> empAttendanceDtos = new ArrayList<>();

        while (rst.next()){
            EmpAttendanceDto dto = new EmpAttendanceDto(rst.getString("attendance_id"),
                    rst.getString("employee_id"),
                    rst.getString("date_time"),
                    rst.getString("duration")
            );
            empAttendanceDtos.add(dto);
        }
        return empAttendanceDtos;
    }
}

