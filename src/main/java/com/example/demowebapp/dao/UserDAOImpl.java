package com.example.demowebapp.dao;

import com.example.demowebapp.model.Role;
import com.example.demowebapp.model.User;
import com.example.demowebapp.utils.DBUtils;
import com.example.demowebapp.utils.EncryptDecryptUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class UserDAOImpl implements UserDAO {
  //  private final RoleDao roleDao= new RoleDaoImpl();
    @Override
    public User findUserByEmail(String email) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try (Connection conn = DBUtils.getConnection()) {
            pstmt =
                    conn.prepareStatement(String.format(
                            "SELECT * FROM users where email = '%s'", email));

          rs =  pstmt.executeQuery();

            if (rs.next()) {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setEmail(rs.getString(3));
                user.setActive(rs.getString(4).equals("Y"));
                user.setPassword(rs.getString(5));
                int roleId = rs.getInt(6);
        //        user.setRole(roleDao.findRoleById(roleId));
                user.setCreatedTs(rs.getTimestamp(7));
                user.setUpdatedTs(rs.getTimestamp(8));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Bad connection", e);
        } finally {
            DBUtils.close(null, null, pstmt, rs);
        }
        return null;
    }

    @Override
    public boolean createUser(User user) {
        PreparedStatement pstmt = null;
        try (Connection conn = DBUtils.getConnection()) {
            pstmt =
                    conn.prepareStatement(String.format(
                            "INSERT INTO users (name, email, password, role) VALUES ('%s', '%s', '%s', 3)",
                            user.getName(), user.getEmail(), EncryptDecryptUtils.encrypt(user.getPassword())));

            return pstmt.executeUpdate() == 1;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("creation User problem", e);
        } finally {
            DBUtils.close(null, null, pstmt, null);
        }
    }

    @Override
    public boolean activate(User user) {
        PreparedStatement pstmt = null;
        try (Connection conn = DBUtils.getConnection()) {
            pstmt = conn.prepareStatement("UPDATE users SET is_active = 'Y', update_ts = CURRENT_TIMESTAMP WHERE users.email = ?");

            pstmt.setString(1, user.getEmail());
            return pstmt.executeUpdate() == 1;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Activation User problem", e);
        } finally {
            DBUtils.close(null, null, pstmt, null);
        }
    }

    @Override
    public Set<User> findAll() {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Set<User> users = new HashSet<>();
        try (Connection conn = DBUtils.getConnection();) {
            pstmt =
                    conn.prepareStatement(
                            "SELECT * FROM users ");

            rs =  pstmt.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setEmail(rs.getString(3));
                user.setActive(rs.getString(4).equals("Y"));
                user.setPassword(rs.getString(5));
                int roleId = rs.getInt(6);
       //         user.setRole(roleDao.findRoleById(roleId));
                user.setCreatedTs(rs.getTimestamp(7));
                user.setUpdatedTs(rs.getTimestamp(8));
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Find all users exception", e);
        } finally {
            DBUtils.close(null, null, pstmt, rs);
        }
        return users;
    }
}
