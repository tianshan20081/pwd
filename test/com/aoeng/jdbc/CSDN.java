package com.aoeng.jdbc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import org.junit.Test;

import com.aoeng.pwd.utils.DBUtils;
import com.aoeng.pwd.utils.MD5Utils;
import com.aoeng.pwd.utils.MessyCodeCheck;

public class CSDN {

	@Test
	public void insert() throws Exception {
		Connection conn = DBUtils.getConn();
		String sql = "insert into tb_csdn(uname,pwd,email,md5,sha1) values(?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
		conn.setAutoCommit(false);

		String path = "/home/aoeng/Study/databases/all-db/csdn.sql";
		FileInputStream in = new FileInputStream(new File(path));
		BufferedReader bur = new BufferedReader(new InputStreamReader(in, "gb18030"));// ,
		String str = "";
		int n = 0;
		int m = 0;
		long begin = System.currentTimeMillis();
		long end = 0;
		while ((str = bur.readLine()) != null) {
			str = str.trim().replaceAll(" ", "");
			String ss[] = str.split("#");
			if (MessyCodeCheck.isMessyCode(ss[0]) || MessyCodeCheck.isMessyCode(ss[1]) || MessyCodeCheck.isMessyCode(ss[2])) {
				m++;
				continue;
			}
			ps.setString(1, ss[0]);
			ps.setString(2, ss[1]);
			ps.setString(3, ss[2]);
			ps.setString(4, MD5Utils.get32BitMD5(ss[1]));
			ps.setString(5, MD5Utils.getSha1(ss[1]));
			ps.addBatch();
			if (n % 10000 == 0) {
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

	@Test
	public void print() throws Exception {

		String path = "/home/aoeng/Study/databases/all-db/csdn.sql";
		FileInputStream in = new FileInputStream(new File(path));
		BufferedReader bur = new BufferedReader(new InputStreamReader(in, "gb18030"));// ,
		// ""
		String str = "";
		int n = 0;
		int m = 0;
		long begin = System.currentTimeMillis();
		while ((str = bur.readLine()) != null) {
			str = str.trim().replaceAll(" ", "");
			String ss[] = str.split("#");
			if (MessyCodeCheck.isMessyCode(ss[0]) || MessyCodeCheck.isMessyCode(ss[1]) || MessyCodeCheck.isMessyCode(ss[2])) {
				// System.out.println(ss[0] + "--->" + ss[1] + "--->" + ss[2] +
				// "--------------->" + n);
				// System.out.println(n);
				m++;
				// break;
			}
			if (n == 869)
				System.out.println(ss[0] + "--->" + ss[1] + "--->" + ss[2] + "--------------->" + n);
			if (n % 10000 == 0) {

			}
			// System.out.println(n + "--->" + new Date());
			n++;
		}
		System.out.println(m);
		System.out.println(System.currentTimeMillis() - begin);

	}

}
