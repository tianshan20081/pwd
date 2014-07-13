package com.aoeng.utils;

import org.junit.Test;

import com.aoeng.pwd.utils.MD5Utils;

public class MD5test {
	
	@Test
	public void testMd5(){
		
		String des = MD5Utils.get32BitMD5("t");
		String des16 = MD5Utils.get16BitMD5("t");
		System.out.println(des);
		System.out.println(des16);
		System.out.println(des.length());
		System.out.println(des16.length());
	}

}
