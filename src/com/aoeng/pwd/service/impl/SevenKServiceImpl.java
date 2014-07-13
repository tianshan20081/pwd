package com.aoeng.pwd.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aoeng.pwd.dao.BaseDao;
import com.aoeng.pwd.domain.SevenK;
import com.aoeng.pwd.service.SevenKService;

@Service("sevenkService")
public class SevenKServiceImpl extends BaseServiceImpl<SevenK> implements SevenKService {

	@Resource(name = "sevenkDao")
	@Override
	public void setDao(BaseDao<SevenK> dao) {
		// TODO Auto-generated method stub
		super.setDao(dao);
	}
}
