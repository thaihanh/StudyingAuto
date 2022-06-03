package dao;

import entity.Table;
import jdbc.SQLServerConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TableDAO {

    public List<Table> getInfo(){
        String sql = "SELECT * FROM INFORMATION_SCHEMA.COLUMNS";
        List<Table> list = new ArrayList();

        try (Connection con = SQLServerConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Table table = Table.builder()
                        .name(rs.getString("TABLE_NAME"))
                        .columnName(rs.getString("COLUMN_NAME"))
                        .dataType(rs.getString("DATA_TYPE"))
                        .build();
                list.add(table);
            }
            return list;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
