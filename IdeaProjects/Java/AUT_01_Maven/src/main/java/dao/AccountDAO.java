package dao;

import entity.Account;
import jdbc.SQLServerConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccountDAO {
    public List<Account> getAll(){
        String sql = "SELECT * FROM account";
        List<Account> list = new ArrayList<>();

        try (Connection con = SQLServerConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Account account = Account.builder()
                        .id(rs.getInt("id"))
                        .username(rs.getString("username"))
                        .password(rs.getString("password"))
                        .type(rs.getInt("type"))
                        .status(rs.getInt("status"))
                        .build();
                list.add(account);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Account getOne(String username){

        String sql = "SELECT * FROM account WHERE username = ?";
        List<Account> list = new ArrayList<>();

        try (Connection con = SQLServerConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Account account = Account.builder()
                        .id(rs.getInt("id"))
                        .username(rs.getString("username"))
                        .password(rs.getString("password"))
                        .type(rs.getInt("type"))
                        .status(rs.getInt("status"))
                        .build();
                return account;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean add(Account account){

        String sql = "INSERT INTO account(username, password, type, status) VALUES (?, ?, ?, ?)";

        int count = 0;
        try (Connection con = SQLServerConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, account.getUsername());
            ps.setObject(2, account.getPassword());
            ps.setObject(3, account.getType());
            ps.setObject(4, account.getStatus());
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count > 0;
    }

    public boolean update(Account account){
        String sql = "UPDATE account SET password = ?, type = ?, status = ? WHERE username = ?";
        int count = 0;
        try (Connection con = SQLServerConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, account.getPassword());
            ps.setObject(2, account.getType());
            ps.setObject(3, account.getStatus());
            ps.setObject(4, account.getUsername());
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count > 0;
    }

    public boolean delete(Account account){
        String sql = "DELETE FROM account WHERE username = ?";
        int count = 0;
        try (Connection con = SQLServerConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, account.getUsername());
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count > 0;
    }

    public List<Account> search(String keyword){
        String sql = "SELECT * FROM account WHERE username LIKE ?";
        String keywordParam = "%" + keyword + "%";
        List<Account> list = new ArrayList<>();
        try (Connection con = SQLServerConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, keywordParam);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Account account1 = Account.builder()
                        .id(rs.getInt("id"))
                        .username(rs.getString("username"))
                        .password(rs.getString("password"))
                        .type(rs.getInt("type"))
                        .status(rs.getInt("status"))
                        .build();
                list.add(account1);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Account> search2(int from, int to){
        String sql = "SELECT * FROM account WHERE type BETWEEN ? AND ?";
        List<Account> list = new ArrayList<>();
        try (Connection con = SQLServerConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, from, to);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Account account1 = Account.builder()
                        .id(rs.getInt("id"))
                        .username(rs.getString("username"))
                        .password(rs.getString("password"))
                        .type(rs.getInt("type"))
                        .status(rs.getInt("status"))
                        .build();
                list.add(account1);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
