package com.aoeng.action;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aoeng.pwd.domain.CSDN;
import com.aoeng.pwd.service.CsdnService;
import com.aoeng.pwd.utils.MD5Utils;

public class CsdnText {

	private static ApplicationContext ac = null;
	private static CsdnService cs = null;

	@BeforeClass
	public static void initAC() {
		ac = new ClassPathXmlApplicationContext("beans.xml");
		cs = (CsdnService) ac.getBean("csdnService");
	}
	
	@Test
	public void initDB(){
		System.out.println(ac);
		System.out.println(cs);
	}

	@Test
	public void add() {

		for (int i = 0; i < 1000000; i++) {
			CSDN t = new CSDN();
			String pwd = "qq";
			t.setUname("admin");
			t.setPwd(pwd);
			cs.saveEntity(t);
			if (i % 100 == 0) {
				System.out.println(i+"-------->"+new Date());
			}
		}
		System.out.println(new Date());

	}

	@Test
	public void readFile() throws Exception {
		String pathName = "/home/aoeng/Study/databases/all-db/csdn.sql";
		File file = new File(pathName);
		BufferedReader reader2 = new BufferedReader(new FileReader(file));
		String str = "";
		String pwd = "";
		CSDN csdn;
		int n = 0;
		System.out.println(new Date());
		while ((str = reader2.readLine()) != "") {
			String[] ss = str.split("#");
			csdn = new CSDN();
			pwd = ss[1].trim();
			csdn.setUname(ss[0].trim());
			csdn.setPwd(pwd);
			csdn.setEmail(ss[2].trim());
			csdn.setMd5(MD5Utils.get32BitMD5(pwd));
			csdn.setSha1(MD5Utils.getSha1(pwd));
			cs.saveEntity(csdn);
			n++;
		}
		reader2.close();
		System.out.println(n);
		System.out.println(new Date());
	}

}
