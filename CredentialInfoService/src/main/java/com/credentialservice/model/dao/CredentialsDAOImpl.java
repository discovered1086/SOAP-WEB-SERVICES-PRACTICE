/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.credentialservice.model.dao;

import com.credentialservice.model.Credentials;
import com.credentialservice.utility.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Kingshuk
 */
public class CredentialsDAOImpl implements CredentialsDAO{
    private ConnectionManager conmm;

    public CredentialsDAOImpl() {
        conmm = new ConnectionManager();
    }

    public void saveCredentials(Credentials credentials) throws Exception {
        PreparedStatement ps = null;
        Connection con = null;
        StringBuffer savesql = new StringBuffer(255);
        savesql.append("insert into credentials_manager ").append("values (").append("credential_sequence.nextval,?,?,?,?,?)");
        try {
            con = conmm.getMyConnection();
            ps = con.prepareStatement(savesql.toString());
            ps.setString(1, credentials.getAccount());
            ps.setString(2, credentials.getUserId());
            ps.setString(3, credentials.getPassword());
            ps.setString(4, credentials.getPasswordType());
            ps.setString(5, credentials.getUrl());
            ps.executeUpdate();
            //con.commit();
        } catch (SQLException sql) {
            sql.printStackTrace();
            throw new SQLException("error occurred while saving credentials in database");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("error occurred while saving credentials in database");
        } finally {
            try {

                if (!con.isClosed()) {
                    con.close();
                }
            } catch (Exception sql) {
                throw sql;
            }
        }
    }

    public List<Credentials> getSearchResults(String searchString) throws Exception {
        List<Credentials> searchresults = new ArrayList<Credentials>();
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        PreparedStatement ps3 = null;
        ResultSet rs = null;
        Connection con = null;
        StringBuffer search = new StringBuffer(255);
        StringBuffer alter = new StringBuffer(255);
        StringBuffer alter2 = new StringBuffer(255);
        alter.append("alter session set NLS_SORT=BINARY_CI");
        alter2.append("alter session set NLS_COMP=LINGUISTIC");
        search.append("Select * from credentials_manager");
        if (searchString != null) {
            search.append(" where account_name like ?").append(" or account_url like ?");
        }
        try {
            con = conmm.getMyConnection();
            ps1 = con.prepareStatement(alter.toString());
            ps1.executeUpdate();
            ps2 = con.prepareStatement(alter2.toString());
            ps2.executeUpdate();
             //con.commit();
            ps3 = con.prepareStatement(search.toString());
            if (searchString != null) {
                ps3.setString(1, "%" + searchString + "%");
                ps3.setString(2, "%" + searchString + "%");
            }
            rs = ps3.executeQuery();
            while (rs.next()) {
                Credentials credentials = new Credentials();
                credentials.setAccountId(rs.getString(1));
                credentials.setAccount(rs.getString(2));
                credentials.setUrl(rs.getString(3));
                credentials.setUserId(rs.getString(4));
                credentials.setPassword(rs.getString(5));
                credentials.setPasswordType(rs.getString(6));
                searchresults.add(credentials);
            }
        } catch (SQLException sql) {
            sql.printStackTrace();
            throw new SQLException("error occurred while saving credentials in database");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("error occurred while saving credentials in database");
        } finally {
            try {

                if (con != null && con.isClosed()) {
                    con.close();
                }
            } catch (Exception sql) {
                throw sql;
            }
        }
        return searchresults;
    }

    public void updateCredentials(Credentials credential) throws Exception {
        PreparedStatement ps = null;
        Connection con = null;
        StringBuffer updatesql = new StringBuffer(255);
        updatesql.append("update credentials_manager  ")
                .append("set account_name=?, ")
                .append("account_url=?,  ")
                .append("user_id=?, ")
                .append("account_password=?, ")
                .append("password_type=?  ")
                .append("where account_id=?");
        try {
            con = conmm.getMyConnection();
            ps = con.prepareStatement(updatesql.toString());
            ps.setString(1, credential.getAccount());
            ps.setString(2, credential.getUrl());
            ps.setString(3, credential.getUserId());
            ps.setString(4, credential.getPassword());
            ps.setString(5, credential.getPasswordType());
            ps.setString(6, credential.getAccountId());
            ps.executeUpdate();
            //con.commit();
        } catch (SQLException sql) {
            sql.printStackTrace();
            //throw new SQLException("error occured while saving credentials in database");
        } catch (Exception e) {
            e.printStackTrace();
            //throw new RuntimeException("error occured while saving credentials in database");
        } finally {
            try {

                if (!con.isClosed()) {
                    con.close();
                }
            } catch (Exception sql) {
                throw sql;
            }
        }
    }


    public void deleteCredentials(String account_id) throws Exception {
        PreparedStatement ps = null;
        Connection con = null;
        StringBuffer updatesql = new StringBuffer(255);
        updatesql.append("delete from credentials_manager  ")
                .append("where account_id=?");
        try {
            con = conmm.getMyConnection();
            ps = con.prepareStatement(updatesql.toString());
            ps.setString(1, account_id);
            ps.executeUpdate();
            //con.commit();
        } catch (SQLException sql) {
            throw new SQLException("error occured while saving credentials in database");
        } catch (Exception e) {
            throw new RuntimeException("error occured while saving credentials in database");
        } finally {
            try {

                if (!con.isClosed()) {
                    con.close();
                }
            } catch (Exception sql) {
                throw sql;
            }
        }
    }
}
