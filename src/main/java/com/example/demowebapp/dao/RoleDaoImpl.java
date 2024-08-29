package com.example.demowebapp.dao;

import com.example.demowebapp.model.Office;
import com.example.demowebapp.model.Role;
import com.example.demowebapp.model.User;
import com.example.demowebapp.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/*public class RoleDaoImpl implements RoleDao {
    @Override
    public Role findRoleById(int id) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Role role = null;
        try (Connection conn = DBUtils.getConnection();){
            pstmt = conn.prepareStatement("SELECT id, name, description from roles where id = ?");
            pstmt.setInt(1, id);

            rs = pstmt.executeQuery();
            while (rs.next()) {
                role = new Role(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException e){
            throw new RuntimeException(e);

        }
        return role;
    }

    @Override
    public Role findByUser(User user) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Role role = null;
        try (Connection conn = DBUtils.getConnection();){
            pstmt = conn.prepareStatement("SELECT id, name, description from roles where id = ?");
            pstmt.setInt(1, user.getRole().getId());

            rs = pstmt.executeQuery();
            while (rs.next()) {
                role = new Role(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException e){
            throw new RuntimeException(e);

        }
        return role;
    }
}*/
