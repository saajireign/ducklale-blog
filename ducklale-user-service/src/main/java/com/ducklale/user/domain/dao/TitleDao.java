package com.ducklale.user.domain.dao;
import com.ducklale.domain.dao.DucklaleDaoI;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Param;
import java.lang.Exception;
import com.ducklale.user.domain.entity.TitlePO;
/**
 * 
 * @author lixiaofei
 * 2015年5月13日
 */
@Repository
@Mapper
public interface TitleDao extends DucklaleDaoI<TitlePO,Integer> {

	
}