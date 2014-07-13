package com.aoeng.pwd.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aoeng.pwd.dao.BaseDao;
import com.aoeng.pwd.domain.CSDN;
import com.aoeng.pwd.domain.RenRen;
import com.aoeng.pwd.service.RenRenService;

@Service("renrenService")
public class RenRenServiceImpl extends BaseServiceImpl<RenRen> implements RenRenService {

	@Resource(name = "renrenDao")
	@Override
	public void setDao(BaseDao<RenRen> dao) {
		// TODO Auto-generated method stub
		super.setDao(dao);
	}
}
