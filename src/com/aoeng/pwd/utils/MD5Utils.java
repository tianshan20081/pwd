package com.aoeng.pwd.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
	public static String get16BitMD5(String src) {
		StringBuffer sb = null;
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(src.getBytes("utf-8"));
			byte[] bs = digest.digest();
			int i;
			sb = new StringBuffer();
			for (int offset = 0; offset < bs.length; offset++) {
				i = bs[offset];
				if (i < 0) {
					i += 256;
				} else if (i < 16) {
					sb.append("0");
				}
				sb.append(Integer.toHexString(i));
			}
			String str16 = sb.toString().substring(8, 24);
			System.out.println(str16);
			System.out.println(sb.toString());
			System.out.println(sb.toString().length());
			return str16.toString();

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";

	}

	public static String get32BitMD5(String src) {
		StringBuffer sb = null;
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(src.getBytes("UTF-8"));
			byte[] bs = digest.digest();
			sb = new StringBuffer();
			for (int i = 0; i < bs.length; i++) {
				int v = bs[i] & 0xff;
				if (v < 16)
					sb.append("0");
				sb.append(Integer.toHexString(v));
			}
			return sb.toString();

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";

	}

	public static String get32BitMD52(String src) {
		StringBuffer sb = null;
		try {
			MessageDigest digest = MessageDigest.getInstance("MD5");
			digest.update(src.getBytes("UTF-8"));
			byte[] bs = digest.digest();
			sb = new StringBuffer();
			for (int i = 0; i < bs.length; i++) {
				String hex = Integer.toHexString(0xFF & bs[i]);
				if (hex.length() == 1) {
					sb.append("0");
				}
				sb.append(hex);
			}
			return sb.toString();

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";

	}

	public static String getSha1(String src) {
		StringBuffer sb = null;
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA1");
			digest.update(src.getBytes("UTF-8"));
			byte[] bs = digest.digest();
			sb = new StringBuffer();
			for (int i = 0; i < bs.length; i++) {
				String hex = Integer.toHexString(0xFF & bs[i]);
				if (hex.length() == 1) {
					sb.append("0");
				}
				sb.append(hex);
			}
			return sb.toString();

		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";

	}
}
