package dao;

import entity.Student;
import jdbc.SQLServerConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDAO {


    public boolean insert(Student student){

        String sql = "INSERT INTO Student(LastName, FirstName, EnrollmentDate) VALUES (?, ?, ?)";

        int count = 0;
        try(Connection con = SQLServerConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setObject(1,student.getLastName());
            ps.setObject(2,student.getFirstName());
            ps.setObject(3,student.getEnrollmentDate());
            count = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count > 0;
    }

    public boolean updateEnrollmentDate(Student student){

        String sql = "UPDATE Student SET EnrollmentDate = ? WHERE Id = ?";

        int count = 0;
        try(Connection con = SQLServerConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setObject(1,student.getEnrollmentDate());
            ps.setObject(2,student.getId());
            count = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count > 0;
    }


}
