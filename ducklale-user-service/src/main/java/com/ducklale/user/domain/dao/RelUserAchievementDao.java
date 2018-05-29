package com.ducklale.user.domain.dao;
import com.ducklale.domain.dao.DucklaleDaoI;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Param;
import java.lang.Exception;
import java.util.List;

import com.ducklale.user.domain.entity.RelUserAchievementPO;
/**
 * 
 * @author lixiaofei
 * 2015年5月13日
 */
@Repository
@Mapper
public interface RelUserAchievementDao extends DucklaleDaoI<RelUserAchievementPO,Long> {
    public void insertBatch(List<RelUserAchievementPO> pos);
}