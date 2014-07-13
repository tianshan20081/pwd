package com.aoeng.pwd.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aoeng.pwd.dao.BaseDao;
import com.aoeng.pwd.domain.DuDuNiu;
import com.aoeng.pwd.service.DuDuNiuService;

@Service("duduniuService")
public class DuDuNiuServiceImpl extends BaseServiceImpl<DuDuNiu> implements DuDuNiuService {

	@Resource(name = "duduniuDao")
	@Override
	public void setDao(BaseDao<DuDuNiu> dao) {
		// TODO Auto-generated method stub
		super.setDao(dao);
	}
}
