package com.ducklale.user.domain.dao;
import com.ducklale.domain.dao.DucklaleDaoI;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Param;
import java.lang.Exception;
import java.util.List;

import com.ducklale.user.domain.entity.UserGradePO;
/**
 * 
 * @author lixiaofei
 * 2015年5月13日
 */
@Repository
@Mapper
public interface UserGradeDao extends DucklaleDaoI<UserGradePO,Long> {
    public List<UserGradePO> getAll();
}