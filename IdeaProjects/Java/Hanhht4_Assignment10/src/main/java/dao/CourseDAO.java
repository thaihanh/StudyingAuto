package dao;

import entity.Course;
import jdbc.SQLServerConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CourseDAO {

    public boolean insert(Course course){

        String sql = "INSERT INTO Course(Title, Credits) VALUES (?, ?)";

        int count = 0;
        try(Connection con = SQLServerConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setObject(1,course.getTitle());
            ps.setObject(2,course.getCredits());
            count = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count > 0;
    }
}
