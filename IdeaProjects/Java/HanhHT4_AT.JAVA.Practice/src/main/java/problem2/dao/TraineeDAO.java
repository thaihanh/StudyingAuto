package problem2.dao;

import problem2.entities.Trainee;
import problem2.jdbc.SQLServerConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TraineeDAO {
    public boolean save(Trainee trainee) {

        String sql = "INSERT INTO [dbo].[Trainee] ([account] ,[full_name], [gender], [birth_date], [phone_number], [gpa]) VALUES (?,?,?,?,?,?)";

        int count = 0;
        try (Connection con = SQLServerConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, trainee.getAccount());
            ps.setObject(2, trainee.getFullName());
            ps.setObject(3, trainee.getGender());
            ps.setObject(4, trainee.getBirthDate());
            ps.setObject(5, trainee.getPhoneNumber());
            ps.setObject(6, trainee.getGpa());
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count > 0;
    }

    public boolean update(Trainee trainee){
        String sql = "UPDATE [dbo].[Trainee] SET [full_name] = ?, [gender] = ?, [birth_date] = ? ,[phone_number] = ?,[gpa] = ? ,[status] = ?" +
                " WHERE [account] = ?";
        int count = 0;
        try (Connection con = SQLServerConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, trainee.getFullName());
            ps.setObject(2, trainee.getGender());
            ps.setObject(3, trainee.getBirthDate());
            ps.setObject(4, trainee.getPhoneNumber());
            ps.setObject(5, trainee.getGpa());
            ps.setObject(6, trainee.getStatus());
            ps.setObject(7, trainee.getAccount());
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count > 0;
    }

    public boolean remove(){
        String sql = "DELETE FROM Trainee WHERE status = 'in-active'";
        int count = 0;
        try (Connection con = SQLServerConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count > 0;
    }

    public List<Trainee> findIncompletedTrainee(){
        String sql = "SELECT * FROM Trainee WHERE gpa < '6'";
        List<Trainee> list = new ArrayList<>();

        try (Connection con = SQLServerConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Trainee trainee = Trainee.builder()
                        .traineeId(rs.getInt("trainee_id"))
                        .account(rs.getString("account"))
                        .fullName(rs.getString("full_name"))
                        .gender(rs.getByte("gender"))
                        .birthDate(rs.getDate("birth_date"))
                        .phoneNumber(rs.getString("phone_number"))
                        .gpa(rs.getString("gpa"))
                        .status(rs.getString("status"))
                        .build();
                list.add(trainee);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Trainee> findExcellentTrainee(){
        String sql = "SELECT account, full_name, gender, birth_date, gpa FROM Trainee WHERE gpa BETWEEN '90' AND '100";
        List<Trainee> list = new ArrayList<>();

        try (Connection con = SQLServerConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Trainee trainee = Trainee.builder()
                        .account(rs.getString("account"))
                        .fullName(rs.getString("full_name"))
                        .gender(rs.getByte("gender"))
                        .birthDate(rs.getDate("birth_date"))
                        .gpa(rs.getString("gpa"))
                        .build();
                list.add(trainee);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
