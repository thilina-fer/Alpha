package lk.ijse.alpha.model;

import lk.ijse.alpha.db.DBConnection;
import lk.ijse.alpha.dto.ItemDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemModel {
    public String saveItem(ItemDto itemDto) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO Item VALUES(?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, itemDto.getItemId());
        statement.setString(2, itemDto.getItemName());
        statement.setInt(3, itemDto.getQuantity());
        statement.setDouble(4, itemDto.getBuyPrice());
        statement.setDouble(5, itemDto.getSellPrice());

        return statement.executeUpdate() > 0 ? "Successfully Saved" : "Fail";
    }

    public String updateItem(ItemDto itemDto) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "UPDATE Item SET item_name = ? , quantity = ? , buying_price = ? , selling_price = ? WHERE item_id = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, itemDto.getItemName());
        statement.setInt(2, itemDto.getQuantity());
        statement.setDouble(3, itemDto.getBuyPrice());
        statement.setDouble(4, itemDto.getSellPrice());
        statement.setString(5, itemDto.getItemId());

        return statement.executeUpdate() > 0 ? "Successfully Updated" : "Fail";

    }

    public ItemDto deleteItem(String itemId) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "DELET FROM Item WHERE item_id = ? ";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, itemId);

        ResultSet rst = statement.executeQuery();

        if (rst.next()) {
            ItemDto dto = new ItemDto(rst.getString("item_id"),
                    rst.getString("item_name"),
                    rst.getInt("quantity"),
                    rst.getDouble("buying_price"),
                    rst.getDouble("selling_price")
            );
            return dto;
        }
        return null;
    }

    public ArrayList<ItemDto> getAll() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getInstance().getConnection();
        String sql = "SELECT * FROM Item";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet rst = statement.executeQuery();
        ArrayList<ItemDto> itemDtos = new ArrayList<>();

        while (rst.next()) {
            ItemDto dto = new ItemDto(rst.getString("item_id"),
                    rst.getString("item_name"),
                    rst.getInt("quantity"),
                    rst.getDouble("buying_price"),
                    rst.getDouble("selling_price")
            );
            itemDtos.add(dto);
        }
        return itemDtos;
    }
}
