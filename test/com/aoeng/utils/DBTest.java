package com.aoeng.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.aoeng.pwd.utils.DBUtils;

public class DBTest {

	@Test
	public void conn() throws Exception {
		Connection conn = DBUtils.getConn();
		System.out.println(conn);
		String sql = "insert into tb_csdn(uname,pwd) values(?,?)";
		PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		long begin = System.currentTimeMillis();
		long end = 0;
		conn.setAutoCommit(false);
		for (int i = 0; i < 100000; i++) {
			ps.setString(1, "admin" + i);
			ps.setString(2, "pwd" + i);
			ps.addBatch();
			if (i % 1000 == 0) {
				ps.executeBatch();
				conn.commit();
			}

		}
		ps.executeBatch();
		conn.commit();
		end = System.currentTimeMillis();
		System.out.println( "------------>" + (end - begin));
		System.out.println(ps);

	}

}
