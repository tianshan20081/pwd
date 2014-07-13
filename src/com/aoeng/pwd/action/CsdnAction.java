package com.aoeng.pwd.action;

import javax.annotation.Resource;

import com.aoeng.pwd.domain.CSDN;
import com.aoeng.pwd.service.CsdnService;
import com.aoeng.pwd.utils.MD5Utils;

public class CsdnAction extends BaseAction<CSDN>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7133347019710249516L;
	
	@Resource
	private CsdnService csdnService ;
	
	public void add(){
		CSDN t = new CSDN();
		String pwd = "qq";
		t.setUname("admin");
		t.setMd5(MD5Utils.get32BitMD5(pwd));
		t.setSha1(MD5Utils.getSha1(pwd));
		csdnService.saveEntity(t);
	}
	

}
