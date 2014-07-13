package com.aoeng.pwd.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aoeng.pwd.dao.BaseDao;
import com.aoeng.pwd.domain.DuoWan;
import com.aoeng.pwd.service.DuoWanService;

@Service("duowanService")
public class DuoWanServiceImpl extends BaseServiceImpl<DuoWan> implements DuoWanService {

	@Resource(name = "duowanDao")
	@Override
	public void setDao(BaseDao<DuoWan> dao) {
		// TODO Auto-generated method stub
		super.setDao(dao);
	}
}
