package lk.ijse.alpha.model;

import lk.ijse.alpha.db.DBConnection;
import lk.ijse.alpha.dto.UserDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserModel {

    public String saveUser(UserDto userDto) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO User VALUES(?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, userDto.getUserId());
        statement.setString(2, userDto.getUserName());
        statement.setString(3, userDto.getEmail());
        statement.setString(4, userDto.getPassword());
        statement.setString(5, userDto.getContact());
        statement.setString(6, userDto.getAddress());
        statement.setString(7, userDto.getRole());

        return statement.executeUpdate() > 0 ? "Successfully Saved" : "Fail";

    }

    public String UpdateUser(UserDto userDto) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE User SET user_name = ? , email = ? , password = ? , contact = ? , address = ? , role = ? WHERE user_id = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, userDto.getUserName());
        statement.setString(2, userDto.getEmail());
        statement.setString(3, userDto.getPassword());
        statement.setString(4, userDto.getContact());
        statement.setString(5, userDto.getAddress());
        statement.setString(6, userDto.getRole());
        statement.setString(7, userDto.getUserId());

        return statement.executeUpdate() > 0 ? "Successfully Updated" : "Fail";
    }

    public UserDto DeleteUser(String userId) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELETE FROM User WHERE user_id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, userId);

        ResultSet rst = statement.executeQuery();

        if (rst.next()) {
            UserDto dto = new UserDto(rst.getString("user_id"),
                    rst.getString("user_name"),
                    rst.getString("email"),
                    rst.getString("password"),
                    rst.getString("contact"),
                    rst.getString("address"),
                    rst.getString("role")
            );
            return dto;
        }
        return null;
    }
    public ArrayList<UserDto> getAll() throws ClassNotFoundException , SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM User";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet rst = statement.executeQuery();
        ArrayList<UserDto> userDtos = new ArrayList<>();

        while (rst.next()){
            UserDto dto = new UserDto(rst.getString("user_id"),
                    rst.getString("user_name"),
                    rst.getString("email"),
                    rst.getString("password"),
                    rst.getString("contact"),
                    rst.getString("address"),
                    rst.getString("role")
            );
            userDtos.add(dto);
        }
        return userDtos;
    }
}
