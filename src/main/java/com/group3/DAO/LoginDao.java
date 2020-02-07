package com.group3.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.group3.BusinessModels.LoginForm;
import com.group3.DBConnectivity.ObtainDataBaseConnection;

public class LoginDao implements ILoginDAO {

	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	LoginForm user;

	@Override
	public LoginForm getUserByEmail(String email) {

		try {
			con = ObtainDataBaseConnection.obtainDatabaseConnection();
			pstmt = con.prepareStatement("select * from  AUTHENTICATION_DATABASE WHERE MAIL_ID = ?");
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			rs.next();
			System.out.println("email " + rs.getString("MAIL_ID"));
			System.out.println("password " + rs.getString("PASSWORD"));
			user = new LoginForm(rs.getString("MAIL_ID"), rs.getString("PASSWORD"));

		} catch (SQLException ex1) {
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					rs.close();
				if (con != null)
					rs.close();
			} catch (SQLException ex2) {
			}
		}
		return user;
	}

	@Override
	public String getRoleByEmail(String email) {
		String role = null;
		try {
			con = ObtainDataBaseConnection.obtainDatabaseConnection();
			// check for password also
			pstmt = con.prepareStatement("select ROLE from  USER_DATABASE WHERE MAIL_ID = ?");
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			rs.next();
			role = rs.getString("ROLE");
			System.out.println("role " + role);

		} catch (SQLException ex1) {
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					rs.close();
				if (con != null)
					rs.close();
			} catch (SQLException ex2) {
			}
		}
		return role;
	}

}
