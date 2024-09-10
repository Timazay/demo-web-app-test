package com.example.demowebapp.dao;

/*
import com.example.demowebapp.model.Office;
import com.example.demowebapp.model.User;
import com.example.demowebapp.utils.DBUtils;
import com.example.demowebapp.utils.EncryptDecryptUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class OfficeDAOImpl implements OfficeDao {

    @Override
    public Office findOfficeByPhone(String phone) {
        PreparedStatement pstmt = null;
        ResultSet set = null;
        try (Connection conn = DBUtils.getConnection()) {
            pstmt = conn.prepareStatement("SELECT * from offices where phone = ?");

            pstmt.setString(1, phone);

            Office office = new Office();

            set = pstmt.executeQuery();

            while (set.next()) {
                office.setOfficeCode(set.getInt(1));
                office.setCity(set.getString(2));
                office.setPhone(set.getString(3));
                office.setAddressLine1(set.getString(4));
                office.setAddressLine2(set.getString(5));
                office.setState(set.getString(6));
                office.setCountry(set.getString(7));
                office.setPostalCode(set.getString(8));
                office.setTerritory(set.getString(9));
                return office;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("creation Office problem", e);
        } finally {
            DBUtils.close(null, null, pstmt, set);
        }
        return null;
    }

    @Override
    public boolean createOffice(Office office) {
        PreparedStatement pstmt = null;
        try (Connection conn = DBUtils.getConnection()) {
            pstmt =
                    conn.prepareStatement(
                            "INSERT INTO offices (city, phone, addressLine1, addressLine2, state, country, " +
                                    "postalCode, territory) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

            pstmt.setString(1, office.getCity());
            pstmt.setString(2, office.getPhone());
            pstmt.setString(3, office.getAddressLine1());
            pstmt.setString(4, office.getAddressLine2());
            pstmt.setString(5, office.getState());
            pstmt.setString(6, office.getCountry());
            pstmt.setString(7, office.getPostalCode());
            pstmt.setString(8, office.getTerritory());

            return pstmt.executeUpdate() == 1;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("creation Office problem", e);
        } finally {
            DBUtils.close(null, null, pstmt, null);
        }
    }

    @Override
    public void update(Office office) {
        PreparedStatement pstmt = null;
        try (Connection connection = DBUtils.getConnection()) {
            Office o = findOfficeByPhone(office.getPhone());
            pstmt = connection.prepareStatement("UPDATE `j1023_db`.`offices` SET city = ?, phone = ?, " +
                    "addressLine1 = ?, addressLine2 = ?, state = ?, country = ?," +
                    "postalCode = ?, territory = ? WHERE (officeCode = ?)");

            pstmt.setString(1, office.getCity());
            pstmt.setString(2, office.getPhone());
            pstmt.setString(3, office.getAddressLine1());
            pstmt.setString(4, office.getAddressLine2());
            pstmt.setString(5, office.getState());
            pstmt.setString(6, office.getCountry());
            pstmt.setString(7, office.getPostalCode());
            pstmt.setString(8, office.getTerritory());
            pstmt.setInt(9, o.getOfficeCode());

            deleteOffice(o.getOfficeCode());


        } catch (SQLException s) {
            s.printStackTrace();
        } finally {
            DBUtils.close(null, null, pstmt, null);
        }
    }

    @Override
    public boolean deleteOffice(int id) {
        PreparedStatement pstmt = null;
        try (Connection conn = DBUtils.getConnection()) {
            pstmt = conn.prepareStatement("DELETE from offices where officeCode = ?");
            pstmt.setInt(1, id);

            return pstmt.executeUpdate() == 1;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("creation Office problem", e);
        } finally {
            DBUtils.close(null, null, pstmt, null);
        }
    }

    @Override
    public Set<Office> findAll() {
        PreparedStatement pstmt = null;
        ResultSet set = null;
        Set<Office> offices = new HashSet<>();
        try (Connection conn = DBUtils.getConnection();) {
            pstmt =
                    conn.prepareStatement(
                            "SELECT * FROM offices ");

            set =  pstmt.executeQuery();

            while (set.next()) {
                Office office = new Office();
                office.setOfficeCode(set.getInt(1));
                office.setCity(set.getString(2));
                office.setPhone(set.getString(3));
                office.setAddressLine1(set.getString(4));
                office.setAddressLine2(set.getString(5));
                office.setState(set.getString(6));
                office.setCountry(set.getString(7));
                office.setPostalCode(set.getString(8));
                office.setTerritory(set.getString(9));
                offices.add(office);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Find all users exception", e);
        } finally {
            DBUtils.close(null, null, pstmt, set);
        }
        return offices;
    }
*/

