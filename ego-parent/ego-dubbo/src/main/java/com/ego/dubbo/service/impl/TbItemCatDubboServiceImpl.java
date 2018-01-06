package com.ego.dubbo.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ego.dubbo.service.TbItemCatDubboService;
import com.ego.mapper.TbItemCatMapper;
import com.ego.pojo.TbItemCat;
import com.ego.pojo.TbItemCatExample;

public class TbItemCatDubboServiceImpl implements TbItemCatDubboService {
	@Resource
	private TbItemCatMapper tbItemCatMapper;
	@Override
	public List<TbItemCat> selByPid(long pid) {
		TbItemCatExample example = new TbItemCatExample();
		//排序���
		example.setOrderByClause("sort_order asc");
		example.createCriteria().andParentIdEqualTo(pid).andStatusEqualTo(1);
		return tbItemCatMapper.selectByExample(example);
	}
	@Override
	public TbItemCat selById(long id) {
		return tbItemCatMapper.selectByPrimaryKey(id);
	}
}
