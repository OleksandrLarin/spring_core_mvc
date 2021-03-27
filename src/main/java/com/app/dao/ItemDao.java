package com.app.dao;

import com.app.model.Item;
import com.app.util.DbConnectionUtils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ItemDao implements Dao<Item> {
    @Override
    public Item findById(int id) {
        try (Connection connection = DbConnectionUtils.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM items WHERE id = ?;");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return convertToItem(resultSet);
            }
            return Item.builder().build();
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    private Item convertToItem(ResultSet resultSet) throws SQLException {
        return Item.builder()
                .name(resultSet.getString("name"))
                .description(resultSet.getString("description"))
                .status(resultSet.getString("status"))
                .priority(resultSet.getInt("priority"))
                .date(getDate(resultSet))
                .build();
    }

    private LocalDate getDate(ResultSet resultSet) throws SQLException {
        Date date = resultSet.getDate("date");
        return date == null ? null : date.toLocalDate();
    }

    @Override
    public List<Item> findAll() {
        try (Connection connection = DbConnectionUtils.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM items;");
            List<Item> items = new ArrayList<>();
            while (resultSet.next()) {
                items.add(convertToItem(resultSet));
            }
            return items;
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    @Override
    public void create(Item item) {
        try (Connection connection = DbConnectionUtils.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO items (name, description, status, priority, date) VALUES (?, ?, ?, ?, ?);");
            statement.setString(1, item.getName());
            statement.setString(2, item.getDescription());
            statement.setString(3, item.getStatus());
            statement.setInt(4, item.getPriority());
            statement.setDate(5, Date.valueOf(item.getDate()));
            statement.executeUpdate();
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    @Override
    public void update(Item item) {
        try (Connection connection = DbConnectionUtils.getConnection()) {

        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }

    @Override
    public void delete(int id) {
        try (Connection connection = DbConnectionUtils.getConnection()) {

        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
    }
}
