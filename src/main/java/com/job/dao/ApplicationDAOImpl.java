package com.job.dao;

import java.sql.*;
import java.util.*;
import com.job.model.Application;
import com.job.util.DBConnection;

public class ApplicationDAOImpl implements ApplicationDAO {

	public void addApplication(Application app) {
	    String sql = "INSERT INTO applications(applicantname, position, email, status) VALUES (?,?,?,?)";

	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        if (con == null) {
	            throw new SQLException("Database connection failed");
	        }

	        ps.setString(1, app.getApplicantName());
	        ps.setString(2, app.getPosition());
	        ps.setString(3, app.getEmail());
	        ps.setString(4, app.getStatus());

	        ps.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


	public List<Application> getAllApplications() {
	    List<Application> list = new ArrayList<>();
	    String sql = "SELECT * FROM applications";

	    try (Connection con = DBConnection.getConnection();
	         Statement st = con.createStatement();
	         ResultSet rs = st.executeQuery(sql)) {

	        if (con == null) {
	            throw new SQLException("Database connection failed");
	        }

	        while (rs.next()) {
	            Application a = new Application();
	            a.setApplicationId(rs.getInt("applicationid"));
	            a.setApplicantName(rs.getString("applicantname"));
	            a.setPosition(rs.getString("position"));
	            a.setEmail(rs.getString("email"));
	            a.setStatus(rs.getString("status"));
	            list.add(a);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return list;
	}

	public Application getApplicationById(int id) {
	    Application a = null;
	    String sql = "SELECT * FROM applications WHERE applicationid=?";

	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        if (con == null) {
	            throw new SQLException("Database connection failed");
	        }

	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            a = new Application();
	            a.setApplicationId(rs.getInt("applicationid"));
	            a.setApplicantName(rs.getString("applicantname"));
	            a.setPosition(rs.getString("position"));
	            a.setEmail(rs.getString("email"));
	            a.setStatus(rs.getString("status"));
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return a;
	}


	public void updateApplication(Application app) {
	    String sql = "UPDATE applications SET applicantname=?, position=?, email=?, status=? WHERE applicationid=?";

	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        if (con == null) {
	            throw new SQLException("Database connection failed");
	        }

	        ps.setString(1, app.getApplicantName());
	        ps.setString(2, app.getPosition());
	        ps.setString(3, app.getEmail());
	        ps.setString(4, app.getStatus());
	        ps.setInt(5, app.getApplicationId());

	        ps.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public void deleteApplication(int id) {
	    String sql = "DELETE FROM applications WHERE applicationid=?";

	    try (Connection con = DBConnection.getConnection();
	         PreparedStatement ps = con.prepareStatement(sql)) {

	        if (con == null) {
	            throw new SQLException("Database connection failed");
	        }

	        ps.setInt(1, id);
	        ps.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}