package com.aoeng.action;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aoeng.pwd.domain.SevenK;
import com.aoeng.pwd.service.SevenKService;
import com.aoeng.pwd.utils.MD5Utils;

public class SevenKTest {

	private static ApplicationContext ac;
	private static SevenKService ss;

	@BeforeClass
	public static void initAC() {
		ac = new ClassPathXmlApplicationContext("beans.xml");
		ss = (SevenKService) ac.getBean("sevenkService");
	}

	@Test
	public void addSevenK() throws Exception {
		String pathname = "/home/aoeng/Study/databases/all-db/2000-1/1-5.txt";

		FileInputStream in = new FileInputStream(new File(pathname));
		BufferedReader buf = new BufferedReader(new InputStreamReader(in,"gb18030"));// ,
																			// "gb18030"
		FileReader reader = new FileReader(new File(pathname));
		String str = "";
		int n = 0;
		SevenK sk;
		String pwd;
		long begin = System.currentTimeMillis();
		while ((str = buf.readLine()) != null) {
			String[] strs = str.split("\\s");
			// sk = new SevenK();
			// sk.setUname(strs[0].trim());
			// pwd = strs[1].trim();
			// sk.setPwd(pwd);
			// sk.setMd5(MD5Utils.get32BitMD5(pwd));
			// sk.setSha1(MD5Utils.getSha1(pwd));
			if (963809 < n && n < 963826)
				System.out.println(str + "---->" + n);

			// ss.saveEntity(sk);
			// System.out.println(sk.toString());
			n++;
		}
		buf.close();
		reader.close();

		System.out.println(n);
		System.out.println(System.currentTimeMillis() - begin);

	}

}
