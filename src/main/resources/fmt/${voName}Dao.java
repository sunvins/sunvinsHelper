package com.sunvins.dao;

import java.util.List;

import com.sunvins.bean.SearchBean;
import com.sunvins.model.${voName}VO;

public interface ${voName}Dao {  
	
    public List<${voName}VO> getSearchList(SearchBean searchBean);
    
    public ${voName}VO getByCid(int cid);
    
    public void insert(${voName}VO ${voName}VO);
    
    public void update(${voName}VO ${voName}VO);
    
    public void delete(int cid);
} 
