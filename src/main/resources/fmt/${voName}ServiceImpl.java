package com.sunvins.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunvins.bean.SearchBean;
import com.sunvins.dao.${voName}Dao;
import com.sunvins.model.${voName}VO;
import com.sunvins.service.${voName}Service;

@Service  
public class ${voName}ServiceImpl implements ${voName}Service {  
    @Autowired    
    private ${voName}Dao ${voName}Dao;    
    
	public List<${voName}VO> getSearchList(SearchBean searchBean) {
		return ${voName}Dao.getSearchList(searchBean);
	}

	public ${voName}VO getByCid(int cid) {
		return ${voName}Dao.getByCid(cid);
	}

	public void insert(${voName}VO ${voName}VO) {
		${voName}Dao.insert(${voName}VO);
	}

	public void update(${voName}VO ${voName}VO) {
		${voName}Dao.update(${voName}VO);
	}

	public void delete(int cid) {
		${voName}Dao.delete(cid);
	} 
} 
