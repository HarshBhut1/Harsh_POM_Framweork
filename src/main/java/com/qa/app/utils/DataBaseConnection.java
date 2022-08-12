package com.qa.app.utils;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnection {

	Connection con;
	Statement stm;
	ResultSet rs;

	public ResultSet getDataBase(String query) {

		// "//jdbc:mysql://" + host + ":" + port + "/databasename";

		String host = "localhost";
		String port = "3306";
		String database = "data";

		String dburl = "jdbc:mysql://" + host + ":" + port + "/" + database;
		String username = "root";
		String password = "HMB12111995";

		try {
			con = DriverManager.getConnection(dburl, username, password);
			stm = con.createStatement();
			rs = stm.executeQuery(query);
		} catch (SQLException e) {
			rs = null;
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return rs;
	}

	public String getString(ResultSet rs, String ColumnLable) {

		String s = null;
		try {
			while (rs.next()) {
				s = rs.getString(ColumnLable);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}

	public int getint(ResultSet rs, String ColumnLable) {

		int s = 0;
		try {
			while (rs.next()) {
				s = rs.getInt(ColumnLable);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}

	public Array getArray(ResultSet rs, String ColumnLable) {

		Array s = null;
		try {
			while (rs.next()) {
				s = rs.getArray(ColumnLable);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return s;
	}

}
