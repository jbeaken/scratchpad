package org.mzuri.scratchpad;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.mysql.jdbc.Statement;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;


public class JDBCTest {

	@Test
	public void getData() {
		try {

			MysqlDataSource dataSource = new MysqlDataSource();
			dataSource.setUser("root");
			dataSource.setPassword("admin");
			dataSource.setServerName("bookmarks");
			dataSource.setUrl("jdbc:mysql://localhost:3306/bookmarks");

			Connection conn = dataSource.getConnection();

			Statement st = (Statement) conn.createStatement();
			ResultSet rs = st.executeQuery("select * from event");

			while (rs.next()) {
				int id = rs.getInt("id");
				System.out.println(id);
			}

			rs.close();
			st.close();
			conn.close();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}
}