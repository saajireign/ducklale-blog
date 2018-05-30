package com.ducklale.user.domain.dao;
import com.ducklale.domain.dao.DucklaleDaoI;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Param;
import java.lang.Exception;
import com.ducklale.user.domain.entity.CategoryPO;
import java.util.List;
/**
 * 
 * @author lixiaofei
 * 2015年5月13日
 */
@Repository
@Mapper
public interface CategoryDao extends DucklaleDaoI<CategoryPO,Integer> {

}