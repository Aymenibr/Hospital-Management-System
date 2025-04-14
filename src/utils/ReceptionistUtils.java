package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ReceptionistUtils {
    public static void loadReceptionistData(DefaultTableModel model, Connection connection, boolean includePassword) {
        String sql = includePassword
                ? "select count,joining,id,name,age,gender,blood,email,phone,address,status,username,password from receptionist"
                : "select count,joining,id,name,age,gender,blood,email,phone,address,status,username from receptionist";
        
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            int columnCount = includePassword ? 13 : 12;
            Object[] columnData = new Object[columnCount];

            while (rs.next()) {
                columnData[0] = rs.getInt("count");
                columnData[1] = rs.getString("joining");
                columnData[2] = rs.getString("id");
                columnData[3] = rs.getString("name");
                columnData[4] = rs.getInt("age");
                columnData[5] = rs.getString("gender");
                columnData[6] = rs.getString("blood");
                columnData[7] = rs.getString("email");
                columnData[8] = rs.getString("phone");
                columnData[9] = rs.getString("address");
                columnData[10] = rs.getString("status");
                columnData[11] = rs.getString("username");
                if (includePassword) {
                    columnData[12] = rs.getString("password");
                }
                model.addRow(columnData);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
