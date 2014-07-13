package com.aoeng.jdbc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Test;

import com.aoeng.pwd.utils.DBUtils;
import com.aoeng.pwd.utils.MD5Utils;
import com.aoeng.pwd.utils.MessyCodeCheck;

public class SevenK {
	@Test
	public void inserts() throws Exception {
		String path = "/home/aoeng/Study/databases/all-db/2000-1/k";
		for (int i = 1; i < 5; i++) {
			insert(path + i + ".txt");
		}

	}

	public void insert(String path) throws Exception {

		Connection conn = DBUtils.getConn();
		String sql = "insert into tb_sevenk(uname,pwd,md5,sha1) values(?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		conn.setAutoCommit(false);

		FileInputStream in = new FileInputStream(new File(path));
		BufferedReader bur = new BufferedReader(new InputStreamReader(in, "gb18030"));// ,
		String str = "";
		int n = 0;
		int m = 0;
		long begin = System.currentTimeMillis();
		long end = 0;
		while ((str = bur.readLine()) != null) {
			// System.out.println(n + "-------------->" + str);
			str = str.trim().replaceAll(" ", "");
			String ss[] = str.split("\\s");
			if (ss.length < 2)
				continue;
			if (MessyCodeCheck.isMessyCode(ss[0]) || MessyCodeCheck.isMessyCode(ss[1])) {
				m++;
//				System.out.println(str);
				continue;
			}
			ps.setString(1, ss[0]);
			ps.setString(2, ss[1]);
			ps.setString(3, MD5Utils.get32BitMD5(ss[1]));
			ps.setString(4, MD5Utils.getSha1(ss[1]));
			ps.addBatch();
			if (n % 100000 == 0) {
				ps.executeBatch();
				conn.commit();
				end = System.currentTimeMillis();
				System.out.println(n + "--->" + (end - begin));
				begin = end;
			}
			n++;
		}
		ps.executeBatch();
		conn.commit();
		System.out.println(m);
		System.out.println(System.currentTimeMillis() - begin);

	}
}
