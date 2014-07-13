/**
 * 
 */
package com.aoeng;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.junit.Test;

/**
 * Jul 9, 2014 2:01:26 PM
 * 
 */
public class Main {

	@Test
	public void fileCode() throws Exception {
		String filePath = "/home/paynet/Downloads/databases/all-db/code3.txt";
		InputStream inputStream = new FileInputStream(filePath);
		byte[] head = new byte[3];
		inputStream.read(head);
		String code = "";
		code = "gb2312";
		if (head[0] == -1 && head[1] == -2)
			code = "UTF-16";
		if (head[0] == -2 && head[1] == -1)
			code = "Unicode";
		if (head[0] == -17 && head[1] == -69 && head[2] == -65)
			code = "UTF-8";
		System.out.println(code);
	}

	@Test
	public void read7kfile() throws IOException {
//		String filePath = "/home/paynet/Downloads/databases/all-db/2000-1/1-5_1.txt";
		String filePath = "/home/paynet/Downloads/databases/all-db/嘟嘟牛/d-REYE_txt.1";
		FileInputStream reader = new FileInputStream(new File(filePath));
		BufferedReader bufr = new BufferedReader(new InputStreamReader(reader,"gb18030"));
		String str = "";
		long begin = System.currentTimeMillis();
		int i = 0;
		while ((str = bufr.readLine()) != null) {
			//gb18030
//			str = new String(str.getBytes("gb18030"));
			String[] ss = str.split("\\s");
				for (String s : ss) {
					System.out.print(s.trim());
				}
				System.out.println();
			++i;
			
//			System.out.println(i);
		}
		System.out.println(i);
		System.out.println(System.currentTimeMillis() - begin);
	}

	@Test
	public void readfile() throws IOException {
		String filePath = "/home/paynet/Downloads/databases/www.csdn.net.sql";
		FileReader reader = new FileReader(new File(filePath));
		BufferedReader bufr = new BufferedReader(reader);
		String str = "";
		long begin = System.currentTimeMillis();
		int i = 0;
		while ((str = bufr.readLine()) != null) {
			String[] ss = str.split("#");
			for (String s : ss) {
				System.out.print(s.trim());
			}
			++i;
			System.out.println();
		}
		System.out.println(i);
		System.out.println(System.currentTimeMillis() - begin);
	}

	/**
	 * 判断文件的编码格式
	 * 
	 * @param fileName
	 *            :file
	 * @return 文件编码格式
	 * @throws Exception
	 */
	@Test
	public void codeString() throws Exception {
		String filePath = "/home/paynet/Downloads/databases/all-db/code3.txt";
		BufferedInputStream bin = new BufferedInputStream(new FileInputStream(filePath));
		int p = (bin.read() << 8) + bin.read();
		String code = null;
		switch (p) {
		case 0xefbb:
			code = "UTF-8";
			break;
		case 0xfffe:
			code = "Unicode";
			break;
		case 0xfeff:
			code = "UTF-16BE";
			break;
		default:
			code = "GBK";
		}

		System.out.println(code);
	}
}
