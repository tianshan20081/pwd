package com.aoeng.pwd.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aoeng.pwd.dao.BaseDao;
import com.aoeng.pwd.domain.CSDN;
import com.aoeng.pwd.service.CsdnService;
@Service("csdnService")
public class CsdnServiceImpl extends BaseServiceImpl<CSDN> implements
		CsdnService {
	
	@Resource(name = "csdnDao")
	@Override
	public void setDao(BaseDao<CSDN> dao) {
		// TODO Auto-generated method stub
		super.setDao(dao);
	}
}
