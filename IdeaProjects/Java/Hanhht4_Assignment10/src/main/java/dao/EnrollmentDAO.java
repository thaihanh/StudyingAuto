package dao;

import entity.Enrollment;
import jdbc.SQLServerConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EnrollmentDAO {
    public boolean insert(Enrollment enrollment ){

        String sql = "INSERT INTO Enrollment(CourseId, StudentId, Grade) VALUES (?, ?, ?)";

        int count = 0;
        try(Connection con = SQLServerConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setObject(1,enrollment.getCourseId());
            ps.setObject(2,enrollment.getStudentId());
            ps.setObject(3,enrollment.getGrade());
            count = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count > 0;
    }
}
