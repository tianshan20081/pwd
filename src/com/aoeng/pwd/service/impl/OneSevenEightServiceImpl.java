package com.aoeng.pwd.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aoeng.pwd.dao.BaseDao;
import com.aoeng.pwd.domain.OneSevenEight;
import com.aoeng.pwd.service.OneSevenEightService;

@Service("oneSevenEightService")
public class OneSevenEightServiceImpl extends BaseServiceImpl<OneSevenEight> implements OneSevenEightService {

	@Resource(name = "oneSevenEightDao")
	@Override
	public void setDao(BaseDao<OneSevenEight> dao) {
		// TODO Auto-generated method stub
		super.setDao(dao);
	}
}
